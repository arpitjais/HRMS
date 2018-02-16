package com.hrms.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.Reporter;

import com.hrms.Utility_Log.Log;
import com.hrms.utility.Base_Class;

public class Logout_Page extends Base_Class {

	// ======== Object
	static By Link_logout = By.linkText("Logout");

	// ========== Method
	public static void logout() throws Exception {
		PropertyConfigurator.configure("Log4j.properties"); // In Main method
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(Link_logout).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(2000);
		System.out.println("===== Logout Completed =====");
		Reporter.log("===== Logout Completed ======");
		Log.info("===== Logout Completed ====== ");
	}
}
