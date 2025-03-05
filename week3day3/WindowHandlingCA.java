package week3.week3day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingCA {

	public static void main(String[] args) 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.irctc.co.in/");		
		driver.findElement(By.xpath("//a[contains(@aria-label,'Menu Flight')]")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		List<String> listAllWindowHandles = new ArrayList<String>(allWindowHandles);
		WebDriver childWindow = driver.switchTo().window(listAllWindowHandles.get(1));
		System.out.println("The title of child window is " + childWindow.getTitle() );
		driver.switchTo().window(listAllWindowHandles.get(0));
		driver.close();
		
		
	}

}
