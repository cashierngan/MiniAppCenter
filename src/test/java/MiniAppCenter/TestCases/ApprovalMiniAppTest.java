package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import org.testng.annotations.Test;

public class ApprovalMiniAppTest extends BaseTest {

    @Test(priority = 1)
    public void ApprovalMiniApp() throws Exception {
        ExcellHelpers excel = new ExcellHelpers();
        ExcellHelpers excel1 = new ExcellHelpers();
        ExcellHelpers excel2 = new ExcellHelpers();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
        getLoginPage().loginWithGoogleAccountAdmin(excel.getCellData("username", 3), excel.getCellData("password", 4));
        getApprovalMiniAppPage().ApprovedMiniApp(excel2.getCellData("MiniAppName", 1), excel1.getCellData("OrganizationName", 1));

    }
}
