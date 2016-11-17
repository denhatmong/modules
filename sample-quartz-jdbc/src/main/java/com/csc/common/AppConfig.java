package com.csc.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppConfig implements java.io.Serializable {

		private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class); // IAF-186
		
	    /** Flag to enable work flow debugging code */
	    public static boolean ENABLE_WORKFLOW_DEBUG = false;

	    /** Work flow logging file */
	    public static String WORKFLOW_DEBUG_LOG = "D:\\tmp\\workflow-after.txt";

	    public static final String QUIPOZ_LIFEASIAWEB_XMLPATH = "Quipoz.LifeAsiaWeb.XMLPath";

		/**
		 * Default value for optional configurable parameter for {@link #fullyQualifiedAppVarsClassName}
		 */
		public static final String APP_VARS_CLASS_IS_NOT_CONFIGURED = "This is not a valid java class name expression";

		public static final String APP_NAME = "Appname";

		/** Constant {@value} . */
		public static final String APPLICATION = "application";

		/** String literal "{@value} ". */
		private static final String ASSM = " was assumed.";

		/** String literal "{@value} ". */
		private static final String BUT_VAL = ">, but the value supplied (";

		/**
	     * Caching is enable or not.
	     */
		protected static boolean cacheEnabled = false;

		//*********Ticket #IAF-47 Externalisation Code ***************

		private boolean vpmsEnable = false;
		//*********Ticket #IAF-220 Externalisation Code ***************
		private static String vpmsModelDirectory = "";
		private static String vpmsEnableLayering = "";
		private static String vpmsCarrierCode = "";
		private static String vpmsProductCode = "";
		private static String vpmsRegion = "";
		private static String vpmsLocale = "";
		private static String vpmsTransEffDate = "";
		private static String vpmsCallingSystem = "";
		private static String vpmsCallingProgram = "";
		private static String vpmsXeServerIp="";
		private static int vpmsXeServerPort=0;
		private static String vpmsXeServer="false";
		
		public static String getVpmsXeServer() {
			return vpmsXeServer;
		}

		public static void setVpmsXeServer(String vpmsXeServer) {
			AppConfig.vpmsXeServer = vpmsXeServer;
		}

		public static String getVpmsXeServerIp() {
			return vpmsXeServerIp;
		}

		public static void setVpmsXeServerIp(String vpmsServerIp) {
			AppConfig.vpmsXeServerIp = vpmsXeServerIp;
		}

		public static int getVpmsXeServerPort() {
			return vpmsXeServerPort;
		}

		public static void setVpmsXeServerPort(int vpmsServerPort) {
			AppConfig.vpmsXeServerPort = vpmsXeServerPort;
		}
		//*********Ticket #IAF-220 Externalisation Code ***************	

		private String browserLocale = null;

		 /**
	     * This property store the CSV file path.
	     **/
	    private  String csvOutput;

	    /**
	     * This property store the SMTP Host.
	     **/
	    private  String SmtpHost;

	    public String getSmtpHost() {
			return SmtpHost;
		}

		public void setSmtpHost(String smtpHost) {
			this.SmtpHost = smtpHost;
		}

		public String getSmtpUser() {
			return SmtpUser;
		}

		public void setSmtpUser(String smtpUser) {
			this.SmtpUser = smtpUser;
		}

		public String getSmtpUserPassword() {
			return SmtpUserPassword;
		}

		public void setSmtpUserPassword(String smtpUserPassword) {
			this.SmtpUserPassword = smtpUserPassword;
		}

		/**
	     * This property store the SMTP User.
	     **/
	    private  String SmtpUser;

	    /**
	     * This property store the SMTP User Password.
	     **/
	    private  String SmtpUserPassword;


		/**
		 * System company code
		 * */
		protected static String systemCompanyCode;

		/**
		 * FSU company code
		 * */
		protected static String fsuCompanyCode;


		/** String literal "{@value} ". */
		protected static final String CMODE = "CMODE";

		/** Constant {@value} . */
		public static final int CONSTRUCTOR_END = 200;

		/** Constant {@value} . */
		public static final int CONSTRUCTOR_START = 199;

		/** String literal "{@value} ". */
		private static final String CONT_NODE = "' contains XML node <";

		/** Constant {@value} . */
		public static final int CONTROLLER_DEBUG = 45;

		/** Constant {@value} . */
		public static final int CONVERSATIONAL = 1;

		/** Constant {@value} . */
		public static final String DATE_TO_DDMMYYYY = "DDMMYYYY";

		/** Constant {@value} . */
		public static final String DATE_TO_MMDDYYYY = "MMDDYYYY";

		/** Constant {@value} . */
		public static final String DATE_TO_MSECS = "MSECS";

		/** Constant {@value} . */
		public static final String DATE_TO_YYYYMMDD = "YYYYMMDD";

		/** Constant {@value} . */
		public static final String DEBUG_PREFIX = "--";

		public static final String DBTYPE_ORACLE = "0";

		public static final String DBTYPE_SQLSERVER = "1";

		private static final String QUIPOZ_CFG = "QuipozCfg";

		protected static final String DEF_XML = "QuipozCfg.xml";

		/** Constant {@value} . */
		public static final int DEFAULT_DEBUG_LEVEL = 5;

		/** Constant {@value} . */
		public static final String DEFAULTDATECURRENT = "Current";

		/** Constant {@value} . */
		public static final String DEFAULTDATEMINIMUM = "Minimum";

		/** String literal "{@value} ". */
		protected static final String DEFNUMS_BATCH = "2, 50, 1000, 50000";

		/** String literal "{@value} ". */
		protected static final String DEFNUMS_ONLINE = "2, 20, 50000";

		protected static final String DOT_XML = ".xml";

		/**
		 * path used for requesting DMS path from server
		 */
	 	private static String dmsServletPath;

		/** Constant {@value} . */
		public static final int EJB_DEBUG = 110;

		/** Constant {@value} . */
		public static final int ERROR = 1;

		/** Constant {@value} . */
		public static final String ERROR_PREFIX = "ERROR: ";

		/** Constant {@value} . */
		public static final int EXCEPTION = 19;

		/** String literal "{@value} ". */
		protected static final String EXCL = "Exclude";

		/** Constant {@value} . */
		public static final int EXECUTING_MODE_BATCH = -1;

		/** String literal "{@value} ". */
		protected static final String FIL = "File '";

		/** Constant System.getProperty("file.separator"). */
		public static final String FILE_SEPARATOR = System.getProperty("file.separator");

		/** String literal "{@value} ". */
		protected static final String FMODE = "FMODE";

		/** This property stores the root directory for on-line printing. */
		protected static String fopOnLinePrintRoot;

		/** This property stores the root directory for FOP printing. */
		protected static String fopPrintRoot;

		/** Half a minute in seconds = {@value} . */
		protected static final int HALF_MIN = 30;

		/** Constant {@value} . */
		public static final int HIGH_DEBUG = 125;

		protected static String identityMapperClass = "";

		/** String literal "{@value} ". */
		protected static final String INCL = "Include";

		/** Constant {@value} . */
		public static final int INFO = 3;

		// Singleton AppConfig
		private static AppConfig instance = null;

		/** Constant {@value} . */
		public static final int INTERNAL_DATA = 250;

		/** Constant saying if debugging time is enabled. */
		public static boolean isDebugTimeEnabled;

		/** Constant {@value} . */
		public static final String JNDIREF = "jndiref";

		/** String literal "{@value} ". */
		protected static final String JNFI = "java.naming.factory.initial";

		/** String literal "{@value} ". */
		protected static final String JNPU = "java.naming.provider.url";

		/** String literal "{@value} ". */
		protected static final String LC = "lowercase";

		/** Constant {@value} . */
		public static final int LOW_DEBUG = 5;

		/** String literal "{@value} ". */
		protected static final String MASTER_PROGS = "MasterPrograms";

		/** Constant {@value} . */
		public static final int MEDIUM_DEBUG = 55;
		/** String literal "{@value} ". */
		protected static final String RMAInt = "RMAIntegration";

		/**
		 * This is an internal debugging variable that can be used to trace resources that should be cleaned up by garbage
		 * collection but are not. Zero, the normal value, means no action.
		 */
		public static int memoryRefDebug = 0;

		/** Constant {@value} . */
		public static final int METHOD = 98;

		/** Constant {@value} . */
		public static final int METHOD_END = 100;

		/** Constant {@value} . */
		public static final int METHOD_START = 99;

		/** Constant {@value} . */
		public static final int MODEL_METHOD = 148;

		/** Constant {@value} . */
		public static final int MODEL_METHOD_END = 150;

		/** Constant {@value} . */
		public static final int MODEL_METHOD_START = 149;

		/** String literal "{@value} ". */
		protected static final String MP_P_N = "<MasterPrograms><Program> node ";

		/** Constant {@value} . */
		public static final String NO_MESSAGE = "No Message";

		/** String literal "{@value} ". */
		protected static final String NO_NODE = "' does not contain XML node <";

		/** Constant {@value} . */
		public static final int NON_CONVERSATIONAL = 0;

		/** String literal "{@value} ". */
		private static final String NOT_VB = ") is not a valid boolean. ";

		/** String literal "{@value} ". */
		protected static final String OMODE = "OMODE";

		/**
		 * Added OptionalDateFormat
		 */
		public static final String OPTIONAL_DATE_FORMAT = BaseData.ISO_TIME_FORMAT;

		/** Constant {@value} . */
		public static final String POPUP = "POPUP";

		/** This property stores the print language. */
		private static String printlng;

		/** Constant {@value} . */
		public static final int PROCESS_END = 50;

		/** Constant {@value} . */
		public static final int PROCESS_START = 49;

		/** String literal "{@value} ". */
		protected static final String PROG = "Program";

		/** Constant {@value} . */
		public static final int PROVIDED = 2;

		/** The session facade bean provided, if any. */
		protected static String providedSessionFacade;

		/** Used for sanity checking only, when {@link #TEST_MODE} is true. */
		private static HashMap<String, String> readLog = new HashMap<String, String>();

		/** Constant {@value} . */
		public static final int SCREENMODEL_DEBUG = 35;

		private static final long serialVersionUID = 350L;

		/** Constant {@value} . */
		public static final int SET_VAR = 120;

		/** This property stores the Batch Socket Port. */
		protected static String socketPort;

		/** This property store the Batch Socket URL. */
		protected static String socketURL;

		/** Constant {@value} . */
		public static final int SQL_REPORT_FETCHES = 55;

		/** Constant {@value} . */
		public static final int SQL_TRACE = 20;

		/** Constant {@value} . */
		public static final int SQL_TRACE_CONNECTIONS = 100;

		/** Constant {@value} . */
		public static final int SQL_TRACE_FETCH_DATA = 70;

		/** Constant {@value} . */
		public static final int SQL_TRACE_FETCH_DATA_ALLCOLS = 80;

		/** Constant {@value} . */
		public static final int SQL_TRACE_FETCH_DATA_FULL = 90;

		/** Constant {@value} . */
		public static final int SQL_TRACE_FETCH_DATA_MAX = 95;

		/** Constant {@value} . */
		public static final int SQL_TRACE_FETCHES = 60;

		/** Constant {@value} . */
		public static final int SQL_TRACE_PREPARES = 150;

		/** Constant {@value} . */
		public static final int SQL_TRACE_QUERIES = 50;

		/** Constant {@value} . */
		public static final int SQL_TRACE_UPDATES = 30;

		/** Ten minutes in seconds = {@value} . */
		protected static final int TEN_MIN = 600;

		/** Test mode. If true, all tags read and written are logged internally. */
		private static boolean TEST_MODE = false;

		/**
		 * Used to specified the package and class name of the transaction manager in case it is desired not to used the
		 * default one (which is Websphere)
		 */
		protected static String transactionManagerHelperClass = "";


		/** String literal "{@value} ". */
		protected static final String VARPATH = ".variables";

		/** Constant {@value} . */
		public static final int WARNING = 2;

		/** Used for sanity checking only, when {@link #TEST_MODE} is true. */
		private static HashMap<String, String> writeLog = new HashMap<String, String>();
			
		protected transient JSONObject additionalConfig = null;

		protected String additionalConfigStr = "";
		
		public static final String FEATURE_MYGST = "MYGST1";  //IAF-186

		protected HashMap<String, Feature> features = new HashMap<String, Feature>(); //IAF-186

		protected String inputfile; //IAF-208
		
		public String getAdditionalConfigStr() {
			return additionalConfigStr;
		}

		public void setAdditionalConfigStr(String additionalConfigStr) {
			this.additionalConfigStr = additionalConfigStr;
		}

		private boolean isNullOrBlank(String item)
		{
			if ((null == item) || ("".equals(item.trim()))) {
				return true;
			}

			return false;
		}

		public void setConfiguredItem(JSONObject jsonObj)
		{
			if (isNullOrBlank(jsonObj.toString()))
			{
				throw new RuntimeException("Configured Item must be neither NULL NOR BLANK");
			}

			additionalConfig = jsonObj;
		}

		public String getConfiguredValue(String item)
		{
			if (isNullOrBlank(item))
			{
				throw new RuntimeException("Configured Item must be neither NULL NOR BLANK");
			}

			return additionalConfig.get(item).toString();
		}

		/**
		 * Get the String representing the alphabet.
		 * <p>
		 * This is fetched from the current instance of AppConfig in the current instance of AppVars, or a constant
		 * "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" if that is not available.
		 * <p>
		 * It would not be available, for instance, if running some classes stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return {@link #alpha}.
		 */
		public static String getAlpha() {
			try {
				return AppVars.getInstance().getAppConfig().alpha;
			} catch (NullPointerException e) {
				return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			}
		}

		/**
		 * Get the char array representing the alphabetic numbers. The method is created to handle the feature on mainframe.
		 * On some mainframe, characters could be treated as valid number, particularly the char set of the mainframe is
		 * EBCDIC. In EBCDIC, hex values of all alphabet is coded as x[1-9]. To simplify the translation, a translating
		 * table is required to be configured along with {@link #alpha}, to indicate how alphabet and number are matched up.
		 * If {@link #alpha2Numer} is turned off, then the {@link #alpha} is used. That is, no translation at all.
		 *
		 * @return {@link #alpha2NumberCharset}.
		 */
		public static String getAlpha2NumberCharset() {
			return AppVars.getInstance().getAppConfig().alpha2NumberCharset;
		}

		/**
		 * Getter for {@link #APPLICATION}.
		 *
		 * @return {@link #APPLICATION}.
		 */
		public static String getApplication() {
			return APPLICATION;
		}

		/**
		 * Get the current AutoTab.
		 * <p>
		 * This is fetched from the current instance of AppConfig in the current instance of AppVars, or "Yes" if that is
		 * not available.
		 * <p>
		 * It would not be available, for instance, if running some classes stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return {@link #autoTab}.
		 */
		public static String getAutoTab() {
			try {
				return AppVars.getInstance().getAppConfig().autoTab;
			} catch (Exception e) {
				return "Yes";
			}
		}

		/**
		 * Get the current Date Format.
		 * <p>
		 * This is fetched from the current instance of AppConfig in the current instance of AppVars, or "yyyy-MM-dd" if
		 * that is not available.
		 * <p>
		 * It would not be available, for instance, if running some classes stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return the current Date Format.
		 */
		public static String getDateFormat() {
			try {
				return AppVars.getInstance().getAppConfig().dateFormat;
			} catch (Exception e) {
				return "yyyy-MM-dd";
			}
		}

		/**
		 * Get the default behaviour that indicates how dates should be converted to numbers.
		 * <p>
		 * This is fetched from the current instance of AppConfig in the current instance of AppVars, or use a constant
		 * saying to set it to YYYYMMDD if that is not available.
		 * <p>
		 * It would not be available, for instance, if using DataData stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return the default behaviour that indicates how dates should be converted to numbers.
		 */
		public static String getDateToNumber() {
			try {
				return AppVars.getInstance().getAppConfig().dateToNumber;
			} catch (Exception e) {
				return AppConfig.DATE_TO_YYYYMMDD;
			}
		}

		/**
		 * Get the default date to use if set to null and not nullable. This is fetched from the current instance of
		 * AppConfig in the current instance of AppVars, or use a constant saying to set it to today if that is not
		 * available.
		 * <p>
		 * It would not be available, for instance, if using DataData stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return the default date to use if set to null and not nullable.
		 */
		public static String getDefaultDate() {
			try {
				return AppVars.getInstance().getAppConfig().defaultDate;
			} catch (Exception e) {
				return AppConfig.DEFAULTDATECURRENT;
			}
		}

		/**
		 * Get the char array representing the alphabetic numbers. The method is created to handle the feature on mainframe.
		 * On some mainframe, characters could be treated as valid number, particularly the char set of the mainframe is
		 * EBCDIC. In EBCDIC, hex values of all alphabet is coded as x[1-9]. To simplify the translation, a translating
		 * table is required to be configured along with {@link #alpha}, to indicate how alphabet and number are matched up.
		 * If {@link #alpha2Numer} is turned off, then the {@link #alpha} is used. That is, no translation at all.
		 *
		 * @return {@link #ebcdicCharset}.
		 */
		public static String getEbcdicCharset() {
			return AppVars.getInstance().getAppConfig().ebcdicCharset;
		}

		public static String getDmsServletPath() {
	        return dmsServletPath;
	    }

		/**
		 * Getter for {@link #enforceSize}.
		 * <p>
		 * This is fetched from the current instance of AppConfig in the current instance of AppVars, or "Yes" if that is
		 * not available.
		 * <p>
		 * It would not be available, for instance, if running some classes stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return {@link #enforceSize}.
		 */
		public static String getEnforceSize() {
			try {
				return AppVars.getInstance().getAppConfig().enforceSize;
			} catch (Exception e) {
				return "Yes";
			}
		}

		/**
		 * Get the current {@link #executionMode Execution Mode}.
		 * <p>
		 * This is fetched from the current instance of AppConfig in the current instance of AppVars, or use a constant
		 * saying conversational if that is not available.
		 * <p>
		 * It would not be available, for instance, if running some classes stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return {@link #executionMode}.
		 */
		public static int getExecutionMode() {
			try {
				return AppVars.getInstance().getAppConfig().executionMode;
			} catch (Exception e) {
				return CONVERSATIONAL;
			}
		}

		/**
		 * Getter for {@link #fopOnLinePrintRoot}.
		 *
		 * @return {@link #fopOnLinePrintRoot}.
		 */
		public static String getFopOnLinePrintRoot() {
			return fopOnLinePrintRoot;
		}

		/**
		 * Getter for {@link #fopPrintRoot}.
		 *
		 * @return {@link #fopPrintRoot}.
		 */
		public static String getFopPrintRoot() {
			return fopPrintRoot;
		}

		/**
		 * Getter for {@link #identityMapperClass}.
		 *
		 * @return {@link #identityMapperClass}.
		 */
		public static String getIdentityMapperClass() {
			return identityMapperClass;
		}

		public static synchronized AppConfig getInstance() {
	        if (instance == null)
	            instance = new AppConfig();
	        return instance;
	    }

		public static synchronized AppConfig getInstance(AppVars pAppVars, String pAppName){
			if(instance==null){
				instance = new AppConfig(pAppName);
			}
			initialize(pAppVars);
			return instance;
		}

		public static synchronized AppConfig getInstance(String pAppName){
			if(instance==null){
				instance = new AppConfig(pAppName);
			}
			return instance;
		}

		/**
		 * Getter for {@link #memoryRefDebug}.
		 *
		 * @return {@link #memoryRefDebug}.
		 */
		public static int getMemoryRefDebug() {
			return memoryRefDebug;
		}

		/**
		 * Get the String representing numbers from {@link #numbers}.
		 * <p>
		 * This is fetched from the current instance of AppConfig in the current instance of AppVars, or a constant
		 * "01234566789" if that is not available.
		 * <p>
		 * It would not be available, for instance, if running some classes stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return {@link #numbers}.
		 */
		public static String getNumbers() {
			try {
				return AppVars.getInstance().getAppConfig().numbers;
			} catch (Exception e) {
				return "0123456789";
			}
		}

		/**
		 * Getter for {@link #printlng}.
		 *
		 * @return {@link #printlng}.
		 */
		public static String getPrintlng() {
			return printlng;
		}

		/**
		 * Getter for {@link #providedSessionFacade}.
		 *
		 * @return {@link #providedSessionFacade}.
		 */
		public static String getProvidedSessionFacade() {
			return providedSessionFacade;
		}

		/**
		 * Getter for {@link #readLog}.
		 *
		 * @return {@link #readLog}.
		 */
		public static HashMap<String, String> getReadLog() {
			return readLog;
		}

		/**
		 * Getter for {@link #serialVersionUID}.
		 *
		 * @return {@link #serialVersionUID}.
		 */
		public static long getSerialVersionUID() {
			return serialVersionUID;
		}

		/**
		 * Getter for {@link #socketPort}.
		 *
		 * @return {@link #socketPort}.
		 */
		public static String getSocketPort() {
			return socketPort;
		}

		/**
		 * Getter for {@link #socketURL}.
		 *
		 * @return {@link #socketURL}.
		 */
		public static String getSocketURL() {
			return socketURL;
		}

		/**
		 * Get the String representing the uppercase alphabet from {@link #upperAlpha}.
		 * <p>
		 * This is fetched from the current instance of AppConfig in the current instance of AppVars, or a constant
		 * "ABCDEFGHIJKLMNOPQRSTUVWXYZ" if that is not available.
		 * <p>
		 * It would not be available, for instance, if running some classes stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return {@link #upperAlpha}.
		 */
		public static String getUpperAlpha() {
			try {
				return AppVars.getInstance().getAppConfig().upperAlpha;
			} catch (NullPointerException e) {
				return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			}
		}

		/**
		 * Get the current Time Format.
		 */
		public static String getTimeFormat() {
			try {
				return AppVars.getInstance().getAppConfig().timeFormat;
			} catch (Exception e) {
				return "HH:mm:ss";
			}
		}

		/**
		 * Getter for {@link #writeLog}.
		 *
		 * @return {@link #writeLog}.
		 */
		public static HashMap<String, String> getWriteLog() {
			return writeLog;
		}

		private static void initialize(AppVars pAppVars) {
			pAppVars.setDontReport(instance.dontReport);
			pAppVars.ApplicationUse0 = instance.ApplicationUse0;
			pAppVars.ApplicationUse1 = instance.ApplicationUse1;
			pAppVars.ApplicationUse2 = instance.ApplicationUse2;
			pAppVars.ApplicationUse3 = instance.ApplicationUse3;
			pAppVars.ApplicationUse4 = instance.ApplicationUse4;
			pAppVars.ApplicationUse5 = instance.ApplicationUse5;
			pAppVars.ApplicationUse6 = instance.ApplicationUse6;
			pAppVars.ApplicationUse7 = instance.ApplicationUse7;
			pAppVars.ApplicationUse8 = instance.ApplicationUse8;
			pAppVars.ApplicationUse9 = instance.ApplicationUse9;
			pAppVars.ApplicationUse10 = instance.ApplicationUse10;
			pAppVars.ApplicationUse11 = instance.ApplicationUse11;
			pAppVars.ApplicationUse12 = instance.ApplicationUse12;

			/* Logon required ? */
			pAppVars.logonRequired = true;
			pAppVars.debugAllowed = 3;
			pAppVars.dontReport = instance.getDontReport();

			if (instance.subPath == null) {
				String classPath = pAppVars.getClass().getName();
				int i = classPath.lastIndexOf(VARPATH);
				if (i < 0) {
					throw new RuntimeException("Cannot derive the application path; supposed value '" + classPath
					        + "' does not contain '" + VARPATH + Str.APOST);
				}
				instance.subPath = classPath.substring(0, i);
			}

			// Defect Mercury#1383 - change from warning to diagnostic so that this message only appears for developers
			AppVars.addStaticDiagnostic("Execution mode is " + instance.executionMode);
		}

		/**
		 * The method is used to indicate if alpha will be translated to number, when a ZDD contains a character rather than
		 * a number. By default, the feature is turned off. It could be set in QuipozCfg.xml.
		 * <p>
		 * The value is obtained from {@link #alpha2Numer}.
		 *
		 * @return {@link #alpha2Numer}.
		 */
		public static final boolean isAlpha2Number() {
			return AppVars.getInstance().getAppConfig().alpha2Numer;
		}

		public static boolean isCacheEnabled() {
			return cacheEnabled;
		}

		public static String getSystemCompanyCode(){
			return systemCompanyCode;
		}
		//*********Ticket #IAF-47 Externalisation Code ***************
		public boolean isVpmsEnable() {
			return vpmsEnable;
		}
		//*********Ticket #IAF-152 Externalisation Code ***************
		/**
		 * gets vpms model files location
		 *
		 * @return return vpmsModelDirectory
		 */
		public static String getVpmsModelDirectory() {
			return vpmsModelDirectory;
		}
		/**
		 * sets vpms model files location
		 *
		 * @param vpmsModelDirectory
		 */
		public static void setVpmsModelDirectory(String vpmsModelDirectory) {
			AppConfig.vpmsModelDirectory = vpmsModelDirectory;
		}

		public static String getFSUCompanyCode(){
			return fsuCompanyCode;
		}

		/**
		 * Getter for {@link #isDebugTimeEnabled}.
		 *
		 * @return {@link #isDebugTimeEnabled}.
		 */
		public static boolean isDebugTimeEnabled() {
			return isDebugTimeEnabled;
		}

		/**
		 * Get the default behaviour that indicates how numbers should be padded when moved to Strings.
		 * <p>
		 * This is fetched from the current instance of AppConfig in the current instance of AppVars, or use a constant
		 * saying to set it to YYYYMMDD if that is not available.
		 * <p>
		 * It would not be available, for instance, if using DataData stand-alone. In that case, behaviour may not be
		 * identical to when it is run within an active application.
		 *
		 * @return {@link #isMoveNToCPad0}.
		 */
		public static boolean isMoveNToCPad0() {
			try {
				return AppVars.getInstance().getAppConfig().isMoveNToCPad0;
			} catch (Exception e) {
				return false;
			}
		}

		/**
		 * Looks for a keyword in the Config XML and throws an exception if it is not there.
		 *
		 * @param fn - file, for diagnostic purposes only.
		 * @param nl - XML node to start from.
		 * @param key - XML tag to look for.
		 * @return Found XML value.
		 */
		public static String mandatory(String fn, QPScreenNL nl, String key) {
			if (TEST_MODE) {
				readLog.put(key, "Mandatory");
			}
			String result = nl.getFirstChild(key).getNodeValue();
			if (result == null) {
				throw new RuntimeException(FIL + fn + NO_NODE + key + Str.XML_C);
			}
			return result;
		}

		/**
		 * Looks for a keyword in the Config XML and uses a default if it is not there.
		 *
		 * @param fn - file, for diagnostic purposes only.
		 * @param nl - XML node to start from.
		 * @param key - XML tag to look for.
		 * @param def - String default to use if not found.
		 * @return Found XML value or default.
		 */
		public static String optional(String fn, QPScreenNL nl, String key, String def) {
			if (TEST_MODE) {
				readLog.put(key, "Optional");
			}
			String result = nl.getFirstChild(key).getNodeValue();
			if (result == null) {
				return def;
			}
			return result;
		}

		/**
		 * Looks for a keyword in the Config XML and uses a default if it is not there or not convertible to a boolean.
		 *
		 * @param fn - file, for diagnostic purposes only.
		 * @param nl - XML node to start from.
		 * @param key - XML tag to look for.
		 * @param def - boolean default to use if not found.
		 * @return Found XML value or default as a boolean.
		 */
		public static boolean optionalBoolean(String fn, QPScreenNL nl, String key, boolean def) {
			String result = optional(fn, nl, key, def + "");
			boolean ret = false;
			if (result.equalsIgnoreCase(Str.TRUE_LC)) {
				ret = true;
			} else if (result.equalsIgnoreCase(Str.FALSE_LC)) {
				ret = false;
			} else {
				AppVars.debug(FIL + fn + CONT_NODE + key + BUT_VAL + result + NOT_VB + def + ASSM);
				ret = def;
			}
			return ret;
		}

		/**
		 * Looks for a keyword in the Config XML and uses a default if it is not there or not convertible to an int.
		 *
		 * @param fn - file, for diagnostic purposes only.
		 * @param nl - XML node to start from.
		 * @param key - XML tag to look for.
		 * @param def - int default to use if not found.
		 * @return Found XML value or default as an int.
		 */
		public static int optionalInt(String fn, QPScreenNL nl, String key, int def) {
			String result = optional(fn, nl, key, def + "");
			int resint = 0;
			try {
				resint = Integer.parseInt(result.trim());
			} catch (NumberFormatException ne) {
				AppVars.debug(FIL + fn + CONT_NODE + key + BUT_VAL + result + ") is not a valid integer. " + def + ASSM);
				return def;
			}
			return resint;
		}

		/**
		 * Setter for {@link #fopOnLinePrintRoot}.
		 *
		 * @param pFopOnLinePrintRoot new value for {@link #fopOnLinePrintRoot}.
		 */
		public static void setFopOnLinePrintRoot(String pFopOnLinePrintRoot) {
			AppConfig.fopOnLinePrintRoot = pFopOnLinePrintRoot;
		}

		public static void setDmsServletPath(String dmsServletPath) {
	        AppConfig.dmsServletPath = dmsServletPath;
	    }

		/**
		 * Setter for {@link #fopPrintRoot}.
		 *
		 * @param pFopPrintRoot the new value for {@link #fopPrintRoot}.
		 */
		public static void setFopPrintRoot(String pFopPrintRoot) {
			AppConfig.fopPrintRoot = pFopPrintRoot;
		}
		/**
		 * Setter for {@link #memoryRefDebug}.
		 *
		 * @param pMemoryRefDebug new value for {@link #memoryRefDebug}.
		 */
		public static void setMemoryRefDebug(int pMemoryRefDebug) {
			AppConfig.memoryRefDebug = pMemoryRefDebug;
		}

		/**
		 * Setter for {@link #printlng}.
		 *
		 * @param pPrintlng new value for {@link #printlng}.
		 */
		public static void setPrintlng(String pPrintlng) {
			AppConfig.printlng = pPrintlng;
		}

		/**
		 * Setter for {@link #socketPort}.
		 *
		 * @param pSocketPort new value for {@link #socketPort}.
		 */
		public static void setSocketPort(String pSocketPort) {
			AppConfig.socketPort = pSocketPort;
		}

		/**
		 * Setter for {@link #socketURL}.
		 *
		 * @param pSocketURL new value for {@link #socketURL}.
		 */
		public static void setSocketURL(String pSocketURL) {
			AppConfig.socketURL = pSocketURL;
		}

		/**
		 * Sets testing mode. In this mode, every tag written and read is logged.
		 *
		 * @param mode true or false.
		 */
		public static void setTestMode(boolean mode) {
			TEST_MODE = mode;
		}

		/** Contains a-z and A-Z. Minimal use; no point in changing it. */
		protected String alpha;

		/**
		 * The attribute contains CharSet which will be used while translate alphabetics into numbers by using EBCDIC hex
		 * values. It is Cp500 by default.
		 */
		private String alpha2NumberCharset;

		/**
		 * Indicator for enabling translation from Alpha to numbers. Translation table is configured by
		 * {@link #ebcdicCharset}. alphaNumbers must be configured while the indicator is turned on. The indicator
		 * will be used in ZonedDecimalData while retrieving data.
		 */
		protected boolean alpha2Numer = false;

		/**
		 * This variable can be used by application code for debugging.
		 * <p>
		 * Mandatory. Suggested values: 0 - 200.
		 * <p>
		 * In the Framework, there are frequent uses of diagnostic code points (See {@link #debugLevel}).
		 * <p>
		 * The use of Application Diagnostic Code Points is also recommended.
		 *
		 * <pre>
		 * av.addAppDiagnostic(&quot;Code started!&quot;, 7);
		 * </pre>
		 *
		 * If AppDebugLevel is >= 7, the message will be added to the diagnostics. Otherwise, it will not appear.
		 * <p>
		 * The distinction between AppDebugLevel and DebugLevel allows application code to be debugged without being swamped
		 * by Framework debugging messages, if the Framework is working OK.
		 */
		public int appDebugLevel = 0;

		private int _defaultCharSetIdx = Comparer.JAVA_NATIVE;

		/**
		 * This property is used to contain the path and name of the configured application property file which uses this
		 * framework.
		 */
		protected String applicationProperties = "application.properties";

		private String _queueManagerName;

		private String _queueName;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework.
		 */
		public String applicationSystemNumber;

		// Application use
		protected String ApplicationUse0 = null;

		public String ApplicationUse1 = null;

		public String ApplicationUse10 = null;

		public String ApplicationUse11 = null;

		public String ApplicationUse12 = null;

		public String ApplicationUse2 = null;

		public String ApplicationUse3 = null;

		public String ApplicationUse4 = null;

		public String ApplicationUse5 = null;

		public String ApplicationUse6 = null;

		public String ApplicationUse7 = null;

		public String ApplicationUse8 = null;

		public String ApplicationUse9 = null;

		/**
		 * Used for scheduling configuration.
		 */
		public String applicationUserCode;

		/**
		 * The application name - not loaded form the configuration file. This comes from the Front End, either the Web
		 * Servlet or the Swing controller or other.
		 */
		protected String appName = null;

		/**
		 * The database schema used by application code.
		 */
		protected String appSchema = null;

		/**
		 * The database schemaNames used by application code.
		 */
		protected String appSchemaNames = null;
		/**
		 * If Yes the cursor will skip to the next field on the screen when the current field is full of data.
		 * <p>
		 * Note, this is a field that is available for use in the final screen formatter. Implementation of the behaviour
		 * must be implemented there.
		 */
		public String autoTab;

		/**
		 * The name of the Single Model main HTML screen.
		 * <p>
		 * When an application is developed or converted, a Screen Model is selected. A Screen is represented by a High
		 * Level Form, which is an HTML document, or a JSP. This Form references the subframes, which can include a
		 * <ul>
		 * <li>title frame
		 * <li>button sidebar
		 * <li>main page area
		 * <li>message area
		 * <li>other areas
		 * </ul>
		 * One High Level Form can be generated for each screen, which offers the most flexibility and customisation
		 * opportunities. However, most of the time, this flexibility is not required, or is better avoided as there is a
		 * great deal of commonality amongst screens.
		 * <p>
		 * If this is not required, a single High Level Form can be used, which will be a JSP. This minimises maintenance if
		 * a global change is required.
		 */
		protected String baseScreen = "";


		/**
		 * List of directories used for print files and output files. Work directories would be used in the case when we
		 * need to create a temporary directory to store files until the batch process ends. When the batch finishes
		 * successfully we will move(rename) the generated files to the final destination directory
		 */
		protected String batchBaseDir;

		/**
		 * An option String value. No use is made of this variable in the Base Framework.
		 */
		public String batchOutputFileDir;

		/**
		 * An option String value. No use is made of this variable in the Base Framework.
		 */
		public String batchPrintFileDir;

		public int batchQueryTimeout = 0;

		/**
		 * An option String value. No use is made of this variable in the Base Framework.
		 */
		public boolean batchRemoveTempFiles;

		/**
		 * An option String value. No use is made of this variable in the Base Framework.
		 */
		protected int[] batchRowNumbersSequence;

		/**
		 * An option String value. No use is made of this variable in the Base Framework.
		 */
		public String batchTempFileDir;

		/**
		 * The amount of time to allow for a batch transaction to complete, before suspecting a problem such as an infinite
		 * loop and killing it.
		 */
		public long batchTimeout = 0;

		/**
		 * An option String value. No use is made of this variable in the Base Framework.
		 */
		public String batchWaitingFileDir;

		/**
		 * An option String value. No use is made of this variable in the Base Framework.
		 */
		public String charSet = null;

		  /**
		 * This table is provided as a convenience method to determine the appropriate High Character for the
		 * platform/database being used. As distributed, it contains a "~", a "9" and a "Z". In the Constructor for the Base
		 * Global Variables class, AppVars, a Database call is used to fetch the first row, sorted descending. The character
		 * found is put into AppVars, from where it can be fetched with getCollate().
		 * <p>
		 * If this parameter is empty, no such check occurs.
		 */
		protected String collateTab = "";

		/**
		 * Number of pages per report
		 */
		private String pagesPerFile = null;

		public String getPagesPerFile() {
		    return pagesPerFile;
		}

		public void setPagesPerFile(String pagesPerFile) {
		    this.pagesPerFile = pagesPerFile;
		}

	    /**
		 * In conversational systems, a Daemon can be run to clean up inactive sessions, where inactive means no response
		 * was received from the front-end auto refresh facility that shows the user's session is still alive (heart beat).
		 * This variable defines how often the Daemon will check for inactive sessions and is in seconds. Optional.
		 */
		public int daemonFrequency;

		/**
		 * Name of the datasource to be used when executing standalone. This is
		 * expected to be the full driver name, Eg jdbc:DB2:GENINS
		 */
		protected String databaseType = null;

		private String currentLanguage;

		/**
		 * Name of the datasource to be used when executing standalone. This is
		 * expected to be the full driver name, Eg jdbc:DB2:GENINS
		 */
		protected String dataDriverJDBC = null;

		/**
	     * Data source Factory for JDBC Connection
	     */
	    protected String dataSourceFactoryJDBC = null;

		/**
		 * When operating as "localswing" (See {@link #server}), i.e. not using a pooled connection supplied by a Container,
		 * this identifies the JDBC source to use.
		 * <p>
		 * This mode usually applies to a) testing, or b) Batch.
		 */
		protected String dataSourceJDBC = null;

		/**
		 * Mandatory JNDI name.
		 * <p>
		 * When operating as "local" or "EJB" (See Server), i.e. using a pooled connection supplied by a Container, this
		 * refers to a Data Source defined in the container.
		 * <p>
		 * Examples
		 *
		 * <pre>
		 * java:comp/env/jdbc/MYDS
		 * </pre>
		 *
		 * While J2EE documentation suggests that the Data Source should be available under a path such as the above, not
		 * all containers work the same. Therefore, the default application code will remove the leading "java:comp/env/"
		 * and lookup just "jdbc/MYDS" if looking up "java:comp/env/jdbc/MYDS" in the context fails.
		 * <p>
		 * Note that this allows easy database switching. As long as you have a number of data sources defined on your
		 * container, switching databases is just a matter of editing the configuration file; the server does not need to be
		 * restarted. As each user logs on, they will then be using the new database. Currently logged on users will remain
		 * on the old database till they log off.
		 */
		protected String dataSourceJNDI = null;

		protected String dataSourceContext = null;
		
		protected String dataSourceURL = null;
		
		protected String dataSourceUserName = null;
		
		protected String dataSourcePassword = null;

		/**
		 * @return the dataSourceContext
		 */
		public String getDataSourceContext() {
			return dataSourceContext;
		}

		/**
		 * @param dataSourceContext the dataSourceContext to set
		 */
		public void setDataSourceContext(String dataSourceContext) {
			this.dataSourceContext = dataSourceContext;
		}

		/**
		 * @return the dataSourceURL
		 */
		public String getDataSourceURL() {
			return dataSourceURL;
		}

		/**
		 * @param dataSourceURL the dataSourceURL to set
		 */
		public void setDataSourceURL(String dataSourceURL) {
			this.dataSourceURL = dataSourceURL;
		}

		/**
		 * @return the dataSourceUserName
		 */
		public String getDataSourceUserName() {
			return dataSourceUserName;
		}

		/**
		 * @param dataSourceUserName the dataSourceUserName to set
		 */
		public void setDataSourceUserName(String dataSourceUserName) {
			this.dataSourceUserName = dataSourceUserName;
		}

		/**
		 * @return the dataSourcePassword
		 */
		public String getDataSourcePassword() {
			return dataSourcePassword;
		}

		/**
		 * @param dataSourcePassword the dataSourcePassword to set
		 */
		public void setDataSourcePassword(String dataSourcePassword) {
			this.dataSourcePassword = dataSourcePassword;
		}
		
		/**
		 * Mandatory - any valid JAVA format. Use of the data in this tag varies from application to application, and indeed
		 * from language to language. It is generally intended to supply the date format used when the System returns the
		 * date.
		 */
		public String dateFormat;

		/**
		 * Mandatory - "MSECS" or "YYYYMMDD". This is provided for some applications which store dates in number fields.
		 * These may be represented as true dates in the database. Then, when a date is read from the database and stored in
		 * a number field, a choice must be made how it will be represented.
		 * <p>
		 * If this variable is "YYYYMMDD", then a date of 1965-05-17 will be stored as 19650517.
		 * <p>
		 * If it is MSEC, the result will be -146052000000 - the number of milliseconds since January 1, 1970, 00:00:00 GMT,
		 * or what would be printed from a java.sql.date.getTime().
		 */
		public String dateToNumber = DATE_TO_YYYYMMDD;

		/**
		 * Does DBCS translation occur on database I/O for String variables. See {@link #DBCSLanguage}.
		 * <p>
		 * Database functionality is usually specified at the application level because that is where the database is
		 * chosen. Use of this variable needs to be implemented there.
		 */
		public boolean dbcsForDB = false;

		/**
		 * Does DBCS translation occur when diagnostic Strings are outputted, that is, is there an attempt to convert the
		 * internal representation of String variables to DBCS. See {@link #DBCSLanguage}. Valid values: true, false, absent
		 * (false assumed).
		 */
		public boolean dbcsForDiag = false;

		/**
		 * <p>
		 * Does DBCS translation occur when flat files are read and written.
		 * <p>
		 * There is no support for flat files in the base Framework, so this is an Application use field. See
		 * {@link #DBCSLanguage}. Valid values: true, false, absent (false assumed).
		 */
		public boolean dbcsForFiles = false;

		/**
		 * Does DBCS translation occur when String screen variables are written to or read from screens. See
		 * {@link #DBCSLanguage}. Valid values: true, false, absent (false assumed).
		 */
		public boolean DBCSForScreens = false;

		/**
		 * This String contains the DBCS language eg GBK which is used to turn characters into the internal representation
		 * of bytes if that functionality is required.
		 * <p>
		 * This is used to handle situations like this: (Mainframe COBOL example)
		 * <p>
		 *
		 * <pre>
		 * 01 ASTRUCTURE.
		 *   10 FIRSTNAME  PIC X(30).
		 *   10 FIRSTCHAR  REDEFINES FIRSTNAME PIC X(2).
		 *   10 SURNAME    PIC X(30).
		 * </pre>
		 *
		 * In this case, the following code concepts operate:
		 * <ol>
		 * <li>The user enters text in Chinese. On the mainframe, such text is enclosed in Shift-in and Shift-out characters
		 * (hex 0E and hex 0F).
		 * <li>Some routine in the application strips those characters out, and stores the names.
		 * <li>Code wants to use the first character of the first name. It accesses the first 2 bytes of the first name. On
		 * output to the screen, this is again surrounded by Shift-in and Shift-out, and the operating system transforms the
		 * characters to Chinese.
		 * </ol>
		 * Now clearly the operation of the code is utterly dependent on the fact that Chinese characters occupy two 8-bit
		 * bytes. Java of course can store Chinese characters just fine, one character per position in a String. Some form
		 * of emulation needed to be found to keep this code working. This configuration item does that.
		 * <p>
		 * The idea is,
		 * <ol>
		 * <li>On input, text is passed through the String to Bytes decoder to get bytes using the Language above. Then, it
		 * is turned back into characters using CodePpage "ISO_8859_1". That code page does not corrupt characters, unlike
		 * the default.
		 * <li>The above process has been shown to properly cope with English text, or for that matter mixed Chinese and
		 * English.
		 * <li>On output, the process is reversed.
		 * </ol>
		 * <p>
		 * This process might have to be done at any point where String data enters or leaves the application. There are
		 * several points catered for by individual configuration items:
		 * <ol>
		 * <li>Screen input/output
		 * <li>Database input/output
		 * <li>Flatfile input/output
		 * <li>Diagnostic output
		 * </ol>
		 * <p>
		 * The process is supported by toDBCS() and setFromDBCS() in the StringBase datatype (and so in
		 * FixedLengthStringData).
		 * <p>
		 * Implementation at the various points sometimes occurs in the Base Framework, and sometimes in the Language
		 * Framework, and sometimes in the Application Framework.
		 * <p>
		 * <b>Screen</b>
		 * </p>
		 * - As there are methods in HTMLFormatter and Screenmodel to get and set character strings from and to the screen,
		 * support has been put in there. HTMLFormatter is often overloaded at the Language or Application levels, and in
		 * that case appropriate code must be included at that point.
		 * <p>
		 * <b>Database</b>
		 * </p>
		 * - All DB I/O should go through AppVars, and so is supported there.
		 * <p>
		 * <b>Flatfile</b>
		 * </p>
		 * - At the time of writing, there is no direct support for flatfiles in the Base Framework.
		 * <p>
		 * <b>Diagnostic output</b>
		 * </p>
		 * - undecided right now.
		 * <p>
		 * See other variables whose name starts DBCS in this Class also.
		 * <p>
		 * This variable can be null, in which case such code is bypassed.
		 */
		public String DBCSLanguage = null;

		/**
		 * This String contains the DBCS language eg UTF-8 which is used on screens for DBCS. It may be different from the
		 * DBCSLanguage.
		 */
		public String dbcsScreenLanguage = null;

		/**
		 * An optional Boolean value. No use is made of this variable in the Base Framework.
		 */
		protected boolean timings;

		/**
		 * An optional Boolean value. No use is made of this variable in the Base Framework.
		 */
		protected boolean diagnostics;

		/**
		 * What level of debugging is active. This variable, 0-250, writes out progressively more verbose debugging
		 * information about the operation of the Framework. 5 is the normal testing level; below that error and warning
		 * messages may not be seen. 2 can be used for production. Error messages are written to the user's session,
		 * internally. They can be reviewed with the onscreen diagnostic facility. They are also written to the log.
		 * <p>
		 * See also {@link #appDebugLevel}, {@link #sqlDiagLevel}, {@link #sqlEDiagLevel}, {@link #appDebugLevel},
		 * {@link #memoryRefDebug}, {@link #traceSource}, {@link #monitorOn}.
		 */
		public int debugLevel = 0;

		/**
		 * Mandatory - future use, do not change.
		 */
		public String decimalSeparator;

		/**
		 * Default charset comparer, loaded from the config file.
		 */
		protected int defaultCharSetIdx = Comparer.JAVA_NATIVE;

		/**
		 * No use is made of this variable in the Base Framework. It is not set up via the Configuration File. It is
		 * defaulted to {@link #DEFAULTDATEMINIMUM}.
		 */
		public String defaultDate = DEFAULTDATEMINIMUM;

		/**
		 * Applies a default for all Screen text fold to uppercase on input. Uppercase means all text entered will be
		 * converted to upper case. It can be overridden at a Screen and/or Field level.
		 * <p>
		 * uppercase, lowercase, none
		 */
		public String defaultFold = LC;

		/**
		 * Default language. If not specified, "double-defaults" to "ENG".
		 * <p>
		 * It is used in only one place, in ScreenModel.getFormActions.
		 * <p>
		 * It is compared to the current user language. If different, and {@link #pfKeyLangConditioned} is "Yes", then the
		 * text assigned to a PF key on the screen is looked up in FrameworkSchema.PFKEYTEXT with the current user language.
		 * <p>
		 * If there is no entry (or no table), no translation occurs.
		 * <p>
		 * This provides a facility to automatically translate PF key text to other languages. Use is optional; nothing
		 * happens unless all of the above conditions apply.
		 */
		public String defaultLanguage = null;

		/**
		 * {@value #FMODE}, {@value #CMODE} or {@value #OMODE}, optional. {@value #FMODE} assumed if not supplied.
		 * <p>
		 * This value affects how Packed Decimal data variables are represented. The normal mainframe encoding of the number
		 * 314159 in a Packed(7) number is, in hex, first char = 0x03, 2nd=0x14, 3rd=0x15, 4th=0x9f.
		 * <p>
		 * The last byte of the 4th char would be 'd' not 'f' if the number was negative.
		 * <p>
		 * This encoding stores two digits per 8 bits of memory, and is a relic from the days when mainframe memory was very
		 * scarce and expensive.
		 * <p>
		 * This is not normally a matter for concern as it is externalised in databases in an unknown way, that is, a Packed
		 * variable in a program will be stored in a Number column in the database, and no-one knows or cares what the
		 * internal encoding is, in the database.
		 * <p>
		 * However, some applications made use of denormalised columns that contained multiple values in a CHAR column. For
		 * instance, a key might consist of "XXnnnnnnppppppppppbbbb" where XX is two chars representing the Branch, <br>
		 * nnnnnn is 6 chars representing the division <br>
		 * pppppppppp is a Packed(8) variable representing a date <br>
		 * bbbb is a Binary number representing the transaction number.
		 * <p>
		 * Thus, for example a key might be made up of
		 * <p>
		 * Branch="SY" <br>
		 * Div = "CITY01" <br>
		 * Date=20070517 <br>
		 * Tran=35912301
		 * <p>
		 * Which would have been represented in hex as
		 * <p>
		 * 0x'5359434954593031020070517f0203fa6d
		 * <p>
		 * This encoded hex String would then have been inserted into the database, and this is what would happen with
		 * FMODE.
		 * <p>
		 * However, some databases (eg Oracle) do not allow arbitrary hex strings to be inserted into CHAR columns,
		 * especially in language encoded databases such as GBK.
		 * <p>
		 * An alternative encoding was developed (OMODE) which still stored 2 digits per char, but only uses characters
		 * known and tested to insert properly into Oracle. The encoding is described in detail in the PackedDecimalData
		 * class.
		 * <p>
		 * Use of OMODE does require all current data in the database in such denormalised columns to be in the correct
		 * format. Whichever encoding is in use.
		 */
		protected char defaultPackedMode = PackedDecimalData.FMODE;

		/**
		 * How the last byte of zoned decimal numbers is represented. See the
		 * {@link com.quipoz.framework.datatype.ZonedDecimalData ZonedDecimalData} class.
		 */
		protected byte defaultPositiveZonedMode;

		/**
		 * Where to look for programs called as the initial program. Example:
		 *
		 * <pre>
		 * com.client.procedures.
		 * </pre>
		 */
		public String defaultProgramPackage;

		/**
		 * deployed environment name
		 */
		public String deployedEnvironment = null;

		/**
	     * DMS flag.
	     */
		protected String DMSEnable = "no";

	    /**
	     * VPMS url
	     */
	    public static String vpmsUrl;

	    /**
	     * Spring Batch Job Webservices enable
	     */
	    private boolean integralBatchEnable;

	    /**
	     * Schema part of Spring Batch Admin Web Services e.g. http, https
	     */
	    private String sbaSchema;

	    /**
	     * Host part of Spring Batch Admin Web Services
	     */
	    private String sbaHostPart;

		/**
	     * Document service taxonomy.
	     */
		protected String documentServiceTaxonomy;

		/**
	     * Document service URL.
	     */
		protected String documentServiceURL;

		/**
		 * A series of Strings separated by "/" used in debugging.
		 * <p>
		 * When a debugging line is outputted, a reference is given of the module and line, for example:
		 *
		 * <pre>
		 * [14/02/08 13:56:21:053 EST] 00000023 SystemOut     O USERME||DataArea retrieve Select, SQLCode=0000, time=   0.000
		 * select *
		 * from DEVTEST.MYTABLE
		 * WHERE KEY='DATE'
		 * : DateRoutines todaysDate 318 [14/02/08 13:56:21:068 EST] 00000023 SystemOut     O USERME
		 * </pre>
		 *
		 * This diagnostic output says that the SQL was performed by Class DateRoutines, method todaysDate().
		 * <p>
		 * In fact, all SQL is done (or should be done) through the Framework class AppVars. And in this application, all
		 * file I/O is done through a common DAM, a Class called FileCode.
		 * <p>
		 * However, saying to the programmer that some SQL was done in AppVars or FileCode does not provide any information
		 * - all SQL is done there.
		 * <p>
		 * So, variable DontReport would include '/AppVars/FileCode/(other classes)', resulting in the diagnostic saying the
		 * call was done in DateRoutines. This happens because the place where the call was done is obtained from the Java
		 * stack trace.
		 * <p>
		 * It may be that programmers decide that knowing the call is done in DateRoutines is also not very useful - it
		 * might be better to know what application code called DateRoutines. DateRoutines could then be added to
		 * DontReport, and the Class and Method reported the next time would be one lower in the stack.
		 * <p>
		 * The list of Classes is held in the configuration file as the list changes depending on the language and the
		 * application.
		 */
		public String dontReport = null;

		/**
	     * Driver class name for JDBC connection
	     */
	    protected String driverClassNameJDBC = null;

		/**
		 * An optional flag. No use is made of this variable in the Base Framework.
		 */
		protected boolean duplicatesOldestFirst;

		/**
		 * The attribute contains CharSet which will be used while translate alphabetics into numbers by using EBCDIC hex
		 * values. It is Cp037 by default.
		 */
		//private String ebcdicCharset = "cp037";
		protected String ebcdicCharset = "Cp500";

		/**
		 * If Yes fields on the screen will be limited to their defined size. That is, you will not be able to type more
		 * character in.
		 */
		public String enforceSize;

		/**
		 * Defines whether the system is pseudo-conversational, conversational or has its own Session Bean provided. Do not
		 * change this value as it is a primary decision made very early on in the transformation process. There is no
		 * possibility that your system will work if it is changed.
		 * <p>
		 * Valid values: 0,1,2. Optional, 0 assumed.
		 */
		public int executionMode = NON_CONVERSATIONAL;

		/**
		 * Application specific AppVars class name.
		 */
		protected String fullyQualifiedAppVarsClassName = "";

		/**
		 * The database schema used by framework code.
		 */
		protected String fwSchema = null;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework.
		 */
		protected String helpCodeScrnsColumn;

		/**
		 * An optional String value used to point to a help directory. No use is made of this variable in the Base
		 * Framework.
		 */
		protected String helpDir;

		/**
		 * An optional String value used to point to a server. No use is made of this variable in the Base Framework.
		 */
		protected String hostServerName;

		/**
		 * An optional boolean value to indicate if initialise FLSD with spaces. It also could be extended to initialise as
		 * a specific char when it is required.
		 */
		protected boolean initFlsd = true;

		/**
		 * These details are used if the EJBs are remote to the web tier. Name of the initial context factory, defaulted to
		 * "com.ibm.websphere.naming.WsnInitialContextFactory" if absent. This is used in the JNDI lookup for database name,
		 * and in JMS queue construction.
		 */
		public String initialContextFactory = null;

		/**
		 * If Y when a numeric variable is moved to a String variable leading zeroes will be added. This is required for
		 * some languages, and not others.
		 */
		protected boolean isMoveNToCPad0 = false;

		/**
		 * An optional flag. No use is made of this variable in the Base Framework.
		 */
		protected boolean isRocBasedApplication;

		/**
		 * Name of the JMS connection factory, defaulted to "tpoc.connectionFactory" if absent. No use is made of this
		 * variable in the Base Framework.
		 */
		public String jmsConnectionFactory;
		/**
		 * Name of the JMS module factory, defaulted to "SystemModule-0" if absent. No use is made of this variable in the
		 * Base Framework.
		 */
		protected String jmsModuleName;

		/**
		 * Name of the JMS server, defaulted to "JMSServer-0" if absent. No use is made of this variable in the Base
		 * Framework.
		 */
		protected String jmsServerName;

		/**
		 * JNDI topic, defaulted to "JMSServer-0" if absent. Defaulted to "topic." No use is made of this variable in the
		 * Base Framework.
		 */
		public String jmsTopicPreffix;

		/**
		 * This property is used to contain the path and name of the configured job property file which is used this
		 * framework.
		 */
		protected String jobProperties = "job.properties";

		/**
		 * An optional String value. No use is made of this variable in the Base Framework.
		 */
		protected String keyColumnForHelpCode;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Obviously well suited to being a
		 * holder for some sort of LDAP base directory.
		 */
		protected String ldapBase = null;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Obviously well suited to being a
		 * holder for some sort of LDAP user directory
		 */
		protected String ldapUserName = null;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Obviously well suited to being a
		 * holder for some sort of LDAP default password
		 */
		protected String ldapDefaultPassword = null;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Obviously well suited to being a
		 * holder for some sort of LDAP URL.
		 */
		protected String ldapUrl = null;
		
		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Obviously well suited to being a
		 * holder for some sort of LDAP Type.
		 */
		protected String ldapType = null;
		
		/**

		/**
		 * Used for scheduling configuration.
		 */
		public String locale= Locale.getDefault().toString();

		/**
		 * A string that represents a collection of objects that can be defined in the configuration that are the only
		 * objects that require locking processing. Typically those objects that have been identified as using explicit
		 * locking functions.
		 */
		protected String logicalLockIncludes = null;

		/**
		 * Used to indicate the user must log on via an internal process. No such process is defined in the Base Framework.
		 */
		protected String logonRequired = Str.SY;

	   /**
	    * Mandatory. Future use, do not change.
	    */
		public String lowerAlpha;
	    /**
		 * How to set a FLSD to ZDD. By default, it converts the string to a number, which is implemented in the subclass of
		 * QuipozFormatter. In some cases, the assignment does memory copy, particularly for special values. For instance,
		 * HI-VALUES/LOW-VALUES in COBOL program. HI-VALUES/LOW-VALUES can't be assigned to a numeric straightly, but they
		 * can be assigned to a alphabetic and then assign the alphabetic to a numeric. On some machine, this will copy
		 * memory instead of conversion.<br>
		 * The property is optional parameter, which is false by default.
		 */
		protected boolean memoryCopy = false;
	    /**
		 * If POPUP, alert boxes will be generated every time a new error message is raised. Otherwise, messages are
		 * presented on a separate frame.
		 */
		protected String messageModel;

	    /**
		 * Monitor screen variables. Mandatory. Valid values: N, Y.
		 * <p>
		 * If Y, then a small performance drain will be incurred as before screens are prepared, the existence of an XML
		 * file saying which fields to monitor for changes will be checked for.
		 */
		public String monitorOn = "N";

		/**
		 * Mandatory. Future use, do not change.
		 */
		public String numbers;

		/**
		 * The queryTimeout limit is the number of seconds the driver will wait for a Statement to execute. If the limit is
		 * exceeded, a SQLException is thrown.
		 */
		public int onLineQueryTimeout = 0;
		/**
		 * Optional sequence of integers defaulted to {@value #DEFNUMS}. No use is made of this variable in the Base
		 * Framework.
		 */
		protected int[] onlineRowNumbersSequence;
		/**
		 * The amount of time to allow for an online transaction to complete, before suspecting a problem such as an
		 * infinite loop and killing it.
		 */
		public long onlineTimeout = 0;
		/**
		 * An optional String value defaulted to "LINGUISTIC". Intended to hold the value of how Strings are compared in
		 * Oracle. No use is made of this variable in the Base Framework.
		 */
		protected String oracleNlsComp;
		/**
		 * An optional String value defaulted to "EBCDIC". Intended to hold the value of how data are sorted in Oracle. No
		 * use is made of this variable in the Base Framework.
		 */
		protected String oracleNlsSort;
		/**
		 * Whether fields defined as Output are rendered as an HTML field, simple text or both.
		 */
		public String outputsAsFields = null;
		/**
		 * Is the password encrypted. See {@link QPStringEncrypter}.
		 */
		protected String passwordEncrypt = null;
		/**
		 * Password to be used when executing stand-alone. The password can be encrypted.
		 */
		protected String passwordJDBC = null;
		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Can be used to store the output
		 * directory for PDF generation if required.
		 */
		protected String pdfOutput;

		
		protected String textInput;
		
		
		/**
		 * IJ-2031
		 * Used to store the output directory for TEXT generation if required.
		 */
		protected String textOutput;

		/**
		 * IJ-2063
		 * Used to store the output directory for XML generation if required.
		 */
		protected String xmlOutput;

		/**
		 * IGROUP-733
		 * An optional String value. Can be used to store the template for CSV generation if required.
		 */
		protected String csvTemplate;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Can be used to store the
		 * template for PDF generation if required.
		 */
		protected String pdfTemplate;
		/**
		 * Is the text for PFKeys, which is present in the XML, conditioned on Language. If it is, and the current language
		 * is not the default, an entry like <br>
		 *
		 * <pre>
		 * &lt;Action&gt;Exit/PFKey03&lt;/Action&gt;
		 * </pre>
		 *
		 * <br>
		 * will cause "Exit" and the language to be used as a key to look up FWSchema.PFKEYTEXT, and the result to be used
		 * instead.
		 */
		public String pfKeyLangConditioned = null;
		/**
		 * Whether HTML fields are pre-formatted.
		 */
		public String preformatted = null;
		/**
		 * Program path.
		 */
		public String programPackage = "";

		/**
		 * Storage for the list of programs that are triggered from the front end. This is loaded from the MasterProgram
		 * tag.
		 */
		public String[][] programs;

		/**
		 * Stores the URL used to obtain EJBs. Defaulted to "iiop://localhost:2809".
		 */
		public String providerUrl = null;

		/**
	     * An optional String[] value. It is used to keep the names of Configuration files which contain all special dynamic CL
	     * commands in some transformed applications such as DIARY and FSU in GroupAsia.
	     *
	     * <p>Example:</p>
		 * <pre>
		 * &lt;QcmdexcFiles&gt;
		 *   &lt;file>/Diary_QCMDEXC_config.xml&lt;/file&gt;
		 *   &lt;file>/Fsu_QCMDEXC_config.xml&lt;/file&gt;
		 * &lt;/QcmdexcFiles&gt;
		 * </pre>
	     */
	    protected String[] qcmdexcFiles;

		/**
		 * The location of the JMS queue used for data queue functionality.
		 */
		protected String queueManagerName;

		/**
		 * The name of the JMS queue used for data queue functionality.
		 */
		protected String queueName;

		/**
		 * ResultSetType to be used when creating prepared statement.
		 * The value of it should be one of the list:
		 * <ol>
		 * <li>{@link ResultSet#TYPE_FORWARD_ONLY}</li>
		 * <li>{@link ResultSet#TYPE_SCROLL_INSENSITIVE}</li>
		 * <li>{@link ResultSet#TYPE_SCROLL_SENSITIVE}</li>
		 */
		protected int resultSetType = ResultSet.TYPE_FORWARD_ONLY;


	    /**
		 * An optional String value. No use is made of this variable in the Base Framework.
		 */
		public String scriptsDir;

		/**
		 * Server type. <br>
		 * ejb - the session facade bean will be obtained via normal J2EE methods. The datasource used will be the JNDI
		 * datasource. <br>
		 * local - the session facade bean will be instantiated as a class and called directly, avoiding the J2EE layer
		 * overhead. The datasource used will be the JNDI datasource. <br>
		 * localswing - as for local, but the datasource used will be the JDBC datasource.
		 */
		private String server = null;

		/**
		 * PFKey2Indicator is an attribute to control if corresponding indicator is set on when a PF key is pressed. It is
		 * currently used in COBOLConvCodeModel. Default is true. No use is made of this variable in the Base Framework.
		 */
		protected boolean setIndicatorByPFKeyNo = true;

		/**
		 * An optional value indicates whether screen ID is showed. If Yes, screen ID is showed
		 *
		 */
		public String showScreenID;

	    /**
		 * Used in {@link DataModel#convertData()}. If YES, the name of the variable that caused a conversion problem will
		 * be put into the error message.
		 */
		protected String showVNOnError = null;
		/**
		 * A list of screens, possibly wild-carded, that qualify to be presented via the {@link #baseScreen}.
		 */
		protected List<String> singleModelJSP = new ArrayList<String>();

		/**
		 * An optional String value. No use is made of this variable in the Base Framework.
		 */
		protected String smaOpConEventDir;

		/**
		 * The SMTP MailServer for sending eMails. If not provided, defaults to "localhost".
		 */
		protected String smtpServer = null;


		/**
		 * Debugs SQL (prints the call) independently of all the above. Levels are: <br>
		 * 0 No trace. <br>
		 * 20 Trace SQL that takes too long. <br>
		 * 30 Trace Inserts, updates and deletes <br>
		 * 50 Trace Selects <br>
		 * 60 Trace Fetches <br>
		 * 70 Trace Fetches and print out the contents of every row fetched, up to a limit of 120 characters. <br>
		 * 80 As 70, but no limit - all variables are shown. <br>
		 * 90 As 80, but in addition, the column name is shown. <br>
		 * 95 As 90, but in addition, the column types and lengths are shown. <br>
		 * 100 Trace Connects <br>
		 * 150 TracePrepares
		 */
		public int sqlDiagLevel = 0;

		/**
		 * Prints out SQL that took longer than this value in milliseconds, if SQLDiagLevel is >= 20.
		 */
		public int sqlEDiagLevel = 0;

		/**
		 * If SQL tracing is on, this option will suppress most of the SQL diagnostic output, and print a summary at each
		 * screen interaction, when the user logs off, or the batch job ends. Each SQL call executed will be listed in a
		 * report, showing the Class, Method and Line, times executed, total elapsed time and average elapsed time.
		 * <p>
		 * The exception is SQL calls taking longer than SQLEDiagLevel, these are always printed in full.
		 */
		public String sqlSummaryOnly = Str.NO_LC;

		/**
		 * An optional number defaulted to 100. No use is made of this variable in the Base Framework.
		 */
		protected int sqlTiersDeep;

		/**
		 * This property is used to store the start up page for an application
		 */
		public String startupPage = null;

		/**
		 * Used to determine the initial path for screen driven applications.
		 */
		public String subPath = null;

		/**
		 * A database schema. Intended for use by tables which are a bit more general than "application", but a bit less
		 * fundamental than "framework". Its use is optional.
		 */
		protected String suppSchema = null;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Can be used to store the system
		 * name for LDAP.
		 */
		protected String systemAdminName = null;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Can be used to store the system
		 * password for LDAP.
		 */
		protected String systemAdminPwd = null;

		/**
		 * The preferred system font face. This is any valid string that can go in an html font-family tag.
		 * <p>
		 * Example and default: "Verdana, Arial, Helvetica, sans-serif"
		 */
		public String systemFont = null;

		/**
		 * The preferred system font size. This is any valid string that can go in an html font-size tag.
		 * <p>
		 * Examples: 12pt, 120%, 10 etc
		 * <p>
		 * Default: 10
		 * <p>
		 * No use is made of this variable in the Base Framework.
		 */
		protected String systemFontSize = null;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework. Obviously well suited to being a
		 * holder for some sort of name, probably of a system.
		 */
		public String systemName;

		/**
		 * Is table buffering in effect. See {@link com.quipoz.framework.tablemodel.TableModel} where this is discussed in
		 * detail.
		 */
		protected String tableBuffer = Str.NO_LC;

		/**
		 * Is table buffering in effect. See {@link com.quipoz.framework.tablemodel.TableModel TableModel} where this is
		 * discussed in detail.
		 */
		public boolean tableBufferFlag = false;

		private String timeFormat;

		/**
		 * Mandatory. Future use.
		 */
		public String thousandSeparator;

		/**
		 * Debugging output can be very useful, but it is sometimes necessary to know where it was generated from.
		 * <p>
		 * For instance, "Variable X changed to 45" may be helpful, but you may also need to know which module, method or
		 * even line number was involved.
		 * <p>
		 * TraceSource may be set to
		 * <p>
		 * Off - No tracing.
		 * <p>
		 * Low - The Class name that created the diagnostic method will be shown. This is reasonably efficient, and can be
		 * enabled in all but high volume production systems.
		 * <p>
		 * On - The Class Name, Method and Line number will be shown. This should only be used for testing, or for a single
		 * user in production. If diagnostic levels are high, it has a big impact on application performance.
		 * <p>
		 * Detail- A full stack trace is shown for each diagnostic statement. Only for extreme debugging needs.
		 */
		public String traceSource = "on";

		/**
		 * Indicates if a global transaction is being used. If not, it is up to the application to issue commits on each and
		 * every connection used as required.
		 */
		public String transactionScope = APPLICATION;

		/**
		 * It sets the timeout value that is associated with transactions started by subsequent invocations of the begin
		 * method.Value is expressed in Seconds.
		 */
		public int transactionTimeout = 0;

		/**
		 * Indicates if parms to SQL statements should have trailing blanks removed. Typically, for DB2 should be yes, for
		 * Oracle no. DB2 does not care if the length of a parm in a WHERE clause is too short, it will pad it out with
		 * blanks. But it does care if the parm is too long, so removing trailing blanks is always OK. Oracle, OTOH,
		 * requires parms to be of exactly the right length to mathc an "=" WHERE clause, so this should be false.
		 */
		public boolean truncateSQLParms = true;

		/**
		 * Mandatory. Future use.
		 */
		public String upperAlpha;

		/**
		 * The time between "beats" that the screens will do, to show the server that the screen is still alive.
		 */
		public long userHeartbeat = 0;

		/**
		 * Userid to be used when executing stand-alone.
		 */
		protected String useridJDBC = null;

		/**
		 * An optional flag. No use is made of this variable in the Base Framework.
		 */
		protected boolean useRowNumbers;

		/**
		 * The time we will let a user sit there without doing anything before concluding they have gone out to lunch, and
		 * they should be signed off for security reasons.
		 */
		public long userTimeout = 0;

		/**
		 * An optional flag. No use is made of this variable in the Base Framework.
		 */
		protected boolean useSQLTiers;

		protected boolean useStackTraceModeBatch = true;

		/**
		 * An optional flag. No use is made of this variable in the Base Framework. true - conventional main stream
		 * development. false - various experimental optimisations.
		 */
		protected boolean useStackTraceModeOnline = true;

		/**
		 * Define suffix of field name renamed. In some cases, variable name in the mainframe language could be conflicting
		 * with java reserved keyword, e.g. class. All of these fields are renamed in accordance to certain rules. However,
		 * these field name could be used in program somewhere. Then it needs to be renamed to be original one at runtime.
		 * To apply this changes, suffixes are defined here to avoid hard-coding.
		 */
		private String[] variableRenamingSuffix;

		/**
		 * version
		 */
		public String version;
		
		/**
		 * Old Jsp Template
		 */
		public boolean oldJspTemplate;

		/**
		 * FSU version
		 */
		public String fsuVersion;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework.
		 */
		protected String xmlACon;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework.
		 */
		protected String xmlBackup;

		/**
		 * An optional String value. No use is made of this variable in the Base Framework.
		 */
		protected String xmlSource;

		/**
		 * Constructor only used in testing.
		 */

		/*
		 * An Optional String value. Manadatory only when need to run batch P1BLKUPLD
		Ticket #IPAE-18 [ Design & Development - Req#23 - Document uploading facility].
		 */
		protected String riskFirServiceURL;
		protected String riskFioServiceURL;
		protected String riskLppServiceURL;
		//Variables added for Policy Experience redirection
		
		protected boolean claimIntegration;	
		protected String desEncrytionScheme;
		protected String messageDigestAlgo;
		protected String desEncyptionPadding;
		protected String defaultEncryptionKey;
		protected String claimIntegralURL;
		protected String claimIntegralUser;
		protected String claimIntegralPasswd;
		protected String claimIntegralDatasource;
		protected String claimIntegralEncMode;	
		protected String claimIntegralScreenNm;
		
		
		protected String subFolders;
		
		
		public boolean isClaimIntegration() {
			return claimIntegration;
		}

		public void setClaimIntegration(boolean claimIntegration) {
			this.claimIntegration = claimIntegration;
		}

		public String getDesEncrytionScheme() {
			return desEncrytionScheme;
		}

		public void setDesEncrytionScheme(String desEncrytionScheme) {
			this.desEncrytionScheme = desEncrytionScheme;
		}
		
		public String getMessageDigestAlgo() {
			return messageDigestAlgo;
		}

		public void setMessageDigestAlgo(String messageDigestAlgo) {
			this.messageDigestAlgo = messageDigestAlgo;
		}

		public String getDesEncyptionPadding() {
			return desEncyptionPadding;
		}

		public void setDesEncyptionPadding(String desEncyptionPadding) {
			this.desEncyptionPadding = desEncyptionPadding;
		}

		public String getDefaultEncryptionKey() {
			return defaultEncryptionKey;
		}

		public void setDefaultEncryptionKey(String defaultEncryptionKey) {
			this.defaultEncryptionKey = defaultEncryptionKey;
		}
		public String getClaimIntegralURL() {
			return claimIntegralURL;
		}

		public void setClaimIntegralURL(String claimIntegralURL) {
			this.claimIntegralURL = claimIntegralURL;
		}

		public String getClaimIntegralUser() {
			return claimIntegralUser;
		}

		public void setClaimIntegralUser(String claimIntegralUser) {
			this.claimIntegralUser = claimIntegralUser;
		}

		public String getClaimIntegralPasswd() {
			return claimIntegralPasswd;
		}

		public void setClaimIntegralPasswd(String claimIntegralPasswd) {
			this.claimIntegralPasswd = claimIntegralPasswd;
		}

		public String getClaimIntegralDatasource() {
			return claimIntegralDatasource;
		}

		public void setClaimIntegralDatasource(String claimIntegralDatasource) {
			this.claimIntegralDatasource = claimIntegralDatasource;
		}

		public String getClaimIntegralEncMode() {
			return claimIntegralEncMode;
		}

		public void setClaimIntegralEncMode(String claimIntegralEncMode) {
			this.claimIntegralEncMode = claimIntegralEncMode;
		}

		public String getClaimIntegralScreenNm() {
			return claimIntegralScreenNm;
		}

		public void setClaimIntegralScreenNm(String claimIntegralScreenNm) {
			this.claimIntegralScreenNm = claimIntegralScreenNm;
		}
		
		/*
		Ticket #IPAE-18 [ Design & Development - Req#23 - Document uploading facility].
		*/
		protected AppConfig() {
		}

		/**
		 * Default constructor and the only one that makes sense. This reads the contents of the Configuration File and
		 * stores it.
		 *
		 * @param pAppVars global variables.
		 * @param pAppName name of the application, used to find the configuration file.
		 */
		private AppConfig(String pAppName) {
			Object[] fnRoot = this.constructorPart1(pAppName);
			this.constructorPart2(pAppName, fnRoot);
			this.constructorPart3(pAppName, fnRoot);
		}



		/**
		 * Method to do first part of work for {@link #AppConfig(AppVars, String)}. Exists only to keep the method size
		 * reasonable.
		 *
		 * @param pAppVars global variables.
		 * @param pAppName name of the application, used to find the configuration file.
		 * @return String fn and QPScreenNL derived in this first part of the constructor and stored in an array.
		 */
		private Object[] constructorPart1(String pAppName) {
			appName = pAppName;
			QPXMLReader xmlr = null;
			try {
				xmlr = new QPXMLReader(pAppName, "QuipozCfg");
			} catch (RuntimeException e) {
				xmlr = new QPXMLReader(getClass().getResourceAsStream("/QuipozCfg.xml"));
			}
			if (!xmlr.getErrorText().equals("OK")) {
				throw new RuntimeException(xmlr.getErrorText());
			}
			QPScreenNL root = new QPScreenNL(xmlr.getDoc());
			String fn = xmlr.getFileName();

			executionMode = optionalInt(fn, root, "ExecutionMode",
					NON_CONVERSATIONAL);
			// Defect Mercury#1383 - change from warning to diagnostic so that this message
			// only appears for developers
			AppVars.addStaticDiagnostic("Execution mode is " + executionMode);

			if (executionMode == PROVIDED) {
				providedSessionFacade = mandatory(fn, root, "ProvidedSessionFacade");
			}

			programPackage = optional(fn, root, "ProgramPackage", "");
			fullyQualifiedAppVarsClassName = optional(fn, root, "ProgramAppVarsClass", APP_VARS_CLASS_IS_NOT_CONFIGURED);

			timings = optionalBoolean(fn, root,"Timings", false);
			diagnostics = optionalBoolean(fn, root,"Diagnostics", false);

			debugLevel = mandatoryInt(fn, root, "DebugLevel");
			appDebugLevel = mandatoryInt(fn, root, "AppDebugLevel");

			appSchema = mandatory(fn, root, "AppSchema");
			appSchemaNames = mandatory(fn, root, "AppSchemaNames");
			fwSchema = mandatory(fn, root, "FWSchema");
			suppSchema = optional(fn, root, "SuppSchema", fwSchema);
			locale=   optional(fn, root, "Locale",locale);
			startupPage = mandatory(fn, root, "StartupPage");
			sqlDiagLevel = mandatoryInt(fn, root, "SQLDiagLevel");
			sqlEDiagLevel = mandatoryInt(fn, root, "SQLEDiagLevel");
			sqlSummaryOnly = optional(fn, root, "SQLSummaryOnly", Str.NO_LC);
			messageModel = mandatory(fn, root, "MessageModel"); /* POPUP or ONSCREEN */
			dataSourceJNDI = mandatory(fn, root, "DataSourceJNDI");
			dataSourceContext = mandatory(fn, root, "DataSourceContext");
			dataSourceURL = mandatory(fn, root, "DataSourceURL");
			dataSourceUserName = mandatory(fn, root, "DataSourceUserName");
			dataSourcePassword = mandatory(fn, root, "DataSourcePassword");
			dataSourceJDBC = mandatory(fn, root, "DataSourceJDBC");
			driverClassNameJDBC = mandatory(fn, root, "DataDriverJDBC");
			dataDriverJDBC = mandatory(fn, root, "DataDriverJDBC");
			dataSourceFactoryJDBC = mandatory(fn, root, "DataSourceFactoryJDBC");
			useridJDBC = mandatory(fn, root, "UseridJDBC");
			databaseType = mandatory(fn, root, "DatabaseType");
			passwordJDBC = mandatory(fn, root, "PasswordJDBC");
			passwordEncrypt = mandatory(fn, root, "PasswordEncrypt");
			traceSource = mandatory(fn, root, "TraceSource");
			ldapUrl = optional(fn, root, "LDapUrl", "");
			ldapBase = optional(fn, root, "LDapBase", "");
			ldapType = optional(fn, root, "LDapType", "");
			ldapDefaultPassword = optional(fn, root, "LdapDefaultPassword", "");
			ldapUserName = optional(fn, root, "LdapUserName", "");
			systemAdminName = optional(fn, root, "SystemAdminName", "");
			systemAdminPwd = optional(fn, root, "SystemAdminPwd", "");
			xmlSource = optional(fn, root, "XMLSource", "");
			xmlBackup = optional(fn, root, "xmlback", "");
			xmlACon = optional(fn, root, "xmlACon", "");
			pdfTemplate = optional(fn, root, "pdfTemplate", "");
			pdfOutput = optional(fn, root, "pdfOutput", "");
			

			textInput = optional(fn, root, "textInput", "");

					
			//IJ-2031
			textOutput = optional(fn, root, "textOutput", "");

			//IJ-2063
			xmlOutput = optional(fn, root, "xmlOutput", "");

			//IGROUP-733
			csvTemplate = optional(fn, root, "csvTemplate", "");

			//IPNC-847
			SmtpHost = optional(fn, root, "SmtpHost", "");
			SmtpUser = optional(fn, root, "SmtpUser", "");
			SmtpUserPassword = optional(fn, root, "SmtpUserPassword", "");

			csvOutput=mandatory(fn,root,"csvOutput");
			//*********Ticket #IAF-47 Externalisation Code ***************
			vpmsEnable = optionalBoolean(fn, root, "VpmsEnable", false);
			//*********Ticket #IAF-220 Externalisation Code ***************
			vpmsModelDirectory = optional(fn, root, "VpmsModelDirectory", "");
			vpmsEnableLayering = optional(fn, root, "VPMS_EnableLayering", "");
			vpmsCarrierCode = optional(fn, root, "VPMS_CarrierCode", "");
			vpmsProductCode = optional(fn, root, "VPMS_ProductCode", "");
			vpmsRegion = optional(fn, root, "VPMS_Region", "");
			vpmsLocale = optional(fn, root, "VPMS_Locale", "");
			vpmsTransEffDate = optional(fn, root, "VPMS_TransEffDate", "");
			vpmsCallingSystem = optional(fn, root, "VPMS_CallingSystem", "");
			vpmsCallingProgram = optional(fn, root, "VPMS_CallingProgram", "");		
			vpmsXeServerIp=optional(fn, root, "VPMS_XE_Server_IP", "");
			vpmsXeServerPort=optionalInt(fn, root, "VPMS_XE_Server_Port", 0);
			vpmsXeServer=optional(fn, root, "VPMS_XE_Server", "");
			//*********Ticket #IAF-220 Externalisation Code ***************
			documentServiceURL = mandatory(fn,root, "DocumentServiceURL");
			documentServiceTaxonomy = mandatory(fn, root, "DocumentServiceTaxonomy");
			DMSEnable = mandatory(fn, root, "DMSUploadEnable");
			vpmsUrl = mandatory(fn, root, "VPMSUrl");
			currentLanguage = mandatory(fn, root, "CurrentLanguage");
	        integralBatchEnable = optionalBoolean(fn, root, "IntegralBatchEnable", false);
	        String sbaServices = mandatory(fn, root, "IntegralBatchWebservices");
	        sbaSchema = sbaServices.substring(0, sbaServices.indexOf(":"));
	        sbaHostPart = sbaServices.substring(sbaServices.indexOf("//") + 2, sbaServices.length());

			deployedEnvironment = optional(fn, root, "DeployedEnvironment", "");

			// add by benny on 28th Feb, 2008
			// store the root directory when generatiNG PDF
			appSchemaNames = mandatory(fn, root, "AppSchemaNames");
			fopPrintRoot = optional(fn, root, "FOPPrintRoot", null);
			fopOnLinePrintRoot = optional(fn, root, "FOPOnLinePrintRoot", null);
			// store the batch socket URL
			socketURL = optional(fn, root, "SocketURL", null);
			// store the batch socket Port
			socketPort = optional(fn, root, "SocketPort", null);
			// add end

			/*****************************TODO*********************************/
			documentServiceURL = optional(fn,root, "DocumentServiceURL", null);
			documentServiceTaxonomy = optional(fn, root, "DocumentServiceTaxonomy", null);
			DMSEnable = optional(fn, root, "DMSUploadEnable", null);
			/*******************************************************************/

			/* Do not load server mode if it is already set */
			if (server == null) {
				server = mandatory(fn, root, "Server").toLowerCase();
			}
			// Optional properties if the EJB is remote
			initialContextFactory = optional(fn, root, "InitialContextFactory", "com.ibm.websphere.naming.WsnInitialContextFactory");
			providerUrl = optional(fn, root, "ProviderUrl", "iiop://localhost:2809");
			smtpServer = optional(fn, root, "SMTPServer", "localhost");
			logonRequired = mandatory(fn, root, "LogonRequired");
			monitorOn = mandatory(fn, root, "MonitorOn");
			defaultFold = optional(fn, root, "DefaultFold", LC);
			tableBuffer = optional(fn, root, "TableBuffer", Str.NO_LC);
			baseScreen = optional(fn, root, "JSPBaseScreen", "BASESCREEN.jsp");
			collateTab = optional(fn, root, "Collate", "");
			showVNOnError = optional(fn, root, "ShowVNOnError", Str.YES_CC);

			showScreenID = optional(fn, root, "ShowScreenID", "No");
			version = optional(fn, root, "Version", "");
			oldJspTemplate = Boolean.valueOf(mandatory(fn, root, "OldJspTemplate"));
			fsuVersion = optional(fn, root, "FsuVersion", "");

			outputsAsFields = optional(fn, root, "OutputsAsFields", Str.NO_CC);
			preformatted = optional(fn, root, "Preformatted", Str.NO_CC);
			charSet = optional(fn, root, "CharSet", null);
			defaultLanguage = optional(fn, root, "DefaultLanguage", "ENG");
			pfKeyLangConditioned = optional(fn, root, "PFKeyLangConditioned", Str.NO_CC);
			setIndicatorByPFKeyNo = Boolean.valueOf(optional(fn, root, "SetIndicatorByPFKeyNo", Str.FALSE_LC));
			systemFont = optional(fn, root, "SystemFont", "Verdana, Arial, Helvetica, sans-serif");
			systemFontSize = optional(fn, root, "SystemFontSize", "10");
			onlineTimeout = optionalInt(fn, root, "OnlineTimeout", Num.SECS_MIN) * Num.MSECS_SEC;
			transactionTimeout = optionalInt(fn, root, "TransactionTimeout", 3600); // Default is set to 1 hour (3600 seconds)
			onLineQueryTimeout = optionalInt(fn, root, "OnLineQueryTimeout", 30); // Default is set to 30 seconds
			batchQueryTimeout = optionalInt(fn, root, "BatchQueryTimeout", 30); // Default is set to 30 seconds seconds)
			batchTimeout = optionalInt(fn, root, "BatchTimeout", Num.SECS_HOUR) * Num.MSECS_SEC;
			userTimeout = optionalInt(fn, root, "UserTimeout", TEN_MIN) * Num.MSECS_SEC;
			userHeartbeat = optionalInt(fn, root, "UserHeartbeat", HALF_MIN) * Num.MSECS_SEC;
			tableBufferFlag = tableBuffer.equalsIgnoreCase("yes");
			transactionScope = mandatory(fn, root, "TransactionScope");
			transactionManagerHelperClass = optional(fn, root, "TransactionManagerHelperClass", "");
			//Ticket #IPAE-18 [ Design & Development - Req#23 - Document uploading facility].
			riskFirServiceURL = optional(fn, root, "RiskFirServiceURL", null);
			riskFioServiceURL = optional(fn, root, "RiskFioServiceURL", null);
			riskLppServiceURL = optional(fn, root, "RiskLppServiceURL", null);
			//Ticket #IPAE-18 [ Design & Development - Req#23 - Document uploading facility].
			identityMapperClass = optional(fn, root, "IdentityMapperClass", "");
			//IAF-39[ILIFE - 1131[MTL: Performance Issue in Batch - L2GLUNLNK]]
			pagesPerFile = optional(fn, root, "PagesPerFile", "");

			numbers = mandatory(fn, root, "Numbers");
			dateToNumber = mandatory(fn, root, "DateToNumber");
			inputfile = optional(fn, root, " inputfile ", ""); //IAF-208

			if (!dateToNumber.equals(DATE_TO_MSECS) && !dateToNumber.equals(DATE_TO_YYYYMMDD)) {
				String save = dateToNumber;
				dateToNumber = null;
				throw new RuntimeException("XML field DateToNumber ('" + save + "') is invalid. Use " + DATE_TO_YYYYMMDD
				        + " or " + DATE_TO_MSECS);
			}
			loadAddtlConfiguration(root);
			
			HashMap<String, Feature> map = SwitchOnOffUtil.readSwitchOnOffFile(); // IAF-186
			if (map != null)
				features = map;
			
			subFolders = optional(fn, root, "SubFolders", null);
			
			return new Object[] { fn, root };
		}

		protected void constructorPart2(String pAppName, Object[] fnRoot) {
			String fn = (String) fnRoot[0];
			QPScreenNL root = (QPScreenNL) fnRoot[1];

			alpha = mandatory(fn, root, "Alpha");

			alpha2Numer = optionalBoolean(fn, root, "Alpha2Number", false);
			ebcdicCharset = optional(fn, root, "EbcdicCharset", ebcdicCharset);

			upperAlpha = mandatory(fn, root, "Uppercase");
			lowerAlpha = mandatory(fn, root, "Lowercase");
			decimalSeparator = mandatory(fn, root, "DecimalSep");
			thousandSeparator = mandatory(fn, root, "ThouSep");
			dateFormat = mandatory(fn, root, "DateFormat");
			timeFormat = mandatory(fn,root, "TimeFormat");
			enforceSize = optional(fn, root, "EnforceSize", Str.NO_CC);

			autoTab = optional(fn, root, "Autotab", Str.NO_CC);
			String moveNToCPad0 = mandatory(fn, root, "MoveNToCPad0");
			isMoveNToCPad0 = moveNToCPad0 != null && moveNToCPad0.trim().equalsIgnoreCase(Str.SY);

			initFlsd = optionalBoolean(fn, root, "InitFlsd", true);
			resultSetType = optionalInt(fn, root, "ResultSetType", ResultSet.TYPE_FORWARD_ONLY);
			/*
			 * This code propagates the date format to the DateData static value
			 */
			DateData.setDefaultDateFormat(dateFormat);

			this.dontReport= optional(fn, root, "DontReport","AppVars/ApplicationVariables");

			if (executionMode != EXECUTING_MODE_BATCH) {
				if (root.getRealChildCount(MASTER_PROGS) == 0) {
					throw new RuntimeException(FIL + fn + NO_NODE + MASTER_PROGS
							+ Str.XML_C);
				}
				QPScreenNL progs = root.getFirstChild(MASTER_PROGS);
				defaultProgramPackage = mandatory(fn + " node <MasterPrograms>",
						progs, "DefaultProgramPackage");
				int count = progs.getRealChildCount(PROG);
				if (count == 0) {
					throw new RuntimeException(FIL + fn
							+ "' does not contain any <Program> nodes within <"
							+ MASTER_PROGS + Str.XML_C);
				}
				programs = new String[count][Num.I3];
				QPScreenNL prog = progs.getFirstChild(PROG);
				for (int i = 0; i < count; i++) {
					programs[i][0] = mandatory(fn + MP_P_N + i, prog, "Handle").trim().toUpperCase();
					programs[i][1] = mandatory(fn + MP_P_N + i, prog, "Name").trim();
					programs[i][2] = optional(fn + MP_P_N + i, prog, "Package", defaultProgramPackage).trim();
					prog = progs.getNextChild(PROG);
				}
			}

			QPScreenNL smh = root.getFirstChild("JSPSingleModel");
			if (smh != null) {
				QPScreenNL r1 = smh.getFirstChild(EXCL);
				while (!r1.isNull()) {
					singleModelJSP.add(Str.BANG + r1.getNodeValue());
					r1 = smh.getNextChild(EXCL);
				}
				r1 = smh.getFirstChild(INCL);
				while (!r1.isNull()) {
					singleModelJSP.add(r1.getNodeValue());
					r1 = smh.getNextChild(INCL);
				}
			}
			//Added this code for Policy Experience Redirection RI-4 start
			if (executionMode != EXECUTING_MODE_BATCH) {
				if (root.getRealChildCount(RMAInt) == 0) {
				throw new RuntimeException(FIL + fn + NO_NODE + RMAInt
						+ Str.XML_C);
			}
			    QPScreenNL rma = root.getFirstChild(RMAInt);
			    if (!rma.isNull()){
					desEncrytionScheme=mandatory(fn + " node <RMAIntegration>",rma,"DesEncrytionScheme");
					messageDigestAlgo=mandatory(fn + " node <RMAIntegration>",rma,"MessageDigestAlgo");
					desEncyptionPadding=mandatory(fn + " node <RMAIntegration>",rma,"DesEncyptionPadding");
					defaultEncryptionKey=mandatory(fn + " node <RMAIntegration>",rma,"DefaultEncryptionKey");
				    claimIntegration=optionalBoolean(fn + " node <RMAIntegration>",rma,"ClaimIntegration",false);
			    	claimIntegralURL=mandatory(fn + " node <RMAIntegration>",rma,"ClaimIntegralURL");
			    	claimIntegralUser=mandatory(fn + " node <RMAIntegration>",rma,"ClaimIntegralUser");
					claimIntegralPasswd=mandatory(fn + " node <RMAIntegration>",rma,"ClaimIntegralPasswd");
					claimIntegralDatasource=mandatory(fn + " node <RMAIntegration>",rma,"ClaimIntegralDatasource");
					claimIntegralEncMode=mandatory(fn + " node <RMAIntegration>",rma,"ClaimIntegralEncMode");
					claimIntegralScreenNm=mandatory(fn + " node <RMAIntegration>",rma,"ClaimIntegralScreenNm");
			    }
			}	
			// Added this code for Policy Experience Redirection RI-4 end
			// Set the default character set translation (typically set to the
			// character set used by the source application.)
			defaultCharSetIdx = Integer.parseInt(optional(fn, root,
			    "com.quipoz.framework.util.charset.comparer.defaultCharSetIdx", String.valueOf(Comparer.JAVA_NATIVE)));
			if (!Comparer.isCharsetSetInThisJVM()) {
				Comparer.setDefaultCharset(defaultCharSetIdx);
				// ebcdicCharset must be initialised already
				Ebcdic.setCharsetArrayAs(ebcdicCharset);
			}

			// Set the JNDI directory naming server provider from the Config.xml
			// entries. BUT ONLY IF THEY ARE PROVIDED!
			String nf = optional(fn, root, JNFI, "");
			if (nf != null && !nf.equals("")) {
				System.setProperty(JNFI, nf);
			}
			String np = optional(fn, root, JNPU, "");
			if (np != null && !np.equals("")) {
				System.setProperty(JNPU, np);
			}

			// Set queue configuration properties for the Config.xml enteries
			queueManagerName = optional(fn, root, "javax.jms.queue.DataQueueManagerName", "");
			queueName = optional(fn, root, "javax.jms.queue.DataQueueName", "");

			// Sets configuration value representing objects that are exclude from
			// locking.
			// The string is in the format of
			// "LIBRARY_NAME|OBJECT_ID|OBJECT_TYPE|DATA_AREA" seperated
			// by commas. The DATA_AREA is optional, if it is left off it will be
			// ignored, all other attributes
			// adhere to the RPG object naming convention.
			// e.g.
			// TSTLIB1|TSTFILE1|*FILE|da1,TSTLIB1|TSTFILE2|*FILE,TSTLIB1|TSTFILE*|*FILE
			logicalLockIncludes = optional(fn, root, "Lockable", "");
			StringBuffer sb = new StringBuffer();
			char[] ca = logicalLockIncludes.toCharArray();
			for (int i = 0; i < ca.length; i++) {
				if (ca[i] != ' ' && ca[i] != '\n' && ca[i] != '\r') {
					sb.append(ca[i]);
				}
			}
			logicalLockIncludes = sb.toString();
		}


		/**
		 * Method to do third part of work for {@link #AppConfig(AppVars, String)}. Exists only to keep the method size
		 * reasonable.
		 *
		 * @param pAppVars global variables.
		 * @param pAppName name of the application, used to find the configuration file.
		 * @param fnRoot String fn and QPScreenNL derived in the first part of the constructor and stored in an array.
		 */
		private void constructorPart3(String pAppName, Object[] fnRoot) {

			String fn = (String) fnRoot[0];
			QPScreenNL root = (QPScreenNL) fnRoot[1];

			// Populate the path of the Properties file configured for the
			// application using this framework
			applicationProperties = optional(fn, root, "ApplicationProperties", "");

			// Populate the path of the Properties file configured for the
			// application using this framework
			jobProperties = optional(fn, root, "JobProperties", "");

			truncateSQLParms = optional(fn, root, "TruncateSQLParms", "YES").equalsIgnoreCase("YES");

			this.ApplicationUse0 = optional(fn, root, "ApplicationUse0", "");
			this.ApplicationUse1 = optional(fn, root, "ApplicationUse1", "");
			this.ApplicationUse2 = optional(fn, root, "ApplicationUse2", "");
			this.ApplicationUse3 = optional(fn, root, "ApplicationUse3", "");
			this.ApplicationUse4 = optional(fn, root, "ApplicationUse4", "");
			this.ApplicationUse5 = optional(fn, root, "ApplicationUse5", "");
			this.ApplicationUse6 = optional(fn, root, "ApplicationUse6", "");
			this.ApplicationUse7 = optional(fn, root, "ApplicationUse7", "");
			this.ApplicationUse8 = optional(fn, root, "ApplicationUse8", "");
			this.ApplicationUse9 = optional(fn, root, "ApplicationUse9", "");
			this.ApplicationUse10 = optional(fn, root, "ApplicationUse10", "");
			this.ApplicationUse11 = optional(fn, root, "ApplicationUse11", "");
			this.ApplicationUse12 = optional(fn, root, "ApplicationUse12", "");

			DBCSLanguage = optional(fn, root, "DBCSLanguage", null);
			dbcsScreenLanguage = optional(fn, root, "DBCSScreenLanguage", null);
			DBCSForScreens = optionalBoolean(fn, root, "DBCSForScreens", false);
			dbcsForDB = optionalBoolean(fn, root, "DBCSForDB", false);
			dbcsForFiles = optionalBoolean(fn, root, "DBCSForFiles", false);
			dbcsForDiag = optionalBoolean(fn, root, "DBCSForDiag", false);

			String def = optional(fn, root, "DefaultPackedMode", FMODE).toUpperCase();

			if (def.equals(FMODE)) {
				defaultPackedMode = PackedDecimalData.FMODE;
			} else if (def.equals(CMODE)) {
				defaultPackedMode = PackedDecimalData.CMODE;
			} else if (def.equals(OMODE)) {
				defaultPackedMode = PackedDecimalData.OMODE;
			} else {
				throw new RuntimeException("DefaultPackedMode must be 'FMODE' or 'CMODE' or 'OMODE' not '"
				        + defaultPackedMode + Str.APOST);
			}

			if (PackedDecimalData.getDefaultMode() != defaultPackedMode) {
				PackedDecimalData.setDefaultMode(defaultPackedMode);
			}

			def = optional(fn, root, "DefaultPositiveZonedMode", FMODE).toUpperCase();

			if (def.equals(FMODE)) {
				defaultPositiveZonedMode = NumberString.FMODE;
			} else if (def.equals(CMODE)) {
				defaultPositiveZonedMode = NumberString.CMODE;
			} else {
				throw new RuntimeException("DefaultPositiveZonedMode must be 'FMODE' or 'CMODE' not '"
				        + defaultPositiveZonedMode + Str.APOST);
			}

			if (NumberString.getModeToUse() != defaultPositiveZonedMode) {
				NumberString.setModeToUse(defaultPositiveZonedMode);
			}

			/**
			 * Added by Max W For 0 divisor
			 */
			String divisionMode = optional(fn, root, "DivisionMode", null);
			if (divisionMode != null && divisionMode.trim().length() > 0) {
				BaseData.setDivisionMode(Byte.valueOf(divisionMode.trim()));
			}

			/**
			 * Added by MW(Quipoz) 25/02/08
			 */
			setVariableRenamingSuffix(optional(fn, root, "VariableRenamingSuffix", null));

			memoryRefDebug = optionalInt(fn, root, "MemoryRefDebug", 0);

			systemName = optional(fn, root, "SystemName", null);
			isDebugTimeEnabled = optionalBoolean(fn, root, "DebugTimeEnabled", false);
			sqlTiersDeep = optionalInt(fn, root, "SQLTiersDeep", Num.I100);

			// vvvvvvvv Excessive reads tuning params START vvvvvvvvvvvvvvvvvv
			// true - conventional main stream development (default).
			// false - various experimental optimisations (Defect 1203 & CR 15955).
			useStackTraceModeBatch = optionalBoolean(fn, root, "UseStackTraceModeBatch", true);
			useStackTraceModeOnline = optionalBoolean(fn, root, "UseStackTraceModeOnline", true);

			useRowNumbers = optionalBoolean(fn, root, "UseRowNumbers", false);
			useSQLTiers = optionalBoolean(fn, root, "UseSQLTiers", false);

			onlineRowNumbersSequence = getRowNumberSequence(optional(fn, root, "OnlineRowNumbersSequence", DEFNUMS_ONLINE));
			batchRowNumbersSequence = getRowNumberSequence(optional(fn, root, "BatchRowNumbersSequence", DEFNUMS_BATCH));

			duplicatesOldestFirst = optionalBoolean(fn, root, "DuplicatesOldestFirst", true);
			// ^^^^^^^^ Excessive reads tuning params END ^^^^^^^^^^^^^^^^^^^^

			isRocBasedApplication = optionalBoolean(fn, root, "IsRocBasedApplication", false);

			oracleNlsComp = optional(fn, root, "ORACLE_NLS_COMP", "LINGUISTIC");
			oracleNlsSort = optional(fn, root, "ORACLE_NLS_SORT", "EBCDIC");

			// jms Weblogic properties for sleep command
			jmsServerName = optional(fn, root, "jmsServerName", "JMSServer-0");
			jmsModuleName = optional(fn, root, "jmsModuleName", "SystemModule-0");
			jmsConnectionFactory = optional(fn, root, "jmsConnectionFactory", "tpoc.connectionFactory");
			jmsTopicPreffix = optional(fn, root, "jmsTopicPreffix", "topic.");

			batchBaseDir = optional(fn, root, "batchBaseDir", "");
			batchOutputFileDir = optional(fn, root, "batchOutputFileDir", "");
			batchPrintFileDir = optional(fn, root, "batchPrintFileDir", "");
			batchTempFileDir = optional(fn, root, "batchTempFileDir", batchOutputFileDir);
			batchWaitingFileDir = optional(fn, root, "batchWaitingFileDir", "");
			batchRemoveTempFiles = optionalBoolean(fn, root, "batchRemoveTempFiles", true);
			scriptsDir = optional(fn, root, "scriptsDir", "");
			daemonFrequency = optionalInt(fn, root, "daemonFrequency", 0);

			applicationUserCode = optional(fn, root, "ApplicationUserCode", "");
			applicationSystemNumber = optional(fn, root, "ApplicationSystemNumber", "");
			smaOpConEventDir = optional(fn, root, "SMAOpConEventDir", "");
			hostServerName = optional(fn, root, "HostServerName", "");

			helpDir = optional(fn, root, "helpDir", "");
			helpCodeScrnsColumn = optional(fn, root, "scrnsColumnForHelpCode", "HELPPRE");
			keyColumnForHelpCode = optional(fn, root, "keyColumnForHelpCode", "");

			memoryCopy = optionalBoolean(fn, root, "MemoryCopy", false);

			QPScreenNL qcmdexc = root.getFirstChild("QcmdexcFiles");
			if (qcmdexc != null) {
				int count = qcmdexc.getRealChildCount("file");
				if (count > 0) {
					qcmdexcFiles = new String[count];
					QPScreenNL file = qcmdexc.getFirstChild("file");
					for (int i = 0; i < count; i++) {
						qcmdexcFiles[i] = file.getNodeValue();
						file = qcmdexc.getNextChild("file");
					}
				}
			}
		}

		/** Empty code block. */
		private void doNothing() {
		}

		/**
		 * Returns the {@link #appDebugLevel}.
		 *
		 * @return {@link #appDebugLevel}.
		 */
		public int getAppDebugLevel() {
			return appDebugLevel;
		}

		/**
		 * Getter for {@link #applicationProperties}.
		 *
		 * @return {@link #applicationProperties}.
		 */
		public String getApplicationProperties() {
			return applicationProperties;
		}

		/**
		 * Gets the path and name of the file configured for the application using the framework.
		 *
		 * @return {@link #applicationProperties}.
		 */
		public String getApplicationPropertiesFilePath() {
			return applicationProperties;
		}

		/**
		 * Getter for {@link #applicationSystemNumber}.
		 *
		 * @return {@link #applicationSystemNumber}.
		 */
		public String getApplicationSystemNumber() {
			return applicationSystemNumber;
		}

		/**
		 * Getter for {@link #applicationUserCode}.
		 *
		 * @return {@link #applicationUserCode}.
		 */
		public String getApplicationUserCode() {
			return applicationUserCode;
		}

		public String getApplicationUse0() {
			return ApplicationUse0;
		}

		public String getApplicationUse1() {
			return ApplicationUse1;
		}

		public String getApplicationUse10() {
			return ApplicationUse10;
		}

		public String getApplicationUse11() {
			return ApplicationUse11;
		}

		public String getApplicationUse12() {
			return ApplicationUse12;
		}

		public String getApplicationUse2() {
			return ApplicationUse2;
		}

		public String getApplicationUse3() {
			return ApplicationUse3;
		}

		public String getApplicationUse4() {
			return ApplicationUse4;
		}

		public String getApplicationUse5() {
			return ApplicationUse5;
		}

		public String getApplicationUse6() {
			return ApplicationUse6;
		}

		public String getApplicationUse7() {
			return ApplicationUse7;
		}

		public String getApplicationUse8() {
			return ApplicationUse8;
		}

		public String getApplicationUse9() {
			return ApplicationUse9;
		}

		/**
		 * Getter for {@link #appName}.
		 *
		 * @return {@link #appName}.
		 */
		public String getAppName() {
			return appName;
		}

		/**
		 * Returns the appSchema.
		 *
		 * @return String
		 */
		public String getAppSchema() {
			return appSchema;
		}

		/**
		 * Returns the appSchemaNames.
		 *
		 * @return String
		 */
		public String getAppSchemaNames() {
			return appSchemaNames;
		}

		/**
		 * Returns the baseScreen.
		 *
		 * @return String
		 */
		public String getBaseScreen() {
			return baseScreen;
		}

		/**
		 * Getter for {@link #batchBaseDir}.
		 *
		 * @return {@link #batchBaseDir}.
		 */
		public String getBatchBaseDir() {
			return batchBaseDir;
		}

		/**
		 * Getter for {@link #batchOutputFileDir}.
		 *
		 * @return {@link #batchOutputFileDir}.
		 */
		public String getBatchOutputFileDir() {
			return batchOutputFileDir;
		}

		/**
		 * Getter for {@link #batchPrintFileDir}.
		 *
		 * @return {@link #batchPrintFileDir}.
		 */
		public String getBatchPrintFileDir() {
			return batchPrintFileDir;
		}

		/**
		 * Getter for {@link #batchQueryTimeout}.
		 *
		 * @return {@link #batchQueryTimeout}.
		 */
		public int getBatchQueryTimeout() {
			return batchQueryTimeout;
		}

		/**
		 * Getter for {@link #batchRowNumbersSequence}.
		 *
		 * @return {@link #batchRowNumbersSequence}.
		 */
		public int[] getBatchRowNumbersSequence() {
			int[] copy = batchRowNumbersSequence;
			return copy;
		}

		/**
		 * Getter for {@link #batchTempFileDir}.
		 *
		 * @return {@link #batchTempFileDir}.
		 */
		public String getBatchTempFileDir() {
			return batchTempFileDir;
		}

		/**
		 * Getter for {@link #batchTimeout}.
		 *
		 * @return {@link #batchTimeout}.
		 */
		public long getBatchTimeout() {
			return batchTimeout;
		}

		/**
		 * Getter for {@link #batchWaitingFileDir}.
		 *
		 * @return {@link #batchWaitingFileDir}.
		 */
		public String getBatchWaitingFileDir() {
			return batchWaitingFileDir;
		}

		/**
		 * Getter for {@link #charSet}.
		 *
		 * @return {@link #charSet}.
		 */
		public String getCharSet() {
			return charSet;
		}

		/**
		 * Clone this Class.
		 *
		 * @return this class cloned.
		 */
		public AppConfig getClone() {
			AppConfig newConfig = new AppConfig();

			newConfig.appName = this.appName;
			newConfig.appSchema = this.appSchema;
			newConfig.appSchemaNames = this.appSchemaNames;
			newConfig.debugLevel = this.debugLevel;
			newConfig.appDebugLevel = this.appDebugLevel;
			newConfig.sqlDiagLevel = this.sqlDiagLevel;
			newConfig.sqlEDiagLevel = this.sqlEDiagLevel;
			newConfig.messageModel = this.messageModel;
			newConfig.dataSourceJNDI = this.dataSourceJNDI;
			newConfig.dataSourceContext = this.dataSourceContext;
			newConfig.dataSourceURL = this.dataSourceURL;
			newConfig.dataSourceUserName = this.dataSourceUserName;
			newConfig.dataSourcePassword = this.dataSourcePassword;
			newConfig.dataSourceJDBC = this.dataSourceJDBC;
			newConfig.driverClassNameJDBC = this.driverClassNameJDBC;
			newConfig.dataSourceFactoryJDBC = this.dataSourceFactoryJDBC;
			newConfig.useridJDBC = this.useridJDBC;
			newConfig.dataDriverJDBC = this.dataDriverJDBC;
			newConfig.databaseType = this.databaseType;
			newConfig.passwordJDBC = this.passwordJDBC;
			newConfig.resultSetType = this.resultSetType;
			newConfig.subPath = this.subPath;
			newConfig.traceSource = this.traceSource;
			newConfig.ldapUrl = this.ldapUrl;
			newConfig.ldapBase = this.ldapBase;
			newConfig.ldapType = this.ldapType;
			newConfig.ldapDefaultPassword = this.ldapDefaultPassword;
			newConfig.ldapUserName = this.ldapUserName;
			newConfig.systemAdminName = this.systemAdminName;
			newConfig.systemAdminPwd = this.systemAdminPwd;
			newConfig.xmlACon = this.xmlACon;
			newConfig.xmlBackup = this.xmlBackup;
			newConfig.xmlSource = this.xmlSource;
			newConfig.pdfOutput = this.pdfOutput;
			newConfig.textInput = this.textInput; 
			newConfig.textOutput = this.textOutput; //IJ-2031
			newConfig.xmlOutput = this.xmlOutput; //IJ-2063
			newConfig.pdfTemplate = this.pdfTemplate;
			newConfig.csvTemplate = this.csvTemplate; //IGROUP-733
			newConfig.qcmdexcFiles = this.qcmdexcFiles;
			newConfig.SmtpHost = this.SmtpHost;//IPNC-847
			newConfig.SmtpUser = this.SmtpUser;//IPNC-847
			newConfig.SmtpUserPassword = this.SmtpUserPassword;//IPNC-847
			//Changes done for Policy Experience Redirection start
			//newConfig.rmaIntegration=this.rmaIntegration;
			newConfig.claimIntegration=this.claimIntegration;
			newConfig.desEncrytionScheme=this.desEncrytionScheme;
			newConfig.defaultEncryptionKey=this.defaultEncryptionKey;
			newConfig.desEncyptionPadding=this.desEncyptionPadding;
			newConfig.messageDigestAlgo=this.messageDigestAlgo;		
			newConfig.claimIntegralURL=this.claimIntegralURL;
			newConfig.claimIntegralUser=this.claimIntegralUser;
			newConfig.claimIntegralPasswd=this.claimIntegralPasswd;
			newConfig.claimIntegralDatasource=this.claimIntegralDatasource;	
			newConfig.claimIntegralEncMode=this.claimIntegralEncMode;
			newConfig.claimIntegralScreenNm=this.claimIntegralScreenNm;
			//Changes done for Policy Experience Redirection end
			newConfig. inputfile = this. inputfile;
			newConfig.subFolders = this.subFolders;
			return newConfig;
		}

		/**
		 * Getter for {@link #collateTab}.
		 *
		 * @return {@link #collateTab}.
		 */
		public String getCollateTab() {
			return collateTab;
		}

		public String getCurrentLanguage() {
	        return currentLanguage;
	    }

		/**
		 * Getter for {@link #daemonFrequency}.
		 *
		 * @return {@link #daemonFrequency}.
		 */
		public int getDaemonFrequency() {
			return daemonFrequency;
		}

		/**
		 * @return the databaseType
		 */
		public String getDatabaseType() {
			return databaseType;
		}

		/**
		 * @return the dataDriverJDBC
		 */
		public String getDataDriverJDBC() {
			return dataDriverJDBC;
		}

		public String getDataSourceFactoryJDBC() {
			return dataSourceFactoryJDBC;
		}

		/**
		 * Getter for {@link #dataSourceJDBC}.
		 *
		 * @return {@link #dataSourceJDBC}.
		 */
		public String getDataSourceJDBC() {
			return dataSourceJDBC;
		}

		/**
		 * Getter for {@link #dataSourceJNDI}.
		 *
		 * @return {@link #dataSourceJNDI}.
		 */
		public String getDataSourceJNDI() {
			return dataSourceJNDI;
		}

		/**
		 * Getter for {@link #DBCSLanguage}.
		 *
		 * @return {@link #DBCSLanguage}.
		 */
		public String getDBCSLanguage() {
			return DBCSLanguage;
		}

		/**
		 * Getter for {@link #dbcsScreenLanguage}.
		 *
		 * @return {@link #dbcsScreenLanguage}.
		 */
		public String getDBCSScreenLanguage() {
			return dbcsScreenLanguage;
		}

		/**
		 * Getter for {@link #appSchema}.
		 *
		 * @return {@link #appSchema}.
		 */
		public String getDBSchema() {
			return appSchema;
		}

		/**
		 * Getter for {@link #debugLevel}.
		 *
		 * @return {@link #debugLevel}.
		 */
		public int getDebugLevel() {
			return debugLevel;
		}

		/**
		 * Getter for {@link #decimalSeparator}.
		 *
		 * @return {@link #decimalSeparator}.
		 */
		public String getDecimalSeparator() {
			return decimalSeparator;
		}

		/**
		 * Gets the default charset {@link #defaultCharSetIdx} that will be used to compare strings within the StringBase
		 * class.
		 *
		 * @return {@link #defaultCharSetIdx}.
		 */
		public int getDefaultCharSetIdx() {
			return defaultCharSetIdx;
		}

		/**
		 * Getter for {@link #defaultFold}.
		 *
		 * @return {@link #defaultFold}.
		 */
		public String getDefaultFold() {
			return defaultFold;
		}

		/**
		 * Getter for {@link #defaultLanguage}.
		 *
		 * @return {@link #defaultLanguage}.
		 */
		public String getDefaultLanguage() {
			return defaultLanguage;
		}

		/**
		 * Getter for {@link #defaultPackedMode}.
		 *
		 * @return {@link #defaultPackedMode}.
		 */
		public char getDefaultPackedMode() {
			return defaultPackedMode;
		}

		/**
		 * Getter for {@link #defaultPositiveZonedMode}.
		 *
		 * @return {@link #defaultPositiveZonedMode}.
		 */
		public byte getDefaultPositiveZonedMode() {
			return defaultPositiveZonedMode;
		}

		/**
		 * Getter for {@link #defaultProgramPackage}.
		 *
		 * @return {@link #defaultProgramPackage}.
		 */
		public String getDefaultProgramPackage() {
			return defaultProgramPackage;
		}

		/**
		 * gets deployed environment setting
		 *
		 * @return return deployedEnvironment;
		 */
		public String getDeployedEnvironment() {
			return deployedEnvironment;
		}

		/**
		 * @return the dMSEnable
		 */
		public String getDMSEnable() {
			return DMSEnable;
		}

		public String getDMSServletPath() {
			return dmsServletPath;
		}

		/**
		 * @return the documentServiceTaxonomy
		 */
		public String getDocumentServiceTaxonomy() {
			return documentServiceTaxonomy;
		}

		/**
		 * @return the documentServiceURL
		 */
		public String getDocumentServiceURL() {
			return documentServiceURL;
		}

		/**
		 * Getter for {@link #dontReport}.
		 *
		 * @return {@link #dontReport}.
		 */
		public String getDontReport() {
			return dontReport;
		}

		public String getDriverClassNameJDBC() {
			return driverClassNameJDBC;
		}

		/**
		 * Getter for {@link #fwSchema}.
		 *
		 * @return {@link #fwSchema}.
		 */
		public String getFwSchema() {
			return fwSchema;
		}

		/**
		 * Getter for {@link #helpCodeScrnsColumn}.
		 *
		 * @return {@link #helpCodeScrnsColumn}.
		 */
		public String getHelpCodeScrnsColumn() {
			return helpCodeScrnsColumn;
		}

		/**
		 * Getter for {@link #helpDir}.
		 *
		 * @return {@link #helpDir}.
		 */
		public String getHelpDir() {
			return helpDir;
		}

		/**
		 * Getter for {@link #hostServerName}.
		 *
		 * @return {@link #hostServerName}.
		 */
		public String getHostServerName() {
			return hostServerName;
		}

		/**
		 * Getter for {@link #identityMapperClass}.
		 *
		 * @return {@link #identityMapperClass}.
		 */
		public String getIdentityMapperClassName() {
			return identityMapperClass;
		}

		/**
		 * Getter for {@link #initialContextFactory}.
		 *
		 * @return {@link #initialContextFactory}.
		 */
		public String getInitialContextFactory() {
			return initialContextFactory;
		}

		/**
		 * Getter for {@link #jmsConnectionFactory}.
		 *
		 * @return {@link #jmsConnectionFactory}.
		 */
		public String getJmsConnectionFactory() {
			return jmsConnectionFactory;
		}

		/**
		 * Getter for {@link #jmsModuleName}.
		 *
		 * @return {@link #jmsModuleName}.
		 */
		public String getJmsModuleName() {
			return jmsModuleName;
		}

		/**
		 * Getter for {@link #jmsServerName}.
		 *
		 * @return {@link #jmsServerName}.
		 */
		public String getJmsServerName() {
			return jmsServerName;
		}

		/**
		 * Getter for {@link #jmsTopicPreffix}.
		 *
		 * @return {@link #jmsTopicPreffix}.
		 */
		public String getJmsTopicPreffix() {
			return jmsTopicPreffix;
		}

		/**
		 * Getter for {@link #jobProperties}.
		 *
		 * @return {@link #jobProperties}.
		 */
		public String getJobProperties() {
			return jobProperties;
		}

		/**
		 * Getter for {@link #jobProperties}.
		 *
		 * @return {@link #jobProperties}.
		 */
		public String getJobPropertiesFilePath() {
			return jobProperties;
		}

		/**
		 * Getter for {@link #keyColumnForHelpCode}.
		 *
		 * @return {@link #keyColumnForHelpCode}.
		 */
		public String getKeyColumnForHelpCode() {
			return keyColumnForHelpCode;
		}

		/**
		 * Getter for {@link #ldapBase}.
		 *
		 * @return {@link #ldapBase}.
		 */
		public String getLdapBase() {
			return ldapBase;
		}

		/**
		 * @return the ldapUserName
		 */
		public String getLdapUserName() {
			return ldapUserName;
		}

		/**
		 * @param ldapUserName the ldapUserName to set
		 */
		public void setLdapUserName(String ldapUserName) {
			this.ldapUserName = ldapUserName;
		}

		/**
		 * @return the ldapDefaultPassword
		 */
		public String getLdapDefaultPassword() {
			return ldapDefaultPassword;
		}

		/**
		 * @param ldapDefaultPassword the ldapDefaultPassword to set
		 */
		public void setLdapDefaultPassword(String ldapDefaultPassword) {
			this.ldapDefaultPassword = ldapDefaultPassword;
		}

		/**
		 * Getter for {@link #ldapUrl}.
		 *
		 * @return {@link #ldapUrl}.
		 */
		public String getLdapUrl() {
			return ldapUrl;
		}

		/**
		 * Getter for {@link #ldapType}.
		 *
		 * @return {@link #ldapType}.
		 */
		public String getLdapType() {
			return ldapType;
		}
		/**
		
		/**
		 * @return the locale
		 */
		public String getLocale() {
			return locale;
		}

		/**
		 * Getter for {@link #logicalLockIncludes}.
		 *
		 * @return {@link #logicalLockIncludes}.
		 */
		public String getLogicalLockIncludes() {
			return logicalLockIncludes;
		}

		/**
		 * Returns a string representation of object that are included for locking. The string is in the format of
		 * "LIBRARY_NAME|OBJECT_ID|OBJECT_TYPE|DATA_AREA" seperated by commas. The DATA_AREA is optional, if it is left off
		 * it will be ignored, all other attributes adhere to the RPG object naming convention. e.g.
		 * TSTLIB1|TSTFILE1|*FILE|da1,TSTLIB1|TSTFILE2|*FILE,TSTLIB1|TSTFILE*|*FILE
		 *
		 * @return - String.
		 */
		public String getLogicalLockOjectids() {
			return logicalLockIncludes;
		}

		/**
		 * Getter for {@link #logonRequired}.
		 *
		 * @return {@link #logonRequired}.
		 */
		public String getLogonRequired() {
			return logonRequired;
		}

		/**
		 * Getter for {@link #lowerAlpha}.
		 *
		 * @return {@link #lowerAlpha}.
		 */
		public String getLowerAlpha() {
			return lowerAlpha;
		}

		/**
		 * Getter for {@link #messageModel}.
		 *
		 * @return {@link #messageModel}.
		 */
		public String getMessageModel() {
			return messageModel;
		}

		/**
		 * Getter for {@link #monitorOn}.
		 *
		 * @return {@link #monitorOn}.
		 */
		public String getMonitorOn() {
			return monitorOn;
		}

		/**
		 * Getter for {@link #onLineQueryTimeout}.
		 *
		 * @return {@link #onLineQueryTimeout}.
		 */
		public int getOnlineQueryTimeout() {
			return onLineQueryTimeout;
		}

		/**
		 * Getter for {@link #onlineRowNumbersSequence}.
		 *
		 * @return {@link #onlineRowNumbersSequence}.
		 */
		public int[] getOnlineRowNumbersSequence() {
			int[] copy = onlineRowNumbersSequence;
			return copy;
		}

		/**
		 * Getter for {@link #onlineTimeout}.
		 *
		 * @return {@link #onlineTimeout}.
		 */
		public long getOnlineTimeout() {
			return onlineTimeout;
		}

		/**
		 * Getter for {@link #oracleNlsComp}.
		 *
		 * @return {@link #oracleNlsComp}.
		 */
		public String getOracleNlsComp() {
			return oracleNlsComp;
		}

		/**
		 * Getter for {@link #oracleNlsSort}.
		 *
		 * @return {@link #oracleNlsSort}.
		 */
		public String getOracleNlsSort() {
			return oracleNlsSort;
		}

		/**
		 * Getter for {@link #outputsAsFields}.
		 *
		 * @return {@link #outputsAsFields}.
		 */
		public String getOutputsAsFields() {
			return outputsAsFields;
		}

		/**
		 * Getter for {@link #passwordEncrypt}.
		 *
		 * @return {@link #passwordEncrypt}.
		 */
		public String getpasswordEncrypt() {
			return passwordEncrypt;
		}

		/**
		 * Getter for {@link #passwordEncrypt}.
		 *
		 * @return {@link #passwordEncrypt}.
		 */
		public String getPasswordEncrypt() {
			return passwordEncrypt;
		}

		/**
		 * Getter for {@link #passwordJDBC}.
		 *
		 * @return {@link #passwordJDBC}.
		 */
		public String getPasswordJDBC() {
			return passwordJDBC;
		}

		/**
		 * Getter for {@link #pdfOutput}.
		 *
		 * @return {@link #pdfOutput}.
		 */
		public String getPdfOutput() {
			return pdfOutput;
		}

		/**
		 * Getter for {@link #pdfTemplate}.
		 *
		 * @return {@link #pdfTemplate}.
		 */
		public String getPdfTemplate() {
			return pdfTemplate;
		}

		/**
		 * Getter for {@link #pfKeyLangConditioned}.
		 *
		 * @return {@link #pfKeyLangConditioned}.
		 */
		public String getPFKeyLangConditioned() {
			return pfKeyLangConditioned;
		}

		/**
		 * Getter for {@link #preformatted}.
		 *
		 * @return {@link #preformatted}.
		 */
		public String getPreformatted() {
			return preformatted;
		}

		/**
		 * Getter for {@link #fullyQualifiedAppVarsClassName}.
		 *
		 * @return {@link #fullyQualifiedAppVarsClassName}.
		 */
		public String getProgramAppVarClass() {
			return fullyQualifiedAppVarsClassName;
		}

		/**
		 * Getter for {@link #programPackage}.
		 *
		 * @return {@link #programPackage}.
		 */
		public String getProgramPackage() {
			return programPackage;
		}

		/**
		 * Getter for {@link #programs}.
		 *
		 * @return {@link #programs}.
		 */
		public String[][] getPrograms() {
			String[][] copy = programs;
			return copy;
		}

		/**
		 * Getter for {@link #providerUrl}.
		 *
		 * @return {@link #providerUrl}.
		 */
		public String getProviderUrl() {
			return providerUrl;
		}

		public String[] getQcmdexcFiles() {
			return qcmdexcFiles;
		}

		/**
		 * Getter for {@link #queueManagerName}.
		 *
		 * @return {@link #queueManagerName}.
		 */
		public String getQueueManagerName() {
			return queueManagerName;
		}

		/**
		 * Getter for {@link #queueName}.
		 *
		 * @return {@link #queueName}.
		 */
		public String getQueueName() {
			return queueName;
		}

		/**
		 * Getter for {@link #resultSetType}.
		 *
		 * @return {@link #resultSetType}.
		 */
		public int getResultSetType() {
			return resultSetType;
		}

		/**
		 * Converts the passed String into an array of ints. Thus, "1, 2, 3, 4" returns [] {1, 2, 3, 4}.
		 *
		 * @param escalationString the passed String.
		 * @return the ints.
		 */
		protected int[] getRowNumberSequence(String escalationString) {
			String[] strArray = escalationString.split(",");
			int[] result = new int[strArray.length];
			for (int i = 0; i < strArray.length; i++) {
				int k = 1;
				try {
					k = Integer.valueOf(strArray[i].trim());
				} catch (Exception e) {
					doNothing();
				}
				result[i] = k;
			}
			return result;
		}

		/**
		 * Getter for {@link #scriptsDir}.
		 *
		 * @return {@link #scriptsDir}.
		 */
		public String getScriptsDir() {
			return scriptsDir;
		}

		/**
		 * Getter for {@link #server}.
		 *
		 * @return {@link #server}.
		 */
		public String getServer() {
			return server;
		}

		/**
		 * Getter for {@link #showVNOnError}.
		 *
		 * @return {@link #showVNOnError}.
		 */
		public String getShowVNOnError() {
			return showVNOnError;
		}

		/**
		 * Getter for {@link #showScreenID}.
		 *
		 * @return {@link #showScreenID}.
		 */
		public String getShowScreenID() {
			return showScreenID;
		}

		/**
		 * Getter for {@link #singleModelJSP}.
		 *
		 * @return {@link #singleModelJSP}.
		 */
		public List<String> getSingleModelJSP() {
			return singleModelJSP;
		}

		/**
		 * Getter for {@link #smaOpConEventDir}.
		 *
		 * @return {@link #smaOpConEventDir}.
		 */
		public String getSmaOpConEventDir() {
			return smaOpConEventDir;
		}

		/**
		 * Getter for {@link #smtpServer}.
		 *
		 * @return {@link #smtpServer}.
		 */
		public String getSMTPServer() {
			return smtpServer;
		}

		/**
		 * Getter for {@link #sqlDiagLevel}.
		 *
		 * @return {@link #sqlDiagLevel}.
		 */
		public int getSqlDiagLevel() {
			return sqlDiagLevel;
		}

		/**
		 * Getter for {@link #sqlEDiagLevel}.
		 *
		 * @return {@link #sqlEDiagLevel}.
		 */
		public int getSqlEDiagLevel() {
			return sqlEDiagLevel;
		}

		/**
		 * Getter for {@link #sqlSummaryOnly}.
		 *
		 * @return {@link #sqlSummaryOnly}.
		 */
		public String getSqlSummaryOnly() {
			return sqlSummaryOnly;
		}

		/**
		 * Getter for {@link #sqlTiersDeep}.
		 *
		 * @return {@link #sqlTiersDeep}.
		 */
		public int getSqlTiersDeep() {
			return sqlTiersDeep;
		}

		/**
		 * Getter for {@link #startupPage}.
		 *
		 * @return {@link #startupPage}.
		 */
		public String getStartupPage() {
			return startupPage;
		}

		/**
		 * Getter for {@link #subPath}.
		 *
		 * @return {@link #subPath}.
		 */
		public String getSubPath() {
			return subPath;
		}

		/**
		 * Getter for {@link #suppSchema}.
		 *
		 * @return {@link #suppSchema}.
		 */
		public String getSuppSchema() {
			return suppSchema;
		}

		/**
		 * Getter for {@link #systemAdminName}.
		 *
		 * @return {@link #systemAdminName}.
		 */
		public String getSystemAdminName() {
			return systemAdminName;
		}

		/**
		 * Getter for {@link #systemAdminPwd}.
		 *
		 * @return {@link #systemAdminPwd}.
		 */
		public String getSystemAdminPwd() {
			return systemAdminPwd;
		}

		/**
		 * Getter for {@link #systemFont}.
		 *
		 * @return {@link #systemFont}.
		 */
		public String getSystemFont() {
			return systemFont;
		}

		/**
		 * Getter for {@link #systemFontSize}.
		 *
		 * @return {@link #systemFontSize}.
		 */
		public String getSystemFontSize() {
			return systemFontSize;
		}

		/**
		 * Getter for {@link #systemName}.
		 *
		 * @return {@link #systemName}.
		 */
		public String getSystemName() {
			return systemName;
		}

		/**
		 * Getter for {@link #tableBuffer}.
		 *
		 * @return {@link #tableBuffer}.
		 */
		public String getTableBuffer() {
			return tableBuffer;
		}

		/**
		 * Getter for {@link #thousandSeparator}.
		 *
		 * @return {@link #thousandSeparator}.
		 */
		public String getThousandSeparator() {
			return thousandSeparator;
		}

		/**
		 * Getter for {@link #traceSource}.
		 *
		 * @return {@link #traceSource}.
		 */
		public String getTraceSource() {
			return traceSource;
		}

		/**
		 * Get the {@link #transactionManagerHelperClass} instantiated as a Class.
		 *
		 * @return instantiated {@link #transactionManagerHelperClass}.
		 */
		public TMHelper getTransactionManagerHelperClass() {
			TMHelper tmh = null;

			Class<?> c = null;
			try {
				c = Class.forName(transactionManagerHelperClass);
				tmh = (TMHelper) c.newInstance();
			} catch (Exception e) {
				if (transactionManagerHelperClass == null) {
					throw new RuntimeException("AppConfig transactionManagerHelperClass (loaded in AppConfig) is null.");
				} else {
					throw new RuntimeException("Error instantiating '" + transactionManagerHelperClass + "' " + e, e);
				}
			}

			return tmh;
		}

		/**
		 * Getter for {@link #transactionScope}.
		 *
		 * @return {@link #transactionScope}.
		 */
		public String getTransactionScope() {
			return transactionScope;
		}

		/**
		 * Getter for {@link #transactionTimeout}.
		 *
		 * @return {@link #transactionTimeout}.
		 */
		public int getTransactionTimeout() {
			return transactionTimeout;
		}

		/**
		 * Getter for {@link #userHeartbeat}.
		 *
		 * @return {@link #userHeartbeat}.
		 */
		public long getUserHeartbeat() {
			return userHeartbeat;
		}

		/**
		 * Getter for {@link #useridJDBC}.
		 *
		 * @return {@link #useridJDBC}.
		 */
		public String getUseridJDBC() {
			return useridJDBC;
		}

		/**
		 * Getter for {@link #userTimeout}.
		 *
		 * @return {@link #userTimeout}.
		 */
		public long getUserTimeout() {
			return userTimeout;
		}

		/**
		 * Getter for {@link #variableRenamingSuffix}.
		 *
		 * @return {@link #variableRenamingSuffix}.
		 */
		public String[] getVariableRenamingSuffix() {
			String[] copy = variableRenamingSuffix;
			return copy;
		}

		/**
		 * Getter for {@link #version}.
		 *
		 * @return {@link #version}.
		 */
		public String getVersion() {
			return version;
		}
		
		/**
		 * Getter for oldJspTemplate.
		 *
		 * @return oldJspTemplate.
		 */
		public boolean getOldJspTemplate() {
			return oldJspTemplate;
		}

		/**
		 * Getter for {@link #FSU Version}.
		 *
		 * @return {@link #FSU version}.
		 */
		public String getFsuVersion() {
			return fsuVersion;
		}

		/**
		 * Getter for {@link #VARPATH}.
		 *
		 * @return {@link #VARPATH}.
		 */
		public static String getVarpath() {
			return VARPATH;
		}

		/**
		 * Getter for {@link #xmlACon}.
		 *
		 * @return {@link #xmlACon}.
		 */
		public String getXmlACon() {
			return xmlACon;
		}

		/**
		 * Getter for {@link #xmlBackup}.
		 *
		 * @return {@link #xmlBackup}.
		 */
		public String getXmlBackup() {
			return xmlBackup;
		}

		/**
		 * Getter for {@link #xmlSource}.
		 *
		 * @return {@link #xmlSource}.
		 */
		public String getXmlSource() {
			return xmlSource;
		}

		/**
		 * Getter for {@link #alpha2Numer}.
		 *
		 * @return {@link #alpha2Numer}.
		 */
		public boolean isAlpha2Numer() {
			return alpha2Numer;
		}

		/**
		 * Getter for {@link #batchRemoveTempFiles}.
		 *
		 * @return {@link #batchRemoveTempFiles}.
		 */
		public boolean isBatchRemoveTempFiles() {
			return batchRemoveTempFiles;
		}

		/**
		 * Getter for {@link #dbcsForDB}.
		 *
		 * @return {@link #dbcsForDB}.
		 */
		public boolean isDBCSForDB() {
			return dbcsForDB;
		}

		/**
		 * Getter for {@link #dbcsForDiag}.
		 *
		 * @return {@link #dbcsForDiag}.
		 */
		public boolean isDBCSForDiag() {
			return dbcsForDiag;
		}

		/**
		 * Getter for {@link #dbcsForFiles}.
		 *
		 * @return {@link #dbcsForFiles}.
		 */
		public boolean isDBCSForFiles() {
			return dbcsForFiles;
		}

		/**
		 * Getter for {@link #DBCSForScreens}.
		 *
		 * @return {@link #DBCSForScreens}.
		 */
		public boolean isDBCSForScreens() {
			return DBCSForScreens;
		}

		/**
		 * Getter for {@link #duplicatesOldestFirst}.
		 *
		 * @return {@link #duplicatesOldestFirst}.
		 */
		public boolean isDuplicatesOldestFirst() {
			return duplicatesOldestFirst;
		}

		/**
		 * Getter of {@link #initFlsd}
		 *
		 * @return true/false
		 */
		public boolean isInitFlsd() {
			return initFlsd;
		}

		/**
		 * Getter of memoryCopy, see {@link #memoryCopy} for details.
		 *
		 * @return value of memoeryCopy.
		 */
		public boolean isMemoryCopy() {
			return memoryCopy;
		}

		/**
		 * Returns true if {@link #messageModel} = {@link #POPUP}.
		 *
		 * @return is the current message model popup.
		 */
		public boolean isPopupMessageModel() {
			return messageModel.equals(POPUP);
		}

		/**
		 * Getter for {@link #isRocBasedApplication}.
		 *
		 * @return {@link #isRocBasedApplication}.
		 */
		public boolean isRocBasedApplication() {
			return isRocBasedApplication;
		}

		/**
		 * Getter for {@link #setIndicatorByPFKeyNo}.
		 *
		 * @return {@link #setIndicatorByPFKeyNo}.
		 */
		public boolean isSetIndicatorByPFKeyNo() {
			return setIndicatorByPFKeyNo;
		}

		/**
		 * Checks {@link #singleModelJSP} to see if the passed screen name should be presented from within the
		 * {@link #singleModelJSP single model JSP} or as a stand-alone screen containing all its own information.
		 *
		 * @param screen screen to be checked.
		 * @return true if the screen matches the include and exclude patterns.
		 */
		public boolean isSingleModelJSP(String screen) {
			String entry = null;
			boolean wildcard = false;
			boolean exclude = false;

			screen = QPUtilities.removeLeading(screen, "/");
			screen = QPUtilities.removeTrailing(screen, ".jsp");
			for (int i = 0; i < singleModelJSP.size(); i++) {
				entry = (String) singleModelJSP.get(i);
				wildcard = entry.endsWith(Str.AST);
				exclude = entry.startsWith(Str.BANG);
				if (exclude) {
					entry = entry.substring(1);
				}
				if (wildcard) {
					entry = QPUtilities.removeTrailing(entry, Str.AST);
				}
				if (!wildcard && screen.equals(entry)) {
					return !exclude;
				}
				if (wildcard && screen.startsWith(entry)) {
					return !exclude;
				}
			}
			return false;
		}

		/**
		 * Getter for {@link #tableBufferFlag}.
		 *
		 * @return {@link #tableBufferFlag}.
		 */
		public boolean isTableBufferFlag() {
			return tableBufferFlag;
		}

		/**
		 * Getter for {@link #truncateSQLParms}.
		 *
		 * @return {@link #truncateSQLParms}.
		 */
		public boolean isTruncateSQLParms() {
			return truncateSQLParms;
		}

		/**
		 * Getter for {@link #useRowNumbers}.
		 *
		 * @return {@link #useRowNumbers}.
		 */
		public boolean isUseRowNumbers() {
			return useRowNumbers;
		}

		/**
		 * Getter for {@link #useSQLTiers}.
		 *
		 * @return {@link #useSQLTiers}.
		 */
		public boolean isUseSQLTiers() {
			return useSQLTiers;
		}

		/**
		 * Getter for {@link #useStackTraceModeBatch}. An optional flag. No use is made of this variable in the Base
		 * Framework. true - conventional main stream development. false - various experimental optimisations.
		 *
		 * @return {@link #useStackTraceModeBatch}.
		 */
		public boolean isUseStackTraceModeBatch() {
			return useStackTraceModeBatch;
		}

		/**
		 * Getter for {@link #useStackTraceModeOnline}. An optional flag. No use is made of this variable in the Base
		 * Framework. true - conventional main stream development. false - various experimental optimisations.
		 *
		 * @return {@link #useStackTraceModeOnline}.
		 */
		public boolean isUseStackTraceModeOnline() {
			return useStackTraceModeOnline;
		}

		/**
		 * Checks for a required integer parameter. The passed XML node is examined for a value. Then, that vlaue is parsed
		 * as an integer. If not found or a number format exception results, the required parameter is counted as not being
		 * supplied.
		 *
		 * @param fn file name, used only for error and diagnostic message.
		 * @param nl XML node.
		 * @param key tag that should be present and contain the value.
		 * @return the found valid integer.
		 */
		public int mandatoryInt(String fn, QPScreenNL nl, String key) {
			String result = mandatory(fn, nl, key);
			int resint = 0;
			try {
				resint = Integer.parseInt(result.trim());
			} catch (NumberFormatException ne) {
				throw new RuntimeException(FIL + fn + CONT_NODE + key + BUT_VAL + result + ") is not a valid integer.");
			}
			return resint;
		}

		/**
		 * Setter for {@link #appDebugLevel}.
		 *
		 * @param pAppDebugLevel the new value for {@link #appDebugLevel}.
		 */
		public void setAppDebugLevel(int pAppDebugLevel) {
			this.appDebugLevel = pAppDebugLevel;
		}

	    public void setApplicationUse0(String applicationUse0) {
	        ApplicationUse0 = applicationUse0;
	    }

	    public void setApplicationUse1(String applicationUse1) {
	        ApplicationUse1 = applicationUse1;
	    }

	    public void setApplicationUse10(String applicationUse10) {
	        ApplicationUse10 = applicationUse10;
	    }

	    public void setApplicationUse11(String applicationUse11) {
	        ApplicationUse11 = applicationUse11;
	    }

	    public void setApplicationUse12(String applicationUse12) {
	        ApplicationUse12 = applicationUse12;
	    }

	    public void setApplicationUse2(String applicationUse2) {
	        ApplicationUse2 = applicationUse2;
	    }

	    public void setApplicationUse3(String applicationUse3) {
	        ApplicationUse3 = applicationUse3;
	    }

	    public void setApplicationUse4(String applicationUse4) {
	        ApplicationUse4 = applicationUse4;
	    }

	    public void setApplicationUse5(String applicationUse5) {
	        ApplicationUse5 = applicationUse5;
	    }

	    public void setApplicationUse6(String applicationUse6) {
	        ApplicationUse6 = applicationUse6;
	    }

	    public void setApplicationUse7(String applicationUse7) {
	        ApplicationUse7 = applicationUse7;
	    }

	    public void setApplicationUse8(String applicationUse8) {
	        ApplicationUse8 = applicationUse8;
	    }

	    public void setApplicationUse9(String applicationUse9) {
	        ApplicationUse9 = applicationUse9;
	    }

	    /**
		 * Sets the appName.
		 *
		 * @param pAppName the new value for {@link #appName}.
		 */
		public void setAppName(String pAppName) {
			this.appName = pAppName;
		}

		/**
		 * Setter for {@link #appSchema}.
		 *
		 * @param pDbSchema the new value for {@link #appSchema}.
		 */
		public void setAppSchema(String pDbSchema) {
			this.appSchema = pDbSchema;
		}

		/**
		 * Setter for {@link #appSchemaNames}.
		 *
		 * @param pDbSchema the new value for {@link #appSchemaNames}.
		 */
		public void setAppSchemaNames(String appSchemaNames) {
			this.appSchemaNames = appSchemaNames;
		}

		/**
		 * Setter for {@link #baseScreen}.
		 *
		 * @param pBaseScreen the new value for {@link #baseScreen}.
		 */
		public void setBaseScreen(String pBaseScreen) {
			this.baseScreen = pBaseScreen;
		}

		public void setBatchTimeout(long batchTimeout) {
	        this.batchTimeout = batchTimeout;
	    }
		public void setCurrentLanguage(String currentLanguage) {
	        this.currentLanguage = currentLanguage;
	    }
		/**
		 * @param databaseType the databaseType to set
		 */
		public void setDatabaseType(String databaseType) {
			this.databaseType = databaseType;
		}

		/**
		 * @param dataDriverJDBC the dataDriverJDBC to set
		 */
		public void setDataDriverJDBC(String dataDriverJDBC) {
			this.dataDriverJDBC = dataDriverJDBC;
		}

		public void setDataSourceFactoryJDBC(String dataSourceFactoryJDBC) {
			this.dataSourceFactoryJDBC = dataSourceFactoryJDBC;
		}

		/**
		 * Setter for {@link #dataSourceJDBC}.
		 *
		 * @param pDataSourceJDBC the new value for {@link #dataSourceJDBC}.
		 */
		public void setDataSourceJDBC(String pDataSourceJDBC) {
			this.dataSourceJDBC = pDataSourceJDBC;
		}

		/**
		 * Setter for {@link #dataSourceJNDI}.
		 *
		 * @param pDataSourceJNDI the new value for {@link #dataSourceJNDI}.
		 */
		public void setDataSourceJNDI(String pDataSourceJNDI) {
			this.dataSourceJNDI = pDataSourceJNDI;
		}

	    /**
		 * Sets the debugLevel.
		 *
		 * @param pDebugLevel the new value for {@link #debugLevel}.
		 */
		public void setDebugLevel(int pDebugLevel) {
			this.debugLevel = pDebugLevel;
		}

		/**
		 * sets deployed environment;
		 *
		 * @param deployedEnvironment
		 */
		public void setDeployedEnvironment(String deployedEnvironment) {
			this.deployedEnvironment = deployedEnvironment;
		}

		public void setDefaultFold(String defaultFold) {
	        this.defaultFold = defaultFold;
	    }

		public void setDefaultLanguage(String defaultLanguage) {
	        this.defaultLanguage = defaultLanguage;
	    }

		public void setServer(String server) {
			this.server = server;
		}

		/**
		 * @param enable the dMSEnable to set
		 */
		public void setDMSEnable(String enable) {
			DMSEnable = enable;
		}

		public void setDMSServletPath(String dmsServletPath) {
			AppConfig.dmsServletPath = dmsServletPath;
		}

		/**
		 * @param documentServiceTaxonomy the documentServiceTaxonomy to set
		 */
		public void setDocumentServiceTaxonomy(String documentServiceTaxonomy) {
			this.documentServiceTaxonomy = documentServiceTaxonomy;
		}

		/**
		 * @param documentServiceURL the documentServiceURL to set
		 */
		public void setDocumentServiceURL(String documentServiceURL) {
			this.documentServiceURL = documentServiceURL;
		}

	    public void setDontReport(String dontReport) {
	        this.dontReport = dontReport;
	    }

	    public void setDriverClassNameJDBC(String driverClassNameJDBC) {
	        this.driverClassNameJDBC = driverClassNameJDBC;
	    }

		public void setCacheEnabled(boolean cacheEnabled) {
	        this.cacheEnabled = cacheEnabled;
	    }

		/**
		 * Setter for {@link #fwSchema}.
		 *
		 * @param pFwSchema the new value for {@link #fwSchema}.
		 */
		public void setFwSchema(String pFwSchema) {
			this.fwSchema = pFwSchema;
		}

		/**
		 * Setter for {@link #ldapBase}.
		 *
		 * @param pLdapBase the new value for {@link #ldapBase}.
		 */
		public void setLdapBase(String pLdapBase) {
			this.ldapBase = pLdapBase;
		}

		/**
		 * Setter for {@link #ldapUrl}.
		 *
		 * @param pLdapUrl the new value for {@link #ldapUrl}.
		 */
		public void setLdapUrl(String pLdapUrl) {
			this.ldapUrl = pLdapUrl;
		}
		
		/**
		 * Setter for {@link #ldapType}.
		 *
		 * @param pLdapType the new value for {@link #ldapType}.
		 */
		public void setLdapType(String pLdapType) {
			this.ldapType = pLdapType;
		}
		/**

		/**
		 * @param locale the locale to set
		 */
		public void setLocale(String locale) {
			this.locale = locale;
		}

		/**
		 * Setter for {@link #messageModel}.
		 *
		 * @param pMessageModel the new value for {@link #messageModel}.
		 */
		public void setMessageModel(String pMessageModel) {
			this.messageModel = pMessageModel;
		}

	    public void setMonitorOn(String monitorOn) {
	        this.monitorOn = monitorOn;
	    }

	    public void setOnlineTimeout(long onlineTimeout) {
	        this.onlineTimeout = onlineTimeout;
	    }

	    public void setOutputsAsFields(String outputsAsFields) {
	        this.outputsAsFields = outputsAsFields;
	    }

	    /**
		 * Sets the passwordJDBC.
		 *
		 * @param pPasswordJDBC the new value for {@link #passwordJDBC}.
		 */
		public void setPasswordJDBC(String pPasswordJDBC) {
			this.passwordJDBC = pPasswordJDBC;
		}

		/**
		 * Setter for {@link #pdfOutput}.
		 *
		 * @param pPdfOutput the new value for {@link #pdfOutput}.
		 */
		public void setPdfOutput(String pPdfOutput) {
			this.pdfOutput = pPdfOutput;
		}


		/**
		 * Setter for {@link #pdfTemplate}.
		 *
		 * @param pPdfTemplate the new value for {@link #pdfTemplate}.
		 */
		public void setPdfTemplate(String pPdfTemplate) {
			this.pdfTemplate = pPdfTemplate;
		}

		public void setQcmdexcFiles(String[] qcmdexcFiles) {
			this.qcmdexcFiles = qcmdexcFiles;
		}

		/**
		 * Setter for {@link #resultSetType}.
		 *
		 * @param pResultSetType the new value for {@link #resultSetType}.
		 */
		public void setResultSetType(int pResultSetType) {
			this.resultSetType = pResultSetType;
		}

		/**
		 * Setter for {@link #sqlDiagLevel}.
		 *
		 * @param pSqlDiagLevel the new value for {@link #sqlDiagLevel}.
		 */
		public void setSqlDiagLevel(int pSqlDiagLevel) {
			this.sqlDiagLevel = pSqlDiagLevel;
		}

		/**
		 * Setter for {@link #sqlEDiagLevel}.
		 *
		 * @param pSqlEDiagLevel the new value for {@link #sqlEDiagLevel}.
		 */
		public void setSqlEDiagLevel(int pSqlEDiagLevel) {
			this.sqlEDiagLevel = pSqlEDiagLevel;
		}

		/**
		 * Setter for {@link #startupPage}.
		 *
		 * @param pStartupPage the new value for {@link #startupPage}.
		 */
		public void setStartupPage(String pStartupPage) {
			this.startupPage = pStartupPage;
		}

		/**
		 * Setter for {@link #subPath}.
		 *
		 * @param pSubPath the new value for {@link #subPath}.
		 */
		public void setSubPath(String pSubPath) {
			this.subPath = pSubPath.substring(0, pSubPath.lastIndexOf('.'));
		}

		/**
		 * Setter for {@link #suppSchema}.
		 *
		 * @param pSuppSchema the new value for {@link #suppSchema}.
		 */
		public void setSuppSchema(String pSuppSchema) {
			this.suppSchema = pSuppSchema;
		}

		/**
		 * Setter for {@link #systemAdminName}.
		 *
		 * @param pSystemAdminName the new value for {@link #systemAdminName}.
		 */
		public void setSystemAdminName(String pSystemAdminName) {
			this.systemAdminName = pSystemAdminName;
		}

		/**
		 * Setter for {@link #systemAdminPwd}.
		 *
		 * @param pSystemAdminPwd the new value for {@link #systemAdminPwd}.
		 */
		public void setSystemAdminPwd(String pSystemAdminPwd) {
			this.systemAdminPwd = pSystemAdminPwd;
		}

		/**
		 * Setter for {@link #traceSource}.
		 *
		 * @param pTraceSource the new value for {@link #traceSource}.
		 */
		public void setTraceSource(String pTraceSource) {
			this.traceSource = pTraceSource;
		}

		/**
		 * Setter for {@link #useridJDBC}.
		 *
		 * @param pUseridJDBC the new value for {@link #useridJDBC}.
		 */
		public void setUseridJDBC(String pUseridJDBC) {
			this.useridJDBC = pUseridJDBC;
		}

		/**
		 * Complex setter for {@link #variableRenamingSuffix}. Slightly more complex than an ordinary setter.
		 * <p>
		 * <ol>
		 * <li>If passed null, sets the instance variable to null.
		 * <li>If passed an empty String or a String containing only blanks, sets the instance variable to null.
		 * <li>Otherwise, sets the instance variable to the passed Sring split at a semi-colon.
		 * </ol>
		 * Note that the instance variable is a String array.
		 *
		 * @param pVariableRenamingSuffix the new value for {@link #variableRenamingSuffix}.
		 */
		public void setVariableRenamingSuffix(String pVariableRenamingSuffix) {
			if (pVariableRenamingSuffix == null) {
				this.variableRenamingSuffix = null;
			} else {
				String s = pVariableRenamingSuffix.trim();
				if (pVariableRenamingSuffix.length() == 0) {
					this.variableRenamingSuffix = null;
				} else {
					this.variableRenamingSuffix = s.split(";");
				}
			}
		}

		/**
		 * Setter for {@link #xmlACon}.
		 *
		 * @param pXmlACon the new value for {@link #xmlACon}.
		 */
		public void setXmlACon(String pXmlACon) {
			this.xmlACon = pXmlACon;
		}

		/**
		 * Setter for {@link #xmlBackup}.
		 *
		 * @param pXmlBackup the new value for {@link #xmlBackup}.
		 */
		public void setXmlBackup(String pXmlBackup) {
			this.xmlBackup = pXmlBackup;
		}
		/**
		 * Setter for {@link #xmlSource}.
		 *
		 * @param pXmlSource the new value for {@link #xmlSource}.
		 */
		public void setXmlSource(String pXmlSource) {
			this.xmlSource = pXmlSource;
		}
		/**
		 * Returns an XML tag based on the passed values. If passed
		 *
		 * <pre>
		 * &quot;abc&quot;, &quot;hello&quot;
		 * </pre>
		 *
		 * would return
		 *
		 * <pre>
		 * &lt;abc&gt;hello&lt;/abc&gt;
		 * </pre>
		 *
		 * @param tag tag
		 * @param value contents
		 * @return as per method description.
		 */
		protected String tag(String tag, String value) {
			String what = tag.trim();

			if (TEST_MODE) {
				writeLog.put(what, "Written");
			}
			String v = value;
			if (v != null && v.length() == 0) {
				v = " ";
			}
			return "    <" + what + Str.XML_C + v + "</" + what + Str.XML_C;
		}
		/**
		 * Conversion to a String should be used for diagnostic purposes only. The work is delegated to
		 * {@link QPUtilities#dumpClass(Object, Object...)}. This lists all variables and their values as one long String.
		 *
		 * @return user readable dump of this Class.
		 */
		public String toString() {
			return QPUtilities.dumpClass(this);
		}
		/**
		 * Write out a tag.
		 *
		 * @param fw where to.
		 * @param value what.
		 * @throws IOException on error.
		 */
		protected void writeFw(BufferedWriter fw, String value) throws IOException {
			fw.write(value);
			fw.newLine();
		}
		/**
		 * Write a specific type of tag.
		 *
		 * @param fw writer to use
		 * @param var variable to write.
		 * @param tag tag.
		 * @throws IOException on write error.
		 */
		protected void writeVar(BufferedWriter fw, boolean var, String tag) throws IOException {
			writeFw(fw, tag(tag, String.valueOf(var)));
		}

		/**
		 * Write a specific type of tag.
		 *
		 * @param fw writer to use
		 * @param var variable to write.
		 * @param tag tag.
		 * @throws IOException on write error.
		 */
		private void writeVar(BufferedWriter fw, int var, String tag) throws IOException {
			writeFw(fw, tag(tag, String.valueOf(var)));
		}

		/**
		 * Write a specific type of tag.
		 *
		 * @param fw writer to use
		 * @param var variable to write.
		 * @param tag tag.
		 * @throws IOException on write error.
		 */
		protected void writeVar(BufferedWriter fw, int[] var, String tag) throws IOException {
			if (var == null || var.length == 0) {
				writeFw(fw, tag(tag, ""));
			} else {
				String value = String.valueOf(var[0]);
				for (int i = 1; i < var.length; i++) {
					value = value + Str.CBK + String.valueOf(var[i]);
				}
				writeFw(fw, tag(tag, value));
			}
		}

		/**
		 * Write a specific type of tag.
		 *
		 * @param fw writer to use
		 * @param var variable to write.
		 * @param tag tag.
		 * @throws IOException on write error.
		 */
		protected void writeVar(BufferedWriter fw, long var, String tag) throws IOException {
			writeFw(fw, tag(tag, String.valueOf(var)));
		}

		/**
		 * Write a specific type of tag.
		 *
		 * @param fw writer to use
		 * @param var variable to write.
		 * @param tag tag.
		 * @throws IOException on write error.
		 */
		protected void writeVar(BufferedWriter fw, String var, String tag) throws IOException {
			writeFw(fw, tag(tag, var));
		}

		/**
		 * Write a specific type of tag.
		 *
		 * @param fw writer to use
		 * @param var variable to write.
		 * @param tag tag.
		 * @throws IOException on write error.
		 */
		protected void writeVar(BufferedWriter fw, String[] var, String tag) throws IOException {
			if (var == null || var.length == 0) {
				writeFw(fw, tag(tag, ""));
			} else {
				String value = String.valueOf(var[0]);
				for (int i = 1; i < var.length; i++) {
					value = value + Str.CBK + String.valueOf(var[i]);
				}
				writeFw(fw, tag(tag, value));
			}
		}

		/**
		 * Calls {@link #writeYourself(String)} with a parm of {@value #DEF_XML}.
		 *
		 * @return zero
		 * @throws IOException on file error.
		 */
		public int writeYourself() throws IOException {
			return writeYourself(DEF_XML);
		}

		/**
		 * This is a diagnostic and/or self-editing help. Any tags added to this Class must be added here otherwise results
		 * will be inconsistent.
		 * <p>
		 * The file name for output will be as follows:
		 * <ol>
		 * <li>The current XML path is examined. this is in System Property "Quipoz." + appName + ".XMLPath". If a file name
		 * ending in ".xml" is present on the end of that, it will be extracted, hence called the Current file name.
		 * <li>The passed file name is also considered, hence called the Passed file name.
		 * </ol>
		 * An example will serve best here:
		 * <table border=1>
		 * <tr>
		 * <th align=left>Current</th>
		 * <th align=left>Passed</th>
		 * <th align=left>Result</th>
		 * </tr>
		 * <tr>
		 * <td>TestCfg.xml</td>
		 * <td>MyAppCfg.xml</td>
		 * <td>TestCfg.xml</td>
		 * </tr>
		 * <tr>
		 * <td>null/empty</td>
		 * <td>MyAppCfg.xml</td>
		 * <td>MyAppCfg.xml</td>
		 * </tr>
		 * <tr>
		 * <td>TestCfg.xml</td>
		 * <td>null/empty</td>
		 * <td>TestCfg.xml</td>
		 * </tr>
		 * <tr>
		 * <td>null/empty</td>
		 * <td>null/empty</td>
		 * <td>QuipozCfg.xml</td>
		 * </tr>
		 * </table>
		 *
		 * @param outputFileName where to write the output.
		 * @return zero
		 * @throws IOException on file error.
		 */
		public int writeYourself(String outputFileName) throws IOException {
			String prop = "Quipoz." + appName + ".XMLPath";
			String path = System.getProperty(prop);

			if (path == null) {
				throw new RuntimeException("System property '" + prop + "' is not set for this server configuration.");
			}

			String current = "";
			String passed = outputFileName;

			if (passed != null && passed.trim().length() == 0) {
				passed = null;
			}

			if (!path.endsWith(DOT_XML) && !path.endsWith(FILE_SEPARATOR)) {
				path = path + FILE_SEPARATOR;
			}

			if (path.endsWith(DOT_XML)) {
				for (int i = path.length() - 1; i >= 0; i--) {
					char c = path.charAt(i);
					if (c == '/' || c == '\\' || c == ':') {
						break;
					}
					current = "" + c + current;
				}
			}

			path = QPUtilities.removeTrailing(path, current);

			current = current.trim();
			if (current.length() == 0) {
				current = null;
			}

			if (passed != null) {
				current = passed;
			} else if (current == null) {
				current = DEF_XML;
			}

			path = path + current;

			BufferedWriter fw = null;

			try {
				fw = new BufferedWriter(new FileWriter(path));
				writeFw(fw, "<?xml version=\"1.0\"?>");
				writeFw(fw, "<Root>");
				writeFw(fw, "\t<JSPSingleModel>");
				for (int j = 0; j < singleModelJSP.size(); j++) {
					String s = singleModelJSP.get(j);
					if (s.startsWith(Str.BANG)) {
						writeFw(fw, tag("Exclude ", s.substring(1)));
					} else {
						writeFw(fw, tag("Include ", s));
					}
				}
				writeFw(fw, "\t</JSPSingleModel>");

				writeVar(fw, AppVars.getInstance().ApplicationUse0, "ApplicationUse0 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse1, "ApplicationUse1 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse2, "ApplicationUse2 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse3, "ApplicationUse3 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse4, "ApplicationUse4 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse5, "ApplicationUse5 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse6, "ApplicationUse6 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse7, "ApplicationUse7 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse8, "ApplicationUse8 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse9, "ApplicationUse9 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse10, "ApplicationUse10 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse11, "ApplicationUse11 ");
				writeVar(fw, AppVars.getInstance().ApplicationUse12, "ApplicationUse12 ");
				writeVar(fw, getAlpha(), "Alpha ");
				writeVar(fw, alpha2Numer, "Alpha2Number ");
				writeVar(fw, getAppDebugLevel(), "AppDebugLevel ");
				writeVar(fw, getAppSchema(), "AppSchema ");
				writeVar(fw, getApplicationProperties(), "ApplicationProperties ");
				writeVar(fw, getApplicationSystemNumber(), "ApplicationSystemNumber ");
				writeVar(fw, getApplicationUserCode(), "ApplicationUserCode ");
				writeVar(fw, getAutoTab(), "Autotab ");
				writeVar(fw, getBaseScreen(), "JSPBaseScreen ");
				writeVar(fw, getBatchBaseDir(), "batchBaseDir ");
				writeVar(fw, getBatchOutputFileDir(), "batchOutputFileDir ");
				writeVar(fw, getBatchPrintFileDir(), "batchPrintFileDir ");
				writeVar(fw, getBatchTempFileDir(), "batchTempFileDir ");
				writeVar(fw, batchRemoveTempFiles, "batchRemoveTempFiles ");
				writeVar(fw, getBatchRowNumbersSequence(), "BatchRowNumbersSequence ");
				writeVar(fw, isDuplicatesOldestFirst(), "DuplicatesOldestFirst ");
				writeVar(fw, getBatchTimeout() / Num.MSECS_SEC, "BatchTimeout ");
				writeVar(fw, getBatchWaitingFileDir(), "batchWaitingFileDir ");
				writeVar(fw, getCharSet(), "CharSet ");
				writeVar(fw, getCollateTab(), "Collate ");

				writeVar(fw, getDataSourceJNDI(), "DataSourceJNDI ");
				writeVar(fw, getDataSourceContext(), "DataSourceContext ");
				writeVar(fw, getDataSourceURL(), "DataSourceURL ");
				writeVar(fw, getDataSourceUserName(), "DataSourceUserName ");
				writeVar(fw, getDataSourcePassword(), "DataSourcePassword ");
				
				writeVar(fw, getDataSourceJDBC(), "DataSourceJDBC ");
				writeVar(fw, getDataDriverJDBC(), "DataDriverJDBC ");
				writeVar(fw, getDataSourceFactoryJDBC(), "DataSourceFactoryJDBC ");

				writeVar(fw, getDatabaseType(), "DatabaseType ");
				writeVar(fw, getPagesPerFile(), "PagesPerFile ");
				writeVar(fw, getUseridJDBC(), "UseridJDBC ");
				writeVar(fw, getPasswordJDBC(), "PasswordJDBC ");

				writeVar(fw, getDateFormat(), "DateFormat ");
				writeVar(fw, getDateToNumber(), "DateToNumber ");
				
				writeVar(fw, getEbcdicCharset(), "EbcdicCharset ");
				writeVar(fw, String.valueOf(dbcsForDB), "DBCSForDB ");
				writeVar(fw, String.valueOf(dbcsForDiag), "DBCSForDiag ");
				writeVar(fw, String.valueOf(dbcsForFiles), "DBCSForFiles ");
				writeVar(fw, String.valueOf(DBCSForScreens), "DBCSForScreens ");
				writeVar(fw, getDBCSLanguage(), "DBCSLanguage ");
				writeVar(fw, String.valueOf(isMemoryCopy()), "MemoryCopy ");
				writeVar(fw, String.valueOf(isInitFlsd()), "InitFlsd ");
				writeVar(fw, String.valueOf(getResultSetType()), "ResultSetType ");
				writeVar(fw, getQcmdexcFiles(), "Qcmdexc ");
				
				writeVar(fw, getAlpha2NumberCharset(), "Alpha2NumberCharset ");

				writeVar(fw, getDBCSScreenLanguage(), "DBCSScreenLanguage ");
				writeVar(fw, getDebugLevel(), "DebugLevel ");
				writeVar(fw, getDecimalSeparator(), "DecimalSep ");
				writeVar(fw, getDefaultCharSetIdx(), "com.quipoz.framework.util.charset.comparer.defaultCharSetIdx ");
				writeVar(fw, getDefaultFold(), "DefaultFold ");
				writeVar(fw, getDeployedEnvironment(), "DeployedEnvironment ");
				String mode = FMODE;
				if (getDefaultPackedMode() == PackedDecimalData.CMODE) {
					mode = CMODE;
				} else if (defaultPackedMode == PackedDecimalData.OMODE) {
					mode = OMODE;
				}
				writeVar(fw, mode, "DefaultPackedMode ");
				mode = FMODE;
				if (defaultPositiveZonedMode == ZonedDecimalData.CMODE) {
					mode = CMODE;
				}
				writeVar(fw, mode, "DefaultPositiveZonedMode ");
				byte divmode = 0;
				for (int i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {
					divmode = (byte) i;
					if (BaseData.isDivisionMode(divmode)) {
						break;
					}
				}
				writeVar(fw, getDaemonFrequency(), "daemonFrequency ");
				writeVar(fw, getDefaultLanguage(), "DefaultLanguage ");
				writeVar(fw, AppVars.getDontReport(), "DontReport ");
				writeVar(fw, divmode, "DivisionMode ");
				writeVar(fw, getEnforceSize(), "EnforceSize ");
				writeVar(fw, getExecutionMode(), "ExecutionMode ");
				writeVar(fw, getFopOnLinePrintRoot(), "FOPOnLinePrintRoot ");
				writeVar(fw, getFopPrintRoot(), "FOPPrintRoot ");
				writeVar(fw, getFwSchema(), "FWSchema ");
				writeVar(fw, getHelpCodeScrnsColumn(), "scrnsColumnForHelpCode ");
				writeVar(fw, getHelpDir(), "helpDir ");
				writeVar(fw, getHostServerName(), "HostServerName ");
				writeVar(fw, getIdentityMapperClass(), "IdentityMapperClass ");
				writeVar(fw, getInitialContextFactory(), "InitialContextFactory ");
				writeVar(fw, isDebugTimeEnabled(), "DebugTimeEnabled ");
				writeVar(fw, isMoveNToCPad0() ? Str.SY : Str.SN, "MoveNToCPad0 ");
				writeVar(fw, getJmsConnectionFactory(), "jmsConnectionFactory ");
				writeVar(fw, getJmsModuleName(), "jmsModuleName ");
				writeVar(fw, getJmsServerName(), "jmsServerName ");
				writeVar(fw, getJmsTopicPreffix(), "jmsTopicPreffix ");
				writeVar(fw, System.getProperty(JNFI), JNFI);
				writeVar(fw, System.getProperty(JNPU), JNPU);
				writeVar(fw, getJobProperties(), "JobProperties ");
				writeVar(fw, getKeyColumnForHelpCode(), "keyColumnForHelpCode ");
				writeVar(fw, getLdapBase(), "LDapBase ");
				writeVar(fw, getLdapUrl(), "LDapUrl ");
				writeVar(fw, getLdapType(), "LDapType ");
				writeVar(fw, getLogicalLockIncludes(), "Lockable ");
				writeVar(fw, getLogonRequired(), "LogonRequired ");
				writeVar(fw, getLowerAlpha(), "Lowercase ");
				writeVar(fw, getMemoryRefDebug(), "MemoryRefDebug ");
				writeVar(fw, getMessageModel(), "MessageModel ");
				writeVar(fw, getMonitorOn(), "MonitorOn ");
				writeVar(fw, getNumbers(), "Numbers ");
				writeVar(fw, getOnlineRowNumbersSequence(), "OnlineRowNumbersSequence ");
				writeVar(fw, isUseStackTraceModeBatch(), "UseStackTraceModeBatch ");
				writeVar(fw, isUseStackTraceModeOnline(), "UseStackTraceModeOnline ");
				writeVar(fw, getOnlineTimeout() / Num.MSECS_SEC, "OnlineTimeout ");
				writeVar(fw, getTransactionTimeout(), "TransactionTimeout ");
				writeVar(fw, getOnlineQueryTimeout(), "OnLineQueryTimeout ");
				writeVar(fw, getBatchQueryTimeout(), "BatchQueryTimeout ");
				writeVar(fw, getOracleNlsComp(), "ORACLE_NLS_COMP ");
				writeVar(fw, getOracleNlsSort(), "ORACLE_NLS_SORT ");
				writeVar(fw, getOutputsAsFields(), "OutputsAsFields ");
				writeVar(fw, getpasswordEncrypt(), "PasswordEncrypt ");
				writeVar(fw, getPdfOutput(), "pdfOutput ");
				writeVar(fw, getPdfTemplate(), "pdfTemplate ");
				writeVar(fw,getCSVOutput(),"csvOutput");
				writeVar(fw,getSmtpHost(),"SmtpHost");//IPNC-847
				writeVar(fw,getSmtpUser(),"SmtpUser");//IPNC-847
				writeVar(fw,getSmtpUserPassword(),"SmtpUserPassword");//IPNC-847
				writeVar(fw, getPFKeyLangConditioned(), "PFKeyLangConditioned ");
				writeVar(fw, getPreformatted(), "Preformatted ");
				writeVar(fw, getProgramPackage(), "ProgramPackage ");
				writeVar(fw, getProgramAppVarClass(), "ProgramAppVarsClass ");
				writeVar(fw, getProvidedSessionFacade(), "ProvidedSessionFacade ");
				writeVar(fw, getProviderUrl(), "ProviderUrl ");
				writeVar(fw, getQueueManagerName(), "javax.jms.queue.DataQueueManagerName ");
				writeVar(fw, getQueueName(), "javax.jms.queue.DataQueueName ");
				writeVar(fw, getScriptsDir(), "scriptsDir ");
				writeVar(fw, getServer(), "Server ");
				writeVar(fw, setIndicatorByPFKeyNo, "SetIndicatorByPFKeyNo ");
				writeVar(fw, getShowVNOnError(), "ShowVNOnError ");
				writeVar(fw, getShowScreenID(), "ShowScreenID ");
				writeVar(fw, getSmaOpConEventDir(), "SMAOpConEventDir ");
				writeVar(fw, getSMTPServer(), "SMTPServer ");
				writeVar(fw, getSocketPort(), "SocketPort ");
				writeVar(fw, getSocketURL(), "SocketURL ");
				writeVar(fw, getSqlDiagLevel(), "SQLDiagLevel ");
				writeVar(fw, getSqlEDiagLevel(), "SQLEDiagLevel ");
				writeVar(fw, getSqlSummaryOnly(), "SQLSummaryOnly ");
				writeVar(fw, getSqlTiersDeep(), "SQLTiersDeep ");
				writeVar(fw, getStartupPage(), "StartupPage ");
				writeVar(fw, getSuppSchema(), "SuppSchema ");
				writeVar(fw, getSystemAdminName(), "SystemAdminName ");
				writeVar(fw, getSystemAdminPwd(), "SystemAdminPwd ");
				writeVar(fw, getSystemFont(), "SystemFont ");
				writeVar(fw, getSystemFontSize(), "SystemFontSize ");
				writeVar(fw, getSystemName(), "SystemName ");
				writeVar(fw, getTableBuffer(), "TableBuffer ");
				writeVar(fw, getThousandSeparator(), "ThouSep ");
				writeVar(fw, getTraceSource(), "TraceSource ");
				writeVar(fw, transactionManagerHelperClass, "TransactionManagerHelperClass ");
				writeVar(fw, getTransactionScope(), "TransactionScope ");
				writeVar(fw, isTruncateSQLParms(), "TruncateSQLParms ");
				writeVar(fw, getUpperAlpha(), "Uppercase ");
				writeVar(fw, isUseStackTraceModeBatch(), "UsePreExcessiveReadsModeBatch ");
				writeVar(fw, isUseStackTraceModeOnline(), "UsePreExcessiveReadsModeOnline ");
				writeVar(fw, isUseRowNumbers(), "UseRowNumbers ");
				writeVar(fw, isDuplicatesOldestFirst(), "DuplicatesOldestFirst ");
				writeVar(fw, isUseSQLTiers(), "UseSQLTiers ");
				writeVar(fw, isRocBasedApplication(), "IsRocBasedApplication ");
				writeVar(fw, getUserHeartbeat() / Num.MSECS_SEC, "UserHeartbeat ");
				writeVar(fw, getUserTimeout() / Num.MSECS_SEC, "UserTimeout ");
				writeVar(fw, getVariableRenamingSuffix(), "VariableRenamingSuffix ");
				writeVar(fw, getVersion(), "Version ");
				writeVar(fw, getFsuVersion(), "FsuVersion ");
				writeVar(fw, getXmlACon(), "xmlACon ");
				writeVar(fw, getXmlBackup(), "xmlback ");
				writeVar(fw, getXmlSource(), "XMLSource ");
				writeVar(fw, getInputFile(), "inputFile");
				writeVar(fw, getSubFolders(), "SubFolders");
				writeFw(fw, "</Root>");
			} finally {
				if (fw != null) {
					try {
						fw.flush();
					} finally {
						fw.close();
					}
				}
			}
			return 0;
		}

	    /**
	     * @return the sbaSchema
	     */
	    public String getSbaSchema() {
	        return sbaSchema;
	    }

	    /**
	     * @param sbaSchema
	     *            the sbaSchema to set
	     */
	    public void setSbaSchema(String sbaSchema) {
	        this.sbaSchema = sbaSchema;
	    }

	    /**
	     * @return the sbaHostPart
	     */
	    public String getSbaHostPart() {
	        return sbaHostPart;
	    }

	    /**
	     * @param sbaHostPart
	     *            the sbaHostPart to set
	     */
	    public void setSbaHostPart(String sbaHostPart) {
	        this.sbaHostPart = sbaHostPart;
	    }

	    /**
	     * @return the integralBatchEnable
	     */
	    public boolean isIntegralBatchEnable() {
	        return integralBatchEnable;
	    }


		public String getBrowserLocale() {
			return browserLocale;
		}

		public void setBrowserLocale(String browserLocale) {
			this.browserLocale = browserLocale;
		}
	    /**
	     * @return the csv path
	     */

		public String getCSVOutput() {
			return csvOutput;
		}
		/**
		 * Getter for {@link #csvTemplate}.
		 *
		 * @return {@link #csvTemplate}.
		 */
		public String getCsvTemplate() {
			return csvTemplate;
		}

		public void setCSVOutput(String csvOutput) {
			this.csvOutput = csvOutput;
		}
		/**
		 * Setter for {@link #csvTemplate}.
		 *
		 * @param pCsvTemplate the new value for {@link #csvTemplate}.
		 */
		public void setCsvTemplate(String pCsvTemplate) {
			this.csvTemplate = pCsvTemplate;
		}
		
		
		public String getTextInput() {
			return textInput;
		}

		public void setTextInput(String textInput) {
			this.textInput = textInput;
		}

		/**
		 * IJ-2031
		 * @return
		 */
		public String getTextOutput() {
			return textOutput;
		}

		/**
		 * IJ-2031
		 * @param textOutput
		 */
		public void setTextOutput(String textOutput) {
			this.textOutput = textOutput;
		}

		/**
		 * IJ-2063
		 * @return
		 */
		public String getXMLOutput() {
			return xmlOutput;
		}

		/**
		 * IJ-2063
		 * @param xmlOutput
		 */
		public void setXMLOutput(String xmlOutput) {
			this.xmlOutput = xmlOutput;
		}

		/*
		 * Ticket #IPAE-18 [ Design & Development - Req#23 - Document uploading facility].
		 */

		public String getRiskFirServiceURL() {
			return riskFirServiceURL;
		}

		public void setRiskFirServiceURL(String riskFirServiceURL) {
			this.riskFirServiceURL = riskFirServiceURL;
		}

		public String getRiskFioServiceURL() {
			return riskFioServiceURL;
		}

		public void setRiskFioServiceURL(String riskFioServiceURL) {
			this.riskFioServiceURL = riskFioServiceURL;
		}

		public String getRiskLppServiceURL() {
			return riskLppServiceURL;
		}

		public void setRiskLppServiceURL(String riskLppServiceURL) {
			this.riskLppServiceURL = riskLppServiceURL;
		}

		//Ticket #IPAE-18 [ Design & Development - Req#23 - Document uploading facility].

		protected void loadAddtlConfiguration(QPScreenNL qpscreen){
				
			if (!qpscreen.findNode("AdditionalField").isNull()){
				String getAdditionnalTag = qpscreen.parseToTag("AdditionalField").toString();
				JSONObject jsonObj = XML.toJSONObject(getAdditionnalTag);
				if(!jsonObj.get("AdditionalField").equals("")){
					JSONObject jsonAdditionalField = jsonObj.getJSONObject("AdditionalField");
					setAdditionalConfigStr(jsonAdditionalField.toString());
					if(passwordEncrypt.equalsIgnoreCase("YES")){
						String decryptPassword = QPStringEncrypter.instance.decrypt(jsonAdditionalField.get("WSAuthPassword").toString());
						jsonAdditionalField.put("WSAuthPassword", decryptPassword);
					}
					 setConfiguredItem(jsonAdditionalField);
				}	
			}
		}
		
		/* IAF-186 STARTS */
		private boolean isFlag(String featureName, String flag){
			if (featureName != null && features != null && features.size() > 0){
				Feature obj = (Feature)features.get(featureName);
				if (obj != null){
					List<String> companies = obj.getCompanies();
					if ((companies != null && companies.size() > 0 && companies.contains(FrameworkDialectFactory.getCompany()))
							&& (obj.getEnable() != null && obj.getEnable().equalsIgnoreCase(flag))){
						return true;
					}
				}
			}
			return false;
		}
		
		/**
		 * Enhancement: MYGST1
		 * 
		 * Check the feature (enhancement) whether turn on or not
		 * 
		 * @author Kien Tran (ktran44)
		 */
		public boolean isOnOf(String featureName){
			return isFlag(featureName, "Yes");		
		}
		
		/**
		 * Enhancement: MYGST1
		 * 
		 * Check the feature (enhancement) whether turn off or not
		 * 
		 * @author Kien Tran (ktran44)
		 */
		public boolean isOffOf(String featureName){
			return isFlag(featureName, "No");	
		}

		/**
		 * Enhancement: MYGST1
		 * 
		 * Check fields of screen whether turn off (no display) or not for specific feature
		 * 
		 * @author Kien Tran (ktran44)
		 */
		public boolean isFieldsOffOf(String featureName, String screenName){
			if (screenName == null || (screenName != null && isOnOf(featureName)))
				return false;

			if (features != null && features.size() > 0){
				Feature obj = (Feature)features.get(featureName);
				return obj.containScreen(screenName);
			}

			return false;
		}

		/**
		 * Enhancement: MYGST1
		 * 
		 * Check functions of screen whether turn off (no display) or not for specific feature
		 * 
		 * @author Kien Tran (ktran44)
		 */
		public boolean isFunctionsOff(String featureName, String screenName, String actionfield){
			if (featureName == null || screenName == null || actionfield == null)
				return false;


			List<String> fields = SwitchOnOffUtil.getFieldsBy(featureName, screenName, features);

			if (fields == null)
				return false;

			for(int i = 0; i< fields.size(); i++){
				if(fields.get(i).equalsIgnoreCase(actionfield) && isOffOf(featureName)){
					return true;
				}
			}
			return false;
		}

		public HashMap<String, Feature> getFeatures() {
			return features;
		}

		public void setFeatures(HashMap<String, Feature> features) {
			this.features = features;
				
		/* IAF-186 ENDS */
		}
		//*********Ticket #IAF-220 Externalisation Code ***************
		public static void setVpmsCarrierCode(String vpmsCarrierCode) {
			AppConfig.vpmsCarrierCode = vpmsCarrierCode;
		}

		public static String getVpmsCarrierCode() {
			return vpmsCarrierCode;
		}

		public static void setVpmsProductCode(String vpmsProductCode) {
			AppConfig.vpmsProductCode = vpmsProductCode;
		}

		public static String getVpmsProductCode() {
			return vpmsProductCode;
		}

		public static void setVpmsRegion(String vpmsRegion) {
			AppConfig.vpmsRegion = vpmsRegion;
		}

		public static String getVpmsRegion() {
			return vpmsRegion;
		}

		public static void setVpmsLocale(String vpmsLocale) {
			AppConfig.vpmsLocale = vpmsLocale;
		}

		public static String getVpmsLocale() {
			return vpmsLocale;
		}

		public static void setVpmsTransEffDate(String vpmsTransEffDate) {
			AppConfig.vpmsTransEffDate = vpmsTransEffDate;
		}

		public static String getVpmsTransEffDate() {
			return vpmsTransEffDate;
		}

		public static void setVpmsCallingSystem(String vpmsCallingSystem) {
			AppConfig.vpmsCallingSystem = vpmsCallingSystem;
		}

		public static String getVpmsCallingSystem() {
			return vpmsCallingSystem;
		}

		public static void setVpmsCallingProgram(String vpmsCallingProgram) {
			AppConfig.vpmsCallingProgram = vpmsCallingProgram;
		}

		public static String getVpmsCallingProgram() {
			return vpmsCallingProgram;
		}

		public static void setVpmsEnableLayering(String vpmsEnableLayering) {
			AppConfig.vpmsEnableLayering = vpmsEnableLayering;
		}

		public static String getVpmsEnableLayering() {
			return vpmsEnableLayering;
		}
		//*********Ticket #IAF-220 Externalisation Code ***************
		//IAF-208 Start
		public String getInputFile () {
			return inputfile;
		}
		public void setInputFile (String inputfile) {
		   this.inputfile = inputfile;
		}

		public String getSubFolders() {
			return subFolders;
		}

		public void setSubFolders(String subFolders) {
			this.subFolders = subFolders;
		}
}
