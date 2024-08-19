package saishwadkar.testcomponents;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import saishwadkar.resources.ExtentReportNG;

import java.io.File;
import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReportNG.configureReport();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread safe

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test); // overcomes concurrency issue ; unique thread id
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // ITestListener.super.onTestFailure(result);
        test.log(Status.FAIL,"Test failed");
        extentTest.get().fail(result.getThrowable());

//        try {
//            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        String testCaseName = result.getMethod().getMethodName();

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // String filePath = System.getProperty("user.dir") + "reports/"+testCaseName+".png";  //   reports/validateUrl.png
        String filePath = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";  //   reports/validateUrl.png
        File file = new File(filePath);
        try {
            Files.copy(source,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // FileUtils.copyFile(source,file);
        System.out.println("File Path : "+filePath);
        // return  filePath;




        // screenshot
//        String filePath = null;
//
//        try{
//            filePath= getScreenshot(result.getMethod().getMethodName(),driver); // not giving driver here
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        // test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
        String myPath = testCaseName + ".png";
        extentTest.get().addScreenCaptureFromPath(myPath,filePath);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // ITestListener.super.onTestSuccess(result);

        test.log(Status.PASS, "Test passed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        test.log(Status.SKIP, "Test skipped");
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
