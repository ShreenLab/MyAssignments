package stepsForCucumber;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {
    WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/");
    }

    @When("user enters the valid username")
    public void user_enters_the_valid_username() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username.sendKeys("DemoSalesManager");
    }

    @When("user enters the valid password")
    public void user_enters_the_valid_password() {
        driver.findElement(By.id("password")).sendKeys("crmsfa");
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        driver.findElement(By.className("decorativeSubmit")).click();
    }

    @Then("user is redirected to login page")
    public void user_is_redirected_to_login_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Leaftaps - TestLeaf Automation Platform"));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Leaftaps - TestLeaf Automation Platform"; 
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @Then("user seeing the welcome message")
    public void user_seeing_the_welcome_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Welcome')]")));
        Assert.assertTrue(welcomeMessage.getText().contains("Welcome"), "Welcome message not displayed!");
        driver.quit();
    }
}