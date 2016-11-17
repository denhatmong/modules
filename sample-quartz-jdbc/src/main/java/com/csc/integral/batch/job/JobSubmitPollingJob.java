/**
 *
 */
package com.csc.integral.batch.job;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.UnableToInterruptJobException;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csc.batch.api.BatchDataAccess;
import com.csc.batch.quartz.BatchJob;
import com.csc.batch.socket.BatchControlType;
import com.csc.batch.socket.BatchTransferData;
import com.csc.common.AppVars;
import com.csc.common.BatchAppVars;
import com.csc.common.BatchJobUtils;
import com.csc.common.COBOLAppVars;
import com.csc.common.JobInfo;
import com.csc.integral.batch.util.BatchServerLauncher;


/**
 * Monitor all job submitted by online application. Ex: AT job, Btman job ... then handle every batch job. Every batch job was fetched from table Jobsubmit then
 * put to scheduler. It's also handle all job operation such as hold, end, restart ...
 *
 * @author qpham4
 * @version 1.0
 */
public class JobSubmitPollingJob extends IntegralJob {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobSubmitPollingJob.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void executeImpl(JobExecutionContext ctx) throws Exception {

		// Each job should use a new AppVars instance to prevent transactional
		// overlapping problem.
		BatchAppVars appVars = BatchServerLauncher.appVars;
		AppVars.setInstance(appVars);
		Connection tempConnection = appVars.getTempDBConnection("DB");
		if (!tempConnection.isValid(0)) {
			tempConnection.close();
		}

		// Loads all ready-to-run jobs from JOBSUBMIT (those with status = 50).
		List<BatchTransferData> jobs = BatchDataAccess.fetchBatchData(AppVars.getInstance(), null);

		// Sort job list
		Collections.sort(jobs, new JobComparator());

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Number of ready-to-run jobs: " + jobs.size());
		}

