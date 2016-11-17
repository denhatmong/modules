/**
 * 
 */
package com.csc.integral.batch.job;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csc.batch.socket.BatchTransferData;

/**
 * Comparator for job queue, base on priority of job.
 * 
 * @author qpham4
 * @version 1.0
 * 
 */
public class JobComparator implements Comparator<BatchTransferData> {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobComparator.class);

	@Override
	public int compare(BatchTransferData object1, BatchTransferData object2) {
		int compareIndicator = 0;
		try {
			// Compare job priority.
			int int1 = Integer.valueOf(object1.getJobPty().trim());
			int int2 = Integer.valueOf(object2.getJobPty().trim());
			compareIndicator = int1 - int2;
		} catch (Exception e) {
			LOGGER.error("Fail to compare job priority.", e);
		}
		return compareIndicator;
	}

}
