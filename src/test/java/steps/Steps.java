package steps;

import base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Steps extends BaseUtil {

    private WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions

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

    @When("User provides valid credentials and submits form {string} {string}")
    public void user_provides_valid_credentials_and_submits_form(String username, String password) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("userEmail")).sendKeys(username);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
    }

    @When("User provides valid credentials and submits form data table")
    public void login_dataTable(DataTable table) throws InterruptedException {
        List<List<String>> data = table.asLists(String.class);

        driver.findElement(By.id("userEmail")).sendKeys(data.get(0).get(0));
    driver.findElement(By.id("userPassword")).sendKeys(data.get(0).get(1));
    driver.findElement(By.id("login")).click();
    Thread.sleep(2000);
}

    @Then("User should login")
    public void user_should_login() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(driver.findElement(By.cssSelector("button[class='btn btn-custom'] i[class='fa fa-sign-out']")).isDisplayed());

    }


}
