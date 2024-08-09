package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends AbstractComponents {

    WebDriver driver;

    public ProductsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // 1. basic
    // WebElement username = driver.findElement(By.id("userEmail"));

    // 2. Page Factory
    @FindBy(id = "userEmail")
    WebElement username;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "Make 'click()' return 'void'")
    WebElement login;


    // Action Methods
    public void loginApplication(String username,String password){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();

    }
}
