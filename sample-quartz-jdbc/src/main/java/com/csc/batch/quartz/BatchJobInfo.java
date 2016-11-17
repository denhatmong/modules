/**
 * 
 */
package com.csc.batch.quartz;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.quartz.JobDetail;

import com.csc.common.AppVars;
import com.csc.common.BatchJobUtils;
import com.csc.common.COBOLAppVars;
import com.csc.common.JobInfo;



/**
 * @author daniel.peng
 * 
 */
public class BatchJobInfo extends JobInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5956631271143989550L;

	private COBOLAppVars appVars = (COBOLAppVars) AppVars.getInstance();

	private final Map<String, Object> attributes = new HashMap<String, Object>(
			20);

	private final Date entryTime;

	// in use attributes amount in batch is 31.
	private static final int ATTR_AMOUNT = 31;

	/**
	 * define regular expression for attribute validation <br>
	 * if not defined, then no validation
	 */
	private static final Map<String, Object> ATTR_PATTERN = new HashMap<String, Object>(
			20);
	static {
		ATTR_PATTERN.put(SWS, "[0|1]{8}");
		ATTR_PATTERN.put(TYPE, "[B]{1}");
		ATTR_PATTERN.put(SUBTYPE, "[E|\u0020]{1}");
	}

	/**
	 * defines default attribute value
	 */

	private static final Map<String, Object> ATTR_DEFAULT = new HashMap<String, Object>(
			20);
	static {
		ATTR_DEFAULT.put(TYPE, "B");
		ATTR_DEFAULT.put(SUBTYPE, " ");
		ATTR_DEFAULT.put(OUTQLIB, COBOLAppVars.LIBL);
		ATTR_DEFAULT.put(ENDSTS, BatchJobUtils.ENDSTS_WAITING);
		ATTR_DEFAULT.put(PRTTXT, "");
		ATTR_DEFAULT.put(LOGLVL, "0");
		ATTR_DEFAULT.put(LOGSEV, "00");
		ATTR_DEFAULT.put(LOGTYPE, "*JOBD");
		ATTR_DEFAULT.put(SWS, "00000000");
		ATTR_DEFAULT.put(RUNPTY, "5");
		ATTR_DEFAULT.put(JOBDLIB, COBOLAppVars.LIBL);
	}

	// indicate if the attribute is changable
	private static final Boolean ATTR_UPDATABLE = Boolean.TRUE;

	// private static final Boolean ATTR_UNUPDATABLE = Boolean.FALSE;
	/**
	 * defines all attributes and if they are updatable; key = attributes name
	 * value == null --> not updatable; value != null --> updatable
	 */
	private static final Map<String, Object> ATTR_LIST = new HashMap<String, Object>(
			ATTR_AMOUNT);
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
		ATTR_LIST.put(ENDSTS, ATTR_UPDATABLE);
		ATTR_LIST.put(RUNPTY, ATTR_UPDATABLE);
		ATTR_LIST.put(SWS, ATTR_UPDATABLE);
		ATTR_LIST.put(DATE, null);
		ATTR_LIST.put(PRTTXT, ATTR_UPDATABLE);
		ATTR_LIST.put(LOGLVL, ATTR_UPDATABLE);
		ATTR_LIST.put(LOGSEV, ATTR_UPDATABLE);
		ATTR_LIST.put(LOGTYPE, ATTR_UPDATABLE);
		ATTR_LIST.put(JOBD, ATTR_UPDATABLE);
		ATTR_LIST.put(JOBDLIB, ATTR_UPDATABLE);
		ATTR_LIST.put(JOBQ, ATTR_UPDATABLE);
		ATTR_LIST.put(CMD, ATTR_UPDATABLE);
		ATTR_LIST.put(SYSLIBL, ATTR_UPDATABLE);
		ATTR_LIST.put(INLLIBL, ATTR_UPDATABLE);
		ATTR_LIST.put(LOG, ATTR_UPDATABLE);
		ATTR_LIST.put(LOGCLPGM, ATTR_UPDATABLE);
		ATTR_LIST.put(INQMSGRPY, ATTR_UPDATABLE);
		ATTR_LIST.put(HOLD, ATTR_UPDATABLE);
		ATTR_LIST.put(MSGQ, ATTR_UPDATABLE);
		ATTR_LIST.put(MSGQLIBL, ATTR_UPDATABLE);
	}

	public BatchJobInfo(String nbr, String name, String type, String subType,
			Date entryTime, String user, String outQueue, String runPty,
			String switches, String printText, String logLevel,
			String logSeverity, String logType, String endSts, String jobd,
			String jobPty, String jobQ, String cmd, String sysLibl,
			String inlLibl, String log, String logCLPgm, String inqMsgRpy,
			String hold, String msgQ, String msgQLibl,String threadNo) {
		super(nbr, name, type, subType, entryTime, user, DEFAULT_LIB + "/"
				+ DEFAULT_OUTQ, runPty, switches, printText, logLevel,
				logSeverity, logType, endSts, jobd, null,threadNo);
		//added by wayne.yang.
		// add trivial SBMMSGQ and SBMMSGQLIB proerties to avoid exception thrown
		// Currently these two not supported by the system.
		this.updateJobInfo("SBMMSGQ", "MSGQ");
		this.updateJobInfo("SBMMSGQLIB", "MSGQLIB");
		this.updateJobInfo(NBR, nbr);
		this.updateJobInfo(JOB, name);
		this.updateJobInfo(TYPE, type);
		this.updateJobInfo(SUBTYPE, subType);
		this.entryTime = (Date) entryTime.clone();
		this.updateJobInfo(USER, user);
		this.updateJobInfo(CURUSER, user);
		String[] parsedOutq = JobUtils.deriveSchema(DEFAULT_LIB + "/"
				+ DEFAULT_OUTQ);
		this.updateJobInfo(OUTQ, parsedOutq[0]);
		this.updateJobInfo(OUTQLIB, parsedOutq[1]);

		this.updateJobInfo(ENDSTS, endSts);
		this.updateJobInfo(RUNPTY, runPty);
		this.updateJobInfo(SWS, switches);
		this.updateJobInfo(PRTTXT, printText);
		this.updateJobInfo(LOGLVL, logLevel);
		this.updateJobInfo(LOGSEV, logSeverity);
		this.updateJobInfo(LOGTYPE, logType);
		this.updateJobInfo(LOGCLPGM, logCLPgm);

		String[] parsedJobd = JobUtils.deriveSchema(DEFAULT_LIB + "/"
				+ DEFAULT_JOBD);
		this.updateJobInfo(JOBD, parsedJobd[0]);
		this.updateJobInfo(JOBDLIB, parsedJobd[1]);

		//add by benny for AT job queue name.
		JOBQ = jobQ;
		//add end
		/*
		 * add by Tom Chi
		 */
		this.updateJobInfo(USRLIBL, USRLIBL);
		//end		
		this.updateJobInfo(JOBQ, jobQ);
		this.updateJobInfo(CMD, cmd);
		this.updateJobInfo(SYSLIBL, sysLibl);
		this.updateJobInfo(INLLIBL, inlLibl);
		this.updateJobInfo(MSGQ, msgQ);
		this.updateJobInfo(MSGQLIBL, msgQLibl);
		this.updateJobInfo(THREAD_NO, threadNo);
	}

	/**
	 * Retrives single job attribute by specified name <br>
	 * usage example: get job no <br>
	 * (BcaAppVars) bac = (BcaAppVars) BcaAppVars.getInstance(); <br>
	 * FixedLengthStringData attrName = new FixedLengthStringData(length,
	 * JobInfo.NBR); <br>
	 * FixedLengthStringData attrValue = new FixedLengthStringData(length); <br>
	 * bac.getJobInfo().retrieveJobInfo(attrName, attrValue); <br>
	 * String jobNo = attrValue.getData(); ....
	 * 
	 * @param inName
	 *            attribute name
	 * @param outValue -
	 *            output, attribute value
	 */
	public void retrieveJobInfo(FixedLengthStringData inName,
			FixedLengthStringData outValue) {
		outValue.set(retrieveJobInfo(inName.getData()));
	}

	/**
	 * Retrives job attributes by specified names <br>
	 * Usage example: <br>
	 * appVars.getJobInfo().retrieveJobInfo(new String[] {"JOB", "USER", "NBR"},
	 * new FixedLengthStringData[] {job, user, nbr});
	 * 
	 * @param nameList
	 *            attribute names
	 * @param outValues -
	 *            attribute values
	 * @param nameList
	 * @param outValues
	 */
	public void retrieveJobInfo(String[] nameList, BaseData[] outValues) {
		if (nameList == null || outValues == null
				|| nameList.length > outValues.length) {
			throw new RuntimeException(
					"Name and value arrays null, or numer of elements mismatch");
		}
		for (int i = 0; i < nameList.length; i++) {
			outValues[i].set(retrieveJobInfo(nameList[i]));
		}
	}

	/**
	 * Retrives a job attribute from the Map of available values. The Map is set
	 * up by whatever creates the Jobinfo in AppVars. In online this is usually
	 * the init section of the controllerServlet. In Batch, it is the batch
	 * scheduler that starts the job.
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
				appVars.addExtMessage("CPF9898", "invalid parameter name - "
						+ attrName);
				return null;
			}
		}
	}

	public void changeJobInfo(String attrName, Object value) {
		checkAndUpdateJobInfo(attrName, value);
	}

	public void changeJobInfo(String[] valuePairs) {
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
	 * set job attributes by specified map This should be amended to improve
	 * effeciency of updating.
	 * 
	 * @param attributes
	 */
	private void changeJobInfo(Map attributes) {
		// check if job is still running
		if (!isAlive()) {
			appVars.addExtMessage("CPF9898", "current job is no available");
			return;
		}

		// change job information
		// some parameters are ignored
		for (Iterator it = attributes.entrySet().iterator(); it.hasNext();) {
			Map.Entry me = (Entry) it.next();
			checkAndUpdateJobInfo((String) me.getKey(), me.getValue());
		}
	}

	private void checkAndUpdateJobInfo(String attrName, Object value) {
		synchronized (this.attributes) {
			if (!isAlive()) {
				appVars.addExtMessage("CPF9898", "job has been cancelled.");
				return;
			} else if (!ATTR_LIST.containsKey(attrName)) {
				appVars.addExtMessage("CPF9898", "attribute is not defined - "
						+ attrName);
				return;
			} else if (ATTR_LIST.get(attrName) == null) {
				appVars.addExtMessage("CPF9898",
						"attribute is not updatable - " + attrName);
			} else {
				// update HashMap
				updateJobInfo(attrName, value);
			}
		}
	}

	private void updateJobInfo(String attrName, Object value) {
		synchronized (this.attributes) {
			if (value == null)
				value = ATTR_DEFAULT.get(attrName);
			if (!validate(attrName, value)) {
				throw new RuntimeException("invalid value for " + attrName);
			} else {
				if (processAttrChange(attrName, value)) {
					this.attributes.put(attrName, value);
				}
			}
		}
	}

	private boolean processAttrChange(String attrName, Object value) {
		if (appVars.getJobInfo() != null) {
			// means this is a change inside the job.
			if (attrName.equals(JOBQ)) {
				if (value == null || !changeJobQ(value.toString())) {
					appVars.addExtMessage("CPF0000", "change jobq failed.");
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * remove a job from a job queue, and submit it to another job queue. 
	 * @param attrName 
	 * 			the name of the attribute 
	 * @param value 
	 * 			the value of the jobQueue
	 * @return 
	 * 			true if change job queue success
	 */
	private boolean changeJobQ(String value) {
		if (BatchJobUtils.ENDSTS_WAITING.equals(appVars.getJobInfo()
				.retrieveJobInfo(JobInfo.ENDSTS))) {
			String jobQueueName = appVars.getJobInfo().retrieveJobInfo(
					JobInfo.JOBQ);
			BatchJobQueue oldJobQueue = BatchJobQueueFactory.getInstance()
					.getJobQueue(jobQueueName);
			BatchJobQueue newJobQueue = BatchJobQueueFactory.getInstance()
					.getJobQueue(value);
			if (newJobQueue == null) {
				appVars.addExtMessage("CPF0000", "unknown new jobq.");
				return false;
			}
			oldJobQueue.holdJobQueue();
			String jobName = appVars.getJobInfo().retrieveJobInfo(JobInfo.JOB);
			String jobNumber = appVars.getJobInfo()
					.retrieveJobInfo(JobInfo.NBR);
			JobDetail jobDetail = oldJobQueue.removeJob(jobName + jobNumber);
			if (jobDetail == null) {
				appVars.addExtMessage("CPF0000", "failed to change jobq.");
				return false;
			}
			oldJobQueue.releaseJobQueue();
			newJobQueue.addJob(jobDetail);
			return true;
		} else {
			// TODO error handling here.
			appVars.addExtMessage("CPF0000",
					"Requested change no longer allowed");
			return false;
		}
	}

	private boolean validate(String attrName, Object value) {
		if (value != null && value instanceof String
				&& ATTR_PATTERN.containsKey(attrName))
			return Pattern.matches((String) ATTR_PATTERN.get(attrName),
					(String) value);
		else
			return true;
	}

	/**
	 * @return Returns the entry date with the format YYMMDD.
	 */
	private String getDate() {

		return COBOLMiscUtils.formatDate(this.entryTime,
				RPGDateFormat.YMD_FORMAT_RPG);
	}

	public synchronized boolean isAlive() {
		String endSts = (String) this.retrieveJobInfo(ENDSTS);
		return endSts != null
				&& (endSts.equals(JobUtils.ENDSTS_PROCESSING)
						|| endSts.equals(JobUtils.ENDSTS_PENDING) || endSts
						.equals(BatchJobUtils.ENDSTS_WAITING));
	}

}
