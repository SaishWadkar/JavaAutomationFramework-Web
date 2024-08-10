import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.CartPage;
import pageobjects.LandingPage;
import pageobjects.OrdersPage;
import pageobjects.ProductsPage;

import java.io.ObjectInput;
import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

    public static void main(String[] args) throws InterruptedException {

        // setup driver,browser and waits
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();

        // Test Data
        String itemName = "ZARA COAT 3";
        String username = "qaautomation@gmail.com";
        String password = "Java@101";
        String country = "India";

        // Page Objects : Landing Page
        LandingPage lp = new LandingPage(driver);
        ProductsPage p = new ProductsPage(driver);
        CartPage cp = new CartPage(driver);
        OrdersPage o = new OrdersPage(driver);

        // login to the application
        lp.loginApplication(username, password);
        p.addItemToCart(itemName);
        p.goToCart();
        cp.checkout(itemName);
        o.setCountry(country);

        Assert.assertTrue(o.placeOder());


        // Thread.sleep(5000);

        // clean up
        driver.quit();

    }
}