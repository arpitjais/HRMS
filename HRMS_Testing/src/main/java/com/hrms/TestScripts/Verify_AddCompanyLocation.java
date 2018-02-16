package com.hrms.TestScripts;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hrms.pages.AddCompanyLocation_Page;
import com.hrms.Utility_Log.Log;
import com.hrms.pages.Login_Page;
import com.hrms.pages.Logout_Page;
import com.hrms.pages.Verifications_Page;

import com.hrms.utility.Base_Class;

public class Verify_AddCompanyLocation {

	@Test
	public void addCompanyLocation() throws Exception {
		PropertyConfigurator.configure("log4j.properties"); // In Main method
		System.out.println("****** Verify School Review Page Test Scripts ******");
		Reporter.log("****** Verify School Review Page Test Scripts ******");
		Log.info("****** Verify School Review Page Test Scripts ****** ");

		Base_Class.openApplication();
		Verifications_Page.verifyTitle("OrangeHRM - New Level of HR Management");

		Login_Page.login("admin", "admin");
		Verifications_Page.verifyTitle("orangeHRM");
		Verify_userNameText.userNameText("Welcome admin");
		AddCompanyLocation_Page.addCompanyLoc();

		Logout_Page.logout();

		Base_Class.closeApplication();
	}
}
