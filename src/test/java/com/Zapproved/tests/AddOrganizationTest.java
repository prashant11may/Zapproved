package com.Zapproved.tests;

import static utils.DataUtils.getDataFromExcel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Extras.ReportGenerator;
import Extras.RetryUtil;

@Listeners(Extras.Listeneres.class)
public class AddOrganizationTest extends BaseTest {
	String zapproved = "ZapprovedData";

	@Test()
	public void addAnOrganisation() throws Exception {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(getDataFromExcel(zapproved, 1, 1));

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(getDataFromExcel(zapproved, 1, 2),
				getDataFromExcel(zapproved, 1, 3));

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

		ReportGenerator.getExtentReport().log(Status.INFO, "Entered Organization Name Which We want to Add ");
		pages.getAddOrganization().enterOrganizationName(getDataFromExcel(zapproved, 1, 4));

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

	}

//======================================================================================================>	

	@Test(priority = 2)
	public void searchOrganization() throws IOException {
		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(getDataFromExcel(zapproved, 1, 1));

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(getDataFromExcel(zapproved, 1, 2),
				getDataFromExcel(zapproved, 1, 3));

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
			Assert.assertTrue(
					pages.getSearchCompany().enterOrganizationNameToSearch(getDataFromExcel(zapproved, 1, 5)));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Verify Organization Is Searched or Not");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getSearchCompany().searchOrganization(getDataFromExcel(zapproved, 1, 5)));
			;
			return null;
		}, 10);

	}

//======================================================================================================>	

	@Test(priority = 3)
	public void addUserInOrganization() throws IOException {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(getDataFromExcel(zapproved, 1, 1));

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(getDataFromExcel(zapproved, 1, 2),
				getDataFromExcel(zapproved, 1, 3));

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
			Assert.assertTrue(
					pages.getSearchCompany().enterOrganizationNameToSearch(getDataFromExcel(zapproved, 1, 5)));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Searched Organization. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().clickOnSearchedOrganization(getDataFromExcel(zapproved, 1, 5)));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Add User. ");
		pages.getAddUser().clickOnAddUser();

		ReportGenerator.getExtentReport().log(Status.INFO, "Enter User Email to Add User. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().addUsers_Email(getDataFromExcel(zapproved, 1, 6),
					getDataFromExcel(zapproved, 2, 6), getDataFromExcel(zapproved, 3, 6),
					getDataFromExcel(zapproved, 4, 6)), "User Not Add");
			;
			return null;
		}, 10);

	}

//======================================================================================================>
	@Test
	public void addAdminAccess() throws IOException {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(getDataFromExcel(zapproved, 1, 1));

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(getDataFromExcel(zapproved, 1, 2),
				getDataFromExcel(zapproved, 1, 3));

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
			Assert.assertTrue(pages.getSearchCompany().enterOrganizationNameToSearch(getDataFromExcel(zapproved, 1, 5)),
					"Organization Name Is Not Entered");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Searched Organization. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().clickOnSearchedOrganization(getDataFromExcel(zapproved, 1, 5)));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On User Which You wanna give Admin Access. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().addAdminAccess(getDataFromExcel(zapproved, 1, 7),
					getDataFromExcel(zapproved, 2, 7), getDataFromExcel(zapproved, 3, 7),
					getDataFromExcel(zapproved, 4, 7)));
			;
			return null;
		}, 10);

	}

//======================================================================================================>
	@Test
	public void removeAdminAccess() throws IOException {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(getDataFromExcel(zapproved, 1, 1));

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(getDataFromExcel(zapproved, 1, 2),
				getDataFromExcel(zapproved, 1, 3));

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
			Assert.assertTrue(pages.getSearchCompany().enterOrganizationNameToSearch(getDataFromExcel(zapproved, 1, 5)),
					"Organization Name Is Not Entered");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Searched Organization. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().clickOnSearchedOrganization(getDataFromExcel(zapproved, 1, 5)));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On User/Users Which You wanna give Admin Access. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getDeleteUser().removeAdminAccess(getDataFromExcel(zapproved, 1, 8),
					getDataFromExcel(zapproved, 2, 8), getDataFromExcel(zapproved, 3, 8),
					getDataFromExcel(zapproved, 4, 8)));
			;
			return null;
		}, 10);
	}

//======================================================================================================>	

	@Test(priority = 4)
	public void deleteUserFromOrganization() throws IOException {

		ReportGenerator.getExtentReport().log(Status.INFO, "Successfully navigated to the url.");
		pages.getAddOrganization().getURL(getDataFromExcel(zapproved, 1, 1));

		ReportGenerator.getExtentReport().log(Status.INFO, "set email and password.");
		pages.getAddOrganization().SetEmailAndPassword(getDataFromExcel(zapproved, 1, 2),
				getDataFromExcel(zapproved, 1, 3));

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
			Assert.assertTrue(pages.getSearchCompany().enterOrganizationNameToSearch(getDataFromExcel(zapproved, 1, 5)),
					"Orgaization Name Not Entered ");
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Go Button. ");
		pages.getSearchCompany().clickOnGoButton();

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On Searched Organization. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getAddUser().clickOnSearchedOrganization(getDataFromExcel(zapproved, 1, 5)));
			;
			return null;
		}, 10);

		ReportGenerator.getExtentReport().log(Status.INFO, "Clicked On User's E-mails Which you wanna Delete. ");
		RetryUtil.retry(() -> {
			Assert.assertTrue(pages.getDeleteUser().deleteUsers(getDataFromExcel(zapproved, 1, 8),
					getDataFromExcel(zapproved, 2, 8), getDataFromExcel(zapproved, 3, 8),
					getDataFromExcel(zapproved, 4, 8)));
			;
			return null;
		}, 10);
	}

}
