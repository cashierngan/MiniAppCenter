package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class ApprovalMiniAppPage extends CommonPage{
    private By menuMiniAppList = By.xpath("//span[@class='ant-menu-title-content'][normalize-space()='Mini App List']");
    private By titleMiniAppList = By.xpath("//div[@class='title___49HqJ']");
    private By inputSearchMiniApp = By.xpath("//input[@placeholder='Search Mini App']");
    private By actionView = By.xpath("//span[@class='viewAction___2dWqD']");
    private By titleMiniAppDetail = By.xpath("//div[@id='rcDialogTitle0']");
    private By miniAppName = By.xpath("//span[@class='ant-descriptions-item-content'][normalize-space()='Bear Coffee 02']");
    private By organizationName = By.xpath("//span[contains(text(),'Ngăn Ngăn Shop')]");
    private By buttonApprove = By.xpath("//button[@class='ant-btn ant-btn-default approvalBtn___1Ca7r']");
    private By buttonReject = By.xpath("//button[@class='ant-btn ant-btn-default rejectBtn___3M72K']");
    private By messageApproveSuccess = By.xpath("//div[@class='ant-notification-notice-message']");
    private By statusPending = By.xpath("//span[normalize-space()='Pending']");

    public void ApprovedMiniApp(String appName, String organiName){
        WebUI.clickElement(DashboardPage.menuMiniAppManagement);
        WebUI.clickElement(menuMiniAppList);
        WebUI.verifyAssertTrueIsDisplayed(titleMiniAppList, "Mini App List is NOT displayed");
        WebUI.sleep(2);
        WebUI.setTextEnter(inputSearchMiniApp, appName);
        WebUI.sleep(2);
        WebUI.verifyAssertTrueIsDisplayed(statusPending, "Mini App is failed status");
        WebUI.clickElement(actionView);
        WebUI.verifyAssertTrueIsDisplayed(titleMiniAppDetail, "Mini App Detail is NOT displayed");
        WebUI.verifyAssertTrueEqual(By.xpath("//span[@class='ant-descriptions-item-content'][normalize-space()='" + appName + "']"), appName, "Mini App Name is NOT corrected");
        WebUI.verifyAssertTrueEqual(By.xpath("//span[contains(text(),'" + organiName + "')]"), organiName, "Organization Name is NOT corrected");
        WebUI.clickElement(buttonApprove);
        WebUI.verifyAssertTrueIsDisplayed(messageApproveSuccess, "Approve Mini App is failed");
    }
}
