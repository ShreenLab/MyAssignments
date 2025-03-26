package runner;

import org.testng.annotations.DataProvider;

import base.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/java/features/LeaftapsAccountCreation.feature"},glue = {"pages"})
public class BDDAccountCreationTC001 extends ProjectSpecificMethods {

	@DataProvider(parallel = true)
    public Object[][] scenarios() {
		return super.scenarios();
        
    }
	
}
