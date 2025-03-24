package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class CreateAccountPage extends ProjectSpecificMethods {

	public CreateAccountPage accountName(){
		driver.findElement(By.id("accountName")).sendKeys("Shreen");
		return this;
	}
	public CreateAccountPage descriptionName() {
		
	    driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
	    return this;
	}
	public CreateAccountPage noOfEmployees() {
	    driver.findElement(By.id("numberEmployees")).sendKeys("7");
	    return this;
	}
	public CreateAccountPage officialSiteName() {
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		return this;
	}
	public ViewAccountPage clickSave()
	{
	
		driver.findElement(By.className("smallSubmit")).click();
		return new ViewAccountPage();

	}

}
