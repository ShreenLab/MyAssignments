package stepsForCucumber;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CreateAccount extends CommonBaseForLead{

    @Given("User is on the Create Account page")
    public void user_is_on_create_account_page() {
    	driver.findElement(By.linkText("Accounts")).click();
        driver.findElement(By.linkText("Create Account")).click();
    }

    @When("User enters account name {string}")
    public void user_enters_account_name(String AccountName) {
        WebElement accountNameField = driver.findElement(By.id("accountName"));
        accountNameField.sendKeys(AccountName);
    }

    @When("User enters phone number {string}")
    public void user_enters_phone_number(String PhoneNumber) {
        WebElement phoneField = driver.findElement(By.id("primaryPhoneNumber"));
        phoneField.sendKeys(PhoneNumber);
    }

    @When("User submits the form")
    public void user_submits_the_form() {
        WebElement submitButton = driver.findElement(By.xpath("//input[@type = 'submit']")); 
        submitButton.click();
    }

    @Then("A new account should be created with {string}")
    public void a_new_account_should_be_created(String AccountName) {
	    String Title = driver.getTitle();
	    String Actual_title = "Account Details | opentaps CRM";
	    if(Title.equals(Actual_title)) {
	    	System.out.println("Title is displayed correctly");
        }
    }
}

