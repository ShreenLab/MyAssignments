package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteLead {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://leaftaps.com/opentaps");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text() = 'Phone']")).click();
		driver.findElement(By.xpath("//input[@name ='phoneNumber']")).sendKeys("88258");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		WebElement leadElement = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a"));
		String leadID = leadElement.getText();
		System.out.println(leadID);
        leadElement.click();
        driver.findElement(By.className("subMenuButtonDangerous")).click();
        
        WebElement verify = driver.findElement(By.xpath("//div[text()='No records to display']"));
        if(verify.isDisplayed()) {
        	System.out.println("deletion successfull");
        }
        else 
        {
        	System.out.println("not successfull");
        	}
        driver.close();
    }
}