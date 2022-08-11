package com.Zapproved.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchCompany extends BasePage {

	public SearchCompany(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	By SearchCompanies = By.xpath("//input[@placeholder='Search Companies']");

	By GoButton = By.xpath("//span[normalize-space()='GO']");

	public void enterCompanyNameToSearch(String CompanyName) {
		SetText(SearchCompanies, CompanyName);
	}

	public boolean clickOnGoButton() {
		clickandwait(GoButton);
		return true;
	}

	public void searchedCompany(String CompanyName) {
		Sleep(4);
		By Table = By.xpath("//tbody[@class='ui-table-tbody']//tr//td[1]");
		int rowCount = driver.get().findElements(Table).size();
		for (int i = 1; i <= rowCount; i++) {
			String actvalue = driver.get()
					.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]//td[1]")).getText();
			if (actvalue.equals(CompanyName)) {
				String Company = actvalue;
				System.out.println("Search Result is :" + actvalue);
				break;
			}

		}
	}

}
