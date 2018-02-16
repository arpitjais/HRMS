package com.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.hrms.utility.Base_Class;
import com.hrms.Utility_Log.Log;
import com.hrms.utility.Actions_Class;

public class SearchCompanyLocation_Page extends Base_Class {

	static By Admin = By.linkText("Admin");
	static By Company_info = By.linkText("Company Info");
	static By Locations = By.linkText("Locations");

	static By SearchBy  = By.id("loc_code");
	static By SearchFor = By.name("loc_name");
	static By SearchButton = By.xpath("//input[@value='Search']");

	public static void searchCompanyLoc() throws Exception {

		// Actions_Class.mouseover("Admin");
		Actions_Class.mouseoverClick("Admin", "Company Info", "Locations");
		
		System.out.println("****** Mouse over and click performed for Location ******");
		Reporter.log("****** Mouse over and click performed for Location ******");
		Log.info("****** Mouse over and click performed for Location ****** ");

		driver.switchTo().frame("rightMenu");
		
		System.out.println("****** Switch of Frame ******");
		Reporter.log("****** Switch of Frame ******");
		Log.info("****** Switch of Frame ****** ");

		Thread.sleep(2000);

		WebElement element = driver.findElement(SearchBy);

		Select sele = new Select(element);

		sele.selectByVisibleText("ID");
		
		System.out.println("****** Selecting dropdown ******");
		Reporter.log("****** Selecting dropdown ******");
		Log.info("****** VSelecting dropdown ****** ");

		driver.findElement(SearchFor).sendKeys("LOC001");
		
		System.out.println("****** Entering SearchFor ******");
		Reporter.log("****** Entering SearchFor ******");
		Log.info("****** Entering SearchFor ****** ");

		driver.findElement(SearchButton).click();
		
		System.out.println("****** Clicking on serch button ******");
		Reporter.log("****** Clicking on serch button ******");
		Log.info("****** Clicking on serch button ****** ");
		
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		
		System.out.println("****** Switching to deafault content******");
		Reporter.log("****** Switching to deafault content ******");
		Log.info("****** Switching to deafault content ****** ");

	}

}
