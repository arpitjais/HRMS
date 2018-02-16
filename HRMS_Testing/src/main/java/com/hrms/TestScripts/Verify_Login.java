package com.hrms.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.apache.log4j.PropertyConfigurator;

import com.hrms.utility.Excell_Utils;
import com.hrms.Utility_Log.Log;
import com.hrms.pages.Login_Page;
import com.hrms.pages.Logout_Page;
import com.hrms.pages.Verifications_Page;
import com.hrms.utility.Base_Class;

public class Verify_Login extends Base_Class {
	public static String un;
	public static String pw;
	public static By WarningloginMsg = By.xpath("//div[@class='alert alert-danger']");
	public static String WarMsg = "Wrong username or password";
	public static String PgTitle = "OrangeHRM";

	@Test
	public static void login() throws Exception {
		PropertyConfigurator.configure("Log4j.properties"); // In Main method
		System.out.println("Verify Login and Logout for HRMS");
		Reporter.log("**** Verify Login and Logout for HRMS ****");
		Log.info("**** Verify Login and Logout for HRMS **** ");
		Base_Class.openApplication();
		Verifications_Page.verifyTitle("PgTitle");

		// ========= Login via Excel
		Excell_Utils.setExcelFile("D:\\eclipse-workspace1\\HRMS_Testing\\TestData\\testdata.xlsx");
		int rows = Excell_Utils.getRowCount(0); // Get Row Count
		System.out.println("Row Count = " + rows);
		for (int i = 1; i <= rows; i++) {
			String un = Excell_Utils.getCellData(0, i, 0);
			String pw = Excell_Utils.getCellData(0, i, 1);
			System.out.println("User Name " + i + " " + un);
			System.out.println("Password " + i + " " + pw);
			Login_Page.login(un, pw);
			// =========== Successfully Login
			if (driver.getTitle().equals(PgTitle)) {
				System.out.println("Title Matched and it's = " + driver.getTitle());
				Reporter.log("Title Matched and it's = " + driver.getTitle());
				Log.info("Title Matched and it's = " + driver.getTitle());
				// ============= Excell Writing
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				Excell_Utils.setCellData("D:\\eclipse-workspace1\\HRMS_Testing\\TestData\\testdata.xlsx", 0, i, 2,"Pass");
				System.out.println("***** Login Successfully *****");
				Reporter.log("Login Successfully");
				Log.info("**** Login Successfully **** ");
				System.out.println("Test Case PASSED");
				Log.info("Test Case PASSED");
				System.out.println(" ");
				Logout_Page.logout();
			} else { // ============= Excell Writing
				Excell_Utils.setCellData("D:\\eclipse-workspace1\\HRMS_Testing\\TestData\\testdata.xlsx", 0, i, 2,"Fail");
				// =========== Warning Login Msg for Failed Login
				String Atext = driver.findElement(WarningloginMsg).getText();
				System.out.println("Text Box in ADD School Message is = " + Atext);
				Log.info("Text Box in ADD School Message Page is = " + Atext);
				System.out.println("Login FAILED, User is not able to login - Due to invalid Credentails");
				Log.info("Login FAILED, User is not able to login - Due to invalid Credentails");
				Reporter.log("Login FAILED");
				Log.info("**** Login FAILED **** ");
				System.out.println("Test Case FAILED");
				Log.info("Test Case FAILED");
				System.out.println(" ");

			} // Else Block
		} // For Loop
			// ====== Logout
		Base_Class.closeApplication();
	}// Method
}// Main Class
