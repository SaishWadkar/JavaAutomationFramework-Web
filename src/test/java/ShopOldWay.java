import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ShopOldWay {

    public static void main(String []args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();

        String itemName = "ZARA COAT 3";

        // Landing Page
        driver.findElement(By.id("userEmail")).sendKeys("qaautomation@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Java@101");
        driver.findElement(By.id("login")).click();

        List<WebElement> items = driver.findElements(By.cssSelector(".col-lg-4")); // returned 3 web elements
        System.out.println(items.size());

        WebElement item = items.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(itemName)).findFirst().orElse(null);
        item.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        // String name = items.get(0).findElement(By.cssSelector("b")).getText();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        // invisibiliy

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[routerlink*='cart']"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        // System.out.println(item);
        //System.out.println(name);


        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart h3"));

        Boolean flag = cartItems.stream().anyMatch(s->s.getText().equalsIgnoreCase(itemName));

        Assert.assertTrue(flag);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(2000,2000)");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".totalRow button"))));
        // Thread.sleep(2000);

        driver.findElement(By.cssSelector(".totalRow button")).click();

        // drop down for country
        WebElement dropDown = driver.findElement(By.cssSelector(".form-group input"));
        dropDown.sendKeys("India");

        List<WebElement> dropDownItems = driver.findElements(By.cssSelector(".form-group section button span"));

        List<WebElement> country = dropDownItems.stream().filter(s->s.getText().equalsIgnoreCase("India")).collect(Collectors.toList());

        country.get(0).click();

//        for(WebElement e:country){
//            e.click();
//        }

        // place order
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".actions a"))));
        driver.findElement(By.cssSelector(".actions a")).click();

        List<WebElement> orderIds =driver.findElements(By.cssSelector("tbody .ng-star-inserted td label"));
        List<String> order = orderIds.stream().map(s->s.getText()).collect(Collectors.toList());

        System.out.println(order);

        Thread.sleep(5000);
        driver.quit();

    }
}