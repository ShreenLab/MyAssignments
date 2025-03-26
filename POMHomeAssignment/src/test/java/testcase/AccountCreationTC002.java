package testcase;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class AccountCreationTC002 extends ProjectSpecificMethods{
	@Test
	public void runCreateAccount() {
		new LoginPage().enterUserName().enterPassword().clickLogin()
		.clickCRM()
		.clickAccounts()
		.clickCreateAccount()
		.accountName()
		.descriptionName()
		.noOfEmployees()
		.officialSiteName().clickSave().viewAccount();

	}

}
