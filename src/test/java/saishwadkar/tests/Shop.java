package saishwadkar.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import saishwadkar.pageobjects.CartPage;
import saishwadkar.pageobjects.LandingPage;
import saishwadkar.pageobjects.OrdersPage;
import saishwadkar.pageobjects.ProductsPage;
import saishwadkar.testcomponents.BaseTest;

import java.io.IOException;
import java.time.Duration;

public class Shop extends BaseTest {

    @Test
    public void addProductAndCheckout() throws InterruptedException, IOException {

        // Test Data
        String itemName = "ZARA COAT 3";
        String username = "qaautomation@gmail.com";
        String password = "Java@101";
        String country = "India";

        // setup driver,browser,waits and open application
        WebDriver driver = launchApp();

        // Page Objects : Landing Page : object creation can be gracefully handled by creating page object instances in chained methods only or inheritance
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

        // clean up
        driver.quit();
    }
}