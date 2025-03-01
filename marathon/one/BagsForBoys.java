package marathon.one;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BagsForBoys {

	public static void main(String[] args) throws InterruptedException 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags for boys");
		driver.findElement(By.xpath("//div[text()='bags for boys']")).click();
		String numberOf = driver.findElement(By.xpath("//span[contains(text(),'results')]")).getText();
		String bagsForBoys = driver.findElement(By.xpath("//span[contains(text(),'results')]/following::span[2]")).getText();
		System.out.println(numberOf + bagsForBoys );
        driver.findElement(By.xpath("//div[@id = 'brandsRefinements']/ul//span[text()='Skybags']")).click();
	    driver.findElement(By.xpath("//div[@id = 'brandsRefinements']/ul//span[text()='Safari']")).click();
	    driver.findElement(By.xpath("//span[text()='Featured']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		String name=driver.findElement(By.xpath("//span[text()='Safari']")).getText();
		System.out.println("bag name is " +name);
		String bag=driver.findElement(By.xpath("//div[contains(@class,'top-small s-price-instructions-style')][1]")).getText();
		System.out.println("Price of the bag is " +bag);
		String title=driver.getTitle();
		System.out.println(title);
		
		
		

	}

}
