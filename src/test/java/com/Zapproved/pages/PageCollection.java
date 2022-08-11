package com.Zapproved.pages;

import org.openqa.selenium.WebDriver;

public class PageCollection {

	ThreadLocal<WebDriver> driver;

	public PageCollection(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}

	private AddCompany loginPage;
	private SearchCompany searchCompany;

	public AddCompany getLoginPage() {

		return (loginPage == null) ? loginPage = new AddCompany(driver) : loginPage;
	}

	public SearchCompany getSearchCompany() {

		return (searchCompany == null) ? searchCompany = new SearchCompany(driver) : searchCompany;

	}

}