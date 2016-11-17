package com.csc.batch.quartz;

import java.util.Comparator;

import org.quartz.JobDetail;

import com.csc.common.BatchJobUtils;
import com.csc.common.JobInfo;


/**
 * This class is responsible for compare the schedule of the queue according to
 * the priority descend. FileName: SequenceComparator.java Create time:
 * 2007-9-28
 * 
 * Change history: 
 * Created by iSoftStone at 2007-9-28
 * 
 * Copyright (2007) CSC Asia, all rights reserved
 * 
 * @author iSoftStone Batch Process Group
 * @version 1.0
 */
public class BatchSequenceComparator implements Comparator {

	/**
	 * Rewrite the compare method.
	 * 
	 * Created Time: 2007-9-28 Modified Time: 2007-9-28 Created By: iSoftStone
	 * Batch Process Group
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	private int compare(JobDetail o1, JobDetail o2) {
		// get the first schedule priority
		String strPriority1 = ((BatchJobInfo) o1.getJobDataMap().get(
				BatchJobUtils.BATCH_JOB_INF)).retrieveJobInfo(JobInfo.RUNPTY);
		// get the second schedule priority
		String strPriority2 = ((BatchJobInfo) o2.getJobDataMap().get(
				BatchJobUtils.BATCH_JOB_INF)).retrieveJobInfo(JobInfo.RUNPTY);
		// transform them to Long
		Long long1 = Long.valueOf(strPriority1);
		Long long2 = Long.valueOf(strPriority2);
		// transform them to int
		int int1 = long1.intValue();
		int int2 = long2.intValue();
		return int1 - int2;
	}

	public int compare(Object o1, Object o2) {
		return compare((JobDetail) o1, (JobDetail) o2);
	}
}