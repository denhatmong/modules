package com.csc.integral.batch.listener;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Global trigger listener for interested schedulers in Integral.
 */
public class IntegralTriggerListener implements TriggerListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntegralTriggerListener.class);

	private Map<String, Integer> jobQueueSize = new HashMap<String, Integer>();

	private Set<String> reschedulableVetoedJobs = new HashSet<String>();

	private Map<String, Integer> groupQueueSize = new HashMap<String, Integer>();

	private Set<String> reschedulableVetoedGroups = new HashSet<String>();

	private int reschedulingInterval;

	@Override
	public String getName() {
		return "IntegralTriggerListener";
	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext ctx, CompletedExecutionInstruction triggerInstructionCode) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("triggerComplete: [" + trigger.getJobKey().getName() + "-" + trigger.getKey().getName() + "]");
		}
	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext ctx) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("triggerFired: [" +trigger.getJobKey().getName() + "-" + trigger.getKey().getName() + "]");
		}
	}

	@Override
	public void triggerMisfired(Trigger trigger) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("triggerMisfired: [" + trigger.getJobKey().getName() + "-" + trigger.getKey().getName() + "]");
		}
	}

	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext ctx) {
		JobDetail jobDetail = ctx.getJobDetail();
		try {
			int groupQueueSizeLimit = groupQueueSizeLimit(jobDetail);
			int jobQueueSizeLimit = jobQueueSizeLimit(jobDetail);
			int currentGroupQueueSize = currentGroupQueueSize(ctx);
			int currentJobQueueSize = currentJobQueueSize(ctx);

			if (groupQueueSizeLimit == currentGroupQueueSize
					|| jobQueueSizeLimit == currentJobQueueSize) {
				LOGGER.info("vetoJobExecution: [" + trigger.getJobKey().getName() + "." + trigger.getJobKey().getGroup() + "-"
						+ trigger.getKey().getName() + "]");

				if (reschedulableVetoedGroups.contains(jobDetail.getKey().getGroup())
						|| reschedulableVetoedJobs.contains(jobKey(jobDetail))) {
					LOGGER.info("Rescheduling job: [" + trigger.getJobKey().getName() + "." + trigger.getJobKey().getGroup() + "]");

					Calendar newFireTime = Calendar.getInstance();
					newFireTime.add(Calendar.MILLISECOND, reschedulingInterval);
					
					Trigger newTrigger = trigger.getTriggerBuilder()
							.startAt(newFireTime.getTime())
							.build();					
					ctx.getScheduler().rescheduleJob(trigger.getKey(),	newTrigger);					
				}

				return true;
			}
		} catch (Exception e) {
			LOGGER.error("Error when trying to veto job: " + jobDetail.getKey().getGroup() + "." + jobDetail.getKey().getName(), e);
		}
		return false;
	}

	private int jobQueueSizeLimit(JobDetail jobDetail) {
		return jobQueueSize.containsKey(jobKey(jobDetail)) ? jobQueueSize.get(jobKey(jobDetail))
				: Integer.MAX_VALUE;
	}

	private int groupQueueSizeLimit(JobDetail jobDetail) {
		return groupQueueSize.containsKey(jobDetail.getKey().getGroup()) ? groupQueueSize.get(jobDetail
				.getKey().getGroup()) : Integer.MAX_VALUE;	
	}

	private String jobKey(JobDetail jobDetail) {
		return jobDetail.getKey().getGroup() + "." + jobDetail.getKey().getName();
	}

	private int currentJobQueueSize(JobExecutionContext ctx) throws SchedulerException {
		int result = 0;
		List<JobExecutionContext> jecs = ctx.getScheduler().getCurrentlyExecutingJobs();
		for (JobExecutionContext jec : jecs) {
			if (StringUtils.equals(jobKey(jec.getJobDetail()), jobKey(ctx.getJobDetail()))) {
				result++;
			}
		}
		return result;
	}

	private int currentGroupQueueSize(JobExecutionContext ctx) throws SchedulerException {
		int result = 0;
		List<JobExecutionContext> jecs = ctx.getScheduler().getCurrentlyExecutingJobs();
		for (JobExecutionContext jec : jecs) {
			if (StringUtils.equals(ctx.getJobDetail().getKey().getGroup(), jec.getJobDetail().getKey().getGroup())) {
				result++;
			}
		}
		return result;
	}

	public void setJobQueueSize(Map<String, Integer> jobQueueSize) {
		this.jobQueueSize = jobQueueSize;
	}

	public void setGroupQueueSize(Map<String, Integer> groupQueueSize) {
		this.groupQueueSize = groupQueueSize;
	}

	public void setReschedulableGroups(Set<String> reschedulableGroups) {
		this.reschedulableVetoedGroups = reschedulableGroups;
	}

	public void setReschedulableVetoedJobs(Set<String> reschedulableVetoedJobs) {
		this.reschedulableVetoedJobs = reschedulableVetoedJobs;
	}

	public void setReschedulableVetoedGroups(Set<String> reschedulableVetoedGroups) {
		this.reschedulableVetoedGroups = reschedulableVetoedGroups;
	}

	public void setReschedulingInterval(int reschedulingInterval) {
		this.reschedulingInterval = reschedulingInterval;
	}
}
