package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUser extends BasePage {

	public AddUser(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By AddUser = By.xpath("//span[contains(text(),'Add User')]");

	By UserEmai = By.xpath("//input[@id='search']");

	By Add = By.xpath("//span[normalize-space()='Add']");

	By ThreeDots = By.xpath("//mat-icon[normalize-space()='more_vert']");

	By AddAdminAccess = By.xpath("//button[normalize-space()='ADD ADMIN ACCESS']");

	public void clickOnSearchedOrganization(String Organization) {
		// By SearchedOrganization = By.xpath("//span[contains(text(),'Ashraff
		// Organization')]");
		By SearchedOrganization2 = By.xpath("//span[contains(text(),'" + Organization + "')]");
//		clickandwait(SearchedOrganization2);
		javascriptButtonClick(SearchedOrganization2);
	}

	public void clickOnAddUser() {
		Sleep(4);
		clickandwait(AddUser);
	}

	public void addUser(String Email) {
		waitforelementtoBecomeclickable(UserEmai);
		SetText(UserEmai, Email);
		By Text = By.xpath("//span[@class='mat-option-text']");
		waitforelementtoBecomeclickable(Text);
		pressDownArrowKey(UserEmai);
		PressEnter();

	}

	public void clickOnAdd() {
		waitforelementtoBecomeclickable(Add);
		clickandwait(Add);
	}

	public void clickOnDots() {
		waitforelementtoBecomeclickable(ThreeDots);
		javascriptButtonClick(ThreeDots);
	}

	public void addAdminAccess() {
		waitforelementtoBecomeclickable(AddAdminAccess);
		clickandwait(AddAdminAccess);

	}
}
