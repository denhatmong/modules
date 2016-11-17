package com.csc.batch.api;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csc.batch.socket.BatchTransferData;
import com.csc.common.AppVars;
import com.csc.common.Smart400SQLHelper;
import com.quipoz.framework.support.SQLUtils;

/**
 * @author lin.yang
 *
 */
public class BatchDataAccess {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchDataAccess.class);

	private static final transient Smart400SQLHelper smart400SQLHelper = new Smart400SQLHelper();
	
	/**
	 * To insert new batchdata into table JOBSUBMIT when on-line submits job.
	 * 
	 * @param appvars
	 * @param data
	 */
	public static BigInteger writeBatchData(AppVars appvars, BatchTransferData data) {
//		Smart400SQLHelper smart400SQLHelper = Smart400SQLHelperFactory.getInstance(appvars.getAppConfig().getDatabaseType());
		return smart400SQLHelper.writeBatchData(appvars, data);
	}
	
	
	/**
	 * To query qualified batchjob records and populate them into
	 * BatchTransferData objects to run.
	 * 
	 * @param criterialClause
	 * @return Qualified batchdata to run
	 * 
	 * The default sitution is to return those records whose JOBSTATUS 
	 * are 50(AVAILABLE) ordered by JOBSUMTIME ASC.
	 */
	public static ArrayList<BatchTransferData> fetchBatchData(AppVars appvars, String criterialClause) {
			
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<BatchTransferData> qualifiedBatch = new ArrayList<BatchTransferData>();
		StringBuilder querySql = new StringBuilder();
		StringBuilder updateSql = new StringBuilder();
		
		String systemDate = SQLUtils.getSystemDate();
				
		querySql.append("SELECT * FROM JOBSUBMIT ");
		if(criterialClause == null || criterialClause.equals("")) {
			querySql.append("WHERE JOBSTATUS='50' ");
			querySql.append("AND COMPANY = '");
			querySql.append("1");
			querySql.append("' ");
			querySql.append("ORDER BY UNIQUE_NUMBER");
		}else {
			querySql.append(criterialClause);
		}
		
		updateSql.append("UPDATE JOBSUBMIT SET ")
		         .append("JOBSTATUS='10', ")
			     .append("JOBSTRTIM=" + systemDate + " ")
			     .append("WHERE COMPANY = '")
			     .append("1")
			     .append("' AND UNIQUE_NUMBER=?");
		         
		try {
			con = appvars.getTempDBConnection("DB");
			ps = con.prepareStatement(updateSql.toString());
			st = con.createStatement();
			rs = st.executeQuery(querySql.toString());
			
			while(rs.next()) {
				BatchTransferData temp = new BatchTransferData();
				temp.setUniqueNum(rs.getBigDecimal("UNIQUE_NUMBER").toBigInteger());
				temp.setJobCommand(rs.getString("JOBCOMMAND"));
				temp.setJobStatus(rs.getString("JOBSTATUS"));				
				String[] jobParas = new String[Integer.parseInt(rs.getString("JOBPARANUM"))];
				for(int j=0; j<jobParas.length; j++) {
					jobParas[j] = rs.getString("JOBPARA"+(j+1));
				}
				temp.setJobParameters(jobParas);
	            temp.setBatchControlType(Integer.parseInt(rs.getString("BATCHCONTY")));
	            temp.setJobName(rs.getString("JOBNAME"));
	            temp.setJobDescription(rs.getString("JOBDESC"));
	            temp.setJobQ(rs.getString("JOBQUEUE"));
	            temp.setJobPty(rs.getString("JOBPRITY"));
	            temp.setRtgDta(rs.getString("RTGDTA"));
	            temp.setLog(rs.getString("LOGOPTION"));
	            temp.setLogCLPgm(rs.getString("LOGOPTION"));
	            temp.setHold(rs.getString("HOLD"));
	            temp.setUser(rs.getString("USERNAME"));
	            temp.setInqMsgRpy(rs.getString("INGMSGRPY"));
	            temp.setMsgQ(rs.getString("MSGQ"));
	            temp.setSyslibl(rs.getString("SYSLIBL"));
	            temp.setCurlib(rs.getString("CURLIB"));
	            temp.setInllibl(rs.getString("INLLIBL"));
	            temp.setRqsDta(rs.getString("RQSDTA"));
	            qualifiedBatch.add(temp);
	            
	            ps.setBigDecimal(1, new BigDecimal(temp.getUniqueNum()));
	            ps.addBatch();
			}
			
			int[] updatedCount = null;
			if(qualifiedBatch.size() > 0) {
				updatedCount = ps.executeBatch();
				if(updatedCount.length != qualifiedBatch.size())
					appvars.addDiagnostic("Job Update Missing!");
			}   			
		} catch (SQLException e) {			
			LOGGER.error("Job Fetch Fail! Reason:\n", e);
		} finally {
			if(rs != null) {
			   try {
				   rs.close();
			   } catch (SQLException e) {
				   
			}}
			if(st != null) {
	           try {
				st.close();
			   } catch (SQLException e) {				
				
			   }
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {					
					
				}
			}
			if(con != null) {
			    try {
				    appvars.freeDBConnection(con);
			    } catch (Exception e) {				
				    LOGGER.error("Error freeing connection. Reason:\n", e);
			}}
		}
		
		return qualifiedBatch;
		
	}
	
	/**
	 * To update the status of batchdata. 
	 * 
	 * @param unique_number
	 * @param started to indicate if the batchjob has been started
	 * @return the count of batchdata updated
	 * 
	 * Default value of @param started should be true since the 
	 * starttime updation of batchdata has been done when being feched.
	 */
	public static int updateBatchData(AppVars appvars, BigInteger unique_number, boolean started) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		StringBuilder updateSql = new StringBuilder();
		
		String systemDate = SQLUtils.getSystemDate();
				
		updateSql.append("UPDATE JOBSUBMIT SET ");
		if(started) {
			updateSql.append("JOBSTATUS='20', ")
			         .append("JOBENDTIM=" + systemDate + " ");		
		}	
		else {			
			updateSql.append("JOBSTATUS='10', ")
			         .append("JOBSTRTIM=" + systemDate + " ");			
		}	
		updateSql.append("WHERE COMPANY = '");
		updateSql.append("1");
		updateSql.append("' AND ");
		updateSql.append("UNIQUE_NUMBER=?");
		
		try {
			con = appvars.getTempDBConnection("DB");
			ps = con.prepareStatement(updateSql.toString());
			ps.setBigDecimal(1, new BigDecimal(unique_number));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("Job Update Fail! Reason:\n", e);
		} finally{
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {					

				}
			}
			if(con != null) {
			try {
				appvars.freeDBConnection(con);
			} catch (Exception e) {
			    LOGGER.error("Error freeing connection. Reason:\n", e);
			}}
		}
		return result;
	}
	
	/**
	 * @return
	 */
	public static int removeBatchData() {
		//need further implementation
		return 0;
		
	}
	
	/**
	 * Reset all batch job which has status is 10 or 20 (Stated) to 50
	 * (Availiable)
	 * 
	 * @param appvars
	 * @return
	 */
	public static int resetBatchJob(AppVars appvars) {

		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		StringBuilder updateSql = new StringBuilder();
		updateSql.append("UPDATE JOBSUBMIT SET ");
		updateSql.append("JOBSTATUS = '50' ");
		updateSql.append("WHERE (JOBSTATUS = '10' OR JOBSTATUS = '20') ");
		updateSql.append("AND COMPANY = '");
		updateSql.append("1");
		updateSql.append("' ");

		try {
			con = appvars.getTempDBConnection("DB");
			ps = con.prepareStatement(updateSql.toString());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("Job Update Fail! Reason:\n", e);
		} finally {
			releaseDB(appvars, null, ps, con);
		}
		return result;
	}
	
	/**
	 * Fetch the first available (status 50) batch job data from table Jobsubmit
	 * with unique_number order
	 * 
	 * @param appvars
	 * @return first available batch job data
	 */
	public static BatchTransferData fetchFirstBatchData(AppVars appvars) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		StringBuilder querySql = new StringBuilder();

		querySql.append("SELECT * FROM JOBSUBMIT ");
		querySql.append("WHERE JOBSTATUS='50' AND COMPANY = '");
		querySql.append("1");
		querySql.append("' ORDER BY UNIQUE_NUMBER");

		try {
			con = appvars.getTempDBConnection("DB");
			st = con.createStatement();
			rs = st.executeQuery(querySql.toString());

			if (rs.next()) {
				BatchTransferData temp = new BatchTransferData();
				temp.setUniqueNum(rs.getBigDecimal("UNIQUE_NUMBER")
						.toBigInteger());
				temp.setJobCommand(rs.getString("JOBCOMMAND"));
				temp.setJobStatus(rs.getString("JOBSTATUS"));
				String[] jobParas = new String[Integer.parseInt(rs
						.getString("JOBPARANUM"))];
				for (int j = 0; j < jobParas.length; j++) {
					jobParas[j] = rs.getString("JOBPARA" + (j + 1));
				}
				temp.setJobParameters(jobParas);
				temp.setBatchControlType(Integer.parseInt(rs
						.getString("BATCHCONTY")));
				temp.setJobName(rs.getString("JOBNAME"));
				temp.setJobDescription(rs.getString("JOBDESC"));
				temp.setJobQ(rs.getString("JOBQUEUE"));
				temp.setJobPty(rs.getString("JOBPRITY"));
				temp.setRtgDta(rs.getString("RTGDTA"));
				temp.setLog(rs.getString("LOGOPTION"));
				temp.setLogCLPgm(rs.getString("LOGOPTION"));
				temp.setHold(rs.getString("HOLD"));
				temp.setUser(rs.getString("USERNAME"));
				temp.setInqMsgRpy(rs.getString("INGMSGRPY"));
				temp.setMsgQ(rs.getString("MSGQ"));
				temp.setSyslibl(rs.getString("SYSLIBL"));
				temp.setCurlib(rs.getString("CURLIB"));
				temp.setInllibl(rs.getString("INLLIBL"));
				temp.setRqsDta(rs.getString("RQSDTA"));
				return temp;
			}
		} catch (SQLException e) {
			LOGGER.error("Job Fetch Fail! Reason:\n", e);
		} finally {
			releaseDB(appvars, rs, st, con);
		}
		return null;
	}
	
	/**
	 * Release ResultSet, Statement, Connection of database
	 * 
	 * @param appvars
	 * @param rs
	 *            ResultSet
	 * @param st
	 *            Statement
	 * @param con
	 *            Connection
	 */
	private static void releaseDB(AppVars appvars, ResultSet rs, Statement st,
			Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error("Error when releaseDB. Reason:\n", e);
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.error("Error when releaseDB. Reason:\n", e);
			}
		}
		if (con != null) {
			try {
				appvars.freeDBConnection(con);
			} catch (Exception e) {
				LOGGER.error("Error when releaseDB. Reason:\n", e);
			}
		}
	}
}