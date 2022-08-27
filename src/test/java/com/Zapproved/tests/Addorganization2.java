package com.Zapproved.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Extras.ReportGenerator;
import Extras.RetryUtil;
import utils.TestUtils;

@Listeners(Extras.Listeneres.class)
public class Addorganization2 extends BaseTest {

	String Company = "#AutomationDemo";

	@Test(priority = 1)
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
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddOrganization().clickOnLHP_Admin(), "LHP Admin Is Not Clicked");
			;
			return null;
		}, 20);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add Organization. ");
		pages.getAddOrganization().clickOnAddOrganization();

		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddOrganization().isOrganizationFieldVisible(),
					"Organization Field Is Not Visible");
			;
			return null;
		}, 20);

		String RandomOrg = TestUtils.uniqueTextGenerator("#AutomationDemo");

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Organization Name ");
		pages.getAddOrganization().enterOrganizationName(RandomOrg);

		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddOrganization().isAddButtonVisible(), "Add Button Is Not Visible");
			;
			return null;
		}, 20);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add button ");
		pages.getAddOrganization().clickOnAddButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Check Organization is Create or Not ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddOrganization().checkOrganization(),
					"Organization Not Created Or Organization Already Created");
			;
			return null;
		}, 10);

		Company = RandomOrg;
	}

	@Test(priority = 2)
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
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddOrganization().clickOnLHP_Admin(), "LHP Admin Is Not Clicked");
			;
			return null;
		}, 20);

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Organization Name Which you Want To search");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getSearchCompany().enterOrganizationNameToSearch(Company));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getSearchCompany().searchOrganization(Company));
			;
			return null;
		}, 10);

	}

	@Test(priority = 3)
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
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddOrganization().clickOnLHP_Admin(), "LHP Admin Is Not Clicked");
			;
			return null;
		}, 20);

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Organization Name Which you Want To search");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getSearchCompany().enterOrganizationNameToSearch(Company));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Searched Organization. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().clickOnSearchedOrganization(Company));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add User. ");
		pages.getAddUser().clickOnAddUser();

		ReportGenerator.getExtentReport().log(Status.INFO, "Enter User Email. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().addUser_Email("www1@zapproved.com"));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add Button. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().clickOnAdd());
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Dots. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().clickOnDots("www1@zapproved.com"));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked on Add Admin Access . ");
		pages.getAddUser().addAdminAccess();

		ReportGenerator.getExtentReport().log(Status.INFO, "Verify Popup Admin Access Added. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().clickOnAddButtonOfAddAdminAccess());
			;
			return null;
		}, 10);
	}

	@Test(priority = 4)
	public void deleteUserFromOrganization() {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(prop.URL());

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(prop.UserName(), prop.PWD());

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Login Button.");
		pages.getAddOrganization().ClickOnLoginButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Settings ");
		pages.getAddOrganization().clickOnSettings();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On LHP Admin. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddOrganization().clickOnLHP_Admin(), "LHP Admin Is Not Clicked");
			;
			return null;
		}, 20);

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Organization Name Which you Want To search");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getSearchCompany().enterOrganizationNameToSearch(Company));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Searched Organization. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().clickOnSearchedOrganization(Company));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Dots. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getDeleteUser().clickOnDots("www1@zapproved.com"));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Delete User. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getDeleteUser().clickOnDeleteButton());
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Delete When Pop_Up Occurs ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getDeleteUser().clickOnDelete());
			;
			return null;
		}, 10);

	}

}
