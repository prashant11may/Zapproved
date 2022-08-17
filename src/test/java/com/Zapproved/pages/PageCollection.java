package com.Zapproved.pages;

import org.openqa.selenium.WebDriver;

public class PageCollection {

	ThreadLocal<WebDriver> driver;

	public PageCollection(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}

	private SearchCompany searchCompany;
	private AddUser addUser;
	private AddOrganization addOrganization;

	public SearchCompany getSearchCompany() {

		return (searchCompany == null) ? searchCompany = new SearchCompany(driver) : searchCompany;

	}

	public AddUser getAddUser() {
		return (addUser == null) ? addUser = new AddUser(driver) : addUser;
	}

	public AddOrganization getAddOrganization() {
		return (addOrganization == null) ? addOrganization = new AddOrganization(driver) : addOrganization;
	}

}