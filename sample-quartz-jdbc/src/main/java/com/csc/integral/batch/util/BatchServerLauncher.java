package com.csc.integral.batch.util;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csc.common.AppConfig;
import com.csc.common.AppVars;
import com.csc.common.BatchAppVars;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;


/**
 * Entry point for Batch Server in Integral. 
 */
public class BatchServerLauncher {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchServerLauncher.class);
	
	public static BatchAppVars appVars = null;

	private static final String[] APPLICATION_CONTEXT = new String[] {
		"classpath*:mandatory/common.xml",
		"classpath*:scenarios/scheduling/quartz/quartz-common.xml",
		"classpath*:scenarios/scheduling/quartz/quartz-jobs.xml",
		"classpath*:scenarios/scheduling/quartz/quartz-listeners.xml",
		"classpath*:scenarios/scheduling/quartz/quartz-schedulers.xml",
		"classpath*:scenarios/scheduling/quartz/quartz-triggers.xml",
		"classpath*:com/csc/polisy/context/PolisyContext.xml",
		null};
	
	private static String getFOPPrintLng(AppVars appVars) {
		Connection con = null;
		ResultSet rs = null;
		try {
			con = appVars.getTempDBConnection("DB");
			rs = con.createStatement().executeQuery(
					"select dataarea_data from printlng where dataarea_id='PRINTLNG'");
			rs.next();
			return rs.getString(1);
		} catch (Exception e) {
			throw new RuntimeException("Error when querying printlng from database.", e);
		} finally {
			try {
				appVars.freeDBConnection(con);
			} catch (Exception e) {
				throw new RuntimeException("Error when closing temp connection.", e);
			}
		}
	}

	public static void main(String[] args) {
		// Verifies prerequisites.
		if (ArrayUtils.getLength(args) < 1) {
			throw new IllegalArgumentException("QuipozCfg.xml is expected.");
		}

		System.setProperty("Quipoz.PolisyAsiaWeb.XMLPath", args[0]);

        if ("true".equals(System.getProperty("aspect4pc"))) {
            URL url = BatchServerLauncher.class.getClassLoader().getResource(
                "com/csc/integral/aop/logback-aop.xml");
            LOGGER.info("Logger run in mode aspect4pc with log configuration file: [{}]", url);
            // assume SLF4J is bound to logback in the current environment
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

            try {
                JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(context);
                // Call context.reset() to clear any previous configuration, e.g. default
                // configuration. For multi-step configuration, omit calling context.reset().
                context.reset();
                configurator.doConfigure(url);
            } catch (JoranException je) {
                // StatusPrinter will handle this
                LOGGER.error("Error while reconfiguration log config file", je);
            }
            StatusPrinter.printInCaseOfErrorsOrWarnings(context);
        }
		
		appVars = new BatchAppVars("PolisyAsiaWeb");
		BatchAppVars.setInstance(appVars);

		// Set Quipoz datasoure config to system propertiey for Quartz
		// configuration
		// Spring will get these setting first, if not, will get from
		// quartz.properties.
		AppConfig appConfig = BatchAppVars.getInstance().getAppConfig();
		System.setProperty("org.quartz.dataSource.myDS.URL", appConfig
				.getDataSourceJDBC());
		System.setProperty("org.quartz.dataSource.myDS.user", appConfig
				.getUseridJDBC());
		System.setProperty("org.quartz.dataSource.myDS.password", appConfig
				.getPasswordJDBC());

		
		if (StringUtils.isEmpty(AppConfig.getPrintlng())) {
			throw new RuntimeException("AppConfig.printlng must NOT be empty.");
		}
		APPLICATION_CONTEXT[APPLICATION_CONTEXT.length-1] = "classpath:com/csc/polisy/context/dao/Polisy-DAO-"+appConfig.getDatabaseType()+".xml";
		// Initializes Spring application context.
		ApplicationContext appCtx = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT);
		
		
	}
}
