package com.hrms.utility;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import com.hrms.Utility_Log.Log;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base_Class {
	// =============== Objects
	// public static WebDriver driver; // WebDriver Object
	public static RemoteWebDriver driver;

	static String url = "http://localhost/orangehrm/login.php"; // Application URL
	// =========== Method

	public static void openApplication() throws Exception {
		PropertyConfigurator.configure("Log4j.properties"); // In Main method
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpit\\Downloads\\chromedriver.exe"); 
																										
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("====== Application Open ======");
		Reporter.log("====== Application Open ===== ");
		Log.info("====== Application Open ===== ");
	}

	public static void closeApplication() {
		PropertyConfigurator.configure("Log4j.properties"); // In Main method
		driver.close();

		System.out.println("&&&&&& Application Closed &&&&&&");
		Reporter.log("&&&&&& Application Closed &&&&&&");
		Log.info("&&&&&& Application Closed &&&&&& ");
	}
}
