package com.quipoz.framework.support;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SQLUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SQLUtils.class);

	public static final String DATABASE_ORACLE = "0";
	public static final String DATABASE_SQLSERVER = "1";
	public static final String DATABASE_DB2 = "2";


	private SQLUtils() {
	}


	public static String getSystemDate() {
		return "getDate()";
	}

	
}
