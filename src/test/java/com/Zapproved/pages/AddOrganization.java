package com.Zapproved.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class AddOrganization extends BasePage {

	public AddOrganization(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By UserName = By.xpath("//*[@id='1-email']");

	By Passwordfield = By.xpath("//*[@name='password']");

	By LoginButton = By.xpath("//button[@name='submit']");

	By MainMenu = By.xpath("//p[contains(text(),'Matters')]");

	By Settings = By.xpath("//span[contains(text(),'Settings')]");

	By ErrorOK_Button = By.xpath("//span[normalize-space()='OK']");

	By LHP_admin = By.xpath("//span[normalize-space()='LHP Admin']");

	By AddOrganizationButton = By.xpath("//span[contains(text(),'ADD ORGANIZATION')]");

	By EnterOrganizationName = By.xpath("//*[@data-placeholder='Enter organization name']");

	By AddButton = By.xpath("//*[@id='create-org-button']");

	By OrganizationSuccessfullyAdded = By.xpath("//span[text()='Organization successfully added!']");

	By SearchOrganization = By.xpath("//input[@placeholder='Search Organizations']");

	public void getURL(String URL) {
		driver.get().get(URL);
		waitforPresenceOFElement(UserName);
	}

	public void SetEmailAndPassword(String userName, String Password) {
		SeTText(UserName, userName);
		SeTText(Passwordfield, Password);

	}

	public void ClickOnLoginButton() {
		clickandwait(LoginButton);
		waitforelementtoBecomePresent(MainMenu);

	}

	public void clickOnSettings() {
		clickandwait(Settings);
	}

	public boolean clickOnLHP_Admin() {
		clickandwait(LHP_admin);
		return isElementPresent(AddOrganizationButton);
	}

	public boolean isAddOrganizationIsDisplayed() {
		return isElementPresent(AddOrganizationButton);
	}

	public void clickOnAddOrganization() {
		clickandwait(AddOrganizationButton);
	}

	public void enterOrganizationName(String Organization) {
		SeTText(EnterOrganizationName, Organization);

	}

	public boolean isOrganizationFieldVisible() {
		return isElementVisible(EnterOrganizationName);
	}

	public void clickOnAddButton() {
		clickandwait(AddButton);

	}

	public boolean isAddButtonVisible() {
		return isElementVisible(AddButton);

	}

	public boolean checkOrganization() { // Check whether organization is created or not

		return IsElementPresent(OrganizationSuccessfullyAdded);
	}

	public boolean name() {
		try {
			return IsElementPresent(OrganizationSuccessfullyAdded);
		} catch (NoSuchElementException ignored) {
			return false;
		} catch (StaleElementReferenceException ignored) {
			return false;
		}
	}

}
