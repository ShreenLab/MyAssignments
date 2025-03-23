package stepsForSF;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsForStatic {
	WebDriver driver;	
	WebDriverWait wait ;
	JavascriptExecutor js ;
	
	@Given("User is on the Salesforce login page")
	public void user_is_on_the_salesforce_login_page() {
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.get("https://login.salesforce.com");	
		driver.navigate().refresh();
		
	   
	}

	@When("enters username and password")
	public void enters_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("bhuvanesh.moorthy@testleaf.com");	
		driver.findElement(By.id("password")).sendKeys("Testleaf@2025");
	}

	@When("clicks the login button")
	public void clicks_the_login_button() {
		driver.findElement(By.id("Login")).click();

	}

	@Then("should be redirected to the Salesforce home page")
	public void should_be_redirected_to_the_salesforce_home_page() 
	{
		 wait.until(ExpectedConditions.titleIs("Home | Salesforce"));
	     String actualTitle = driver.getTitle();
	     String expectedTitle = "Home | Salesforce"; 
	     Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
	}

	@When("User clicks the App Launcher Icon next to Setup")
	public void user_clicks_the_app_launcher_icon_next_to_setup() throws InterruptedException
	{
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		WebElement appLauncher = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']"))));
        appLauncher.click();
        Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	
	}

	@When("selects Accounts")
	public void selects_accounts() throws InterruptedException {
		Thread.sleep(4000);
		WebElement accountsElement = driver.findElement(By.xpath("//span//p[text()='Accounts']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accountsElement);
		accountsElement.click();
	    
	}

	@When("searches for the account using TestAccount1")
	public void searches_for_the_account_using_test_account1() throws InterruptedException {
		////a[text() = 'Shreen']
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement showMoreActions = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Shreen']/ancestor::th/following-sibling::td//a[contains(@class, 'rowActionsPlaceHolder')]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreActions);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreActions);


		}

	@When("clicks the dropdown icon next to the account and select Edit")
	public void clicks_the_dropdown_icon_next_to_the_account_and_select_edit() throws InterruptedException {
		Thread.sleep(3000);
		WebElement editButton = driver.findElement(By.xpath("//div[@title='Edit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);
	}

	@When("sets Type to Technology Partner")
	public void sets_type_to_Technology_Partner() throws InterruptedException {
		//driver.findElement(By.xpath("//button[@aria-label ='Type']")).click();
		Thread.sleep(3000);
		WebElement typeButton = driver.findElement(By.xpath("//button[@aria-label ='Type']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", typeButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", typeButton);
		Thread.sleep(3000);
		WebElement techPartner = driver.findElement(By.xpath("//span[text()= 'Technology Partner']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", techPartner);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", techPartner);

	}

	@When("sets Industry to Healthcare")
	public void sets_industry_to_Healthcare() throws InterruptedException {
		Thread.sleep(3000);
		WebElement industryButton = driver.findElement(By.xpath("//button[@aria-label = 'Industry']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", industryButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", industryButton);
		Thread.sleep(3000);
		WebElement techPartner = driver.findElement(By.xpath("//span[text() = 'Healthcare']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", techPartner);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", techPartner);

		
	}

	@When("enters the Billing Address as {string}")
	public void enters_the_Billing_Address_as (String billing_address) throws InterruptedException {
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='Billing Street']/following-sibling::div//textarea")).sendKeys(billing_address);
	}

	@When("enters the Shipping Address as {string}")
	public void enters_the_shipping_address_as (String shipping_address) throws InterruptedException {
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='Shipping Street']/following-sibling::div//textarea")).sendKeys(shipping_address);
	}

	@When("sets Customer Priority to Low")
	public void sets_customer_priority_to_Low() throws InterruptedException {
		Thread.sleep(3000);
		WebElement priorityButton = driver.findElement(By.xpath("//button[@aria-label = 'Customer Priority']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", priorityButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", priorityButton);
		Thread.sleep(3000);
		WebElement low = driver.findElement(By.xpath("//span[text() = 'Low']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", low);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", low);
	    
	}

	@When("sets SLA to Silver")
	public void sets_sla_to_Silver() throws InterruptedException {
		Thread.sleep(3000);
		WebElement SLAButton = driver.findElement(By.xpath("//button[@aria-label ='SLA']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SLAButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", SLAButton);
		Thread.sleep(3000);
		WebElement Silver = driver.findElement(By.xpath("//span[text() = 'Silver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Silver);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Silver);
	}

	@When("sets Active to NO")
	public void sets_active_to_No() throws InterruptedException {
		Thread.sleep(3000);
		WebElement activeButton = driver.findElement(By.xpath("//button[@aria-label ='Active']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activeButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", activeButton);
		Thread.sleep(3000);
		WebElement noOption = driver.findElement(By.xpath("//span[text() ='No']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noOption);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", noOption);
	    
	}

	@When("enters a unique number in the Phone field as {string}")
	public void enters_a_unique_number_in_the_phone_field_as(String phone_number) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys(phone_number);
	}

	@When("sets Upsell Opportunity to {string}")
	public void sets_upsell_opportunity_to(String string) throws InterruptedException {
		Thread.sleep(3000);
		WebElement upskillButton = driver.findElement(By.xpath("//button[@aria-label ='Upsell Opportunity']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", upskillButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", upskillButton);
		Thread.sleep(3000);
		WebElement noUpskill = driver.findElement(By.xpath("//span[text() ='No']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noUpskill);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", noUpskill);
	}

	@When("clicks Save")
	public void clicks_save() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@name = 'SaveEdit']")).click();
	}

}