		// Sequentially schedules all ready-to-run jobs into Quartz schedulers.
		for (BatchTransferData job : jobs) {

			// Trims all String fields that were stored as CHAR(n).
			job.trimData();

			// Immediately updates the job to status = 20.
			BatchDataAccess.updateBatchData(AppVars.getInstance(), job.getUniqueNum(), true);

			// Processes the loaded batch.
			processBatchControl(job);
		}
	}

	/**
	 * This method is responsible for calling Batch API.
	 *
	 * @param batchData
	 */
	private void processBatchControl(BatchTransferData batchData) {
		int batchAction = batchData.getBatchControlType();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Batch job action: " + batchAction);
		}
		switch (batchAction) {
		case BatchControlType.SUBMIT_JOB:
			submitJob(batchData); // Submit a job
			break;
		case BatchControlType.PAUSE_JOB:
			pauseJob(batchData); // Pause a job
			break;
		case BatchControlType.RESTART_JOB:
			restartJob(batchData); // Restart a job
			break;
		case BatchControlType.DELAY_JOB:
			delayJob(batchData); // delay a job
			break;
		case BatchControlType.STOP_JOB:
			stopJob(batchData); // stop a job
			break;
		case BatchControlType.HOLD_JOBQ:
			holdJobQ(batchData); // hold a job queue
			break;
		case BatchControlType.RELEASE_JOBQ:
			releaseJobQ(batchData); // release a job queue
			break;
		case BatchControlType.CHANGE_JOB:
			changeJob(batchData); // change a job
			break;
		default:
			throw new IllegalArgumentException("Unknown batch control action.");
		}
	}

	/**
	 * This method is responsible for changing a job.
	 *
	 * @param batchData
	 */
	private void changeJob(BatchTransferData batchData) {
		String jobName = batchData.getJobName();
		String jobNumber = batchData.getJobNumber();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] info is changing.");
		}
		String[] valuePairs = batchData.getValuePairsToChange();
		if (valuePairs != null && valuePairs.length > 0) {
			BatchAppVars batchAppVars = (BatchAppVars) BatchAppVars.getInstance();
			batchAppVars.getJobInfo().changeJobInfo(valuePairs);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] info was changed.");
			}
		}
	}

	/**
	 * This method is responsible for releasing a job queue.
	 *
	 * @param batchData
	 */
	private void releaseJobQ(BatchTransferData batchData) {
		String jobQName = batchData.getJobQ();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Job group [" + jobQName + "] is resuming.");
		}
		if (jobQName != null) {
			try {
				getScheduler().resumeTriggers(GroupMatcher.triggerGroupEquals(jobQName));
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("Job group [" + jobQName + "] was resumed.");
				}
			} catch (SchedulerException e) {
				LOGGER.info("Job group [" + jobQName + "] failed to resume.");
			}
		}
	}

	/**
	 * This method is responsible for holding a job queue.
	 *
	 * @param batchData
	 */
	private void holdJobQ(BatchTransferData batchData) {
		String jobQName = batchData.getJobQ();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Job group [" + jobQName + "] is pausing.");
		}
		if (jobQName != null) {
			try {
				getScheduler().pauseTriggers(GroupMatcher.triggerGroupEquals(jobQName));
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("Job group [" + jobQName + "] was paused.");
				}
			} catch (SchedulerException e) {
				LOGGER.info("Job group [" + jobQName + "] failed to pause.");
			}
		}
	}

	/**
	 * This method is responsible for stopping a job.
	 *
	 * @param batchData
	 */
	private void stopJob(BatchTransferData batchData) {
		String jobName = batchData.getJobName();
		String jobNumber = batchData.getJobNumber();
		String jobQ = batchData.getJobQ();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] is stopping.");
		}
		if (jobName != null && jobNumber != null && jobQ != null) {
			try {
				getScheduler().interrupt(new JobKey(jobName + jobNumber, jobQ));
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] was stopped.");
				}
			} catch (UnableToInterruptJobException e) {
				LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] failed to stop.");
			}
		}
	}

	/**
	 * This method is responsible for delaying a job.
	 *
	 * @param batchData
	 */
	private void delayJob(BatchTransferData batchData) {
		String jobName = batchData.getJobName();
		String jobNumber = batchData.getJobNumber();
		String jobQ = batchData.getJobQ();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] is delaying.");
		}

		if (jobName != null && jobNumber != null && jobQ != null) {
			changeJobInfo(jobName, jobNumber, jobQ, JobInfo.ENDSTS, BatchJobUtils.ENDSTS_CANCELLED);
			COBOLAppVars tmpAppVars = new BatchAppVars();
			try {
				Date date = batchData.getDateToDelay();
				
				Trigger oldTrigger = getScheduler().getTrigger(new TriggerKey(jobName + jobNumber, jobQ));				
				Trigger newTrigger = oldTrigger.getTriggerBuilder()
					    .startAt(date)
					    .build();			
				
				getScheduler().rescheduleJob(oldTrigger.getKey(), newTrigger);
				
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] was delayed.");
				}
			} catch (SchedulerException e) {
				tmpAppVars.addExtMessage("CPF0000", "can not find job.");
				LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "]  failed to delay.");
			}
		}

	}

	/**
	 * This method is responsible for restarting a job.
	 *
	 * @param batchData
	 */
	private void restartJob(BatchTransferData batchData) {
		String jobName = batchData.getJobName();
		String jobNumber = batchData.getJobNumber();
		String jobQ = batchData.getJobQ();
		if (jobName != null && jobNumber != null && jobQ != null) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] is restarting.");
			}
			submitJob(batchData);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] was restarted.");
			}
		}
	}

	/**
	 * This method is responsible for pause a job.
	 *
	 * @param batchData
	 */
	private void pauseJob(BatchTransferData batchData) {
		String jobName = batchData.getJobName();
		String jobNumber = batchData.getJobNumber();
		String jobQ = batchData.getJobQ();
		if (jobName != null && jobNumber != null && jobQ != null) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] is pausing.");
			}
			changeJobInfo(jobName, jobNumber, jobQ, JobInfo.ENDSTS, BatchJobUtils.ENDSTS_PENDING);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Job [" + jobName + "] Number: [" + jobNumber + "] was paused.");
			}
		}

	}

	/**
	 * Change job info, reaction from com.csc.batch.BatchController
	 *
	 * @param jobName
	 * @param jobNumber
	 * @param jobQueue
	 * @param attr
	 * @param value
	 */
	public void changeJobInfo(String jobName, String jobNumber, String jobQueue, String attr, String value) {
		COBOLAppVars tmpAppVars = new BatchAppVars();
		try {
			JobDetail jobDetail = getScheduler().getJobDetail(new JobKey(jobName, jobQueue));

			if (jobDetail != null) {
				COBOLAppVars appVars = (COBOLAppVars) jobDetail.getJobDataMap().get(BatchJobUtils.BATCH_APPVARS);
				appVars.getJobInfo().changeJobInfo(attr, value);
			} else {
				tmpAppVars.addExtMessage("CPF0000", "can not find job.");
			}
		} catch (SchedulerException e) {
			tmpAppVars.addExtMessage("CPF0000", "Unknown obq.");
		}
	}

	/**
	 * This method is responsible for submiting a job.
	 *
	 * @param batchData
	 */
	private boolean submitJob(BatchTransferData batchData) {
		String jobCmd = batchData.getJobCommand();
		Object[] jobParms = batchData.getJobParameters();
		String jobName = batchData.getJobName();
		String jobDesc = batchData.getJobDescription();
		String jobQ = batchData.getJobQ();
		String jobPty = batchData.getJobPty();
		String rtgDta = batchData.getRtgDta();
		String log = batchData.getLog();
		String logCLPgm = batchData.getLogCLPgm();
		String hold = batchData.getHold();
		String user = batchData.getUser();
		Date date = new Date();
		String rqsDta = batchData.getRqsDta();

		return submitJob(jobCmd, jobParms, jobName, jobDesc, jobQ, jobPty, rtgDta, log, logCLPgm, hold, user, date, rqsDta);
	}

	private boolean submitJob(String jobCmd, Object[] jobParms, String jobName, String jobDesc, String jobQ, String jobPty, String rtgDta, String log,
			String logCLPgm, String hold, String user, Date date, String rqsDta) {
		try {

			if (jobDesc == null) {
				jobDesc = JobInfo.DEFAULT_LIB + "/" + JobInfo.DEFAULT_JOBD;
			}

			String logLevel = null;
			String logSeverity = null;
			String logType = null;

			// retrieve params from parameter array.
			String scheduleName = "";
			String scheduleNumber = "";
			String scheduleThreadNo = "";
			String shceduleNumberAndThreadNo = "";
			String scheduleID = "";

			if (jobParms.length == 4) {
				scheduleName = jobParms[0].toString();
				FixedLengthStringData f = new FixedLengthStringData(6);
				PackedDecimalData t = new PackedDecimalData(8, 0);
				t.setInternal(new FixedLengthStringData(jobParms[1].toString()));
				ZonedDecimalData d = new ZonedDecimalData(6).isAPartOf(f, 0);
				d.set(t.getbigdata());
				scheduleNumber = f.toString();
				scheduleThreadNo = getScheduleThreadNo(jobParms[3]);
	            shceduleNumberAndThreadNo = scheduleNumber + scheduleThreadNo;
	            scheduleID = scheduleName + shceduleNumberAndThreadNo;
			} else {
				scheduleNumber = jobParms[0].toString();
				scheduleName = jobName;
				scheduleID = scheduleName + scheduleNumber;
			}

			BatchAppVars appVars = new BatchAppVars("test");

			// construct a new job info.
			BatchJobInfo jobInfo = new BatchJobInfo(scheduleNumber, scheduleName, null, null, date, user, null, jobPty, null, null, logLevel, logSeverity,
					logType, BatchJobUtils.ENDSTS_WAITING, jobDesc, jobPty, jobQ, jobCmd, null, null, log, logCLPgm, null, hold, null, null,shceduleNumberAndThreadNo);
			// set the job info into the appVars.
			appVars.setJobinfo(jobInfo);

			// construct a new BatchJob JobDetail instance
			// and put it into a job queue.
			JobDetail jobDetail = JobBuilder.newJob(BatchJob.class)
	                .withIdentity(scheduleID, jobQ)
	                .build();
			
			Map<String, Object> dataMap = jobDetail.getJobDataMap();

			dataMap.put(BatchJobUtils.JOB_CMD, jobCmd);
			dataMap.put(BatchJobUtils.JOB_PARAMS, jobParms);
			dataMap.put(BatchJobUtils.BATCH_JOB_INF, jobInfo);
			dataMap.put(BatchJobUtils.BATCH_APPVARS, appVars);
			dataMap.put(BatchJobUtils.JOB_NAME, jobName);
			dataMap.put(BatchJobUtils.JOB_DESC, jobDesc);
			dataMap.put(BatchJobUtils.JOB_Q, jobQ);
			dataMap.put(BatchJobUtils.JOB_PTY, jobPty);
			dataMap.put(BatchJobUtils.JOB_RTGDTA, rtgDta);
			dataMap.put(BatchJobUtils.JOB_LOG, log);
			dataMap.put(BatchJobUtils.JOB_CLPGM, logCLPgm);
			dataMap.put(BatchJobUtils.JOB_HOLD, hold);
			dataMap.put(BatchJobUtils.JOB_USER, user);
			dataMap.put(BatchJobUtils.JOB_ENTRYTIME, date);
			dataMap.put(BatchJobUtils.JOB_RQSDTA, rqsDta);
			dataMap.put(BatchJobUtils.JOB_ID_SEQ, scheduleNumber);

			if (jobDetail != null) {
				if (LOGGER.isInfoEnabled()) {
					recordSubmitLog(jobDetail);
				}

				// Set end time to a year from current date to avoid Complete
				// state of quartz job when reschedule job.
				Calendar endTime = Calendar.getInstance();
				endTime.add(Calendar.YEAR, 1);
				
				Trigger simpleTrigger = TriggerBuilder.newTrigger()
						.withIdentity(new TriggerKey(jobDetail.getKey().getName(), jobDetail.getKey().getGroup()))
						.endAt(endTime.getTime())
						.build();

				// Schedule job
				getScheduler().scheduleJob(jobDetail, simpleTrigger);
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("Schedule job: " + jobName + " in scheduler: " + jobQ);
				}
			}
			return true;
		} catch (Exception e) {
			LOGGER.error("Batch Job fail to schedule", e);
			return false;
		}
	}

	private Scheduler getScheduler() {
		return (Scheduler) getApplicationContext().getBean("IntegralSchedulerFactoryBean");
	}

	/**
	 * This method is responsible for recording the submit log.
	 *
	 * @param jobDetail
	 */
	private void recordSubmitLog(JobDetail jobDetail) {
		String jobNo = ((String) jobDetail.getJobDataMap().get(BatchJobUtils.JOB_ID_SEQ)).trim();
		String jobName = ((String) jobDetail.getJobDataMap().get(BatchJobUtils.JOB_NAME)).trim();
		String jobQueue = ((String) jobDetail.getJobDataMap().get(BatchJobUtils.JOB_Q)).trim();
		String jobPty = ((String) jobDetail.getJobDataMap().get(BatchJobUtils.JOB_PTY)).trim();
		String userName = ((String) jobDetail.getJobDataMap().get(BatchJobUtils.JOB_USER)).trim();
		StringBuilder sb = new StringBuilder("Batch Job:\"");
		sb.append(jobName);
		sb.append("\" submited, User:\"");
		sb.append(userName);
		sb.append("\", Job Number:\"");
		sb.append(jobNo);
		sb.append("\", Job Queue:\"");
		sb.append(jobQueue);
		sb.append("\", Job Priority:\"");
		sb.append(jobPty);
		sb.append("\".\r\n");
		LOGGER.info(sb.toString());
	}
	  private String getScheduleThreadNo(Object jobParam) {
	        FixedLengthStringData f = new FixedLengthStringData(2);
	        PackedDecimalData t = new PackedDecimalData(2, 0);
	        t.setInternal(new FixedLengthStringData(jobParam.toString()));
	        ZonedDecimalData d = new ZonedDecimalData(2).isAPartOf(f, 0);
	        d.set(t.getbigdata());
	        return f.toString();
	    }
}
