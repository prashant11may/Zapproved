package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchCompany extends BasePage {

	public SearchCompany(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By GoButton = By.xpath("//span[normalize-space()='GO']");

	By SearchOrganization = By.xpath("//input[@placeholder='Search Organizations']");

	public void enterOrganizationNameToSearch(String CompanyName) {
		waitforelementtoBecomePresent(SearchOrganization);
		SetText(SearchOrganization, CompanyName);
	}

	public void clickOnGoButton() {
		waitforelementtoBecomeclickable(GoButton);
		clickandwait(GoButton);
		Sleep(4);

	}

	public void searchedCompany(String CompanyName) {

		By Table = By.xpath("//tbody[@class='ui-table-tbody']//tr//td[1]");
		waitforelementtoBecomeclickable(Table);
		int rowCount = driver.get().findElements(Table).size();
		for (int i = 1; i <= rowCount; i++) {
			String actvalue = driver.get()
					.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]//td[1]")).getText();
			if (actvalue.equals(CompanyName)) {
				System.out.println("Search Organization is :" + actvalue);
				break;
			}
		}
	}

}
