package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteUser extends BasePage {

	public DeleteUser(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By AddUser = By.xpath("//span[contains(text(),'Add User')]");

	By Delete = By.xpath("//button[normalize-space()='DELETE']");

	By Delete_Button = By.xpath("(//span[normalize-space()='Delete'])[2]");

	By UserDeleted = By.xpath("//span[normalize-space()='User deleted.']");

	By RemoveAdminAccess = By.xpath("//button[normalize-space()='REMOVE ADMIN ACCESS']");

	By Remove = By.xpath("//span[normalize-space()='Remove']");

	public boolean clickOnUsers(String user) {// click on dots
		By DesiredUser = By.xpath("//tbody//tr//td//span[contains(text(),'" + user + "')]//following::td[2]//button");
		clickandwait(DesiredUser);
		return isElementPresent(RemoveAdminAccess);
	}

	public boolean deleteUsers(String... email) {
		for (String users : email) {
			By DesiredUser = By
					.xpath("//tbody//tr//td//span[contains(text(),'" + users + "')]//following::td[2]//button");
			clickandwait(DesiredUser);
			clickOnDeleteButton();// when click on dots
			clickOnDelete();// When Pop-up Occurs

		}
		return isElementPresent(AddUser);
	}

	public boolean clickOnDeleteButton() { // when click on Dots
		clickandwait(Delete);
		return isElementPresent(Delete_Button);
	}

	public boolean clickOnDelete() { // pop-up
		clickandwait(Delete_Button);
		return isElementPresent(UserDeleted);
	}

	public boolean removeAdminAccess(String... user) { // For add admin access to Multiple

		for (String email : user) {
			By DesiredUser = By
					.xpath("//tbody//tr//td//span[contains(text(),'" + email + "')]//following::td[2]//button");
			clickandwait(DesiredUser); // click on dots
			clickOnRemoveButton();
			clickOnRemove();
		}
		return isElementPresent(AddUser);
	}

	public void clickOnRemoveButton() { // click On Dots to click on remove Button
		clickandwait(RemoveAdminAccess);
		isElementPresent(Remove);
	}

	public void clickOnRemove() { // click On remove When Pop-Up Occurs
		clickandwait(Remove);
		isElementPresent(RemoveAdminAccess);
	}
}
