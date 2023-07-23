package com.org.pages;

import static com.org.main.BaseTest.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LeftMenuPage {
	
	private WebElement seleniumLink;
	private WebElement jMeterLink;
	
	public WebElement getSeleniumLink() {
		seleniumLink = driver.findElement(By.xpath("//a[text()='Selenium']"));
		return seleniumLink;
	}
	public WebElement getjMeterLink() {
		jMeterLink = driver.findElement(By.xpath("//a[text()='JMeter']"));
		return jMeterLink;
	}
	
	

}
