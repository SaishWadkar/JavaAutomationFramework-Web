package saishwadkar.pageobjects;

import saishwadkar.abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 1. basic
    // WebElement username = driver.findElement(By.id("userEmail"));

    // 2. Page Factory
    @FindBy(id = "userEmail")
    WebElement usernameTextBox;

    @FindBy(id = "userPassword")
    WebElement passwordTextBox;

    @FindBy(id = "login")
    WebElement loginButton;


    // Action Methods
    public void loginApplication(String username, String password) {

        this.usernameTextBox.sendKeys(username);
        this.passwordTextBox.sendKeys(password);
        loginButton.click();

    }
}
