package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class LogoutPage {
    private static By buttonLogout =By.xpath("//span[normalize-space()='Logout']");

    public void logout(){
        WebUI.waitForElementVisible(DashboardPage.buttonAccount);
        WebUI.clickElement(DashboardPage.buttonAccount);
        WebUI.clickElement(buttonLogout);
        WebUI.waitForElementVisible(CommonPage.buttonLogin);
    }
}
