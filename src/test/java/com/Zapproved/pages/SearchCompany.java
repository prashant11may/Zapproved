package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchCompany extends BasePage {

	public SearchCompany(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By GoButton = By.xpath("//span[normalize-space()='GO']");

	By SearchOrganization = By.xpath("//input[@placeholder='Search Organizations']");

	public void enterOrganizationNameToSearch(String CompanyName) {
		waitforelementtoBecomePresent(SearchOrganization);
		SetText(SearchOrganization, CompanyName);
		// PressEnter();
	}

	public void clickOnGoButton() {
		waitforelementtoBecomeclickable(GoButton);
		clickandwait(GoButton);
		waitforLoaderToAppear();
	}

	public void searchedCompany(String CompanyName) {

		By Table = By.xpath("//tbody[@class='ui-table-tbody']//tr//td[1]");
		int rowCount = driver.get().findElements(Table).size();
		for (int i = 1; i <= rowCount; i++) {
			WebElement actvalue = driver.get()
					.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]//td[1]"));
			if (actvalue.getText().equals(CompanyName)) {
				waitforelementtoBecomeclickable(actvalue);
				actvalue.click();
				System.out.println("Search Result is :" + actvalue.getText());
				break;
			} else {
				System.out.println("Organization Nou Found");
			}
			break;
		}
	}

}
