package com.hrms.TestScripts;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.Reporter;
import com.hrms.utility.Base_Class;

import com.hrms.Utility_Log.Log;

public class Verify_userNameText  extends Base_Class {

	public static void userNameText(String text){

		PropertyConfigurator.configure("Log4j.properties"); // In Main method
		String text1 = driver.findElement(By.xpath("//ul[@id='option-menu']/li")).getText();
		System.out.println("Welcome Text Msg is = " + text1);
		Reporter.log("Welcome Text Msg is = " + text1);
		Log.info("Welcome Text Msg is = " + text1);
		
		assertTrue(driver.findElement(By.xpath("//ul[@id='option-menu']/li")).getText().matches(text));
		System.out.println("Welcome Msg Matched");
		Reporter.log("Welcome Msg Matched");
	}

}
