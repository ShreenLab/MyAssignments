package base;

import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class ProjectSpecificMethods extends AbstractTestNGCucumberTests{
    // Using ThreadLocal to handle parallel execution
    private static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    // Getter for RemoteWebDriver
    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    // Setter for RemoteWebDriver
    public static void setDriver(RemoteWebDriver driverInstance) {
        driver.set(driverInstance);
    }

    @BeforeMethod
    public void preConditon() {
        // Initialize the WebDriver and set it in ThreadLocal
        setDriver(new EdgeDriver());

        // Use getDriver() to perform browser actions
        getDriver().manage().window().maximize();
        getDriver().get("http://leaftaps.com/opentaps/control/main");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

	
	@AfterMethod
	public void postCondition() {
		getDriver().quit();

	}

}
