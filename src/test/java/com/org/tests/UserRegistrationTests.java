package com.org.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.io.Files;
import com.org.main.BaseTest;
import com.org.pages.UserRegistrationPage;
import com.org.utils.ProjectProperties;

public class UserRegistrationTests extends BaseTest {

	UserRegistrationPage urp;

	@BeforeMethod
	public void setUp() {
		urp = new UserRegistrationPage();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("UserRegistration");
	}

	@Test
	public void validateFirstName() throws IOException {
		ExtentTest testCase = reports.createTest("SEL-1123 : validateFirstName");
		testCase.info("Starting Test case..");
		try {
			urp.getFirstNameField().sendKeys(ProjectProperties.props.getProperty("UserRegistrationTests_FirstName_TestData"));
			System.out.println("Pass: First Name field exist.");
		} catch (Exception e) {
			System.out.println("Fail: First Name field do not exist.");
			testCase.info(e);
		}
		String expectedValue = "Ram";
		String actualValue = urp.getFirstNameField().getAttribute("value");
		
		testCase.info("First Name Validation starts");
		
		if(actualValue.equals(expectedValue)) {
			testCase.pass("validateFirstName is passed");
		}else {
			testCase.fail("validateFirstName is failed as expected [" + expectedValue + "]" + " But actual values is [" + actualValue + "]");
			
			TakesScreenshot tss = (TakesScreenshot)driver;
			File srcFile = tss.getScreenshotAs(OutputType.FILE);
			File tagFile = new File(BaseTest.screenshotPath + "validateFirstName.png");
			System.out.println("File:" + tagFile.getAbsolutePath());
			Files.copy(srcFile, tagFile);
			testCase.addScreenCaptureFromPath(BaseTest.screenshotPath + "validateFirstName.png");
			
		}
		
		testCase.info("First Name Validation ends");

		//Assert.assertEquals(actualValue, expectedValue);
	}

	@Test
	public void validateMiddleName() {
		ExtentTest testCase = reports.createTest("SEL-1133 : validateMiddleName");
		urp.getMiddleNameField().sendKeys("Gopal");
		
		String expectedValue = "Gopal";
		String actualValue = urp.getMiddleNameField().getAttribute("value");
		
		if(actualValue.equals(expectedValue)) {
			testCase.pass("validateMiddleName is passed");
		}else {
			testCase.fail("validateMiddleName is failed");
		}
	}

	@Test
	public void validateLastName() {
		ExtentTest testCase = reports.createTest("SEL-4444 : validateLastName");
		urp.getLastNameField().sendKeys("Verma");
	}

}
