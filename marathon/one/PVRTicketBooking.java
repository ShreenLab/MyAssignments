package marathon.one;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class PVRTicketBooking {

	public static void main(String[] args) throws InterruptedException
	{
//Launch the Browser
		ChromeDriver driver = new ChromeDriver();
//Load the Url "https://www.pvrcinemas.com/"
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Click on Cinema under Quick Book
		driver.findElement(By.xpath("//span[text() = 'Cinema']")).click();
		driver.findElement(By.id("cinema")).click();
		Thread.sleep(2000);
//Select Your Cinema
		driver.findElement(By.xpath("//span[text()='INOX Prozone Mall,Saravanampatty, Sathy Road Coimbatore']")).click();
		Thread.sleep(2000);
// Select Your Date as Tomorrow
		driver.findElement(By.xpath("//span[contains(text(),'Tomorrow')]")).click();
//Select Your Movie
		driver.findElement(By.xpath("(//span[text()='Select Movie']/following::span[text()='AGHATHIYAA'])[2]")).click();
//select your show time		
		driver.findElement(By.xpath("//span[text() = '01:00 PM']")).click();
//click on book button
		driver.findElement(By.xpath("//div[@class='quick-lefts ']//button[1]")).click();
//accept terms and conditions
		driver.findElement(By.xpath("//button[text() = 'Accept']")).click();
		driver.findElement(By.xpath("//td[@class='seats-col']/span[@class='seat-current-pvr'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text() = 'Proceed']")).click();
//booking seat and getting seat information
		WebElement bookingInfo = driver.findElement(By.xpath("//div[@class='ticket-value']/p[contains(text(),'EXECUTIVE')]"));
		String info = bookingInfo.getText();
		System.out.println("seat type is " + info);
		String amount = driver.findElement(By.xpath("//div[@class='food-pay-amount']")).getText();
		System.out.println(amount);
		String summ = driver.findElement(By.xpath("//div[@class='movies-summary']")).getText();
		System.out.println(summ);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.findElement(By.xpath("(//div[@class='cinema-house mobile-login-M'])[2]/preceding::i[1]")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		
	
		
		}
	

}
