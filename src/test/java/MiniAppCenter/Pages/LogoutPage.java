package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class LogoutPage extends CommonPage{
    private By buttonLogout =By.xpath("//span[normalize-space()='Logout']");
    private By messageRegisterSuccess =By.xpath("//div[@class='ant-notification-notice-description']");

    public void logout(){
        WebUI.waitForElementVisible(DashboardPage.buttonAccount);
        WebUI.clickElement(DashboardPage.buttonAccount);
        WebUI.clickElement(buttonLogout);
        WebUI.waitForElementVisible(CommonPage.buttonLogin);
    }

    public void logoutWithHiddenMessage(){
        WebUI.waitForElementInvisible(messageRegisterSuccess);
        WebUI.waitForElementVisible(DashboardPage.buttonAccount);
        WebUI.clickElement(DashboardPage.buttonAccount);
        WebUI.sleep(4);
        WebUI.clickElement(buttonLogout);
        WebUI.waitForElementVisible(CommonPage.buttonLogin);
    }
}
