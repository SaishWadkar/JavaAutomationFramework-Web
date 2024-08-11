package saishwadkar.pageobjects;

import saishwadkar.abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class OrdersPage extends AbstractComponents {

    WebDriver driver;

    public OrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 1. basic
    // WebElement username = driver.findElement(By.id("userEmail"));

    // 2. Page Factory

    @FindBy(css = ".form-group input")
    WebElement dropDown;

    @FindBy(css = ".form-group section button span")
    List<WebElement> dropDownItems;

    @FindBy(css = ".actions a")
    WebElement placeOrderButton;

    @FindBy(css = "td h1")
    WebElement confirmationMessage;

    // Action Methods
    public void setCountry(String country) {

        //    WebElement dropDown = driver.findElement(By.cssSelector(".form-group input"));
        dropDown.sendKeys(country);

        // List<WebElement> dropDownItems = driver.findElements(By.cssSelector(".form-group section button span"));

        List<WebElement> countryList = dropDownItems.stream().filter(s -> s.getText().equalsIgnoreCase(country)).collect(Collectors.toList());

        countryList.get(0).click();
    }

    public Boolean placeOder() {
        placeOrderButton.click();

        // System.out.print(confirmationMessage.getText());

        if (confirmationMessage.getText().toLowerCase().contains("thankyou")) {
            return true;
        } else {
            return false;
        }

    }
}
