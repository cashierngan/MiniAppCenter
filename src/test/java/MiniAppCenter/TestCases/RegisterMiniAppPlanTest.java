package MiniAppCenter.TestCases;

import Common.BaseTest;
import MiniAppCenter.Pages.*;
import helpers.ExcellHelpers;
import helpers.PropertiesHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
public class RegisterMiniAppPlanTest extends BaseTest {
    private RegisterMiniAppPlanPage registerMiniAppPlanPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private LogoutPage logoutPage;
    private UserAuthorizationPage userAuthorizationPage;
    ExcellHelpers excel;
    ExcellHelpers excel1;
    @BeforeMethod
    public void RegisterMiniAppPlanTest() {
        registerMiniAppPlanPage = new RegisterMiniAppPlanPage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        logoutPage = new LogoutPage();
        userAuthorizationPage = new UserAuthorizationPage();
        excel = new ExcellHelpers();
        excel1 = new ExcellHelpers();
    }
    @Test(priority = 1)
    public void registerMiniAppPlanSuccess() throws Exception {
        excel.setExcelFile("src/test/Resource/Book1.xlsx", "SheetLogin");
        excel1.setExcelFile("src/test/Resource/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");

        registerPage.registerSuccessWithPhoneNumberNOTValid(PropertiesHelper.getValue("url"), excel.getCellData("username", 5), excel.getCellData("password", 3),
                excel.getCellData("password", 3), excel.getCellData("username", 6), excel.getCellData("code", 1),
                excel.getCellData("username", 7), excel.getCellData("username", 8), excel.getCellData("username", 10),
                excel.getCellData("password", 3), excel.getCellData("username", 9), excel.getCellData("password", 3));

        loginPage.loginSuccessFromRegister(excel.getCellData("username", 9), excel.getCellData("password", 3));


        registerMiniAppPlanPage.registerMiniAppPlanSuccess(excel1.getCellData("OrganizationName", 1), excel1.getCellData("ContactName", 1), excel1.getCellData("Title", 1), excel1.getCellData("Email", 1), excel1.getCellData("PhoneNumber", 1), excel1.getCellData("Title", 1));

        logoutPage.logout();


        loginPage.loginWithGoogleAccountAdmin(PropertiesHelper.getValue("url"), excel.getCellData("username", 3), excel.getCellData("password", 4));

        userAuthorizationPage.userAuthorizationMiniappAdmin(excel.getCellData("username", 9));

        logoutPage.logout();

        loginPage.loginSuccessFromRegister(excel.getCellData("username", 9), excel.getCellData("password", 3) );

        registerMiniAppPlanPage.viewMiniAppList(excel.getCellData("OrganizationName", 1));
    }

}
