package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUser extends BasePage {

	public AddUser(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By AddUser = By.xpath("//span[contains(text(),'Add User')]");

	public void clickOnAddUser() {
		waitforLoaderToAppear();
		waitforLoaderToDisAppear();
		clickandwait(AddUser);
	}
}
