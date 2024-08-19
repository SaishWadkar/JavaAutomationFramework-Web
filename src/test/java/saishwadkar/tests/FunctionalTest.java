package saishwadkar.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saishwadkar.pageobjects.CartPage;
import saishwadkar.pageobjects.LandingPage;
import saishwadkar.pageobjects.OrdersPage;
import saishwadkar.pageobjects.ProductsPage;
import saishwadkar.testcomponents.BaseTest;

import java.io.IOException;

public class FunctionalTest extends BaseTest {

    // Test Data
    String itemName = "ZARA COAT 3";
    String username = "qaautomation@gmail.com";
    String password = "Java@101";
    String country = "India";
    String orderID;

    @Test(groups = {"regression"})
    public void addProductAndCheckoutTest() throws InterruptedException, IOException {
        // setup driver,browser,waits and open application
        // WebDriver driver = setup();

        // Page Objects : Landing Page : object creation can be gracefully handled by creating page object instances in chained methods only or inheritance
        LandingPage lp = new LandingPage(driver);
        ProductsPage pp = new ProductsPage(driver);
        CartPage cp = new CartPage(driver);
        OrdersPage op = new OrdersPage(driver);

        // login to the application
        lp.loginApplication(username, password);

        pp.addItemToCart(itemName);
        pp.goToCart();
        cp.checkout(itemName);
        op.setCountry(country);

        Assert.assertTrue(op.placeOder());

        // clean up
        // driver.quit();
    }

    @Test(dependsOnMethods = {"addProductAndCheckoutTest"})
    public void checkOrder(){
        // grab order id from addProductAndCheckoutTest and check it in orders table

        System.out.println("I'll run after addProductAndCheckoutTest only - once the product is added in the cart (TC passed) then only I'll execute ");
    }
}