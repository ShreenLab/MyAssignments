package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/resources/features"},
glue = {"stepsForCucumber", "hooksImpl"},
dryRun = false,
publish = true,
tags = "@createAccount or @editAccount or @deleteAccount ",
monochrome = true)

public class HooksRunnerClass extends AbstractTestNGCucumberTests {

}
