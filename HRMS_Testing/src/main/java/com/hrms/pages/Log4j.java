package com.hrms.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class Log4j {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello World!");

		Logger logger = Logger.getLogger("Log4j");

		PropertyConfigurator.configure("Log4j.properties");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpit\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		logger.info("Chrome Opened");

		driver.get("http://localhost/orangehrm/login.php");
		logger.info("Opening URL");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("admin");
		logger.info("Entering UserName");
		
		
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin");
		logger.info("Entering Pass.");

		driver.findElement(By.name("Submit")).click();
		logger.info("clicking Submit");

		Thread.sleep(2000);

		driver.close();
		logger.info("Closing Browser");
	}
}
