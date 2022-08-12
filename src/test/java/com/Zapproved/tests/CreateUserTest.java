package com.Zapproved.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Extras.ReportGenerator;

@Listeners(Extras.Listeneres.class)
public class CreateUserTest extends BaseTest {

	@Test
	public void createAnUser() {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getLoginPage().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getLoginPage().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getLoginPage().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Settings ");
		pages.getLoginPage().clickOnSettings();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Settings ");
		pages.getCreateUser().clickOnUsers();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On users ");
		pages.getCreateUser().clickOnAddUser();

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered The First Name ");
		pages.getCreateUser().enterTheFirstName("Automation");

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered The Last Name ");
		pages.getCreateUser().enterTheLastName("Testing");

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered The Emailed Address ");
		pages.getCreateUser().enterTheEmailAddress("Testing@gmail.com");

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Create User Button ");
		pages.getCreateUser().clickOnCreateUser();

	}
}
