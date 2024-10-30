package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.ja.且つ;
import org.openqa.selenium.WebDriver;
import saishwadkar.pageobjects.LandingPage;
import saishwadkar.testcomponents.BaseTest;

import java.io.IOException;

public class StepDefinitionImplementation extends BaseTest {

    LandingPage lp = new LandingPage(driver);

    @Given("I have landed to the home page")
    public void I_have_landed_to_the_home_page() throws IOException, InterruptedException {
        driver = initializeDriver();
        launchApplication();
    }

    @Given("I'm on the website")
    public void Im_on_the_website(){
        // before test takes care of this
    }

    //    if given directly in quotes use curly braces
    @When("I set username to {string} and password to {string}")
    public void login(String username,String password){
        lp.loginApplication(username,password);
    }

//    if it is coming from Examples section use : regular exp :   ^ (.+) $


}
