package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

//	By AddCompany = By.xpath("//span[contains(text(),'ADD COMPANY')]");
//
//	By CompanyName = By.xpath("//input[@id='mat-input-0']");
//
//	By Companylogo = By.xpath("//div[@class='file-select flex-it-to-me ng-star-inserted']");
//
//	By CustomLogoutURL = By.xpath("//input[@id='mat-input-1']");
//
//	By SSO_Login = By.xpath("//div[@class='mat-slide-toggle-thumb']");
//
//	By SSO_EmailDomains = By.xpath("//textarea[@id='mat-input-2']");
//
//	By CreateCompanyButton = By.xpath("//span[normalize-space()='CREATE COMPANY']");
//
//	By EnableSSO_Button = By.xpath("//span[normalize-space()='Enable SSO'] ");

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

//	public void clickOnAddCompany() {
//		clickandwait(AddCompany);
//	}
//
//	public void enterCompanyName(String Company) {
//		SeTText(CompanyName, Company);
//	}
//
//	public void uploadCompanyLogo(String PathToFolder) {
//		waitforelementtoBecomePresent(Companylogo);
//		InputFiles(Companylogo, PathToFolder);
//	}
//
//	public void enterCustomLogoutURL(String LogoutURL) {
//		SeTText(CustomLogoutURL, LogoutURL);
//	}
//
//	public void switchSSO_LoginToggle() {
//		clickandwait(SSO_Login);
//	}
//
//	public void enterSSO_EmailDomains(String EmailDomains) {
//		SeTText(SSO_EmailDomains, EmailDomains);
//	}
//
//	public void clickOnCreateCompanyButton() {
//		clickandwait(CreateCompanyButton);
//	}
//
//	public void clickOnEnableSSO_Button() {
//		clickandwait(EnableSSO_Button);
//	}

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

	public void checkOrganization() {

		try {
			waitforelementtoBecomeclickable(Error);
			WebElement error = driver.get().findElement(Error);
			if (IsElementPresent(Error)) {
				String ErrorsMessage = driver.get().findElement(Error).getText();
				System.out.println(ErrorsMessage);
				WebElement Ok = driver.get().findElement(ErrorOK_Button);
				waitforelementtoBecomeclickable(Ok);
				Ok.click();

			}

		} catch (Exception e) {

			System.out.println("Customer Created Successfully");

		}

	}
}
