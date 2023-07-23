package com.org.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.main.BaseTest;
import com.org.pages.LeftMenuPage;
import com.org.pages.UserRegistrationPage;

public class LeftMenuPageTests extends BaseTest {
	LeftMenuPage lmp;

	@BeforeMethod
	public void setUp() {
		lmp = new LeftMenuPage();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("LeftMenu");
	}

	@Test
	public void validateSeleniumLink() {
		lmp.getSeleniumLink().click();
	}

	@Test
	public void validateJMeterLink() {
		lmp.getjMeterLink().click();
	}

}
