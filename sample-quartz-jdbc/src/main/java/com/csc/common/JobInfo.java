package com.csc.common;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Details about a job.
 *
 * @author Quipoz - Max Wang
 * @version 1.0 20/02/2007 Manually coded
 */
public class JobInfo implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobInfo.class);

	private COBOLAppVars appVars = (COBOLAppVars) COBOLAppVars.getInstance();

	/**
	 * attributes map
	 */
	private final Map attributes = new HashMap(20);

	// entry date
	private final Date entryTime;

	/**
	 * definition for attributes' values
	 */
	public static final String CURLIB = "CURLIB";

	public static final String TYPE_BATCH = "B";

	public static final String SUBTYPE_PGM = "E";

	public static final String SUBTYPE_OTHERS = " ";

	// default Job Values
	public static final String DEFAULT_JOBD = "QDFTJOBD";
	public static final String DEFAULT_LIB = "QGPL";
	public static final String DEFAULT_OUTQ = "PRTQ";

	/**
	 * definition of attributes' name
	 *
	 * @see CL command references
	 */
	// job no. It is used as identifier in new System
	public static final String NBR = "NBR";

	// JOB NAME
	public static final String JOB = "JOB";

	// User name
	public static final String USER = "USER";

	// Current User name
	public static final String CURUSER = "CURUSER";

	// user library list
	public static final String USRLIBL = "USRLIBL";

	// job type, B = batch, Currently, only support batch job
	public static final String TYPE = "TYPE";

	// sub type, E = envoked by program, Blank = others
	public static final String SUBTYPE = "SUBTYPE";

	// out queue name
	public static final String OUTQ = "OUTQ";

	// out queue library
	public static final String OUTQLIB = "OUTQLIB";

	// end status, 0=processing, 1=cancelling, 2=cancelled, 3=completed,
	// -1=waiting,
	public static final String ENDSTS = "ENDSTS";

	// run priority
	public static final String RUNPTY = "RUNPTY";

	// switches for the job. 8 characters value, could be 0/1
	public static final String SWS = "SWS";

	// job entry date, YYMMDD
	public static final String DATE = "DATE";

	// print text
	public static final String PRTTXT = "PRTTXT";

	// LOG FLAG
	public static final String LOGLVL = "LOGLVL";

	// log severity
	public static final String LOGSEV = "LOGSEV";

	// log text
	public static final String LOGTYPE = "LOGTYPE";

	// job queue name
	public static final String JOBD = "JOBD";

	// log queue library
	public static final String JOBDLIB = "JOBDLIB";

	public static final String THREAD_NO = "THREADNO";

	public static String JOBQ = "JOBQ";

	public static final String CMD = "CMD";

	public static final String SYSLIBL = "SYSLIBL";

	public static final String INLLIBL = "INLLIBL";

	public static final String LOG = "LOG";

	public static final String LOGCLPGM = "LOGCLPGM";

	public static final String INQMSGRPY = "INQMSGRPY";

	public static final String HOLD = "HOLD";

	public static final String MSGQ = "MSGQ";

	public static final String MSGQLIBL = "MSGQLIBL";

	private static final int ATTR_AMOUNT = 20;

	// ISSUE benny ADD USERPRF
	public static String USERPRF = "USERPRF";

	/**
	 * define regular expression for attribute validation <br>
	 * if not defined, then no validation
	 */
	private static final Map ATTR_PATTERN = new HashMap(20);
	static {
		ATTR_PATTERN.put(SWS, "[0|1]{8}");
		ATTR_PATTERN.put(TYPE, "[B]{1}");
		ATTR_PATTERN.put(SUBTYPE, "[E|\u0020]{1}");
	}

	/**
	 * defines default attribute value
	 */

	private static final Map ATTR_DEFAULT = new HashMap(20);
	static {
		ATTR_DEFAULT.put(TYPE, "B");
		ATTR_DEFAULT.put(SUBTYPE, " ");
		ATTR_DEFAULT.put(OUTQLIB, COBOLAppVars.LIBL);
		ATTR_DEFAULT.put(ENDSTS, "0");
		ATTR_DEFAULT.put(PRTTXT, "");
		ATTR_DEFAULT.put(LOGLVL, "0");
		ATTR_DEFAULT.put(LOGSEV, "00");
		ATTR_DEFAULT.put(LOGTYPE, "*JOBD");
		ATTR_DEFAULT.put(SWS, "00000000");
		ATTR_DEFAULT.put(RUNPTY, "5");
		ATTR_DEFAULT.put(JOBDLIB, COBOLAppVars.LIBL);
	}

	/*
	 * match attributes name and corresponding table columns
	 */
	public static final Map ATTR_COLUMN = new HashMap(20);
	static {
		ATTR_COLUMN.put(NBR, "JOB_ID");
		ATTR_COLUMN.put(USER, "JOB_USER");
		ATTR_COLUMN.put(THREAD_NO, "THREADNO");
		ATTR_COLUMN.put(CURUSER, "JOB_USER");
		ATTR_COLUMN.put(JOB, "JOB_NAME");
		ATTR_COLUMN.put(OUTQ, "OUTQ");
		ATTR_COLUMN.put(OUTQLIB, "OUTQLIB");
		ATTR_COLUMN.put(JOBD, "job_desc_name");
		ATTR_COLUMN.put(JOBDLIB, "job_desc_library");
		ATTR_COLUMN.put(PRTTXT, "PRTTXT");
	}

	// indicate if the attribute is changable
	private static final Boolean ATTR_UPDATABLE = Boolean.TRUE;

	// private static final Boolean ATTR_UNUPDATABLE = Boolean.FALSE;
	/**
	 * defines all attributes and if they are updatable; key = attributes name value == null --> not updatable; value !=
	 * null --> updatable
	 */
	private static final Map ATTR_LIST = new HashMap(ATTR_AMOUNT);
	static {
		ATTR_LIST.put(NBR, null);
		ATTR_LIST.put(JOB, null);
		ATTR_LIST.put(USER, ATTR_UPDATABLE);
		ATTR_LIST.put(THREAD_NO, ATTR_UPDATABLE);
		ATTR_LIST.put(CURUSER, ATTR_UPDATABLE);
		ATTR_LIST.put(USRLIBL, ATTR_UPDATABLE);
		ATTR_LIST.put(TYPE, null);
		ATTR_LIST.put(SUBTYPE, null);
		ATTR_LIST.put(OUTQ, ATTR_UPDATABLE);
		ATTR_LIST.put(OUTQLIB, ATTR_UPDATABLE);
		ATTR_LIST.put(ENDSTS, null);
		ATTR_LIST.put(RUNPTY, ATTR_UPDATABLE);
		ATTR_LIST.put(SWS, ATTR_UPDATABLE);
		ATTR_LIST.put(DATE, null);
		ATTR_LIST.put(PRTTXT, ATTR_UPDATABLE);
		ATTR_LIST.put(LOGLVL, ATTR_UPDATABLE);
		ATTR_LIST.put(LOGSEV, ATTR_UPDATABLE);
		ATTR_LIST.put(LOGTYPE, ATTR_UPDATABLE);
		ATTR_LIST.put(JOBD, ATTR_UPDATABLE);
		ATTR_LIST.put(JOBDLIB, ATTR_UPDATABLE);
	}

	/**
	 * constructor
	 *
	 * @param id
	 * @param name
	 * @param entryTime
	 * @param user
	 * @param outQueue
	 */
	public JobInfo(String id, String name, Date entryTime, String user, String outQueue, String jobd, String usrlibl) {
		this(id, name, null, null, entryTime, user, outQueue, null, null, null, null, null, null, null, jobd, USRLIBL,null);
	}

	/**
	 * constructor
	 *
	 * @param id
	 * @param name
	 * @param entryTime
	 * @param user
	 */
	public JobInfo(String id, String name, Date entryTime, String user) {
		this(id, name, null, null, entryTime, user, DEFAULT_LIB + "/" + DEFAULT_OUTQ, null, null, null, null, null,
		    null, null, DEFAULT_LIB + "/" + DEFAULT_JOBD, USRLIBL,null);
	}

	/**
	 * constructor
	 *
	 * @param id
	 * @param name
	 * @param type
	 * @param subType
	 * @param entryTime
	 * @param user
	 * @param outQueue
	 * @param runPty
	 * @param switches
	 * @param printText
	 * @param logLevel
	 * @param logSeverity
	 * @param logType
	 */
	public JobInfo(String id, String name, String type, String subType, Date entryTime, String user, String outQueue,
	        String runPty, String switches, String printText, String logLevel, String logSeverity, String logType,
	        String endSts, String jobd, String usrlibl,String threadNo) {

		this.updateJobInfo(NBR, id);
		this.updateJobInfo(JOB, name);
		this.updateJobInfo(TYPE, type);
		this.updateJobInfo(SUBTYPE, subType);
		this.entryTime = (Date) entryTime.clone();
		this.updateJobInfo(USER, user);
		this.updateJobInfo(THREAD_NO, threadNo);
		this.updateJobInfo(CURUSER, user);
		String[] parsedOutq = JobUtils.deriveSchema(outQueue);
		this.updateJobInfo(OUTQ, parsedOutq[0]);
		this.updateJobInfo(OUTQLIB, parsedOutq[1]);

		this.updateJobInfo(ENDSTS, endSts);
		this.updateJobInfo(RUNPTY, runPty);
		this.updateJobInfo(SWS, switches);
		this.updateJobInfo(PRTTXT, printText);
		this.updateJobInfo(LOGLVL, logLevel);
		this.updateJobInfo(LOGSEV, logSeverity);
		this.updateJobInfo(LOGTYPE, logType);

		String[] parsedJobd = JobUtils.deriveSchema(jobd);
		this.updateJobInfo(JOBD, parsedJobd[0]);
		this.updateJobInfo(JOBDLIB, parsedJobd[1]);

		// add by benny
		this.updateJobInfo(USRLIBL, USRLIBL);
	}

	/**
	 * set attributes without validation
	 *
	 * @param attrName
	 * @param value
	 * @return if setter has been executed successfully
	 */
	private void updateJobInfo(String attrName, Object value) {
		synchronized (this.attributes) {
			if (value == null)
				value = ATTR_DEFAULT.get(attrName);
			if (!validate(attrName, value)) {
				throw new RuntimeException("invalid value for " + attrName);
			} else
				this.attributes.put(attrName, value);

		}
	}

	/**
	 * Retrives single job attribute by specified name <br>
	 * usage example: get job no <br>
	 * (BcaAppVars) bac = (BcaAppVars) BcaAppVars.getInstance(); <br>
	 * FixedLengthStringData attrName = new FixedLengthStringData(length, JobInfo.NBR); <br>
	 * FixedLengthStringData attrValue = new FixedLengthStringData(length); <br>
	 * bac.getJobInfo().retrieveJobInfo(attrName, attrValue); <br>
	 * String jobNo = attrValue.getData(); ....
	 *
	 * @param inName attribute name
	 * @param outValue - output, attribute value
	 */
	public void retrieveJobInfo(FixedLengthStringData inName, FixedLengthStringData outValue) {
		outValue.set(retrieveJobInfo(inName.getData()));
	}

	/**
	 * Retrives job attributes by specified names <br>
	 * Usage example: <br>
	 * appVars.getJobInfo().retrieveJobInfo(new String[] {"JOB", "USER", "NBR"}, new FixedLengthStringData[] {job, user,
	 * nbr});
	 *
	 * @param nameList attribute names
	 * @param outValues - attribute values
	 * @param nameList
	 * @param outValues
	 */
	public void retrieveJobInfo(String[] nameList, BaseData[] outValues) {
		if (nameList == null || outValues == null || nameList.length > outValues.length) {
			throw new RuntimeException("Name and value arrays null, or numer of elements mismatch");
		}
		for (int i = 0; i < nameList.length; i++) {
			outValues[i].set(retrieveJobInfo(nameList[i]));
		}
	}

	/**
	 * Retrives a job attribute from the Map of available values. The Map is set up by whatever creates the Jobinfo in
	 * AppVars. In online this is usually the init section of the controllerServlet. In Batch, it is the batch scheduler
	 * that starts the job.
	 *
	 * @param nameList
	 * @return
	 */
	public Map retrieveJobInfo(String[] nameList) {
		Map attributes = new HashMap(nameList.length);
		if (nameList != null) {
			for (int i = 0; i < nameList.length; i++) {
				Object attrValue;
				if (nameList[i].equals(JobInfo.CURLIB)) {
					// get current lib
					attrValue = appVars.getPossibleSchemas(CURLIB)[0];
				} else if (nameList[i].equals(JobInfo.USRLIBL)) {
					// get user library list
					StringData result = new StringData();
					appVars.retrieveUserProfile(JobInfo.USRLIBL, result);
					attrValue = result.getData();
				} else {
					attrValue = retrieveJobInfo(nameList[i]);
				}
				attributes.put(nameList[i], attrValue);
			}
		}
		return attributes;
	}

	/**
	 * @param attrName
	 * @return
	 */
	public String retrieveJobInfo(String attrName) {
		synchronized (this.attributes) {
			if (DATE.equals(attrName)) {
				return getDate();
			} else if (this.attributes.containsKey(attrName))
				return (String) attributes.get(attrName);
			else {
				appVars.addExtMessage("CPF9898", "invalid parameter name - " + attrName);
				return null;
			}
		}
	}

	/**
	 * set job attributes by specified string values implements CHGJOB <br>
	 * sample: <br>
	 * (BcaAppVars) bac = (BcaAppVars) BcaAppVars.getInstance(); <br>
	 * bav.getJobInfo().changeJobInfo(new String[]{OUTQ=outq10, OUTQLIB=*LIBL}); <br>
	 *
	 * @param valuePairs e.g. "NBR=123, JOB=batchjob1" <br>
	 *            CPF1336 - incorrect parameter
	 */
	public void changeJobInfo(String[] valuePairs) {

		// parse value pairs
		if (valuePairs.length > 0) {
			Map tempMap = new HashMap(valuePairs.length);
			for (int i = 0; i < valuePairs.length; i++) {
				String[] temp = valuePairs[i].split("=");
				if (temp.length != 2) {
					appVars.addExtMessage("CPF1336", "incorrect parameter");
					return;
				}
				// validate parameters, if validator not defined, true will be
				// returned
				tempMap.put(temp[0].trim(), temp[1].trim());
			}
			changeJobInfo(tempMap);
		}
	}

	/**
	 * set job attributes by specified map This should be amended to improve effeciency of updating.
	 *
	 * @param attributes
	 */
	private void changeJobInfo(Map attributes) {

		// check if job is still running
		if (!isAlive()) {
			appVars.addExtMessage("CPF9898", "current job is no available");
			return;
		}

		// update database
		PreparedStatement ps = null;
		String HERE = QPUtilities.getThisClass() + " changeJobInfo";
		Connection conn;
		boolean savedAutoCommit;
		try {
			conn = appVars.getAnotherDBConnection(HERE);
			savedAutoCommit = conn.getAutoCommit();
		} catch (SQLException e) {
			LOGGER.error("Exception:\n", e);
			appVars.addExtMessage("CPF9898", "failed to get database connection");
			return;
		}
		// get connection with transaction control
		try {
			// update database
			ps = prepareUpdateSql(conn, attributes);
			if (ps != null) {
				conn.setAutoCommit(false);
				int i = appVars.executeUpdate(ps);
				if (i != 1) {
					appVars.addExtMessage("CPF9898", "failed to update database.");
					return;
				}
			}
			// change job information && commit database changes
			// some parameters are ignored
			try {
				for (Iterator it = attributes.entrySet().iterator(); it.hasNext();) {
					Map.Entry me = (Entry) it.next();
					checkAndUpdateJobInfo((String) me.getKey(), me.getValue());
				}
			} catch (RuntimeException e) {
				// rollback database changes
				if (ps != null && conn != null) {
					conn.rollback();
				}
				throw e;
			}
			// commit database changes
			if (ps != null && conn != null)
				conn.commit();
		} catch (SQLException e) { //
			try {
				conn.rollback();
			} catch (SQLException e1) {
				appVars.addDiagnostic("failed rollback in jobinfo");
			}
			LOGGER.error("Exception:\n", e);
			appVars.addExtMessage("CPF9898", "failed to update job information");
			return;
		} finally {
			if (ps != null) {
				try {
					conn.setAutoCommit(savedAutoCommit);
				} catch (SQLException e) {
					throw new SQLRuntimeException(e);
				}
			}
			appVars.freeDBConnectionIgnoreErr(conn, ps, null);
		}

	}

	/**
	 * set attributes with validation
	 *
	 * @param attrName
	 * @param value
	 * @return if setter has been executed successfully
	 */
	public void changeJobInfo(String attrName, Object value) {
		Map temp = new HashMap(1);
		temp.put(attrName, value);
		changeJobInfo(temp);
	}

	/**
	 * set attributes with validation
	 *
	 * @param attrName
	 * @param value
	 * @return if setter has been executed successfully
	 */
	private void checkAndUpdateJobInfo(String attrName, Object value) {
		synchronized (this.attributes) {
			if (!isAlive()) {
				appVars.addExtMessage("CPF9898", "job has been cancelled.");
				return;
			} else if (!ATTR_LIST.containsKey(attrName)) {
				appVars.addExtMessage("CPF9898", "attribute is not defined - " + attrName);
				return;
			} else if (ATTR_LIST.get(attrName) == null) {
				appVars.addExtMessage("CPF9898", "attribute is not updatable - " + attrName);
			} else {
				// update HashMap
				updateJobInfo(attrName, value);
			}
		}
	}

	/**
	 * String we may need to use \" to contain the value
	 *
	 * @param attributes
	 * @return sql command to update JOB_INFO_COMMISSION
	 * @throws SQLException
	 */
	private PreparedStatement prepareUpdateSql(Connection conn, Map attributes) throws SQLException {

		if (attributes == null || attributes.size() == 0)
			return null;
		else {
			StringBuffer sql = new StringBuffer("UPDATE ");
			sql.append(appVars.getAppConfig().getFwSchema()).append('.').append(JobUtils.JOB_SUBMISSION_TABLE).append(
			    " SET ");
			boolean updateDb = false;
			StringArrayList parmList = new StringArrayList(attributes.size());
			int count = 0;
			for (Iterator it = attributes.entrySet().iterator(); it.hasNext();) {
				Entry element = (Entry) it.next();
				if (ATTR_COLUMN.containsKey(element.getKey())) {
					if (updateDb) {
						sql.append(',');
					}
					sql.append(ATTR_COLUMN.get(element.getKey())).append(" = ? ");
					updateDb = true;
					parmList.add(count, element.getValue());
					count++;
				}
			}

			if (updateDb) {
				sql.append(" WHERE JOB_ID = ?");
				PreparedStatement ps = appVars.prepareStatement(conn, sql.toString());
				int index = 1;
				// set parameters for sql statements
				for (int i = 0; i < parmList.size(); i++) {
					ps.setString(index++, parmList.get(i));
				}
				ps.setString(index, retrieveJobInfo(NBR));
				return ps;
			} else
				return null;
		}
	}

	/**
	 * validate parameter value. it is unused at this moment.
	 */

	private boolean validate(String attrName, Object value) {
		if (value != null && value instanceof String && ATTR_PATTERN.containsKey(attrName))
			return Pattern.matches((String) ATTR_PATTERN.get(attrName), (String) value);
		else
			return true;
	}

	/**
	 * @param endStatus The endStatus to set.
	 */
	public void cancel(boolean immed) {
		String endStatus;
		if (immed)
			endStatus = JobUtils.ENDSTS_CANCELLED;
		else
			endStatus = JobUtils.ENDSTS_CANCELLING;
		this.updateJobInfo(ENDSTS, endStatus);
	}

	/**
	 * @return if the job is running
	 */
	public synchronized boolean isAlive() {
		String endSts = (String) this.retrieveJobInfo(ENDSTS);
		return endSts != null && (endSts.equals(JobUtils.ENDSTS_PROCESSING) || endSts.equals(JobUtils.ENDSTS_PENDING));
	}

	/**
	 * @return Returns the entry date with the format YYMMDD.
	 */
	private String getDate() {

		return COBOLMiscUtils.formatDate(this.entryTime, RPGDateFormat.YMD_FORMAT_RPG);
	}

	/**
	 * Delay Job delays the current job by the specified number of seconds
	 *
	 * @param delay - Number of seconds to delay
	 */
	public void delayJob(BaseData delay) {
		delayJob(delay.toInt());
	}

	/**
	 * Delay Job delays the current job by the specified number of seconds
	 *
	 * @param delay - Number of seconds to delay
	 */
	public void delayJob(int delay) {
		// delay time comes in as secs, need to convert to milliseconds
		int delayMillis = delay * 1000;
		try {
			Thread.sleep(delayMillis);
		} catch (InterruptedException ie) {
			// do nothing
		}
	}
}