package stepsForCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import java.time.Duration;
import org.testng.Assert;

public class deleteLeaftap extends CommonBaseForLead {

    WebDriverWait wait;
    public static String leadID; // Storing leadID for verification

    @Given("User is on the Find Leads page")
    public void user_is_on_the_find_leads_page() {
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Find Leads")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User searches for a lead with phone number {string}")
    public void user_searches_for_a_lead_with_phone_number(String phoneNumber) {
        driver.findElement(By.xpath("//span[text()='Phone']")).click();
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        
        // Wait for the search result to load properly
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'x-grid3-col-firstName')]/a)[1]")));
    }

    @When("User selects the first lead from the search results")
    public void user_selects_the_first_lead_from_the_search_results() {
        // Re-find the element after waiting to avoid Stale Element Exception
        WebElement leadElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'x-grid3-col-firstName')]/a)[1]")));
        
        leadID = leadElement.getText(); // Store Lead ID for later use
        System.out.println("Lead ID to be deleted: " + leadID);
        
        leadElement.click(); // Click the lead after ensuring it's ready
    }

    @When("User clicks the Delete button")
    public void user_clicks_the_delete_button() throws InterruptedException {
    	Thread.sleep(2000);
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class ='subMenuButtonDangerous']")));
        deleteButton.click();
    }

    @Then("The lead should be deleted successfully")
    public void the_lead_should_be_deleted_successfully() throws InterruptedException {
        driver.findElement(By.linkText("Find Leads")).click();
        
        // Enter the stored Lead ID for search
        driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        
        // Wait for the "No records to display" message to appear
        Thread.sleep(5000);
        WebElement verifyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='No records to display']")));
        
        // Validate deletion
        Assert.assertTrue(verifyMessage.isDisplayed(), "Lead deletion failed!");
        System.out.println("Lead deletion successful!");
    }
}
