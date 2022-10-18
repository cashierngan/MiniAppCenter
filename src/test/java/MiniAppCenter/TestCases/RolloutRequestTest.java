package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import org.testng.annotations.Test;

public class RolloutRequestTest extends BaseTest {
    @Test(priority = 1)
    public void rolloutRequest() throws Exception {
        ExcellHelpers excel = new ExcellHelpers();
        ExcellHelpers excel1 = new ExcellHelpers();
        ExcellHelpers excel2 = new ExcellHelpers();
        ExcellHelpers excel4 = new ExcellHelpers();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
        excel4.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RolloutRequest");
        getLoginPage().loginSuccessBeforeAddMiniApp(excel.getCellData("username", 9), excel.getCellData("password", 3) );
        getBuildMiniAppPage().viewMiniApp(excel1.getCellData("OrganizationName", 1), excel2.getCellData("MiniAppName", 3));
        getRolloutRequestPage().rolloutRequest(excel4.getCellData("RolloutDescription", 1));
    }

    @Test(priority = 2)
    public void approveRolloutRequest() throws Exception {
        ExcellHelpers excel = new ExcellHelpers();
        ExcellHelpers excel1 = new ExcellHelpers();
        ExcellHelpers excel2 = new ExcellHelpers();
        ExcellHelpers excel4 = new ExcellHelpers();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        excel1.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RegisterMiniAppPlan");
        excel2.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp");
        excel4.setExcelFile("datatest/RegisterMiniAppPlan.xlsx", "RolloutRequest");
        getLoginPage().loginSuccessBeforeAddMiniApp(excel.getCellData("username", 13), excel.getCellData("password", 13) );
        getRolloutRequestPage().approveRolloutRequest(excel2.getCellData("MiniAppName", 3),excel.getCellData("username", 13),excel2.getCellData("NoteApproveAndroid", 3),excel2.getCellData("NoteApproveIOS", 3));
    }
}
