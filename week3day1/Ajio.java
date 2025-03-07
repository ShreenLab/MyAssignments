package week3.week3day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajio {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.ajio.com/");
//search bags
		driver.findElement(By.xpath("//input[@aria-label = 'Search Ajio']")).sendKeys("bags");
		driver.findElement(By.xpath("//button[@type='submit']//span[1]")).click();
//filtering men
		driver.findElement(By.xpath("//input[contains(@name, 'genderfilter') and contains(@id, 'Men')]/following-sibling::label")).click();
		Thread.sleep(6000);
		WebElement fashionBags = driver.findElement(By.xpath("//input[@id='Men - Fashion Bags']/following-sibling::label[@for='Men - Fashion Bags']"));
        fashionBags.click();
        String fashionBag = fashionBags.getText();
        System.out.println("Number of fashion bags for men displaying is " + fashionBag);
        List<WebElement> brandNames = driver.findElements(By.xpath("//a[descendant::div[@class='brand']]//strong"));
        System.out.println("-------The brand names displaying are----");
        for(int i=0; i < brandNames.size(); i++)
        {
        	WebElement brands = brandNames.get(i);
        	String brName = brands.getText();
        	System.out.println(brName);
        }
        
        List<WebElement> names = driver.findElements(By.xpath("//div[@class = 'brand'] /following-sibling::div[@class='nameCls']"));
        System.out.println("------------The names of bags displaying are---------");
        for(int i = 0; i<names.size();i++)
        {
        	WebElement bagName = names.get(i);
        	String namesOfBags = bagName.getText();
        	System.out.println(namesOfBags);
        	
        }
        driver.close();
	}

}
