package com.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hrms.utility.Base_Class;
import com.hrms.utility.Actions_Class;

public class AddCompanyLocation_Page extends Base_Class {

	static By Admin = By.linkText("Admin");
	static By Company_info = By.linkText("Company Info");
	static By Locations = By.linkText("Locations");
	static By Add = By.xpath("//input[@value='Add']");

	static By Name = By.id("txtLocDescription");
	static By Country = By.name("cmbCountry");
	static By Address = By.name("txtAddress");
	static By ZipCode = By.name("txtZIP");

	static By Save = By.xpath("//input[@value='Save']");

	public static void addCompanyLoc() throws Exception {

		// Actions_Class.mouseover("Admin");
		Actions_Class.mouseoverClick("Admin", "Company Info", "Locations");

		driver.switchTo().frame("rightMenu");

		driver.findElement(Add).click();

		Thread.sleep(2000);

		driver.findElement(Name).sendKeys("Jholachap");

		WebElement element = driver.findElement(By.id("cmbCountry"));

		Select sele = new Select(element);

		sele.selectByVisibleText("India");

		driver.findElement(Address).sendKeys("SAI KRUTI P.G. ");
		driver.findElement(ZipCode).sendKeys("208002");

		driver.findElement(Save).click();

		driver.switchTo().defaultContent();

	}

}
