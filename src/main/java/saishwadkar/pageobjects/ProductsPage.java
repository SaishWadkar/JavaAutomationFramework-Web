package saishwadkar.pageobjects;

import saishwadkar.abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends AbstractComponents {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 1. basic
    // WebElement username = driver.findElement(By.id("userEmail"));

    // 2. Page Factory
    By itemsDiv = By.cssSelector(".col-lg-4");
    By addToCartButton = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    By annimation = By.cssSelector(".ng-animating");

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartButton;


    // Action Methods
    public void addItemToCart(String itemName) {
        waitForElementToAppear(itemsDiv);
        List<WebElement> items = driver.findElements(itemsDiv); // returned 3 web elements
        // System.out.println(items.size());

        WebElement item = items.stream().filter(s -> s.findElement(By.cssSelector("b")).getText().equals(itemName)).findFirst().orElse(null);
        item.findElement(addToCartButton).click();
    }

    public void goToCart() {
        waitForElementToAppear(toastMessage);
        waitForElementToDisAppear(annimation);
        cartButton.click();
    }

}
