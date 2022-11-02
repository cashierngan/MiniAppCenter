package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class addRemoveMenberFromMiniApp extends BaseTest {
    ExcellHelpers excel = new ExcellHelpers();

    @Test(priority = 1)
    public void addMenberIntoMiniAppSuccessWithPhoneNumber() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        getMinIAppHomePage().goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        getTeamSettingPage().addNewMenberIntoMiniAppPageSuccessfull(excel.getCellData("username", 1));
        getLogoutPage().logout();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 15), excel.getCellData("password", 15));
        getTeamSettingPage().checkMemberWasAddIntoMiniAppPage();
    }

    @Test(priority = 1)
    public void addMenberIntoMiniAppSuccessWithEmail() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        getMinIAppHomePage().goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        getTeamSettingPage().addNewMenberIntoMiniAppPageSuccessfull(excel.getCellData("username", 3));
        getLogoutPage().logout();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 16), excel.getCellData("password", 16));
        getTeamSettingPage().checkMemberWasAddIntoMiniAppPage();
    }

    @Test(priority = 3)
    public void addMenberIntoMiniAppFailWithNulldata() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMenberIntoMiniAppWithNullData();
    }

    @Test(priority = 4)
    public void addMenberIntoMiniAppFailWithNotCreatedUser() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        getMinIAppHomePage().goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        getTeamSettingPage().addNewMenberIntoMiniAppWithIncorrectData(excel.getCellData("username", 2),getTeamSettingPage().informUserNotFound);
    }

    @Test(priority = 5)
    public void addMenberIntoMiniAppFailWithAddedUser() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        getMinIAppHomePage().goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        getTeamSettingPage().addNewMenberIntoMiniAppWithIncorrectData(excel.getCellData("username", 1),getTeamSettingPage().inFormMemberIsAdded);
    }

    @Test(priority = 6)
    public void addMenberIntoMiniAppFailWithWrongUserEmailData() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        getMinIAppHomePage().goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        getTeamSettingPage().addNewMenberIntoMiniAppWithIncorrectData(excel.getCellData("username", 4),getTeamSettingPage().inFormDataIsInvalid);
    }

    @Test(priority = 7)
    public void addMenberIntoMiniAppFailWithWrongPhoneEmailData() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        getMinIAppHomePage().goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        getTeamSettingPage().addNewMenberIntoMiniAppWithIncorrectData(excel.getCellData("username", 6),getTeamSettingPage().inFormDataIsInvalid);
    }

    @Test(priority = 7)
    public void removeMenberFromAMiniAppWithEmail() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        getMinIAppHomePage().goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        getTeamSettingPage().deleteExitedUser(excel.getCellData("username", 3));
    }

    @Test(priority = 8)
    public void removeMenberFromAMiniAppWithPhone() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(dashboardPage.namFolder, dashboardPage.miniAppCatogery, dashboardPage.viewButton);
        getMinIAppHomePage().goIntoTeamInfoPage();
        excel.setExcelFile("datatest/EditMiniAppMenber.xlsx", "SheetAddMenber");
        getTeamSettingPage().deleteExitedUser(excel.getCellData("username", 1));
    }
}

