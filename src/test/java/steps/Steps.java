package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Steps {

    private WebDriver driver;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
    }

    @When("User provides valid credentials and subits form")
    public void user_provides_valid_credentials_and_subits_form() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("userEmail")).sendKeys("qaautomation@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Java@101");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
    }

    @Then("User should login")
    public void user_should_login() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(driver.findElement(By.cssSelector("button[class='btn btn-custom'] i[class='fa fa-sign-out']")).isDisplayed());
        driver.quit();
    }


}
