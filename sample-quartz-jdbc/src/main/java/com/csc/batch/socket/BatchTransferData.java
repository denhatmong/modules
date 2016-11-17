package com.csc.batch.socket;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is a transfer objct between web-page and Batch framework by Socket. FileName: BatchTransferData.java Create time: 23/11/2007 Change history:
 * Created by iSoftStone at 23/11/2007 Company: iSoftStone Copyright: Copyright (c) 2007
 *
 * @author iSoftStone Batch Process Group
 * @version 1.0
 */
public class BatchTransferData implements Serializable {
	private static final long serialVersionUID = -8579108988924346498L;

	/**
     * Logger for this class
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchTransferData.class);

	private BigInteger uniqueNum;

	private String jobCommand;
	private String jobStatus;

	private Object[] jobParameters;

	private String jobName;

	private String jobDescription;

	private String jobQ;

	private String jobPty;

	private String rtgDta;

	private String log;

	private String logCLPgm;

	private String hold;

	private String user;

	private String jobNumber;

	private String inqMsgRpy;

	private String msgQ;

	private String syslibl;

	private String curlib;

	private String inllibl;

	private String[] valuePairsToChange;

	private String attrToChange;

	private String valueToChange;

	private Date dateToDelay;

	private int secondToDelay;

	private int batchControlType;

	private String rqsDta;

	public String getAttrToChange() {
		return attrToChange;
	}

	public void setAttrToChange(String attrToChange) {
		this.attrToChange = attrToChange;
	}

	public int getBatchControlType() {
		return batchControlType;
	}

	public void setBatchControlType(int batchControlType) {
		this.batchControlType = batchControlType;
	}

	public Date getDateToDelay() {
		return dateToDelay;
	}

	public void setDateToDelay(Date dateToDelay) {
		this.dateToDelay = dateToDelay;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	public String getJobCommand() {
		return jobCommand;
	}

	public void setJobCommand(String jobCommand) {
		this.jobCommand = jobCommand;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public Object[] getJobParameters() {
		return jobParameters;
	}

	public void setJobParameters(Object[] jobParameters) {
		this.jobParameters = jobParameters;
	}

	public String getJobPty() {
		return jobPty;
	}

	public void setJobPty(String jobPty) {
		this.jobPty = jobPty;
	}

	public String getJobQ() {
		return jobQ;
	}

	public void setJobQ(String jobQ) {
		this.jobQ = jobQ;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getLogCLPgm() {
		return logCLPgm;
	}

	public void setLogCLPgm(String logCLPgm) {
		this.logCLPgm = logCLPgm;
	}

	public String getRtgDta() {
		return rtgDta;
	}

	public void setRtgDta(String rtgDta) {
		this.rtgDta = rtgDta;
	}

	public int getSecondToDelay() {
		return secondToDelay;
	}

	public void setSecondToDelay(int secondToDelay) {
		this.secondToDelay = secondToDelay;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String[] getValuePairsToChange() {
		return valuePairsToChange;
	}

	public void setValuePairsToChange(String[] valuePairsToChange) {
		this.valuePairsToChange = valuePairsToChange;
	}

	public String getValueToChange() {
		return valueToChange;
	}

	public void setValueToChange(String valueToChange) {
		this.valueToChange = valueToChange;
	}

	public String getInqMsgRpy() {
		return inqMsgRpy;
	}

	public void setInqMsgRpy(String inqMsgRpy) {
		this.inqMsgRpy = inqMsgRpy;
	}

	public String getMsgQ() {
		return msgQ;
	}

	public void setMsgQ(String msgQ) {
		this.msgQ = msgQ;
	}

	public String getCurlib() {
		return curlib;
	}

	public void setCurlib(String curlib) {
		this.curlib = curlib;
	}

	public String getInllibl() {
		return inllibl;
	}

	public void setInllibl(String inllibl) {
		this.inllibl = inllibl;
	}

	public String getSyslibl() {
		return syslibl;
	}

	public void setSyslibl(String syslibl) {
		this.syslibl = syslibl;
	}

	public String getRqsDta() {
		return rqsDta;
	}

	public void setRqsDta(String rqsDta) {
		this.rqsDta = rqsDta;
	}

	public BigInteger getUniqueNum() {
		return uniqueNum;
	}

	public void setUniqueNum(BigInteger uniqueNum) {
		this.uniqueNum = uniqueNum;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	/**
	 * Trim all String property in BatchTransferData.
	 */
	public void trimData() {
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				Object value = field.get(this);
				if (value != null && value.getClass() == String.class) {
					field.set(this, ((String) value).trim());
				}
			} catch (Exception e) {
				LOGGER.error("Error when trim data for BatchTransferData", e);
			}
		}
	}
}
