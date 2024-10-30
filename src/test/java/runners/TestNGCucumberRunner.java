package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources", // complete path
        glue = "steps" // package name only - cucumber understands rest
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}
