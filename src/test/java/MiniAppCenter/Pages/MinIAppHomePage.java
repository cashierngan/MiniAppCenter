package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

import java.sql.Driver;

public class MinIAppHomePage {
    public static By overviewPage = By.xpath("//span[contains(text(),'Overview')]");
    public static By buildPacket = By.xpath("//span[contains(text(),'Build')]");
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
        WebUI.waitForElementVisible(overviewPage);
        WebUI.clickElement(overviewPage);
    }

    public void goIntoBranchsPage(){
        WebUI.waitForElementVisible(branches);
        WebUI.clickElement(branches);
    }

    public void goIntoBuildListPage(){
        WebUI.waitForElementVisible(buildList);
        WebUI.clickElement(buildList);
    }

    public void goIntoBugReportPage(){
        WebUI.waitForElementVisible(bugReporter);
        WebUI.clickElement(bugReporter);
    }

    public void goIntoPermissionListPage() {
        WebUI.waitForElementVisible(managementPacket);
        WebUI.clickElement(managementPacket);
        WebUI.waitForElementVisible(permissionList);
        WebUI.clickElement(permissionList);
    }

    public void goIntoNotificationListPage() {
        WebUI.waitForElementVisible(managementPacket);
        WebUI.clickElement(managementPacket);
        WebUI.waitForElementVisible(notificationList);
        WebUI.clickElement(notificationList);
    }

    public void goIntoAppInfoPage(){
        WebUI.waitForElementVisible(settingPacket);
        WebUI.clickElement(settingPacket);
        WebUI.waitForElementVisible(appInfo);
        WebUI.clickElement(appInfo);
    }

    public void goIntoTeamInfoPage(){
        WebUI.waitForElementVisible(settingPacket);
        WebUI.clickElement(settingPacket);
        WebUI.waitForElementVisible(teamInfo);
        WebUI.clickElement(teamInfo);
    }

    public void goIntoDevelopmentInfoPage(){
        WebUI.waitForElementVisible(settingPacket);
        WebUI.clickElement(settingPacket);
        WebUI.waitForElementVisible(developmentInfo);
        WebUI.clickElement(developmentInfo);
    }
}



