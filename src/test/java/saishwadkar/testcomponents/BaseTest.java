package saishwadkar.testcomponents;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {
        driver = initializeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        //return driver;
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

        String browserName = System.getProperty("browser") == null ? prop.getProperty("browser") : System.getProperty("browser");

        // String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }

//         default is chrome
        else{
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

//    public void WebDriver getDriver(){
//        return this.driver;
//    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String filePath = System.getProperty("user.dir") + "//reports//"+testCaseName+".png";
        File file = new File(filePath);
        Files.copy(source,file);
        // FileUtils.copyFile(source,file);
        System.out.println(filePath);
        return  filePath;
    }

}
