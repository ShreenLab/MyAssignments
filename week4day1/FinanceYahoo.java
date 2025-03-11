package week4.week4day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://finance.yahoo.com/");
		Actions action = new Actions(driver);
		WebElement more = driver.findElement(By.xpath("//button[@aria-label = 'More']"));
		action.moveToElement(more).build().perform();
		WebElement crypto = driver.findElement(By.xpath("//a[@aria-label = 'Finance: Crypto']"));
		action.moveToElement(crypto).click().perform();
//number of rows in table
		List<WebElement> rowsInTable = driver.findElements(By.xpath("//table[@data-testid = 'table-container']//tbody/tr"));
		System.out.println("the number of rows in the table is " + rowsInTable.size());
//list crypt currency name column
		List<WebElement> secondColumnElements = driver.findElements(By.xpath("//table[@data-testid = 'table-container']//tbody/tr/td[2]"));
		for( int i= 1; i <= secondColumnElements.size(); i++)
		{
			WebElement col = driver.findElement(By.xpath("//table[@data-testid = 'table-container']//tbody/tr["+i+"]/td[2]"));
			String cryptoNames = col.getText();
			System.out.println(cryptoNames);
		
		}
	}

}
