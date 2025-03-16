package week4.week4day3;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SalesforceProjectSpecific {
		WebDriver driver;
		@Parameters({"url", "username", "password"})
		@BeforeMethod
		public void preConditions(String url, String username, String password) throws InterruptedException
		{
        // Set ChromeOptions
    	
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        option.addArguments("--disable-blink-features=AutomationControlled");
        option.addArguments("--incognito");
        option.addArguments("--guest");

        // Initialize WebDriver with Options
        driver = new ChromeDriver(option);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Open Salesforce
        driver.get(url);
        driver.navigate().refresh();

        // Login
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='Login']"))));
        loginButton.click();

        // Click App Launcher
        WebElement appLauncher = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']"))));
        appLauncher.click();

        // Click View All
        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='View All Applications']")));
        js.executeScript("arguments[0].click();", viewAll);

        // Click Legal Entities
        WebElement legalEntities = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@data-label='Legal Entities']//p[text()='Legal Entities']"))));
        js.executeScript("arguments[0].scrollIntoView(true);", legalEntities);
        js.executeScript("arguments[0].click();", legalEntities);

        // Click "New Legal Entity"
        
        /*WebElement newLegal = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Legal Entities List']/parent::a"))));
        js.executeScript("arguments[0].click();", newLegal);*/
        Thread.sleep(2000);
        WebElement legalEntityTab = driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(legalEntityTab));
        js.executeScript("arguments[0].click();", legalEntityTab); 
		}
		@AfterMethod
		public void postCondition() throws InterruptedException
		{
			Thread.sleep(1000);;
			driver.close();
			}
	}