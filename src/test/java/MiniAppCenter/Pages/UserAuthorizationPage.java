package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class UserAuthorizationPage extends CommonPage{
    private By menuUserAuthorization = By.xpath("//span[@class='ant-menu-title-content' and normalize-space()='User Authorization']");
    private By inputSearchUser = By.xpath("//input[@placeholder='Search User']");
    private By selectRole = By.xpath("//div[@class='ant-select selectRole___BAGzN ant-select-single ant-select-show-arrow']");
    private By selectRoleMiniAppAdmin = By.xpath("//div[contains(text(),'MiniApp Admin')]");
    private By titleUserAuthorization = By.xpath("//div[@class='title___49HqJ']");

    public void userAuthorizationMiniappAdmin(String phoneNumber, String authorization){
        WebUI.waitForElementVisible(DashboardPage.menuSystemManagement);
        WebUI.clickElement(DashboardPage.menuSystemManagement);
        WebUI.clickElement(menuUserAuthorization);
        WebUI.waitForElementVisible(titleUserAuthorization);
        WebUI.verifyAssertTrueIsDisplayed(titleUserAuthorization, "Title User Authorization is NOT displayed");
        WebUI.setTextEnter(inputSearchUser, phoneNumber);
        WebUI.sleep(2);
        WebUI.clickElement(selectRole);
        WebUI.clickElement(By.xpath("//div[contains(text(),'" + authorization + "')]"));
        WebUI.waitForElementVisible(By.xpath("//span[@title='" + authorization + "']"));
        WebUI.sleep(3);
    }
}
