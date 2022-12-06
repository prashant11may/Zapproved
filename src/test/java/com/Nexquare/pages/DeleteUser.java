package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteUser extends BasePage {

	public DeleteUser(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By Delete = By.xpath("//button[normalize-space()='DELETE']");

	By Delete_Button = By.xpath("(//span[normalize-space()='Delete'])[2]");

	By UserDeleted = By.xpath("//span[normalize-space()='User deleted.']");

	By RemoveAdminAccess = By.xpath("//button[normalize-space()='REMOVE ADMIN ACCESS']");

	public boolean clickOnDots(String user) {
		By DesiredUser = By
				.xpath("//tbody//tr//td//span[contains(text(),'" + user + "')]//following::td[2]//button//span");
		clickandwait(DesiredUser);
		return isElementPresent(RemoveAdminAccess);
	}

	public boolean clickOnDeleteButton() {
		clickandwait(Delete);
		return isElementPresent(Delete_Button);
	}

	public boolean clickOnDelete() {
		clickandwait(Delete_Button);
		return isElementPresent(UserDeleted);
	}
}
