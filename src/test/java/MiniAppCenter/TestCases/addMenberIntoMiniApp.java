package MiniAppCenter.TestCases;

import Common.BaseTest;
import MiniAppCenter.Pages.*;
import helpers.ExcellHelpers;
import helpers.PropertiesHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addMenberIntoMiniApp extends BaseTest {
    private DashboardPage dashboardPage;
    private MinIAppHomePage minIAppHomePage;
    private LoginPage loginPage;
    private TeamSettingPage teamSettingPage;
    private LogoutPage logoutPage;
    ExcellHelpers excel;

    @BeforeMethod
    public void addMenberIntoMiniApp() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        minIAppHomePage = new MinIAppHomePage();
        teamSettingPage = new TeamSettingPage();
        logoutPage = new LogoutPage();
        excel = new ExcellHelpers();
    }

    @Test(priority = 1)
    public void addMenberIntoMiniAppSuccess() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        loginPage.loginSuccess(PropertiesHelper.getValue("url"), excel.getCellData("username", 14), excel.getCellData("password", 14));
        dashboardPage.accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        minIAppHomePage.goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        teamSettingPage.addNewMenberIntoMiniAppPageSuccessfull(excel.getCellData("username", 1));
        logoutPage.logout();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        loginPage.loginSuccess(PropertiesHelper.getValue("url"), excel.getCellData("username", 15), excel.getCellData("password", 15));
        teamSettingPage.checkMemberWasAddIntoMiniAppPage();
    }

    @Test(priority = 2)
    public void addMenberIntoMiniAppFailWithNulldata() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        loginPage.loginSuccess(PropertiesHelper.getValue("url"), excel.getCellData("username", 14), excel.getCellData("password", 14));
        dashboardPage.accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        minIAppHomePage.goIntoTeamInfoPage();
        teamSettingPage.addNewMenberIntoMiniAppWithNullData();
    }

    @Test(priority = 2)
    public void addMenberIntoMiniAppFailWithNotCreatedUser() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        loginPage.loginSuccess(PropertiesHelper.getValue("url"), excel.getCellData("username", 14), excel.getCellData("password", 14));
        dashboardPage.accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        minIAppHomePage.goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        teamSettingPage.addNewMenberIntoMiniAppWithUserNotCreated(excel.getCellData("username", 2));
    }
}
