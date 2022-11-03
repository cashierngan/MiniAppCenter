package MiniAppCenter.TestCases;

import Common.BaseTest;

import helpers.*;
import org.testng.annotations.Test;

public class addRemoveMemberFromMiniApp extends BaseTest {
    ExcellHelpers excel = new ExcellHelpers();
    ExcellHelpers excel1 = new ExcellHelpers();
    ExcellHelpers excel2 = new ExcellHelpers();

    @Test(priority = 1)//Add member with correct phone data
    public void addMemberIntoMiniAppSuccessWithPhoneNumber() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel2.setExcelFile("datatest/EditMiniAppMember.xlsx", "MiniAppFolder");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("miniappname", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessfull(excel1.getCellData("username", 1));
        getLogoutPage().logout();
        getLoginPage().loginSuccess(excel.getCellData("username", 15), excel.getCellData("password", 15));
        getTeamSettingPage().checkMemberWasAddIntoMiniAppPage(excel2.getCellData("miniappname", 1));
    }

    @Test(priority = 2)//Add member with correct email data
    public void addMemberIntoMiniAppSuccessWithEmail() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel2.setExcelFile("datatest/EditMiniAppMember.xlsx", "MiniAppFolder");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("miniappname", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessfull(excel1.getCellData("username", 3));
        getLogoutPage().logout();
        getLoginPage().loginSuccess(excel.getCellData("username", 16), excel.getCellData("password", 16));
        getTeamSettingPage().checkMemberWasAddIntoMiniAppPage(excel2.getCellData("miniappname", 1));
    }

    @Test(priority = 3)//Add member with null data
    public void addMemberIntoMiniAppFailWithNulldata() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "MiniAppFolder");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel1.getCellData("miniappname", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithNullData();
    }

    @Test(priority = 4)//Add member with not created user data
    public void addMemberIntoMiniAppFailWithNotCreatedUser() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel2.setExcelFile("datatest/EditMiniAppMember.xlsx", "MiniAppFolder");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("miniappname", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithIncorrectData(excel1.getCellData("username", 2),getTeamSettingPage().informUserNotFound);
    }

    @Test(priority = 5)//Add member with user in the member list
    public void addMemberIntoMiniAppFailWithAddedUser() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel2.setExcelFile("datatest/EditMiniAppMember.xlsx", "MiniAppFolder");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("miniappname", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithIncorrectData(excel1.getCellData("username", 1),getTeamSettingPage().inFormMemberIsAdded);
    }

    @Test(priority = 6)//Add member with incorrect email format data
    public void addMemberIntoMiniAppFailWithWrongUserEmailData() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel2.setExcelFile("datatest/EditMiniAppMember.xlsx", "MiniAppFolder");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("miniappname", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithIncorrectData(excel1.getCellData("username", 4),getTeamSettingPage().informUserNotFound);
    }

    @Test(priority = 7) //Add member with Incorrect phone format data
    public void addMemberIntoMiniAppFailWithWrongPhoneData() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel2.setExcelFile("datatest/EditMiniAppMember.xlsx", "MiniAppFolder");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("miniappname", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().addNewMemberIntoMiniAppWithIncorrectData(excel1.getCellData("username", 5),getTeamSettingPage().inFormDataIsInvalid);
    }

    @Test(priority = 9) //Remove member with email
    public void removeMemberFromAMiniAppWithEmail() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel2.setExcelFile("datatest/EditMiniAppMember.xlsx", "MiniAppFolder");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("miniappname", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 3));
    }

    @Test(priority = 8) //Remove member with phone number
    public void removeMemberFromAMiniAppWithPhone() throws Exception{
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        excel2.setExcelFile("datatest/EditMiniAppMember.xlsx", "MiniAppFolder");
        getLoginPage().loginSuccess(excel.getCellData("username", 14), excel.getCellData("password", 14));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("miniappname", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
    }
}

