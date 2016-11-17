package com.csc.batch.socket;

/**
 * This class is responsible for defining the batch control type. FileName: BatchControlType.java Create time:
 * 23/11/2007 Change history: Created by iSoftStone at 23/11/2007 Company: iSoftStone Copyright: Copyright (c) 2007
 * 
 * @author iSoftStone Batch Process Group
 * @version 1.0
 */
public class BatchControlType {

	private BatchControlType() {
	}

	/** Store final variable mean for submiting a job. */
	public static final int SUBMIT_JOB = 1;

	/** Store final variable mean for stopping a job. */
	public static final int STOP_JOB = 2;

	/** Store final variable mean for pausing a job. */
	public static final int PAUSE_JOB = 3;

	/** Store final variable mean for restarting a job. */
	public static final int RESTART_JOB = 4;

	/** Store final variable mean for delaying a job. */
	public static final int DELAY_JOB = 5;

	/** Store final variable mean for holding a job. */
	public static final int HOLD_JOBQ = 6;

	/** Store final variable mean for releasing a job. */
	public static final int RELEASE_JOBQ = 7;

	/** Store final variable mean for change a job. */
	public static final int CHANGE_JOB = 8;

}
