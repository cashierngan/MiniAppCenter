package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class addRemoveMemberFromMiniApp extends BaseTest {
    ExcellHelpers excel = new ExcellHelpers();

    @Test(priority = 1)
    public void addMemberIntoMiniAppSuccessWithPhoneNumber() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel.getCellData("username", 6));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessfull(excel.getCellData("username", 1));
        getLogoutPage().logout();
        getLoginPage().loginSuccess(excel.getCellData("username", 15), excel.getCellData("password", 15));
        getTeamSettingPage().checkMemberWasAddIntoMiniAppPage();
    }

    @Test(priority = 2)
    public void addMemberIntoMiniAppSuccessWithEmail() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel.getCellData("username", 6));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessfull(excel.getCellData("username", 3));
        getLogoutPage().logout();
        getLoginPage().loginSuccess(excel.getCellData("username", 16), excel.getCellData("password", 16));
        getTeamSettingPage().checkMemberWasAddIntoMiniAppPage();
    }

    @Test(priority = 3)
    public void addMemberIntoMiniAppFailWithNulldata() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel.getCellData("username", 6));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithNullData();
    }

    @Test(priority = 4)
    public void addMemberIntoMiniAppFailWithNotCreatedUser() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel.getCellData("username", 6));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithIncorrectData(excel.getCellData("username", 2),getTeamSettingPage().informUserNotFound);
    }

    @Test(priority = 5)
    public void addMemberIntoMiniAppFailWithAddedUser() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel.getCellData("username", 6));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithIncorrectData(excel.getCellData("username", 1),getTeamSettingPage().inFormMemberIsAdded);
    }

    @Test(priority = 6)
    public void addMemberIntoMiniAppFailWithWrongUserEmailData() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel.getCellData("username", 6));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithIncorrectData(excel.getCellData("username", 4),getTeamSettingPage().informUserNotFound);
    }

    @Test(priority = 7)
    public void addMemberIntoMiniAppFailWithWrongPhoneData() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel.getCellData("username", 6));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithIncorrectData(excel.getCellData("username", 5),getTeamSettingPage().inFormDataIsInvalid);
    }

    @Test(priority = 9)
    public void removeMemberFromAMiniAppWithEmail() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel.getCellData("username", 6));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().deleteExitedUser(excel.getCellData("username", 3));
    }

    @Test(priority = 8)
    public void removeMemberFromAMiniAppWithPhone() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel.getCellData("username", 6));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().deleteExitedUser(excel.getCellData("username", 1));
    }
}

