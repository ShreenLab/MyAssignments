package stepsForCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.*;
import java.time.Duration;

public class EditLeaftapAccount extends CommonBaseForLead {

    WebDriverWait wait;
    JavascriptExecutor js;

    @Given("User is on the Accounts page")
    public void user_is_on_the_accounts_page() {
        driver.findElement(By.linkText("Accounts")).click();
        driver.findElement(By.linkText("Find Accounts")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    @When("User searches for an account with name {string}")
    public void user_searches_for_an_account_with_name(String existingAccountName) {
        WebElement accountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("accountName")));
        accountInput.sendKeys(existingAccountName);
        driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();

        // Ensure search results load properly
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'x-grid3-row')]")));
    }

    @When("User selects the first account from the list")
    public void user_selects_the_first_account_from_the_list() {
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='linktext'])[1]")));

        // Using JavaScript Click to avoid any interception issues
        js.executeScript("arguments[0].click();", firstResult);
    }

    @When("User updates the account name to {string} and saves the changes")
    public void user_updates_the_account_name_to_and_saves_the_changes(String newAccountName) {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Edit']")));
        editButton.click();

        WebElement accountNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='accountName']")));
        accountNameField.clear();
        accountNameField.sendKeys(newAccountName);
    }

    @Then("The account name should be updated to {string}")
    public void the_account_name_should_be_updated_to(String newAccountName) {
        WebElement updatedName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Account Name']/following::span[1]")));
        String actualAccountName = updatedName.getText();
        Assert.assertEquals(actualAccountName, newAccountName, "Account name update failed!");
    }
}