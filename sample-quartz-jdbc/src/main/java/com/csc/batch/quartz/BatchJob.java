package com.csc.batch.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csc.common.Atdriver;
import com.csc.common.BatchAppVars;
import com.csc.common.BatchJobUtils;
import com.csc.common.Bmanmthrd;
import com.csc.common.Bmonproccl;
import com.csc.common.JobInfo;
import com.csc.common.ThreadLocalStore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.quartz.InterruptableJob;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;


/**
 * @author daniel.peng
 * 
 */
public class BatchJob implements InterruptableJob {
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchJob.class);
	
	/* Added by Max Wang (Quipoz) 
	 * Contains frequently used programs to improve performance
	 */
	private static final Map<String, Class> FREQUENT_PROGRAM_MAPPING = new HashMap<String, Class>(3);
	static {
		FREQUENT_PROGRAM_MAPPING.put(Atdriver.class.getSimpleName(), Atdriver.class);
		FREQUENT_PROGRAM_MAPPING.put(Bmanmthrd.class.getSimpleName(), Bmanmthrd.class);
		FREQUENT_PROGRAM_MAPPING.put(Bmonproccl.class.getSimpleName(), Bmonproccl.class);
	}
	// end of modification
	private BatchAppVars appVars;

	/*
	 * 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("==================================================================");
			LOGGER.info("----- Job [" + context.getJobDetail().getKey().getGroup() + "." + context.getJobDetail().getKey().getName() + "] starting ----");
			LOGGER.info("==================================================================");
		}
		
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();

		// String jobCommand = dataMap.getString(BatchJobUtils.JOB_CMD);
		Object[] jobParameters = (Object[]) dataMap.get(BatchJobUtils.JOB_PARAMS);
		
		// added benny
		String jobCommand = dataMap.getString(BatchJobUtils.JOB_CMD);
		String rqsDta =  dataMap.getString(BatchJobUtils.JOB_RQSDTA);

		//Updated by Max W@Quipoz. It used to assign a constant other than actual value of job queue.
		//String jobQ = ((BatchJobInfo)dataMap.get(BatchJobUtils.BATCH_JOB_INF)).retrieveJobInfo(BatchJobUtils.JOB_Q);
		String jobQ = dataMap.getString(BatchJobUtils.JOB_Q);

		// set the appVars into the ThreadLocal.
		appVars = (BatchAppVars) dataMap.get(BatchJobUtils.BATCH_APPVARS);
		//appVars = (BatchAppVars) dataMap.get(BatchJobUtils.BATCH_APPVARS);
		appVars.recreateTransientFields();
		AppVars.setInstance(appVars);
		//appVars.addDiagnostic("BatchJob: Run BatchJob with Quartz");
		ThreadLocalStore.put(ThreadLocalStore.SCHEDULENAME, context.getJobDetail().getJobDataMap().get(BatchJobUtils.JOB_NAME));
		ThreadLocalStore.put(ThreadLocalStore.SCHEDULENUMBER, context.getJobDetail().getJobDataMap().get(BatchJobUtils.JOB_ID_SEQ));
		ThreadLocalStore.put(ThreadLocalStore.USER, context.getJobDetail().getJobDataMap().get(BatchJobUtils.JOB_USER));
		// update job status in DB and on object
		updateJobStatus(BatchJobUtils.ENDSTS_PROCESSING);

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Job: [" + context.getJobDetail().getKey().getGroup() + "." + context.getJobDetail().getKey().getName() + "] start running.");
		}
		
		// modified by benny
		// runJob(jobParameters,jobQ);
		runJob(jobParameters, jobCommand, context);

		// update job status to completed in DB and on object
		updateJobStatus(JobUtils.ENDSTS_COMPLETED);
	}

	private void updateJobStatus(String endsts) {
		appVars.getJobInfo().changeJobInfo(JobInfo.ENDSTS, endsts);
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("==================================================================");
			LOGGER.info(" Job [" + appVars.getJobInfo().retrieveJobInfo(JobInfo.JOB) + "] end status was changed to " + endsts);
			LOGGER.info("==================================================================");
		}
	}

	/**
	 * Job interrupt handler. Initiating cancellation of the running job
	 */
	public void interrupt() throws UnableToInterruptJobException {
		// set the job status to "cancelled".
		// the loop of Schedule Process should examine this flag.
		updateJobStatus(BatchJobUtils.ENDSTS_CANCELLED);
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("==================================================================");
			LOGGER.info(" Job [" + appVars.getJobInfo().retrieveJobInfo(JobInfo.JOB) + "] was interrupted");
			LOGGER.info("==================================================================");
		}
	}

	private void runJob(Object[] jobParameters,String jobCommand, JobExecutionContext context) {
		/*
		 * Updated by Max Wang @ QUIPOZ - start
		 * The jobCommand should be a program name.
		 * It is assumed that all SBMJOB calls a program, not a CL command. 
		 */
		//Frequently using programs
		Object toCallProgram = jobCommand;
		if (FREQUENT_PROGRAM_MAPPING.containsKey(jobCommand)) {
			toCallProgram = FREQUENT_PROGRAM_MAPPING.get(jobCommand);
		}
		try {
			CLFunctions.callProgram(jobCommand, jobParameters, appVars);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("==================================================================");
				LOGGER.info(" Job [" + context.getJobDetail().getKey().getGroup() + "." + context.getJobDetail().getKey().getName() + "] ended successfully");
				LOGGER.info("==================================================================");
			}
		} catch (ExtMsgException e) {
			//print out statck trace for the convenient of diagnostic
            LOGGER.error("runJob(Object[], String, JobExecutionContext)", e);
			//send a message to console.
			String msgId = e.getMessageId().trim();
			String msgFileName = msgId.trim().substring(0, 3).toUpperCase() + "MSGF";
			MessageAgent.sendMessageToUser(getProgramName(toCallProgram), 
					msgId, msgFileName, "", ISeriesMessage.ESCAPE, 
					new String[]{MessageAgent.QSYSOPR}, null, null);
			appVars.addDiagnostic("BatchJob: runJob ExtMsgException is "+e.getMessage(),1);
		} catch (RuntimeException e) {
			//print out statck trace for the convenient of diagnostic
            LOGGER.error("runJob(Object[], String, JobExecutionContext)", e);
			//send a message to console.
			MessageAgent.sendMessageToUser(getProgramName(toCallProgram), 
					"CPF9898", "CPFMSGF", e.getLocalizedMessage(), ISeriesMessage.ESCAPE, 
					new String[]{MessageAgent.QSYSOPR}, null, null);
			appVars.addDiagnostic("BatchJob: runJob RuntimeException is "+e.toString(),1);
		}
		// modified end
	}
	
	/**
	 * Only used by callProgram at the moment. 
	 * If toCallProgram is null, then return an empty string;
	 * Else if toCallProgram is an instance of Class, then return its simple name;
	 * Otherwise, return toString(); 
	 * @param toCallProgram
	 * @return
	 */
	private static String getProgramName(Object toCallProgram) {
		if (toCallProgram == null) {
			return "";
		} else if (toCallProgram instanceof Class) {
			return ((Class)toCallProgram).getSimpleName();
		} else {
			return toCallProgram.toString().trim();
		}
	}

//	/**
//	 * This method is responsible for parse cmd or rqsDta and get the called class.
//	 * @param jobCommand
//	 * @return
//	 */
//	private String parseSbmjob(String jobCommand) {
//		// CALL PGM(ddd) parm(aa)
//		return jobCommand.substring(jobCommand.indexOf("(")+1, jobCommand.indexOf(")"));
//	}
	
	public static void main(String[]args){
		System.setProperty("Quipoz.test.XMLPath", "D:\\datadevelopment\\CSCBatch\\src\\QuipozCfg.xml");
		
		COBOLAppVars appVars = new SMARTAppVars("test");
		appVars.set(appVars);
		
		JobInfo jobInfo = new JobInfo("12345", "MLS010", new Date(), "OKEWAH", "AT", "ATTest", null);
		appVars.setJobinfo(jobInfo);
		BatchJob b = new BatchJob();
		b.setGlobalVars(appVars);
		b.runJob(new Object[]{"1"}, "Bmanmthrd", null);
	}

}
