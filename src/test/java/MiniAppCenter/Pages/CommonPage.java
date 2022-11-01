package MiniAppCenter.Pages;

import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.openqa.selenium.By;

public class CommonPage {

    public RegisterMiniAppPage registerMiniAppPage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public LogoutPage logoutPage;
    public UserAuthorizationPage userAuthorizationPage;
    public AddMiniAppsPage addMiniAppsPage;
    public ApprovalMiniAppPage approvalMiniAppPage;
    public AppInfoPage appInfoPage;
    public BuildMiniAppPage buildMiniAppPage;
    public RolloutRequestPage rolloutRequestPage;

    public MinIAppHomePage minIAppHomePage;

    public TeamSettingPage teamSettingPage;

    public DashboardPage dashboardPage;

    public static By buttonLogin = By.xpath("(//a[normalize-space() = 'Login'])[1]");

    public LoginPage getLoginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public RegisterPage getRegisterPage(){
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    public LogoutPage getLogoutPage(){
        if (logoutPage == null) {
            logoutPage = new LogoutPage();
        }
        return logoutPage;
    }

    public UserAuthorizationPage getUserAuthorizationPage(){
        if (userAuthorizationPage == null) {
            userAuthorizationPage = new UserAuthorizationPage();
        }
        return userAuthorizationPage;
    }

    public AddMiniAppsPage getMiniAppPage(){
        if (addMiniAppsPage == null) {
            addMiniAppsPage = new AddMiniAppsPage();
        }
        return addMiniAppsPage;
    }

    public ApprovalMiniAppPage getApprovalMiniAppPage(){
        if (approvalMiniAppPage == null) {
            approvalMiniAppPage = new ApprovalMiniAppPage();
        }
        return approvalMiniAppPage;
    }

    public RegisterMiniAppPage getRegisterMiniAppPlanPage(){
        if (registerMiniAppPage == null) {
            registerMiniAppPage = new RegisterMiniAppPage();
        }
        return registerMiniAppPage;
    }

    public AppInfoPage getAppInfoPage(){
        if (appInfoPage == null) {
            appInfoPage = new AppInfoPage();
        }
        return appInfoPage;
    }

    public BuildMiniAppPage getBuildMiniAppPage(){
        if (buildMiniAppPage == null) {
            buildMiniAppPage = new BuildMiniAppPage();
        }
        return buildMiniAppPage;
    }

    public RolloutRequestPage getRolloutRequestPage(){
        if (rolloutRequestPage == null) {
            rolloutRequestPage = new RolloutRequestPage();
        }
        return rolloutRequestPage;
    }

    public MinIAppHomePage getMinIAppHomePage() {
        if(minIAppHomePage == null){
            minIAppHomePage = new MinIAppHomePage();
        }
        return minIAppHomePage;
    }

    public TeamSettingPage getTeamSettingPage() {
        if (teamSettingPage == null){
            teamSettingPage = new TeamSettingPage();
        }
        return teamSettingPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null){
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }
}
