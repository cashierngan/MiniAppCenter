package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import org.testng.annotations.Test;

public class AddMiniAppTest extends BaseTest {

    @Test(priority =1)
    public void addMiniAppReactNative() throws Exception {

        ExcellHelpers excel = new ExcellHelpers();
        ExcellHelpers excel1 = new ExcellHelpers();
        ExcellHelpers excel2 = new ExcellHelpers();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
        getLoginPage().loginSuccessFromRegister(excel.getCellData("username", 11), excel.getCellData("password", 3));
        getRegisterMiniAppPlanPage().registerMiniAppPlanSuccessReactNative(excel1.getCellData("OrganizationName", 1), excel1.getCellData("ContactName", 1), excel1.getCellData("Title", 1), excel1.getCellData("Email", 1), excel1.getCellData("PhoneNumber", 1), excel1.getCellData("Title", 1));
        getRegisterMiniAppPlanPage().viewMiniAppList(excel1.getCellData("OrganizationName", 1));
        getMiniAppPage().addMiniAppReactNativeSuccess(excel2.getCellData("MiniAppName", 1), excel2.getCellData("Type",1), excel2.getCellData("ServiceScenario",1), excel2.getCellData("Description", 1), excel2.getCellData("Status", 1), excel1.getCellData("OrganizationName", 1));

    }

//    @Test(priority =1)
//    public void addMiniAppWebApp() throws Exception {
//
//        ExcellHelpers excel = new ExcellHelpers();
//        ExcellHelpers excel1 = new ExcellHelpers();
//        ExcellHelpers excel2 = new ExcellHelpers();
//        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
//        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
//        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
//        getLoginPage().loginSuccessFromRegister(excel.getCellData("username", 11), excel.getCellData("password", 3));
////        getRegisterMiniAppPlanPage().registerMiniAppPlanSuccessReactNative(excel1.getCellData("OrganizationName", 1), excel1.getCellData("ContactName", 1), excel1.getCellData("Title", 1), excel1.getCellData("Email", 1), excel1.getCellData("PhoneNumber", 1), excel1.getCellData("Title", 1));
//        getRegisterMiniAppPlanPage().viewMiniAppList(excel1.getCellData("OrganizationName", 1));
//        getMiniAppPage().addMiniAppWebViewSuccess(excel2.getCellData("MiniAppName", 2), excel2.getCellData("Type",2), excel2.getCellData("ServiceScenario",2), excel1.getCellData("Website/App", 2), excel2.getCellData("Description", 2), excel2.getCellData("Status", 2));
//
//    }

}
