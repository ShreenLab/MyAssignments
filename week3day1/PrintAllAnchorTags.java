package week3.week3day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllAnchorTags {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/login/");
		List<WebElement> elementsInTagA = driver.findElements(By.tagName("a"));
		for(int i=0; i < elementsInTagA.size() ; i++) {
			WebElement eachElement = elementsInTagA.get(i);
			String text = eachElement.getText();
			System.out.println(text);
		}
		
		// TODO Auto-generated method stub

	}

}
