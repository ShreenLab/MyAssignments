package week3.week3day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDealActions 
{

	public static void main(String[] args) throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text() = concat(\"Men\", \"'s Fashion\")]"))).perform();
		driver.findElement(By.xpath("//span[text() = 'Sports Shoes']")).click();
		String shoeCount = driver.findElement(By.xpath("//h1[@class = 'category-name']/following-sibling::span")).getText();
		System.out.println("The number of shoes are " + shoeCount);
		driver.findElement(By.xpath("//div[text() = 'Training Shoes']")).click();
		action.moveToElement(driver.findElement(By.xpath("//span[text() = 'Sort by:']"))).click().perform();
		driver.findElement(By.xpath("//ul[@class ='sort-value']/li[2]")).click();
//verifying the selected option
		String sortMethod = driver.findElement(By.xpath("//div[@class = 'sort-selected']")).getText();
		if(sortMethod.equalsIgnoreCase("Price Low To High")) 
		{
			System.out.println("correct option is selected");
		}
		else 
		{
				System.out.println("wrong option is selected");
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement fromVal = driver.findElement(By.xpath("//input[@name = 'fromVal']"));
		action.moveToElement(fromVal).perform();
		js.executeScript("arguments[0].click()", fromVal);
		fromVal.clear();
		fromVal.sendKeys("500");
		
//toValue
		WebElement toVal = driver.findElement(By.xpath("//input[@name ='toVal']"));
		action.moveToElement(toVal).perform();
		js.executeScript("arguments[0].click()", toVal);
		toVal.clear();
		toVal.sendKeys("600");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		WebElement color = driver.findElement(By.xpath("//label[@for ='Color_s-Black']"));
		js.executeScript("arguments[0].click()", color);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Set<String> allOpenedWindows = driver.getWindowHandles();
		
		List<String> shiftFocusTo = new ArrayList<String>(allOpenedWindows);
		driver.switchTo().window(shiftFocusTo.get(0));
		
		WebElement quickViewButton = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		wait.until(ExpectedConditions.visibilityOf(quickViewButton));		
		quickViewButton.click();
        String discount = driver.findElement(By.xpath("(//span[@class='pdpDiscount ']/span)[1]")).getText();
		
		System.out.println("Discounted Percentage is : "+ discount + "%" );
				
		driver.findElement(By.xpath("//div[@class='col-xs-6 marR15 btn btn-xl btn-theme-secondary rippleWhite buyLink']")).click();
		
		String price = driver.findElement(By.xpath("//div[@class='you-pay']/span")).getText();
		
		System.out.println("Price of the shoe is :"+price);
		
		// Taking screenshot
		File scr = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./SnapDealpage/shoe.png");
		FileUtils.copyFile(scr, target);
				
	    driver.close();
	    
	    driver.switchTo().window(shiftFocusTo.get(0));
	    
	    driver.close();
		
		}
		
		
		

	

}
