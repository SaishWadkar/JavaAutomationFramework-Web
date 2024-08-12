package saishwadkar.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saishwadkar.testcomponents.BaseTest;

public class ValidationTest extends BaseTest {

    @Test(groups = {"sanity"})
    public void validateTitle(){
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Let's Shop"));
    }

    @Test(groups = {"sanity"})
    public void validateUrl(){
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/client/auth/login"));
    }


}
