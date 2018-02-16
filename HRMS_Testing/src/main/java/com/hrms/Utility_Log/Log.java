package com.hrms.Utility_Log;

import org.apache.log4j.Logger;

public class Log {
	// initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());
	// import org.apache.log4j.xml.DOMConfigurator; // Call Log
	// DOMConfigurator.configure("log4j.xml"); // In Main method

	public static void info(String message) {
		Log.info(message);
	}
}
