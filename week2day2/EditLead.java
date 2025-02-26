package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
//instantiating the browser
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
//filling the create lead form
		driver.findElement(By.xpath("//input[contains(@id,'companyName')]")).sendKeys("myCompany");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Miles");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Murph");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Milo");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Production");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("productMaking");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@def.com");
// selecting state using select class
		Select state = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
		state.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@value = 'Create Lead']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("It is important");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
	//getting title
		 String actualTitle = driver.getTitle();
		 System.out.println(actualTitle);
		 
		 driver.close();

	}

}
