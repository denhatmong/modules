package com.csc.batch.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

/**
 * A job contains a ordered list of jobs waiting to be processed.
 *
 * @author daniel.peng
 * @version 1.0
 * 
 */
public class BatchJobQueue {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchJobQueue.class);

	/**
	 * The name of the job queue.
	 */
	private String jobQueueName;

	/**
	 * The max number of running job in the job queue.
	 */
	private int jobLmt = 1;

	/**
	 * If the job queue is active.
	 */
	private boolean isActive = false;

	/**
	 * The job list waiting to run.
	 */
	private List jobList = new Vector<JobDetail>();

	/**
	 * The paused job and time map.
	 */
	private Map pausedJobTimeMap = Collections
			.synchronizedMap(new HashMap<JobDetail, Date>());
	
	/**
	 * The longest time to be paused. 
	 */
	public static final long PAUSE_LONGEST_TIME = 1000 * 60 * 60 * 24;// 24h.

	/**
	 * Each job queue has a unique Quartz Scheduler.
	 */
	private Scheduler scheduler = null;

	/**
	 * @param strJobQueueName
	 *            the name of the job queue.
	 * @throws SchedulerException
	 */
	public BatchJobQueue(String strJobQueueName) {
		this.jobQueueName = strJobQueueName;
		this.scheduler = BatchSchedulerDelegate.getInstance().getScheduler(
				jobQueueName);
		try {
			this.scheduler.start();
		} catch (SchedulerException e) {
            LOGGER.error("BatchJobQueue(String)", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param strJobQueueName
	 *            the name of the job queue.
	 * @param iJobLmt
	 *            the max number of running job.
	 * @throws SchedulerException
	 */
	public BatchJobQueue(String strJobQueueName, int iJobLmt) {
		this(strJobQueueName);
		this.jobLmt = iJobLmt;
	}

	/**
	 * @return if the job queue is active.
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Get the next job by priority order.
	 * 
	 * @return the next job in priority order. null if no job to run.
	 */
	public JobDetail getNextJob() {
		JobDetail jobDetail = getJobInPriorityOrder();
		this.jobList.remove(jobDetail);
		return jobDetail;
	}

	/*
	 * @return the next job.
	 */
	private JobDetail getJobInPriorityOrder() {
		if (this.jobList != null && this.jobList.size() > 0) {
			return (JobDetail) this.jobList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Add a BatchJob into the job queue.
	 * 
	 * @param bjbatchJob
	 *            the batch job added to the job queue.
	 */
	public void addJob(JobDetail jobDetail) {
		jobList.add(jobDetail);
		Comparator comparator = new BatchSequenceComparator();
		Collections.sort(jobList, comparator);
	}

	/**
	 * Active the job queue.
	 */
	public void releaseJobQueue() {
		this.isActive = true;
	}

	/**
	 * Hold the job queue.
	 */
	public void holdJobQueue() {
		this.isActive = false;
	}

	/**
	 * @return The scheduler of the job queue.
	 */
	public Scheduler getScheduler() {
		return this.scheduler;
	}

	/**
	 * Get the max count of running job.
	 * @return the max count of runing job.
	 */
	public int getJobLmt() {
		return this.jobLmt;
	}

	/**
	 * Get the name of the job queue.
	 * @return the name of the job queue.
	 */
	public String getBatchJobQueueName() {
		return this.jobQueueName;
	}

	public JobDetail removeJob(String jobID) {
		JobDetail jobDetail;
		for (int i = 0; i < jobList.size(); i++) {
			jobDetail = (JobDetail) jobList.get(i);
			if (jobDetail.getKey().getName().equals(jobID)) {
				jobList.remove(jobDetail);
				return jobDetail;
			}
		}
		return null;
	}
	
	public JobDetail getJob (String jobID) {
		JobDetail jobDetail;
		try {
			jobDetail = scheduler.getJobDetail(new JobKey(jobID, jobQueueName));
			if (jobDetail != null) {
				return jobDetail;
			}
		} catch (SchedulerException e) {
			jobDetail = null;
		}
		for (int i = 0; i < jobList.size(); i++) {
			jobDetail = (JobDetail) jobList.get(i);
			if (jobDetail.getKey().getName().equals(jobID)) {
				return jobDetail;
			}
		}
		Set pausedJobs = pausedJobTimeMap.keySet();
		for(Iterator it = pausedJobs.iterator();it.hasNext();){
			jobDetail = (JobDetail) it.next();
			if (jobDetail.getKey().getName().equals(jobID)) {
				return jobDetail;
			}
		}
		return null;
	}
	
	public void addPausedJob(JobDetail jobDetail) {
		this.pausedJobTimeMap.put(jobDetail, new Date());
	}
	
	Map getPausedJobs() {
		return this.pausedJobTimeMap;
	}
}
