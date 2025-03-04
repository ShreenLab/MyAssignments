package week3.week3day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
//switching to frame
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(), 'Try it')]")).click();
		Alert tryAlert = driver.switchTo().alert();
		tryAlert.sendKeys("Shreen");
		tryAlert.accept();
		String name = driver.findElement(By.id("demo")).getText();
        if(name.contains("Shreen")) {
            System.out.println("Text Matching");
        } else {
            System.out.println("Text Not Matching");
        }

		driver.close();
		

	}

}
