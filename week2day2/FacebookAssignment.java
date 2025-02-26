package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookAssignment {

	public static void main(String[] args) throws InterruptedException 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys("mile");
		driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys("murph");
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("99934");
		driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys("secret");
		Select date = new Select(driver.findElement(By.xpath("//select[@aria-label='Day']")));
		date.selectByValue("31");
		Select month = new Select(driver.findElement(By.xpath("//select[@aria-label='Month']")));
		month.selectByValue("4");
		Select year = new Select(driver.findElement(By.xpath("//select[@aria-label='Year']")));
		year.selectByValue("2000");
		driver.findElement(By.xpath("//label[text() = 'Female']")).click();

	}

}
