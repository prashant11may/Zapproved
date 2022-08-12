package com.Zapproved.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Extras.ReportGenerator;
import Extras.RetryUtil;

@Listeners(Extras.Listeneres.class)
public class AddCompanyTest extends BaseTest {

	String Company = "Test Company";

	@Test
	public void addAnOrganisation() throws Exception {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getLoginPage().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getLoginPage().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getLoginPage().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Settings ");
		pages.getLoginPage().clickOnSettings();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add Company button ");
		pages.getLoginPage().clickOnAddCompany();

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered A Company Name ");
		pages.getLoginPage().enterCompanyName(Company);

//		ReportGenerator.getExtentReport().log(Status.INFO, "Upload A Company logo ");
//		pages.getLoginPage().uploadCompanyLogo(PathToInputPNG);

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Custom Logout URL.");
		pages.getLoginPage().enterCustomLogoutURL("https://www.test.com");

		ReportGenerator.getExtentReport().log(Status.INFO, "Switch SSO Login Toggle.");
		pages.getLoginPage().switchSSO_LoginToggle();

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered SSO Email Domain.");
		pages.getLoginPage().enterSSO_EmailDomains("www.test.com");

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Custom Logout URL.");
		pages.getLoginPage().clickOnCreateCompanyButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Click On Eable SSO Button.");
		pages.getLoginPage().clickOnEnableSSO_Button();
	}

	@Test
	public void searchAnOrganisation() {
		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getLoginPage().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getLoginPage().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getLoginPage().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Settings ");
		pages.getLoginPage().clickOnSettings();

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Company Name Which you Want To search");
		pages.getSearchCompany().enterCompanyNameToSearch("Test Company");

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getSearchCompany().clickOnGoButton(), "Delete button is visible");
			return null;
		}, 2);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().searchedCompany(Company);

	}

}