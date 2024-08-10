package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 1. basic
    // WebElement username = driver.findElement(By.id("userEmail"));

    // 2. Page Factory
    @FindBy(css = ".cart h3")
    List<WebElement> cartItems;

    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

    // Action Methods
    public void checkout(String itemName) {

        Boolean flag = cartItems.stream().anyMatch(s -> s.getText().equalsIgnoreCase(itemName));

        // if item is present proceed to checkout, else dont
        if (flag) {
            // to scroll page
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scroll(2000,2000)");

            checkoutButton.click();
        }
    }

}
