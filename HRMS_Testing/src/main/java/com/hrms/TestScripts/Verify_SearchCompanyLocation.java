package com.hrms.TestScripts;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.hrms.pages.SearchCompanyLocation_Page;
import com.hrms.Utility_Log.Log;
import com.hrms.pages.Login_Page;
import com.hrms.pages.Logout_Page;
import com.hrms.pages.Verifications_Page;

import com.hrms.utility.Base_Class;

public class Verify_SearchCompanyLocation {

	@Test
	public void addCompanyLocation() throws Exception {
		PropertyConfigurator.configure("log4j.properties"); // In Main method
		System.out.println("****** Verify SearchComapny Location Test Scripts ******");
		Reporter.log("****** Verify SearchComapny Location Test Scripts ******");
		Log.info("****** Verify SearchComapny Location Test Scripts ****** ");

		Base_Class.openApplication();
		Verifications_Page.verifyTitle("OrangeHRM - New Level of HR Management");

		Login_Page.login("admin", "admin");
		Verifications_Page.verifyTitle("orangeHRM");
		Verify_userNameText.userNameText("Welcome admin");
		SearchCompanyLocation_Page.searchCompanyLoc();

		Logout_Page.logout();

		Base_Class.closeApplication();
	}
}
