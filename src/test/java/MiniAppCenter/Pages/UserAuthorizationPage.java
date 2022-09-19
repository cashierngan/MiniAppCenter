package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class UserAuthorizationPage {
    private By menuUserAuthorization = By.xpath("//span[@class='ant-menu-title-content' and normalize-space()='User Authorization']");
    private By inputSearchUser = By.xpath("//input[@placeholder='Search User']");
    private By selectRole = By.xpath("//span[@title='MiniApp Developer']");
    private By selectRoleMiniAppAdmin = By.xpath("//div[contains(text(),'MiniApp Admin')]");
    private By titleUserAuthorization = By.xpath("//div[@class='title___49HqJ']");

    public void userAuthorizationMiniappAdmin(String phoneNumber){
        WebUI.waitForElementVisible(DashboardPage.menuSystemManagement);
        WebUI.clickElement(DashboardPage.menuSystemManagement);
        WebUI.clickElement(menuUserAuthorization);
        WebUI.waitForElementVisible(titleUserAuthorization);
        WebUI.verifyAssertTruIsDisplayed(titleUserAuthorization, "Title User Authorization is NOT displayed");
        WebUI.setText(inputSearchUser, phoneNumber);
        WebUI.keydownEnter();
        WebUI.clickElement(selectRole);
        WebUI.clickElement(selectRoleMiniAppAdmin);
//        WebUI.verifyAssertTrueEqual(selectRole, "MiniApp Admin", "MiniApp Admin is NOT selected");
    }
}
