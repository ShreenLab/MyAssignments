package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.When;

public class CreateAccountPage extends ProjectSpecificMethods {
	@When("the user enters account name as")
	public CreateAccountPage accountName(){
		getDriver().findElement(By.id("accountName")).sendKeys("Shreen");
		return this;
	}
	@When("the user enters the description as")
	public CreateAccountPage descriptionName() {
		
	    getDriver().findElement(By.name("description")).sendKeys("Selenium Automation Tester");
	    return this;
	}
	@When("the user enters no of eployees as")
	public CreateAccountPage noOfEmployees() {
	    getDriver().findElement(By.id("numberEmployees")).sendKeys("7");
	    return this;
	}
	@When("the user enters official site name as")
	public CreateAccountPage officialSiteName() {
		getDriver().findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		return this;
	}
	@When("the user click submit button")
	public ViewAccountPage clickSave()
	{
		getDriver().findElement(By.className("smallSubmit")).click();
		return new ViewAccountPage();

	}

}
