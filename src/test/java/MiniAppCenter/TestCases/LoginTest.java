package MiniAppCenter.TestCases;

import Common.BaseTest;
import MiniAppCenter.Pages.LoginPage;
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


public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    ExcellHelpers excel;


    @BeforeMethod
    public void LoginTest() {
        loginPage = new LoginPage();
        excel = new ExcellHelpers();

    }

    @Test(priority = 1)
    public void loginFailWithNullData() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        loginPage.loginFailWithNullData(PropertiesHelper.getValue("url"));
    }

    @Test(priority = 2)
    public void loginFailWithAccountFail() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        loginPage.loginFailWithAccountFail(PropertiesHelper.getValue("url"), excel.getCellData("username", 1), excel.getCellData("password", 1));
    }

    @Test(priority = 3)
    public void loginSuccess() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        loginPage.loginSuccess(PropertiesHelper.getValue("url"), excel.getCellData("username", 2), excel.getCellData("password", 2));
    }

    // case account chưa được kích hoạt -> chưa có data để test vì chưa register thành công

    @Test(priority = 4)
    public void loginSuccessWithGoogle() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        loginPage.loginSuccessWithGoogle(PropertiesHelper.getValue("url"), excel.getCellData("username", 3), excel.getCellData("password", 3));
    }

    @Test(priority = 5)
    public void loginFailWithGoogle() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        loginPage.loginFailWithGoogle(PropertiesHelper.getValue("url"), excel.getCellData("username", 4));
    }

    @Test(priority = 6)
    public void validationText() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        loginPage.validationText(PropertiesHelper.getValue("url"));
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
