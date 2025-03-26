package testcase;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginTC001 extends ProjectSpecificMethods{
	@Test
	public void runCreateAccount() {
		new LoginPage().enterUserName().enterPassword().clickLogin();

	}

}
