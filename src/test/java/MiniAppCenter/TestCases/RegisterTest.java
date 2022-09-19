package MiniAppCenter.TestCases;

import Common.BaseTest;
import MiniAppCenter.Pages.RegisterPage;
import driver.DriverManager;
import helpers.ExcellHelpers;
import helpers.PropertiesHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage;
    ExcellHelpers excel;

    @BeforeMethod
    public void RegisterTest() {
        excel = new ExcellHelpers();
        registerPage = new RegisterPage();
    }

    @Test(priority = 1)
    public void registerValidNullDataWithPhoneNumber() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        registerPage.registerValidNullDataWithPhoneNumber(PropertiesHelper.getValue("url"));
    }

    @Test(priority = 2)
    public void registerValidNullDataWithEmail() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        registerPage.registerValidNullDataWithEmail(PropertiesHelper.getValue("url"));

    }

    @Test(priority = 3)
    public void registerSuccessWithPhoneNumber() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        registerPage.registerSuccessWithPhoneNumber(PropertiesHelper.getValue("url"), excel.getCellData("username", 5), excel.getCellData("password", 5),
                excel.getCellData("password", 5), excel.getCellData("username", 6), excel.getCellData("code", 1),
                excel.getCellData("username", 7), excel.getCellData("username", 8), excel.getCellData("username", 10),
                excel.getCellData("password", 9), excel.getCellData("username", 9), excel.getCellData("password", 9));

    }


    @Test(priority = 5)
    public void validationTextRegister() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        registerPage.validationTextRegister(PropertiesHelper.getValue("url"));
    }

    @Test(priority = 6)
    public void registerSuccessWithPhoneNumberNOTValid() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        registerPage.registerSuccessWithPhoneNumberNOTValid(PropertiesHelper.getValue("url"), excel.getCellData("username", 5), excel.getCellData("password", 5),
                excel.getCellData("password", 5), excel.getCellData("username", 6), excel.getCellData("code", 1),
                excel.getCellData("username", 7), excel.getCellData("username", 8), excel.getCellData("username", 10),
                excel.getCellData("password", 9), excel.getCellData("username", 9), excel.getCellData("password", 9));

    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Tạo tham chiếu của TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
                // Gọi hàm capture screenshot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
}
