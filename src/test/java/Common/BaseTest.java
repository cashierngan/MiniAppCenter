package Common;

import Listeners.TestListeners;
import MiniAppCenter.Pages.CommonPage;
import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

@Listeners(TestListeners.class)
public class BaseTest extends CommonPage {
    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browser) {
        WebDriver driver = setupDriver(browser);
        DriverManager.setDriver(driver);

    }

    public static WebDriver setupDriver(String browserName) {
        WebDriver driver;
        System.out.println(browserName.trim().toLowerCase());
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver(ITestResult result) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // T???o tham chi???u c???a TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
                // G???i h??m capture screenshot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Ki???m tra folder t???n t???i. N??u kh??ng th?? t???o m???i folder
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                // result.getName() l???y t??n c???a test case xong g??n cho t??n File ch???p m??n h??nh
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("???? ch???p m??n h??nh: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
}
