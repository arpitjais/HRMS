package com.hrms.pages;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.hrms.Utility_Log.Log;
import com.hrms.utility.Base_Class;

public class Login_Page extends Base_Class {
	// ========== String
	public static String un;
	public static String pw;

	// ====== Object
	public static By txt_User_Name = By.name("txtUserName");
	public static By txt_Password = By.name("txtPassword");
	public static By btn_login = By.xpath("//input[@type='Submit']");
	public static By WarningloginMsg = By.xpath("//*[text()='Invalid Login']");
	public static String WarMsg = "Wrong username or password";
	public static String PgTitle = "orangeHRM";

	// ====== Re-usable Method
	public static void login(String un, String pw) throws Exception {
		PropertyConfigurator.configure("Log4j.properties");
		driver.findElement(txt_User_Name).clear();
		driver.findElement(txt_User_Name).sendKeys(un);

		driver.findElement(txt_Password).clear();
		driver.findElement(txt_Password).sendKeys(pw);

		WebDriverWait wait = new WebDriverWait(driver, 40);
//		wait.until(ExpectedConditions.elementToBeClickable(btn_login));


		driver.findElement(btn_login).click();
		System.out.println("Click on LogIn Button");
		Reporter.log("Click on LogIn Button");
		Log.info("Click on LogIn Button");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}// Method
}// Main Class
