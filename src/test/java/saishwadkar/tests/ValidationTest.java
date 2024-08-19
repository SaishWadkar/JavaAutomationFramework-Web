package saishwadkar.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import saishwadkar.pageobjects.LandingPage;
import saishwadkar.testcomponents.BaseTest;
import saishwadkar.testcomponents.Retry;

import java.util.HashMap;

public class ValidationTest extends BaseTest {

    @Test(groups = {"sanity"})
    public void validateTitle(){
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Let's Shop"));
    }

    @Test(groups = {"sanity"})
    public void validateUrl(){
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/client/auth/login"));
    }

    // 1 Using Object Array
//    @Test(dataProvider = "getData",groups = {"login"})
//    public void checkLogin(String username, String password) throws InterruptedException {
//
//        LandingPage lp = new LandingPage(driver);
//        lp.loginApplication(username,password);
//        Thread.sleep(3000);
//        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/client/dashboard/dash"));
//    }
//
//    @DataProvider
//    public Object[][] getData(){
//        Object[][] data = new Object[2][2];
//        data[0][0] = "qaautomation@gmail.com";
//        data[0][1] = "Java@101";
//        data[1][0] = "wrongemail@gmail.com";
//        data[1][1] = "wrongpassword123";
//        return data;
//    }

    // 2, using hashmap
    @Test(dataProvider = "getData",groups = {"login"},retryAnalyzer = Retry.class)
    public void checkLogin(HashMap hashMap) throws InterruptedException {

        String username = (String) hashMap.get("username");
        String password = (String) hashMap.get("password");
        LandingPage lp = new LandingPage(driver);
        lp.loginApplication(username,password);
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/client/dashboard/dash"));
    }

    @DataProvider
    public Object[][] getData(){
        HashMap<String,String> map1 = new HashMap<String,String>();
        map1.put("username","qaautomation@gmail.com");
        map1.put("password","Java@101");

        HashMap<String,String> map2 = new HashMap<String,String>();
        map2.put("username","wrongemail@gmail.com");
        map2.put("password","wrongpassword123");

        return new Object[][] {{map1},{map2}};
    }

}
