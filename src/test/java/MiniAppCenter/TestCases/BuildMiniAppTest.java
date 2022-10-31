package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import org.testng.annotations.Test;

public class BuildMiniAppTest extends BaseTest {

    @Test(priority = 1)
    public void buildMiniappReactNative() throws Exception {
        ExcellHelpers excel = new ExcellHelpers();
        ExcellHelpers excel1 = new ExcellHelpers();
        ExcellHelpers excel2 = new ExcellHelpers();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
        getLoginPage().loginSuccessBeforeAddMiniApp(excel.getCellData("username", 9), excel.getCellData("password", 3) );
        getBuildMiniAppPage().viewMiniApp(excel1.getCellData("OrganizationName", 1), excel2.getCellData("MiniAppName", 3));
        getBuildMiniAppPage().buildMiniAppReactNative();
    }

//    @Test(priority = 2)
//    public void buildMiniappWebView() throws Exception {
//        ExcellHelpers excel = new ExcellHelpers();
//        ExcellHelpers excel1 = new ExcellHelpers();
//        ExcellHelpers excel2 = new ExcellHelpers();
//        ExcellHelpers excel3 = new ExcellHelpers();
//        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
//        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
//        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
//        excel3.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "BuildMiniApp");
//        getLoginPage().loginSuccessBeforeAddMiniApp(excel.getCellData("username", 9), excel.getCellData("password", 3) );
//        getBuildMiniAppPage().viewMiniApp(excel1.getCellData("OrganizationName", 1), excel2.getCellData("MiniAppName", 2));
//        getBuildMiniAppPage().buildMiniAppWebView(excel3.getCellData("LinkTest", 1), excel3.getCellData("LinkProduct", 1));
//
//    }
}
