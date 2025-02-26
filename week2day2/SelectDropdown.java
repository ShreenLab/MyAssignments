package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown 
{

	public static void main(String[] args) throws InterruptedException 
	{
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
		WebElement name = driver.findElement(By.id("accountName"));
		name.sendKeys("ShreenTest009");
		String acctName = name.getAttribute("value");
		System.out.println(acctName);
	    driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
	    Select industryDropdown = new Select(driver.findElement(By.name("industryEnumId")));
	    industryDropdown.selectByVisibleText("Computer Software");
	    Select ownership = new Select(driver.findElement(By.name("ownershipEnumId")));
	    ownership.selectByVisibleText("S-Corporation");
	    Select source = new Select(driver.findElement(By.name("dataSourceId")));
	    source.selectByValue("LEAD_EMPLOYEE");
	    Select marketingCampaign = new Select(driver.findElement(By.id("marketingCampaignId")));
	    marketingCampaign.selectByIndex(6);
	    Select stateProvince = new Select(driver.findElement(By.id("generalStateProvinceGeoId")));
	    stateProvince.selectByValue("TX");
	    driver.findElement(By.className("smallSubmit")).click();
//verifying acct name
	    if(acctName.equals("ShreenTest009")) {
	    	System.out.println("acct name is verified");}
	    else
	    {
	    		System.out.println("not verified");
	    	}
	    }		
	
}
