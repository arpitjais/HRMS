package com.hrms.pages;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

import com.hrms.Utility_Log.Log;
import com.hrms.utility.Base_Class;

import static org.testng.Assert.assertTrue;

public class Verifications_Page extends Base_Class {

	// ============ Methods
	public static  void verifyTitle(String title) {
		PropertyConfigurator.configure("Log4j.properties"); // In Main method

		if (driver.getTitle().equals(title)) {
			System.out.println("Title Matched and it's = " + driver.getTitle());
			Reporter.log("Title Matched and it's = " + driver.getTitle());
			Log.info("Title Matched and it's = " + driver.getTitle());
		} else {
			System.out.println("Title not Matched and Expected Title is = " + driver.getTitle());
			Reporter.log("Title not Matched and Expected Title is = " + driver.getTitle());
			Log.info("Title not Matched and Expected Title is = " + driver.getTitle());
		}
	}

	public static void verifyTitleViaAssertStmt(String title) {
		PropertyConfigurator.configure("Log4j.properties"); // In Main method
		System.out.println("This Page Title is = " + driver.getTitle());
		assertTrue(driver.getTitle().matches(title), "User is not able to login - Due to invalid Credentails");
		System.out.println("Title Matched via 'Assert' and it's = " + driver.getTitle());
		Log.info("Title Matched and it's = " + driver.getTitle());
	}

} // Main Class
