package week3.week3day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonActionHomeAssignment {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();		
		WebElement firstTextLink = driver.findElement(By.xpath("//h2[contains(@aria-label , 'Sponsored Ad')]/span"));
		actions.moveToElement(firstTextLink).click().perform();
		Set<String> amazonWindowHandles = driver.getWindowHandles();
		List<String> listAmazonWH = new ArrayList<String> (amazonWindowHandles);
		driver.switchTo().window(listAmazonWH.get(1));
		WebElement firstPhonePrice = driver.findElement(By.xpath("//div[contains(@id, 'corePriceDisplay')]//span[@class='a-price-symbol']/following-sibling::span"));
		System.out.println("The price of first phone is " + firstPhonePrice.getText());
		WebElement customerRatings = driver.findElement(By.xpath("//div[@id = 'averageCustomerReviews']//span[@id = 'acrCustomerReviewText']"));
		System.out.println("The number of custome ratings are " + customerRatings.getText());
		//WebElement firstTextLink = driver.findElement(By.linkText("Visit the OnePlus Store"));
		//actions.moveToElement(firstTextLink).click().perform();
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("screenshot.png"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addToCart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
		actions.pause(2000).click(addToCart).perform();
		//cart total
		WebElement cart = driver.findElement(By.xpath("//span[contains(@id,'cart-subtotal')]"));
		wait.until(ExpectedConditions.visibilityOf(cart));
		String cartTotal = cart.getText();
		System.out.println(cartTotal);
		if(cartTotal.contains(firstPhonePrice.getText())) {
			System.out.println("Price is verified");}
		else {
				System.out.println("Price not verified");
			}
			
		}

	}


