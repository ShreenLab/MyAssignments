package stepsForSF;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsForSFAV {
    	WebDriver driver;
    	WebDriverWait wait;
    	JavascriptExecutor js;

    	@Given("the user is on the login page {string}")
    	public void the_user_is_on_the_login_page(String url) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    	}
		@When("the user enters username as {string}")
		public void the_user_enters_username_as(String email) {
		    driver.findElement(By.xpath("//input[@type = 'email']")).sendKeys(email);
		}
		@When("the user enters the password as {string}")
		public void the_user_enters_the_password_as(String pwd) {
		    driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(pwd);
		}
		@And("the user logs into page")
		public void the_user_logs_into_page() {
			driver.findElement(By.xpath("//input[@id = 'Login']")).click();
		    
		}
		@Then("the user should be redirected to the Home page")
		public void the_user_should_be_redirected_to_the_home_page() {
	        wait.until(ExpectedConditions.titleIs("Home | Salesforce"));
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Home | Salesforce"; 
	        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
		}
		@Then("the user clicks on the toggle menu button from the left corner")
		public void the_user_clicks_on_the_toggle_menu_button_from_the_left_corner() {
			WebElement appLauncher = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']"))));
	        appLauncher.click();
		}
		@Then("the user clicks View All and selects Sales from the App Launcher")
		public void the_user_clicks_view_all_and_selects_sales_from_the_app_launcher() throws InterruptedException {
			//WebElement viewAll = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@aria-label = 'View All Applications']"))));
			//viewAll.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//p[text()= 'Sales']")).click();
		}
		@Then("the user clicks on the Accounts tab")
		public void the_user_clicks_on_the_accounts_tab() throws InterruptedException {
		    Thread.sleep(6000);
		    js = (JavascriptExecutor) driver;
		    WebElement accounts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Accounts']")));
		    
		    js.executeScript("arguments[0].scrollIntoView(true);", accounts);
		    
		    // Click using JavaScriptExecutor
		    js.executeScript("arguments[0].click();", accounts);
		}
		
		@Then("the user clicks on the New button")
		public void the_user_clicks_on_the_new_button() throws InterruptedException {
			Thread.sleep(3000);
		    driver.findElement(By.xpath("//div[@title = 'New']")).click();
		}
		
		@Then("the user enters the account name as (.*)$")
		public void the_user_enters_the_account_name_as(String name) throws InterruptedException {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		}
		    
	
		@Then("the user selects Ownership as Public")
		public void the_user_selects_ownership_as_public() throws InterruptedException {
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ownership = driver.findElement(By.xpath("//div[@aria-label = 'Ownership']"));
			js.executeScript("arguments[0].scrollIntoView(true);", ownership);
			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", ownership);
			Thread.sleep(2000);
			WebElement publicButton = driver.findElement(By.xpath("//span[text() = 'Public']"));
			js.executeScript("arguments[0].click();", publicButton);
			
		    
		}
		@Then("the user clicks save and verifies the Account name")
		public void the_user_clicks_save_and_verifies_the_account_name() throws InterruptedException {
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[@name= 'SaveEdit']")).click();
		    Thread.sleep(5000);
		    String title = driver.getTitle();
		    System.out.println(title);
		    String expectedKeyword = "Shreen";

		    Assert.assertTrue(title.contains(expectedKeyword), "Title does not contain the expected word!");
		    
		}


	}

