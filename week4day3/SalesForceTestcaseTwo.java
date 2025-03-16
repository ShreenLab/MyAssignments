package week4.week4day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SalesForceTestcaseTwo extends SalesforceProjectSpecific{
	@Test
	public void verifyAlert() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement legalEntityTab = driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(legalEntityTab));
        js.executeScript("arguments[0].click();", legalEntityTab); 
        
        //driver.findElement(By.xpath("//span[text()='Legal Entities List']/parent::a")).click();
        //driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]")).click();
    
        // Fill Form)
        WebElement companyName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='CompanyName']")));
        companyName.sendKeys("Testleaf");

        WebElement description = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Description')]//following::textarea")));
        description.sendKeys("salesforce");
        
        WebElement status = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(@id, 'combobox-button')]"))));
        js.executeScript("arguments[0].click();", status);
        
        WebElement inactive = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text() = 'Inactive']"))));
        js.executeScript("arguments[0].click();", inactive);
        
        driver.findElement(By.xpath("//input[@name = 'Name']")).sendKeys("Salesforce Automation by Shreen");
        WebElement save = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//Button[@name = 'SaveEdit']"))));
        js.executeScript("arguments[0].click();", save);
        
        String actulName = "Salesforce Automation by Shreen";
        
        String expectedName = driver.findElement(By.xpath("(//div[@class='slds-form-element__control']//slot)[1]/lightning-formatted-text")).getText();
        
        System.out.println(expectedName);
        
        if(expectedName.equalsIgnoreCase(actulName))
        	System.out.println("Alert is verified");
        else
        	System.out.println("Alert is not verified");
		// TODO Auto-generated method stub

	}

}
