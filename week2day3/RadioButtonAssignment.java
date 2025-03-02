package week2.week2day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonAssignment 
{

	public static void main(String[] args) throws InterruptedException 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
//clicking my favorite browser
		List<org.openqa.selenium.WebElement> browser = driver.findElements(By.xpath("//label[text()='Chrome']/parent::td//div[contains(@class, 'ui-radiobutton-box')]"));
		browser.get(0).click();
		Thread.sleep(3000);
//verifying if it is selected
		WebElement chrome = driver.findElement(By.xpath("//label[text()='Chrome']/parent::td//div[contains(@class, 'state-active')]"));
		System.out.println("The selected element displaying state is " + chrome.isDisplayed());
//clicking the same button again	
		List<org.openqa.selenium.WebElement> browser1 = driver.findElements(By.xpath("//label[text()='Chrome']/parent::td//div[contains(@class, 'ui-radiobutton-box')]"));
		browser1.get(0).click();
//verifying again
		WebElement chrome1 = driver.findElement(By.xpath("//label[text()='Chrome']/parent::td//div[contains(@class, 'state-active')]"));
		System.out.println("The selected element displaying state is " + chrome1.isDisplayed() + " again");
        Thread.sleep(3000);
		
//find default selected button
        WebElement defaultclicked = driver.findElement(
				By.xpath("//h5[text()='Find the default select radio button']/following-sibling::div//span[contains(@class,'ui-icon-bullet')]"));
		
		
		if (defaultclicked.isDisplayed() == true) 
		{		
			WebElement defaultselected = driver.findElement(
					By.xpath("//h5[text()='Find the default select radio button']/following-sibling::div//span[contains(@class,'ui-icon-bullet')]/ancestor::div[contains(@class,'ui-radiobutton')]/following-sibling::label"));		
			
			System.out.println("Default Radio button is selected is "+ defaultselected.getText());			
		}
		else 
		{
			System.out.println("Default Radio button is not selected");
			
		}
			
		WebElement agegroup = driver.findElement(By.xpath("//div[@id='j_idt87:age']/div[1]/div[2]/div[1]/div[2]/span[1]"));
		if (agegroup.isDisplayed() == true) 
		{
			System.out.println("21-40 years radio button is already selected ");
			} 
		else
			{		
			System.out.println("21-40 years radio button is not selected ");
			}
	    
	    //

	}
}