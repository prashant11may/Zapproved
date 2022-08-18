package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.TestUtils;

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

	By Error = By.xpath("//h1[@id='mat-dialog-title-1']//following-sibling::div//p");

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

	public void clickOnLHP_Admin() {
		clickandwait(LHP_admin);
		waitforLoaderToAppear();
		waitforLoaderToDisAppear();
	}

	public void clickOnAddOrganization() {
		clickandwait(AddOrganizationButton);
	}

	public void enterOrganizationName(String Organization) {
		waitforelementtoBecomePresent(EnterOrganizationName);
		SeTText(EnterOrganizationName, Organization);
		waitforelementtoBecomeclickable(AddButton);
	}

	public void clickOnAddButton() {
		clickandwait(AddButton);

	}

	public boolean checkOrganization() { // Check whether organization is created or not

		waitforelementtoBecomePresent(Error);
		WebElement ele = driver.get().findElement(Error);

		ele.isDisplayed();
		System.out.println(ele.getText());
		return false;

	}

	public void enterAOrganization(String NameOfCompany) {

		String str = TestUtils.uniqueTextGenerator(NameOfCompany);
		waitforelementtoBecomePresent(EnterOrganizationName);

		SetText(EnterOrganizationName, NameOfCompany + str);
	}
}
