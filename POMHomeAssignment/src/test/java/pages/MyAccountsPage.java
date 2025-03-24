package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class MyAccountsPage extends ProjectSpecificMethods{

	public CreateAccountPage clickCreateAccount() {
		driver.findElement(By.linkText("Create Account")).click();
		return new CreateAccountPage();
		

	}

}
