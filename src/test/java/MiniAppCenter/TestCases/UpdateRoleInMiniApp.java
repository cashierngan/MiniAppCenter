package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.WebUI;

public class UpdateRoleInMiniApp extends BaseTest {
    ExcellHelpers excel = new ExcellHelpers();
    ExcellHelpers excel1 = new ExcellHelpers();
    ExcellHelpers excel2 = new ExcellHelpers();


    @Test
    public void updateMiniAppViewerToMiniAppDeveloper () throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 13), excel.getCellData("password", 13));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("OrganizationName", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 1) +"']"))){
            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));
        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));}
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",2));
    }

    @Test
    public void updateMiniAppViewerToMiniAdmin () throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 13), excel.getCellData("password", 13));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("OrganizationName", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 1) +"']"))){
            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));
        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));}
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",3));
    }

    @Test
    public void updateMiniAppDeveloperToMiniAppViewer () throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 13), excel.getCellData("password", 13));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("OrganizationName", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 1) +"']"))){
            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));
        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));}
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",2));
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",1));
    }

    @Test
    public void updateMiniAppDeveloperToMiniAppAdmin () throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 13), excel.getCellData("password", 13));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("OrganizationName", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 1) +"']"))){
            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));
        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));}
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",2));
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",3));
    }

    @Test
    public void updateMiniAppAdminToMiniAppDeveloper () throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 13), excel.getCellData("password", 13));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("OrganizationName", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 1) +"']"))){
            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));
        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));}
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",3));
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",2));
    }

    @Test
    public void updateMiniAppAdminToMiniAppViewer () throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 13), excel.getCellData("password", 13));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("OrganizationName", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 1) +"']"))){
            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));
        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));}
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",3));
        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",1));
    }

    @Test
    public void updateRoleWithoutSaving () throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 13), excel.getCellData("password", 13));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("OrganizationName", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 1) +"']"))){
            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));
        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));}
        getTeamSettingPage().editRoleForMemberInMiniAppWithoutSaving(excel1.getCellData("username",1),excel1.getCellData("Role",3));
        getMinIAppHomePage().goIntoTeamInfoPage();
        getTeamSettingPage().checkCurrentRoleOfUser(excel1.getCellData("username",1),excel1.getCellData("Role",1));
    }

    @Test
    public void updateOtherMemberBeforeSavePreviousMemberIsEdited () throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
        getLoginPage().loginSuccess(excel.getCellData("username", 13), excel.getCellData("password", 13));
        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("OrganizationName", 1));
        getMinIAppHomePage().goIntoTeamInfoPage();
        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 1) +"']"))){
            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));
        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));}
        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 6) +"']"))){
            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 6));
            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 6));
        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 6));}
        getTeamSettingPage().clickEditButtonOnOtherMemberWhenEditingMemberIsNotSaved(excel1.getCellData("username", 1),excel1.getCellData("username", 6),excel1.getCellData("Role",3));
    }

//    @Test
//    public void roleMiniAppDeveloperCanNotDeleteOtherMember () throws Exception{
//        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
//        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
//        excel1.setExcelFile("datatest/EditMiniAppMember.xlsx", "SheetEditMember");
//        getLoginPage().loginSuccess(excel.getCellData("username", 13), excel.getCellData("password", 13));
//        getDashboardPage().accessIntoAMiniApp(excel2.getCellData("OrganizationName", 1));
//        getMinIAppHomePage().goIntoTeamInfoPage();
//        if (WebUI.checkVisibilityOfItem(By.xpath("//tr[@data-row-key='"+ excel1.getCellData("username", 1) +"']"))){
//            getTeamSettingPage().deleteExitedUser(excel1.getCellData("username", 1));
//            getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));
//        }else {getTeamSettingPage().addNewMemberIntoMiniAppPageSuccessful(excel1.getCellData("username", 1));}
//        getTeamSettingPage().editRoleForMemberInMiniAppSuccessful(excel1.getCellData("username",1),excel1.getCellData("Role",2));
//        getLogoutPage().logout();
//        getLoginPage().loginSuccess(excel.getCellData("username", 15), excel.getCellData("password", 15));
//        getMinIAppHomePage().goIntoTeamInfoPage();
//
//    }
}
