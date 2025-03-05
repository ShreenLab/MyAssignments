package week3.week3day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandlingHomeAssignment {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//- Enter the username and password. 
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//- Click on the Login button.
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		// Click on the CRM/SFA link. 
		driver.findElement(By.linkText("CRM/SFA")).click();
		//- Click on the Contacts button. 
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		// Click on Merge Contacts. 
		driver.findElement(By.xpath("//a[contains(text(), 'Merge Contacts')]")).click();
		// Click on the widget of the "From Contact".
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
		//switch to resulting child window and click on the first resulting contact. 
		Set<String> setWindowHandles = driver.getWindowHandles();
		List<String> listWindowHandles = new ArrayList<String> (setWindowHandles);
		driver.switchTo().window(listWindowHandles.get(1));
		driver.findElement(By.xpath("//a[text() = 'DemoCustomer']")).click();
		//getting back to parent window and  Click on the widget of the "To Contact". 
		driver.switchTo().window(listWindowHandles.get(0));
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		//switch to resulting child window and click on the first resulting contact. 
		Set<String> setWindowHandlesTwo = driver.getWindowHandles();
		List<String> listWindowHandlesTwo = new ArrayList<String>(setWindowHandlesTwo);
		driver.switchTo().window(listWindowHandlesTwo.get(1));
		driver.findElement(By.xpath("//a[text() = 'DemoLBCust']")).click();
	    //back to parent window and click merge	
		driver.switchTo().window(listWindowHandles.get(0));
		driver.findElement(By.xpath("//a[text() = 'Merge']")).click();
        //switch to alert and accept it
		Alert alertWindow = driver.switchTo().alert();
		alertWindow.accept();
		//getting title and print it
		String title = driver.getTitle();	
		System.out.println(title);
		
		
		

	}

}
