package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// monochrome set to true, to be readable
@CucumberOptions(features = "src/test/java/cucumber",glue = "stepDefinitions",monochrome = true,plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {


}
