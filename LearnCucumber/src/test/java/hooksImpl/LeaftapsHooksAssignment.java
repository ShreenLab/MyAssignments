package hooksImpl;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class LeaftapsHooksAssignment extends stepsForCucumber.CommonBaseForLead{
	@Before
	public void preConditions() throws InterruptedException
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("CRM")).click();
		

	}
	
	/*@After
	public void postConditions() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		
	}*/
}
