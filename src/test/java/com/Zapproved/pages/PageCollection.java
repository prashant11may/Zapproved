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
	private UserSearch userSearch;
	private DeleteUser deleteUser;

	public SearchCompany getSearchCompany() {
//variable x=(expression)?value if true:value if false;
		return (searchCompany == null) ? searchCompany = new SearchCompany(driver) : searchCompany;

	}

	public AddUser getAddUser() {
		return (addUser == null) ? addUser = new AddUser(driver) : addUser;
	}

	public AddOrganization getAddOrganization() {
		return (addOrganization == null) ? addOrganization = new AddOrganization(driver) : addOrganization;
	}

	public UserSearch getUserSearch() {
		return (userSearch == null) ? userSearch = new UserSearch(driver) : userSearch;

	}

	public DeleteUser getDeleteUser() {
		return (deleteUser == null) ? deleteUser = new DeleteUser(driver) : deleteUser;

	}
}