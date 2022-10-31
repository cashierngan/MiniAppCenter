package helpers;

import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


public class CaptureHelpers {
    public static void takeScreenshot(ITestResult result) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        File theDir = new File("./Screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
        System.out.println("Screenshot taken: " + result.getName());

    }



}
