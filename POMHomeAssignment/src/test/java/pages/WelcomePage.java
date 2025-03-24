package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods {
	public MyHomePage clickCRM() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();

}
}
