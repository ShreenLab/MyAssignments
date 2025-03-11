package week4.week4day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailClassroomActivity {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://erail.in/");
        driver.findElement(By.id("chkSelectDateOnly")).click();
// Find all train name elements in the table
        List<WebElement> trainElements = driver.findElements(By.xpath("//div[@id='divTrainsList']//tbody/tr/td[2]"));
//Create a list to store train names extracted from WebElements        
        List<String> trainNameList = new ArrayList<>();
//Create a set to store unique train names for duplicate detection  
        Set<String> uniqueTrainNames = new HashSet<>();
//Create a set to store duplicate train names
        Set<String> duplicateTrainNames = new HashSet<>();
//Loop through each train name element   
        for (WebElement element : trainElements) {
//Extract the train name text and remove extra spaces 
            String trainName = element.getText().trim();
//Check if train name is not empty before processing
            if (!trainName.isEmpty()) {
//Add train name to the list  
                trainNameList.add(trainName);
//If adding to the unique set fails, it means it's a duplicate
                if (!uniqueTrainNames.add(trainName)) {
//Add duplicate train name to the duplicate set  
                    duplicateTrainNames.add(trainName);
                }
            }
        }

        System.out.println("All Train Names: " + trainNameList);
        System.out.println("Duplicate Train Names: " + duplicateTrainNames);


        driver.quit();
    }
}
