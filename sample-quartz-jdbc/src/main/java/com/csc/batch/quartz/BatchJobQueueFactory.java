package com.csc.batch.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.quipoz.framework.datatype.FixedLengthStringData;

/**
 * The factory class of batch job queue.
 * 
 * @author daniel.peng
 * @version 1.0
 * 
 */
public class BatchJobQueueFactory {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchJobQueueFactory.class);

	/**
	 * The default name of the job queue.
	 */
	private static FixedLengthStringData defaultJobQueueName;

	/**
	 * The name of batch config file.
	 */
	private static final String BATCH_CFG_FILE = "config.properties";

	/**
	 * The key of the jobqueues in config file.
	 */
	private static final String BATCH_CFG_JOBQUEUES = "batch.jobQueues";

	/**
	 * The key of the default job queues in the config file.
	 */
	private static final String BATCH_CFG_DFTJOBQUEUE = "batch.defaultJobQueue";

	/**
	 * The key name of the jobqueue's separator in config file.
	 */
	private static final String BATCH_CFG_JOBQUEUES_SEPARATOR = ",";

	/**
	 * The key name of the jobqueue's params separator in config file.
	 */
	private static final String BATCH_CFG_JOBQUEUES_PARAMS_SEPARATOR = ":";

	/**
	 * The key name of the jobqueue's params start charator in config file.
	 */
	private static final String BATCH_CFG_JOBQUEUES_PARAMS_START = "(";

	/**
	 * The key name of the jobqueue's params end charator in config file.
	 */
	private static final String BATCH_CFG_JOBQUEUES_PARAMS_END = ")";

	/**
	 * The map contains all job queues.
	 */
	private static Map<String, BatchJobQueue> jobQueueMap = new HashMap<String, BatchJobQueue>();

	/**
	 * The singleton instance of BatchJobQueueFactory.
	 */
	private static BatchJobQueueFactory instance;

	/*
	 * The private Constructor of BatchJobQueueFactory.
	 */
	private BatchJobQueueFactory() {

	}

	/**
	 * Get the instance of BatchJobQueueFactory.
	 * 
	 * @return instance of BatchJobQueueFactory.
	 */
	public static BatchJobQueueFactory getInstance() {
		if (instance == null) {
			instance = new BatchJobQueueFactory();
		}
		return instance;
	}

	/**
	 * Get the specified job queue.
	 * 
	 * @param jobQueueName
	 *            the name of the job queue.
	 * @return the instance of the specified job queue.
	 */
	public BatchJobQueue getJobQueue(String jobQueueName) {
		BatchJobQueue batchJobQueue = null;
		if (jobQueueMap.containsKey(jobQueueName)) {
			batchJobQueue = (BatchJobQueue) jobQueueMap.get(jobQueueName);
		}
		return batchJobQueue;
	}

	/**
	 * Get the map of the job queues.
	 * 
	 * @return the map of the job queues.
	 */
	public Map<String, BatchJobQueue> getJobQueueMap() {
		return jobQueueMap;
	}

	/**
	 * Initialize all the job queues.
	 */
	public void initializeJobQueues() {
		Properties props = new Properties();
		try {
			 props.load(this.getClass().getClassLoader().getResourceAsStream(
			 BATCH_CFG_FILE));
			//InputStream is = new FileInputStream("app\\java\\"+BATCH_CFG_FILE);
			//props.load(is);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		defaultJobQueueName = new FixedLengthStringData(props
				.getProperty(BATCH_CFG_DFTJOBQUEUE));
		String jobQueuesStr = props.getProperty(BATCH_CFG_JOBQUEUES);
		constructJobQueues(jobQueuesStr);
	}

	/*
	 * @param jobQueuesStr the config String in the properties file.
	 */
	private void constructJobQueues(String jobQueuesStr) {
		String[] jobQueuesAry = jobQueuesStr
				.split(BATCH_CFG_JOBQUEUES_SEPARATOR);
		String jobQueueName;
		int jobQueueLmt;
		String tmp;
        LOGGER.debug("The Batch Server contain " + jobQueuesAry.length + " jobQ");
		for (int i = 0; i < jobQueuesAry.length; i++) {
			tmp = jobQueuesAry[i].trim();
			jobQueueName = tmp.substring(0,
					tmp.indexOf(BATCH_CFG_JOBQUEUES_PARAMS_START)).trim();
			String paramsStr = tmp.substring(
					tmp.indexOf(BATCH_CFG_JOBQUEUES_PARAMS_START) + 1,
					tmp.indexOf(BATCH_CFG_JOBQUEUES_PARAMS_END)).trim();
			String[] paramsAry = paramsStr
					.split(BATCH_CFG_JOBQUEUES_PARAMS_SEPARATOR);
			// parse job queue params.
			jobQueueLmt = Integer.parseInt(paramsAry[0].trim());

			BatchJobQueue jobQueue = new BatchJobQueue(jobQueueName,
					jobQueueLmt);
			jobQueue.releaseJobQueue();
            LOGGER.debug("Created " + jobQueueName + " JobQ completed.");
			jobQueueMap.put(jobQueueName, jobQueue);
		}
	}

	/**
	 * Get the default batch job queue.
	 * 
	 * @return the default batch job queue.
	 */
	public FixedLengthStringData getDefaultBatchJobQueueName() {
		return defaultJobQueueName;
	}

	/**
	 * Hold the specified job queue.
	 * 
	 * @param strJobQueueName
	 *            the name of the job queue.
	 */
	public void holdJobQueue(String strJobQueueName) {
		BatchJobQueue jobQueue = getJobQueue(strJobQueueName);
		if (jobQueue != null) {
			jobQueue.holdJobQueue();
		} else {
			throw new RuntimeException("unknown job queue.");
		}
	}

	/**
	 * Release the specifed job queue.
	 * 
	 * @param strJobQueueName
	 *            the name of the job queue.
	 */
	public void releaseJobQueue(String strJobQueueName) {
		BatchJobQueue jobQueue = getJobQueue(strJobQueueName);
		if (jobQueue != null) {
			jobQueue.releaseJobQueue();
		} else {
			throw new RuntimeException("unknown job queue.");
		}
	}

}
