package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateUser extends BasePage {

	public CreateUser(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By Users = By.xpath("//span[normalize-space()='Users']");

	By AddUser = By.xpath("//span[contains(text(),'ADD USER')]");

	By FirstName = By.xpath("//input[@data-placeholder='First Name']");

	By LastName = By.xpath("//input[@data-placeholder='Last Name']");

	By EmailAddress = By.xpath("//input[@data-placeholder='Email Address']");

	By CreaeUser = By.xpath("//span[normalize-space()='CREATE USER']");

	public void clickOnUsers() {
		clickandwait(Users);
	}

	public void clickOnAddUser() {
		clickandwait(AddUser);
	}

	public void enterTheFirstName(String firstName) {
		SeTText(FirstName, firstName);
	}

	public void enterTheLastName(String lastName) {
		SeTText(LastName, lastName);
	}

	public void enterTheEmailAddress(String Email) {
		SeTText(EmailAddress, Email);
	}

	public void clickOnCreateUser() {
		clickandwait(Users);
	}

}
