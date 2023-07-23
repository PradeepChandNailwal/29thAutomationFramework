package com.org.main;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.org.utils.ProjectProperties;

public class BaseTest {
	public static WebDriver driver;
	public static ExtentHtmlReporter reportTemplate;
	public static ExtentReports reports;
	public static String screenshotPath = System.getProperty("user.dir") + "\\reports\\screenshots\\";

	@BeforeSuite
	public static void setUpReport() {
		reportTemplate = new ExtentHtmlReporter("C:\\Users\\thaku\\eclipse-workspace\\29thSeleniumAutomationFramework\\reports\\Ramesh.html");
		reports = new ExtentReports();
		reports.attachReporter(reportTemplate);
	}

	@AfterSuite
	public static void saveReport() {
		reports.flush();
	}

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaku\\eclipse-workspace\\29thSeleniumAutomationFramework\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ProjectProperties.props.getProperty("appUrl"));
	}

	@AfterClass
	public static void closeBrowser() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
