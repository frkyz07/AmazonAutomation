package TestComponents;

import AbstractComponents.AbstractComponent;
import Resources.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    String filePath = null;
    ExtentReports extent = ExtentReporter.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result){
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }
    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.get().log(Status.PASS,"Test Passed Good Work");
    }
    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result){
        extentTest.get().log(Status.FAIL, String.valueOf(test.fail(result.getThrowable())));
        //Screenshot and attach method will be written here
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        filePath = AbstractComponent.getScreenShot(result.getMethod().getMethodName(),driver);
        extentTest.get().addScreenCaptureFromPath(filePath);
    }
    @Override
    public void onTestSkipped(ITestResult result){

    }
    public void onFinish(ITestContext context){
        extent.flush();
    }
}
