package com.csc.batch.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Scheduler Delegate is a Scheduler Factory - used to return the named
 * scheduler.
 * 
 * modified by daniel.peng
 * 
 * @author Sarah Kim
 * @version 1.0 Feb 2007
 * 
 */
public class BatchSchedulerDelegate {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchSchedulerDelegate.class);

	private Map<String, Scheduler> mSchedulers = new HashMap<String, Scheduler>();

	private static final String BATCH_CFG_SCHEDULER_SUFFIX = ".properties";

	private static BatchSchedulerDelegate mInstance;

	/**
	 * Returns named scheduler
	 * 
	 * @param name
	 * @return Scheduler
	 * @throws SchedulerException
	 */
	public Scheduler getScheduler(String name) {
		Scheduler scheduler = null;
		if (mSchedulers.containsKey(name)) {
			scheduler = (Scheduler) mSchedulers.get(name);
		} else {
			SchedulerFactory factory;
			try {
				factory = new StdSchedulerFactory(name
						+ BATCH_CFG_SCHEDULER_SUFFIX);
				scheduler = factory.getScheduler();
			} catch (SchedulerException e) {
                LOGGER.error("getScheduler(String)", e);
				throw new RuntimeException(e);
			}
			
			mSchedulers.put(name, scheduler);
		}
		return scheduler;
	}

	/**
	 * Returns an instance of the Scheduler Delegate
	 * 
	 * @return SchedulerDelegate
	 */
	public static BatchSchedulerDelegate getInstance() {
		if (mInstance == null) {
			mInstance = new BatchSchedulerDelegate();
		}
		return mInstance;
	}
}
