package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods {

	public MyAccountsPage clickAccounts() {
		driver.findElement(By.xpath("//a[text() = 'Accounts']")).click();
		return new MyAccountsPage();
		
	

	
	}

}
