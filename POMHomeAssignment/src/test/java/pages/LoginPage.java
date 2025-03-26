package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.When;

public class LoginPage extends ProjectSpecificMethods{
	@When("the user enters the username as")
	public LoginPage enterUserName() {	
		getDriver().findElement(By.id("username")).sendKeys("Demosalesmanager");
		return this;
	}
	@When("the user enters the password as")
	public LoginPage enterPassword() {
		getDriver().findElement(By.id("password")).sendKeys("crmsfa");
		return this;

	}
	@When("the user clicks the login button")
	public WelcomePage clickLogin() {
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage();

	}
}
