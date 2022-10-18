package Listeners;

import com.aventstack.extentreports.Status;
import driver.DriverManager;
import helpers.CaptureHelpers;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;
import reports.ExtentTestManager;
import utils.Log;

import java.io.IOException;

public class TestListeners implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        Log.info("Start Testing " + result.getName());
        System.out.println("onStart: " + result.getStartDate());
    }

    @Override
    public void onFinish(ITestContext result) {
        Log.info("End Testing" + result.getName());
        ExtentReportManager.getExtentReports().flush(); // kết thúc và thực thi xuất report
        System.out.println("onFinish: " + result.getEndDate());
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info(getTestName(result) + " test is starting...");
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.error("Test failed but it is in defined success ratio " + getTestName(result));
        ExtentTestManager.logMessage("Test failed but it is in defined success ratio " + getTestName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getName() + " is passed");
        ExtentTestManager.logMessage(Status.PASS, getTestName(result) + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            CaptureHelpers.takeScreenshot(result); // chụp màn hình khi fail
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Log.error(result.getName() + " is failed");

        //Extent Report
        ExtentTestManager.addScreenShot(Status.FAIL, "Evidence " + getTestName(result) + " failed");
        ExtentTestManager.logMessage(Status.FAIL, getTestName(result) + " is failed");

        //Allure report
        saveTextLog(result.getName());
        saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Đây là test case bị bỏ qua: " + result.getName());
        ExtentTestManager.logMessage(Status.SKIP, getTestDescription(result) + " is skipped");
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
