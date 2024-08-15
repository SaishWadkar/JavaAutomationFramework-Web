package saishwadkar.testcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import saishwadkar.resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReportNG.configureReport();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // ITestListener.super.onTestFailure(result);
        test.log(Status.FAIL,"Test failed");
        test.fail(result.getThrowable());



//        try {
//            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance()) ;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // screenshot
        String filePath = null;

        try{
            filePath= getScreenshot(result.getMethod().getMethodName(),driver); // not giving driver here
        }
        catch (Exception e){
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // ITestListener.super.onTestSuccess(result);

        test.log(Status.PASS, "Test passed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        // ITestListener.super.onFinish(context);
        extent.flush();
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }
}
