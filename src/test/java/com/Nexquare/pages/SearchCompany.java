package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchCompany extends BasePage {

	public SearchCompany(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By GoButton = By.xpath("//span[normalize-space()='GO']");

	By SearchOrganization = By.xpath("//input[@placeholder='Search Organizations']");

	public boolean enterOrganizationNameToSearch(String CompanyName) {
		SetText(SearchOrganization, CompanyName);
		return isElementPresent(SearchOrganization);
	}

	public void clickOnGoButton() {

		clickandwait(GoButton);

	}

	public boolean searchOrganization(String Organization) {
		By SearchOrganizations = By.xpath("//span[normalize-space()='" + Organization + "']");
		return isElementPresent(SearchOrganizations);
	}

}
