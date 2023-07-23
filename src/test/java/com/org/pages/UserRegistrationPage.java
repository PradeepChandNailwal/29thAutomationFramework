package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.org.main.BaseTest.driver;

public class UserRegistrationPage{

	private WebElement firstNameField;
	private WebElement middleNameField;
	private WebElement lastNameField;
	private WebElement ageField;

	public WebElement getFirstNameField() {
		firstNameField = driver.findElement(By.xpath("//input[@name='fname']"));
		return firstNameField;
	}

	public WebElement getMiddleNameField() {
		middleNameField = driver.findElement(By.xpath("//input[@name='mname']"));
		return middleNameField;
	}

	public WebElement getLastNameField() {
		lastNameField = driver.findElement(By.xpath("//input[@name='lname']"));
		return lastNameField;
	}

	public WebElement getAgeField() {
		ageField = driver.findElement(By.xpath("//input[@name='age']"));
		return ageField;
	}


}
