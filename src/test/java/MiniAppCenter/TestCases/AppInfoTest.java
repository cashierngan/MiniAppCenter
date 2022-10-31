package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import org.testng.annotations.Test;

public class AppInfoTest extends BaseTest {
    @Test (priority = 1)
    public void configAppInfo() throws Exception {
        ExcellHelpers excel = new ExcellHelpers();
        ExcellHelpers excel1 = new ExcellHelpers();
        ExcellHelpers excel2 = new ExcellHelpers();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
        getLoginPage().loginSuccessBeforeAddMiniApp(excel.getCellData("username", 11), excel.getCellData("password", 3) );
        getMiniAppPage().searchAndViewMiniApp(excel2.getCellData("MiniAppName", 1), excel1.getCellData("OrganizationName", 1));
        getAppInfoPage().configAppInfo(excel2.getCellData("MiniAppName", 1), excel2.getCellData("ShortDescription", 3), excel2.getCellData("CSPhoneNumber", 3));
    }
}
