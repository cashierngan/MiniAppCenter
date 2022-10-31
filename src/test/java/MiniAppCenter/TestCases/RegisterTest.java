package MiniAppCenter.TestCases;

import Common.BaseTest;
import MiniAppCenter.Pages.RegisterPage;
import helpers.ExcellHelpers;
import helpers.PropertiesHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage;
    ExcellHelpers excel;

    @BeforeMethod
    public void RegisterTest() {
        excel = new ExcellHelpers();
        registerPage = new RegisterPage();
    }

    @Test(priority = 1)
    public void registerValidNullDataWithPhoneNumber() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getRegisterPage().registerValidNullDataWithPhoneNumber(PropertiesHelper.getValue("url"));
    }

    @Test(priority = 2)
    public void registerValidNullDataWithEmail() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getRegisterPage().registerValidNullDataWithEmail(PropertiesHelper.getValue("url"));

    }

    @Test(priority = 3)
    public void registerSuccessWithPhoneNumber() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getRegisterPage().registerSuccessWithPhoneNumber(excel.getCellData("username", 5), excel.getCellData("password", 5),
                excel.getCellData("password", 5), excel.getCellData("username", 6), excel.getCellData("code", 1),
                excel.getCellData("username", 7), excel.getCellData("username", 8), excel.getCellData("username", 10),
                excel.getCellData("password", 9), excel.getCellData("username", 9), excel.getCellData("password", 9));

    }


    @Test(priority = 5)
    public void validationTextRegister() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getRegisterPage().validationTextRegister(PropertiesHelper.getValue("url"));
    }

    @Test(priority = 6)
    public void registerSuccessWithPhoneNumberNOTValid() throws Exception {
        excel.setExcelFile("datatest/Login.xlsx", "SheetLogin");
        getRegisterPage().registerSuccessWithPhoneNumberNOTValid(excel.getCellData("username", 5), excel.getCellData("password", 5),
                excel.getCellData("password", 5), excel.getCellData("username", 6), excel.getCellData("code", 1),
                excel.getCellData("username", 7), excel.getCellData("username", 8), excel.getCellData("username", 10),
                excel.getCellData("password", 9), excel.getCellData("username", 9), excel.getCellData("password", 9));

    }
}
