package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import helpers.PropertiesHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@Listeners(TestListeners.class)
public class LoginTest extends BaseTest {

    ExcellHelpers excel;


    @BeforeMethod
    public void LoginTest() {
        excel = new ExcellHelpers();

    }

    @Test(priority = 1)
    public void loginFailWithNullData() throws Exception {
        excel.setExcelFile("src/test/Resource/Login.xlsx", "SheetLogin");
        getLoginPage().loginFailWithNullData(PropertiesHelper.getValue("url"));

    }

    @Test(priority = 2)
    public void loginFailWithAccountFail() throws Exception {
        excel.setExcelFile("src/test/Resource/Login.xlsx", "SheetLogin");
        getLoginPage().loginFailWithAccountFail(PropertiesHelper.getValue("url"), excel.getCellData("username", 1), excel.getCellData("password", 1));
    }

    @Test(priority = 3)
    public void loginSuccess() throws Exception {
        excel.setExcelFile("src/test/Resource/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(PropertiesHelper.getValue("url"), excel.getCellData("username", 2), excel.getCellData("password", 2));
    }

    // case account chưa được kích hoạt -> chưa có data để test vì chưa register thành công

    @Test(priority = 4)
    public void loginSuccessWithGoogle() throws Exception {
        excel.setExcelFile("src/test/Resource/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccessWithGoogle(PropertiesHelper.getValue("url"), excel.getCellData("username", 3), excel.getCellData("password", 3));
    }

    @Test(priority = 5)
    public void loginFailWithGoogle() throws Exception {
        excel.setExcelFile("src/test/Resource/Login.xlsx", "SheetLogin");
        getLoginPage().loginFailWithGoogle(PropertiesHelper.getValue("url"), excel.getCellData("username", 4));
    }

    @Test(priority = 6)
    public void validationText() throws Exception {
        excel.setExcelFile("src/test/Resource/Login.xlsx", "SheetLogin");
        getLoginPage().validationText(PropertiesHelper.getValue("url"));
    }


}
