package MiniAppCenter.TestCases;

import Common.BaseTest;
import helpers.ExcellHelpers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserAuthorizationTest extends BaseTest {
    private UserAuthorizationTest userAuthorizationTest;
    ExcellHelpers excel;

    @BeforeMethod
    public void UserAuthorizationTest(){
        userAuthorizationTest = new UserAuthorizationTest();
        excel = new ExcellHelpers();
    }

    @Test
    public void userAuthorizationMiniappAdmin(){

    }
}
