package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class MinIAppHomePage {
    public static By overviewPage = By.xpath("//span[contains(text(),'Overview')]");
//  public static By buildPacket = By.xpath("//span[contains(text(),'Build')]");
    public static By branches = By.xpath("//span[contains(text(),'Branches')]");
    public static By buildList = By.xpath("//span[contains(text(),'Build List')]");
    public static By bugReporter = By.xpath("//span[contains(text(),'Crashlytics')]");
    public static By managementPacket = By.xpath("//span[contains(text(),'Management')]");
    public static By permissionList = By.xpath("//span[contains(text(),'Permission List')]");
    public static By notificationList = By.xpath("//span[contains(text(),'Notification List')]");
    public static By settingPacket = By.xpath("//span[contains(text(),'Settings')]");
    public static By appInfo = By.xpath("//span[contains(text(),'App Info')]");
    public static By teamInfo = By.xpath("//span[contains(text(),'Team')]");
    public static By developmentInfo = By.xpath("//span[contains(text(),'Development')]");

    public void goIntoOverviewPage(){
        WebUI.clickElement(overviewPage);
    }

    public void goIntoBranchsPage(){
        WebUI.clickElement(branches);
    }

    public void goIntoBuildListPage(){
        WebUI.clickElement(buildList);
    }

    public void goIntoBugReportPage(){
        WebUI.clickElement(bugReporter);
    }

    public void goIntoPermissionListPage() {
        WebUI.clickElement(managementPacket);
        WebUI.clickElement(permissionList);
    }

    public void goIntoNotificationListPage() {
        WebUI.clickElement(managementPacket);
        WebUI.clickElement(notificationList);
    }

    public void goIntoAppInfoPage(){
        WebUI.clickElement(settingPacket);
        WebUI.clickElement(appInfo);
    }

    public void goIntoTeamInfoPage(){
        WebUI.waitForElementVisible(settingPacket);
        WebUI.clickElement(settingPacket);
        WebUI.clickElement(teamInfo);
    }

    public void goIntoDevelopmentInfoPage(){
        WebUI.clickElement(settingPacket);
        WebUI.clickElement(developmentInfo);
    }
}



