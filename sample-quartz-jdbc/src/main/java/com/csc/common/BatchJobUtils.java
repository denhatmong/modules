package com.csc.common;

public class BatchJobUtils {
		// Batch job entrance command.
		public static final String BATCH_ENTRANCE_COMMAND = "BMANMTHRD";
		// Batch Job Info.
		public static final String BATCH_JOB_INF = "BATCH_JOB_INF";
		// Batch Job AppVars.
		public static final String BATCH_APPVARS = "BATCH_APPVARS";

		// constant definitions
		public static final String JOB_SUBMISSION_TABLE = "BATCH_JOB_SUBMISSIONS";

		// Job Status Constants
		public static final String ENDSTS_WAITING = "-1";
		public static final String ENDSTS_PROCESSING = "0";
		public static final String ENDSTS_CANCELLING = "1";
		public static final String ENDSTS_CANCELLED = "2";
		public static final String ENDSTS_COMPLETED = "3";
		public static final String ENDSTS_PENDING = "4";
		public static final String ENDSTS_ERROR = "5";

		// Job Information
		public static final String JOB_ID_SEQ = "BATCH_JOB_ID";
		public static final String JOB_INFO = "RPGJOBINFO";
		public static final String JOB_BASE_MODEL = "BASEMODEL";
		public static final String KEY_YES = "*YES";
		public static final String JOB_CMD = "CMD";
		public static final String JOB_CURLIB = "CURLIB";
		public static final String JOB_INLLIBL = "INLLIBL";
		public static final String JOB_PARAMS = "PARAMS";
		public static final String ERR_PGM_NOT_FOUND = "CPD0170";
		public static final String JOB_RQSDTA = "RQSDTA";
		// more information
		public static final String JOB_NAME = "BATCH_JOB_NAME";
		public static final String JOB_DESC = "BATCH_JOB_DESC";
		public static final String JOB_Q = "BATCH_JOB_Q";
		public static final String JOB_PTY = "BATCH_JOB_PTY";
		public static final String JOB_RTGDTA = "BATCH_JOB_RTGDTA";
		public static final String JOB_LOG = "BATCH_JOB_LOG";
		public static final String JOB_CLPGM = "BATCH_JOB_CLPGM";
		public static final String JOB_HOLD = "BATCH_JOB_HOLD";
		public static final String JOB_USER = "BATCH_JOB_USER";
		public static final String JOB_ENTRYTIME = "BATCH_JOB_ENTRYTIME";
}
