package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUser extends BasePage {

	public AddUser(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By AddUser = By.xpath("//span[contains(text(),'Add User')]");

	By UserEmail = By.xpath("//input[@id='search']");

	By Add = By.xpath("//span[normalize-space()='Add']");

	By UserAddedSuccessfully = By.xpath("//span[contains(text(),'User successfully added!')]");

	By ThreeDots = By.xpath("//mat-icon[normalize-space()='more_vert']");

	By AddAdminAccess = By.xpath("//button[normalize-space()='ADD ADMIN ACCESS']");

	By AddButton_AddAdminAccess = By.xpath("//button[normalize-space()='Add']");

	public boolean clickOnSearchedOrganization(String Organization) {

		By SearchedOrganization = By.xpath("//span[normalize-space()='" + Organization + "']");
		clickandwait(SearchedOrganization);
		return isElementPresent(AddUser);

	}

	public void clickOnAddUser() {
		clickandwait(AddUser);

	}

	public boolean addUser(String Email) {

		waitforelementtoBecomeclickable(UserEmail);
		SetText(UserEmail, Email);
		By ChooseMail = By.xpath("//span[@class='mat-option-text']");
		waitforelementtoBecomeclickable(ChooseMail);
		pressDownArrowKey(UserEmail);
		PressEnter();
		return isElementPresent(Add);

	}

	public boolean clickOnAdd() {

		clickandwait(Add);
		return isElementPresent(UserAddedSuccessfully);
	}

	public boolean clickOnDots(String user) {
		By DesiredUser = By
				.xpath("//tbody//tr//td//span[contains(text(),'" + user + "')]//following::td[3]//button//span");
		clickandwait(DesiredUser);
		return isElementPresent(AddAdminAccess);
	}

	public void addAdminAccess() {
		waitforelementtoBecomeclickable(AddAdminAccess);
		clickandwait(AddAdminAccess);

	}

	public boolean clickOnAddButtonOfAddAdminAccess() {
		clickandwait(AddButton_AddAdminAccess);
		By AdminAccessAdded = By.xpath("//span[contains(text(),'Admin access added.')]");
		return isElementPresent(AdminAccessAdded);

	}
}
