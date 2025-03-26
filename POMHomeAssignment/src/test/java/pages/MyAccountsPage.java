package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.When;

public class MyAccountsPage extends ProjectSpecificMethods{
	@When("the user clicks the create account menu")
	public CreateAccountPage clickCreateAccount() {
		getDriver().findElement(By.linkText("Create Account")).click();
		return new CreateAccountPage();
		

	}

}
