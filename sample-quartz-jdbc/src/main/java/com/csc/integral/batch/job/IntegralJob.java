package com.csc.integral.batch.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Base class for all Quartz jobs in Integral. 
 */
public abstract class IntegralJob extends QuartzJobBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntegralJob.class);
	
	private ApplicationContext applicationContext;

	@Override
	protected final void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("==================================================================");
				LOGGER.trace("----- JOB [" + ctx.getJobDetail().getKey().getGroup() + "." + ctx.getJobDetail().getKey().getName() + "] starting ----");
				LOGGER.trace("==================================================================");
		}
		
		try {
			executeImpl(ctx);
			
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("==================================================================");
				LOGGER.trace(" JOB [" + ctx.getJobDetail().getKey().getGroup() + "." + ctx.getJobDetail().getKey().getName() + "] ended successfully");
				LOGGER.trace("==================================================================");
			}
		} catch (Exception e) {
			LOGGER.error("==================================================================");
			LOGGER.error("	JOB [" + ctx.getJobDetail().getKey().getGroup() + "." + ctx.getJobDetail().getKey().getName() + "] ended in error:"  );
			LOGGER.error("  Details: ", e);
			LOGGER.error("==================================================================");
		} finally {
			// Temporarily, does nothing.
		}
	}

	/**
	 * Implementation for concrete jobs must be done here.
	 * @param ctx Context of the being executed Job.
	 */
	protected abstract void executeImpl(JobExecutionContext ctx) throws Exception;
	
	/**
	 * @return the applicationContext
	 */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param applicationContext the applicationContext to set
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
