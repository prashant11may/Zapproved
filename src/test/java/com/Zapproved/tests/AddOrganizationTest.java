package com.Zapproved.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Extras.ReportGenerator;
import Extras.RetryUtil;

@Listeners(Extras.Listeneres.class)
public class AddOrganizationTest extends BaseTest {

	String Company = "xyzzz Organization";

	@Test
	public void addAnOrganisation() throws Exception {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getAddOrganization().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Settings. ");
		pages.getAddOrganization().clickOnSettings();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On LHP Admin. ");
		pages.getAddOrganization().clickOnLHP_Admin();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add Organization. ");
		pages.getAddOrganization().clickOnAddOrganization();

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Organization Name ");
		pages.getAddOrganization().enterOrganizationName(Company);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add button ");
		pages.getAddOrganization().clickOnAddButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Check Organization is Create or Not ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddOrganization().checkOrganization(),
					"Organization Not Created Or Organization Already Created");
			;
			return null;
		}, 10);

	}

	@Test
	public void searchOrganization() {
		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getAddOrganization().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Settings ");
		pages.getAddOrganization().clickOnSettings();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On LHP Admin. ");
		pages.getAddOrganization().clickOnLHP_Admin();

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Organization Name Which you Want To search");
		pages.getSearchCompany().enterOrganizationNameToSearch(Company);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().searchedCompany(Company);

	}

	@Test
	public void addUserInOrganization() {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getAddOrganization().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Settings ");
		pages.getAddOrganization().clickOnSettings();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On LHP Admin. ");
		pages.getAddOrganization().clickOnLHP_Admin();

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Organization Name Which you Want To search");
		pages.getSearchCompany().enterOrganizationNameToSearch(Company);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Searched Organization. ");
		pages.getAddUser().clickOnSearchedOrganization(Company);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add User. ");
		pages.getAddUser().clickOnAddUser();

		ReportGenerator.getExtentReport().log(Status.INFO, "Enter User Email. ");
		pages.getAddUser().addUser("WWW1@Zapproved.com");

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add Button. ");
		pages.getAddUser().clickOnAdd();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Dots. ");
		pages.getAddUser().clickOnDots();

		ReportGenerator.getExtentReport().log(Status.INFO, "Add Admin Access To User. ");
		pages.getAddUser().addAdminAccess();
	}

}
