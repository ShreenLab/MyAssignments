package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLogin {

	public static void main(String[] args) 
	{
		//Instantiating the browser driver
		FirefoxDriver driver = new FirefoxDriver();
		//gettig the webpage and trying to login
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Find your account and log in.")).click();
		//getting the current title and check if it matches the visible title
		String Tit = driver.getTitle();
		System.out.println(Tit);
		String VisibleTitle = "Forgotten Password | Can't Log In | Facebook";
		if(Tit.equals(VisibleTitle)) {
			System.out.println("Title matches");
		}
		driver.close();
	}

}
