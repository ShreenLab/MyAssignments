package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.When;

public class WelcomePage extends ProjectSpecificMethods {
	@When("the user clicks the crsmfa link")
	public MyHomePage clickCRM() {
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();

}
}
