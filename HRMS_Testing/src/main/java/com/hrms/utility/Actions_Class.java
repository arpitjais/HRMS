package com.hrms.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import com.hrms.Utility_Log.Log;
import com.hrms.utility.Base_Class;

public class Actions_Class extends Base_Class {
	// ================ Mouse Over

	public static void mouseover(String mouseoverXpath) {
		WebElement ele = driver.findElement(By.linkText(mouseoverXpath));
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
	}
	// ================ Mouse Over And Click

	public static void mouseoverClick(String mouseoverXpath, String mouseoverXpath1, String mouseoverXpathClick) {
		WebElement ele = driver.findElement(By.linkText(mouseoverXpath));
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement ele1 = driver.findElement(By.linkText(mouseoverXpath1));
		Actions a1 = new Actions(driver);
		a1.moveToElement(ele1).build().perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText(mouseoverXpathClick)).click();
	}

	// ======== Explicit Wait
	public static void explicitwait(String x) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(x)));
		driver.findElement(By.xpath(x)).click();
		System.out.println("Explicit Wait Executed");
	}

	// ======== Implicit Wait
	public static void implicitwait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Implicit Wait Executed");
	}

	// ======== Thread.Sleep Wait
	public static void threadsleep() throws Exception {
		Thread.sleep(3000);
		System.out.println("Thread.Sleep Wait Executed");
	}

	public static void bootStrap(String ClickXpath, String ListXpath, String ListValue) throws Throwable {
		// First we have to click on menu item then only dropdown items will display
		driver.findElement(By.xpath(ClickXpath)).click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath(ListXpath));
		// We are using enhanced for loop to get the elements
		for (WebElement ele : list) //
		{
			// for every elements it will print the name using innerHTML
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			// Here we will verify if link (item) is equal to Java Script
			if (ele.getAttribute("innerHTML").contains(ListValue)) {// if yes then click on link (iteam)
				ele.click();
				break;
			}
		} // For loop
	}// Method

	public static String typecast(int S) {
		String test = Integer.toString(S);
		return test;
	}

	// ====== Alert Accepts
	public static void alertAccept() throws InterruptedException {

		try {
			Alert alt = driver.switchTo().alert();
			System.out.println("Alert Text ---->>>> " + alt.getText());
			Log.info("Alert Text ---->>>> " + alt.getText());
			alt.accept();
			System.out.println("Alert Accept");
			Thread.sleep(1000);
		} catch (NoAlertPresentException noe) {
		}
	}

	// ====== Alert Dismiss
	public static void alertDismiss() throws InterruptedException {

		try {
			Alert alt = driver.switchTo().alert();
			System.out.println("Alert Text ---->>>> " + alt.getText());
			Log.info("Alert Text ---->>>> " + alt.getText());
			alt.dismiss();
			System.out.println("Alert Dismissed");
			Thread.sleep(1000);
		} catch (NoAlertPresentException noe) {
		}
	}

	// ================ Scroll Down
	public static void scrolldown() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

	}

	// =================== File Upload
	public static void fileupload(String BtnXpath, String FilePath) throws InterruptedException {
		Thread.sleep(2000);
		WebElement fl = driver.findElement(By.xpath(BtnXpath));
		fl.sendKeys(FilePath);
		System.out.println("File Upload Successfully");
		Thread.sleep(5000);
	}

	public static void fileuploadrobot(String BtnXpath, String FilePath) throws InterruptedException, AWTException {
		// File Uploading
		// Specify the file location with extension
		StringSelection sel = new StringSelection(FilePath);
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		System.out.println("selection" + sel);
		driver.findElement(By.xpath(BtnXpath)).click();
		System.out.println("Clicked on Add New");
		// Create object of Robot class
		Robot robot = new Robot();
		Thread.sleep(1000);
		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);
		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("File Uploaded Successfully");
		Thread.sleep(3000);
		Thread.sleep(3000);
	}

}
