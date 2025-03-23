package runnerForSFAV;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "./src/test/resources/features",
    tags = "@SalesForceStatic or @SalesforceAccount",
    glue = "stepsForSF",
    monochrome = true,
    publish = true
)
public class runnerSFAVerification extends AbstractTestNGCucumberTests {
}