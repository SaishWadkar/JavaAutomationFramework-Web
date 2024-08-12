package saishwadkar.testcomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public WebDriver launchApp() throws IOException {
        driver = initializeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public WebDriver initializeDriver() throws IOException {

        // read from properties file
        Properties prop = new Properties();
        // System.getProperty("user.dir")
        FileInputStream fis = new FileInputStream("src/main/java/saishwadkar/resources/GlobalData.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }

        // default is chrome
        else{
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

}
