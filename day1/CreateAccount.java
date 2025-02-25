package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException 
	{
		//initializing webdriver
		FirefoxDriver driver = new FirefoxDriver();
		//get the website using .get() method
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//finding the elements using basic locators
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Accounts")).click();
        driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("ShreenTestLea");
	    driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
	    driver.findElement(By.id("numberEmployees")).sendKeys("7");
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		driver.findElement(By.className("smallSubmit")).click();
	    Thread.sleep(1000);
	    //comparing the displayed title matches the actual title
	    String Title = driver.getTitle();
	    String Actual_title = "Create Account | opentaps CRM";
	    if(Title.equals(Actual_title)) {
	    	System.out.println("Title is displayed correctly");
	    }
	   driver.close();
	    
		

	}


}
