package com.csc.integral.batch.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class IntegralJobListener implements JobListener {

	@Override
	public String getName() {
		return "IntegralJobListener";
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext ctx) {
		// Does nothing.

	}

	@Override
	public void jobToBeExecuted(JobExecutionContext ctx) {
		// Does nothing.

	}

	@Override
	public void jobWasExecuted(JobExecutionContext ctx, JobExecutionException ex) {
		// Does nothing.
	}

}
