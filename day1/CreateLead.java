package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateLead 
{

	public static void main(String[] args) 
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.partialLinkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Shreen");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Banu");
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("TestLead");
		driver.findElement(By.className("smallSubmit")).click();
		
		String title = driver.getTitle();
		String VisTitle = "View Lead | opentaps CRM";
		if(title.equals(VisTitle)) {
			System.out.println("Title matches");
		}
		
		driver.close();
		
	}
}