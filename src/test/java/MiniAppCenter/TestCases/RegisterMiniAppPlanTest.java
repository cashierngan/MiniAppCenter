package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import org.testng.annotations.Test;

public class RegisterMiniAppPlanTest extends BaseTest {

    @Test(priority = 1)
    public void registerMiniAppPlanSuccess() throws Exception {
        ExcellHelpers excel = new ExcellHelpers();
        ExcellHelpers excel1 = new ExcellHelpers();
        ExcellHelpers excel2 = new ExcellHelpers();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");

        getRegisterPage().registerSuccessWithPhoneNumberNOTValid(excel.getCellData("username", 5), excel.getCellData("password", 3),
                excel.getCellData("password", 3), excel.getCellData("username", 6), excel.getCellData("code", 1),
                excel.getCellData("username", 7), excel.getCellData("username", 8), excel.getCellData("username", 10),
                excel.getCellData("password", 3), excel.getCellData("username", 11), excel.getCellData("password", 3));
        getLoginPage().loginWithGoogleAccountAdmin(excel.getCellData("username", 3), excel.getCellData("password", 4));

        getUserAuthorizationPage().userAuthorizationMiniappAdmin(excel.getCellData("username", 11), excel.getCellData("authorization", 1));

        getLogoutPage().logout();
        getLoginPage().loginSuccessFromRegister(excel.getCellData("username", 11), excel.getCellData("password", 3));


        getRegisterMiniAppPlanPage().registerMiniAppPlanSuccessReactNative(excel1.getCellData("OrganizationName", 1), excel1.getCellData("ContactName", 1), excel1.getCellData("Title", 1), excel1.getCellData("Email", 1), excel1.getCellData("PhoneNumber", 1), excel1.getCellData("Title", 1));

        getRegisterMiniAppPlanPage().viewMiniAppList(excel1.getCellData("OrganizationName", 1));

        getMiniAppPage().addMiniAppReactNativeSuccess(excel2.getCellData("MiniAppName", 1), excel2.getCellData("Type",1), excel2.getCellData("ServiceScenario",1), excel2.getCellData("Description", 1), excel2.getCellData("Status", 1), excel1.getCellData("OrganizationName", 1));


    }

//    @Test(priority = 2, dataProvider = "data_provider_miniapp", dataProviderClass = DataProviderManager.class)
//    public void registerMiniAppPlanSuccess2(Hashtable < String, String > data) throws Exception {
//        ExcellHelpers excel = new ExcellHelpers();
//        ExcellHelpers excel1 = new ExcellHelpers();
//        ExcellHelpers excel2 = new ExcellHelpers();
//        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
//        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
//        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
//
//        getLoginPage().loginSuccessBeforeAddMiniApp(excel.getCellData("username", 11), excel.getCellData("password", 3) );
//
//        getRegisterMiniAppPlanPage().viewMiniAppList(excel1.getCellData("OrganizationName", 1));
//
////        miniAppsPage.addMiniAppWebViewSuccess(excel2.getCellData("MiniAppName", 2), excel2.getCellData("Type",2), excel2.getCellData("ServiceScenario",2), excel2.getCellData("Website/App", 2), excel2.getCellData("Description", 2), excel2.getCellData("Status", 2), excel1.getCellData("OrganizationName", 1));
////        miniAppsPage.addMiniAppWebViewSuccess(data.get("MiniAppName"), data.get("Type"), data.get("ServiceScenario"), data.get("Website/App"), data.get("Description"), data.get("Status"), "Ngăn Ngăn Shop");
//        getMiniAppPage().addMiniAppWebViewSuccess(data.get("MiniAppName"), data.get("Type"), data.get("ServiceScenario"), data.get("Website/App"), data.get("Description"), data.get("Status"));
//    }

//    @Test(priority = 3)
//    public void ApprovalMiniApp() throws Exception {
//        ExcellHelpers excel = new ExcellHelpers();
//        ExcellHelpers excel1 = new ExcellHelpers();
//        ExcellHelpers excel2 = new ExcellHelpers();
//        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
//        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
//        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
//
//        getLoginPage().loginWithGoogleAccountAdmin(excel.getCellData("username", 3), excel.getCellData("password", 4));
//
//        getApprovalMiniAppPage().ApprovedMiniApp(excel2.getCellData("MiniAppName", 2), excel1.getCellData("OrganizationName", 1));
//
//    }
}
