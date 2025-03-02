package week2.week2day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckboxAssignment 
{
    public static void main(String[] args) throws InterruptedException 
    {
    	FirefoxDriver driver = new FirefoxDriver();
    	driver.get("https://leafground.com/checkbox.xhtml");
    	driver.manage().window().maximize();
    	Thread.sleep(2000);
//click basic & ajax box
    	driver.findElement(By.xpath("//span[text() = 'Basic']")).click();
    	driver.findElement(By.xpath("//span[text() = 'Ajax']")).click();
    	Thread.sleep(3000);
//verifying the expected message
    	
    	String text = driver.findElement(By.xpath("//span[text() = 'Checked']")).getText();
    	System.out.println(text);
    	String expText = "Checked";
    	if(text.equals(expText)) {
    		System.out.println("Displayed message is verified");}
    	else {
    		System.out.println("not verified");
    		}
 //selecting favorite language
    	driver.findElement(By.xpath("//label[text()='Java']/preceding::div[1]")).click();
    	Thread.sleep(3000);
 //clicking and verifying message for tri state
    	WebElement triState = driver.findElement(By.xpath("//div[contains(@id , 'ajaxTri')]/div[2]"));
    	triState.click();
    	//Thread.sleep(3000);
    	//System.out.println(triState.isSelected());
    	WebElement state = driver.findElement(By.xpath("//p[text() = 'State = 1']"));
    	System.out.println(state.getText());
    	String text1 = state.getText();
    	String exptext1 = "State = 1";
    	if(text1.equals(exptext1)){
    		System.out.println("Tri state option is chosen");}
    	else {
    		System.out.println("Tri state option is not chosen");
    		}
//clicking toggle switch amd verifying
    	driver.findElement(By.className("ui-toggleswitch-slider")).click();
    	
    	
    	WebElement toggle = driver.findElement(By.xpath("//div[contains(@class , 'checked')]"));
    	if(toggle.isDisplayed()) {
    		System.out.println("toggle button is enabled");
    	}
    	else {
    		System.out.println("toggle button is not enabled");
    	}
//select multiple options
    	driver.findElement(By.xpath("//ul[@data-label = 'Cities']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//label[text()='London'])[2]/preceding::div[1]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@id='j_idt87:multiple_panel']/div[2]/ul[1]/li[3]/div[1]/div[2]")).click();

    	driver.close();
    	
    }
   
    		    	
}