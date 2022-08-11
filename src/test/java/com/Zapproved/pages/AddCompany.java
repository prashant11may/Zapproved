package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCompany extends BasePage {

	public AddCompany(ThreadLocal<WebDriver> driver) {
		super(driver);

	}

	By UserName = By.xpath("//*[@id='1-email']");

	By Passwordfield = By.xpath("//*[@name='password']");

	By LoginButton = By.xpath("//button[@name='submit']");

	By MainMenu = By.xpath("//p[contains(text(),'Matters')]");

	By Settings = By.xpath("//span[contains(text(),'Settings')]");

	By AddCompany = By.xpath("//span[contains(text(),'ADD COMPANY')]");

	By CompanyName = By.xpath("//input[@id='mat-input-0']");

	By Companylogo = By.xpath("//div[@class='file-select flex-it-to-me ng-star-inserted']");

	By CustomLogoutURL = By.xpath("//input[@id='mat-input-1']");

	By SSO_Login = By.xpath("//div[@class='mat-slide-toggle-thumb']");

	By SSO_EmailDomains = By.xpath("//textarea[@id='mat-input-2']");

	By CreateCompanyButton = By.xpath("//span[normalize-space()='CREATE COMPANY']");

	By EnableSSO_Button = By.xpath("//span[normalize-space()='Enable SSO'] ");

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

	public void clickOnAddCompany() {
		clickandwait(AddCompany);
	}

	public void enterCompanyName(String Company) {
		SeTText(CompanyName, Company);
	}

	public void uploadCompanyLogo(String PathToFolder) {
		waitforelementtoBecomePresent(Companylogo);
		InputFiles(Companylogo, PathToFolder);
	}

	public void enterCustomLogoutURL(String LogoutURL) {
		SeTText(CustomLogoutURL, LogoutURL);
	}

	public void switchSSO_LoginToggle() {
		clickandwait(SSO_Login);
	}

	public void enterSSO_EmailDomains(String EmailDomains) {
		SeTText(SSO_EmailDomains, EmailDomains);
	}

	public void clickOnCreateCompanyButton() {
		clickandwait(CreateCompanyButton);
	}

	public void clickOnEnableSSO_Button() {
		clickandwait(EnableSSO_Button);
	}

}