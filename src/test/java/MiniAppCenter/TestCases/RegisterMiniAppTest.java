package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import org.testng.annotations.Test;

public class RegisterMiniAppTest extends BaseTest {

    @Test(priority = 1)
    public void registerForBussiness() throws Exception {

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

    }
    @Test(priority =2)
    public void authorizationForBussinessAccount() throws Exception {

        ExcellHelpers excel = new ExcellHelpers();
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getLoginPage().loginWithGoogleAccountAdmin(excel.getCellData("username", 3), excel.getCellData("password", 4));
        getUserAuthorizationPage().userAuthorizationMiniappAdmin(excel.getCellData("username", 11), excel.getCellData("authorization", 1));
        getLogoutPage().logout();

    }

    @Test(priority =3)
    public void addMiniApp() throws Exception {

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

}
