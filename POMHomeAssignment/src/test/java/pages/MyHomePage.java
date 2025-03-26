package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.When;

public class MyHomePage extends ProjectSpecificMethods {
	@When("the user clicks the accounts menu")
	public MyAccountsPage clickAccounts() {
		getDriver().findElement(By.xpath("//a[text() = 'Accounts']")).click();
		return new MyAccountsPage();
		
	

	
	}

}
