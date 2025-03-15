package week3.week3day4;

import java.io.File;
import java.time.Duration;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException, IOException  {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.bigbasket.com/");
		
		driver.findElement(By.id("headlessui-menu-button-:R5bab6:")).click();
		
		Thread.sleep(1000);
		
		// Mouse hovering to elements
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		action.moveToElement(driver.findElement(By.linkText("Foodgrains, Oil & Masala"))).perform();
		
		action.moveToElement(driver.findElement(By.linkText("Rice & Rice Products"))).perform();
		
		action.moveToElement(driver.findElement(By.linkText("Boiled & Steam Rice"))).click().perform();
		
		
		 WebElement brand = driver.findElement(By.xpath("//input[@id='i-BBRoyal']"));
		   wait.until(ExpectedConditions.visibilityOf(brand));
		 	action.moveToElement(brand).click(brand).perform();
		 	action.pause(1000).perform();
		
		action.scrollToElement(driver.findElement(By.xpath("//div[@class='break-words h-10 w-full']/h3[contains(text(),'Tamil Ponni Boiled Rice')]"))).perform();
		
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='10 kg - Bag']")));
		
		driver.executeScript("arguments[0].click()", driver.findElement(By.linkText("Show more")));
		
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='5 kg']")));
		
		// Checking for the price
		String price = driver.findElement(By.xpath("//h1[contains(text(),'bb Royal Tamil Ponni Boiled Rice, 5 kg (12-17 Mont')]//following::td[@class='Description___StyledTd-sc-82a36a-4 fLZywG']")).getText();
		System.out.println("Price of the product selected: "+price);
		
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div/button[text()='Add to basket']")));
		
		Thread.sleep(1000);
		WebElement message = driver.findElement(By.xpath("//div[@class='self-center']/following-sibling::p"));
	
		// Get text using JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;      
        String textDisplayed= (String) js.executeScript("return arguments[0].textContent;", message);
        System.out.println("Tooltip message: " + textDisplayed);
		
        if(message.isDisplayed())
        	System.out.println("Message is succesfully Displayed");
        else
        	System.out.println("Message is not succesfully Displayed");
              
        // Screenshot
        File scr = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./BigBasket/BBPage.png");
		FileUtils.copyFile(scr, target);
		
		driver.close();

	}

}
