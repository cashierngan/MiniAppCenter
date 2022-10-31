package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class BuildMiniAppPage {
    private By menuBranches = By.xpath("//span[contains(text(),'Branches')]");
    private By titleConnectRepo = By.xpath("//div[@class='title___49HqJ']");
    private By serviceGitlab = By.xpath("(//div[@class='container___1KOGz'])[1]");
    private By titleRepoGitlap = By.xpath("//div[@id='rcDialogTitle0']");
    private By repositoryGitlab = By.xpath("(//div[@class='containerFullWidth___1m-Tn'])[1]");
    private By titleSelectGitlap = By.xpath("//div[@id='rcDialogTitle1']");
    private By selectGitlap = By.xpath("(//input[@value='[object Object]'])[2]");
    private By buttonConnectGitlap = By.xpath("//span[normalize-space()='Connect']");
    private By messageConnectGitlapSuccess = By.xpath("//div[@class='ant-notification-notice-message']");
    private By actionBuild = By.xpath("//button[@type='button']//span[contains(text(),'Build')]");
    private By titleBuildRequest = By.xpath("//div[@class='title___49HqJ']");
    private By buttonBuildNow = By.xpath("//span[normalize-space()='Build Now']");
    private By titleBuildDetail = By.xpath("//div[@class='title___49HqJ']");
    private By labelBuildCompleted = By.xpath("//div[@class='processText___XiJLZ']");
    private By buttonRequestRollout = By.xpath("//span[normalize-space()='Request Rollout']");
    private By buttonUnlink = By.xpath("//button[@class='ant-btn ant-btn-default unlink___v7HRG']");
    private By menuMiniApps = By.xpath("//span[@class='ant-menu-title-content'][normalize-space()='Mini Apps']");
    private By titleMiniAppList = By.xpath("//div[@class='title___49HqJ']");
    private By actionView = By.xpath("//span[normalize-space()='View']");
    private By inputSearchMiniApp = By.xpath("//input[@placeholder='Search Mini App']");
    private By titleMiniAppLinks = By.xpath("//div[@class='title___49HqJ']");
    private By inputTestLink = By.xpath("//input[@placeholder='Please input your test link']");
    private By inputProductLink = By.xpath("//input[@placeholder='Please input your production link']");
    private By buttonSaveAppLink = By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-block button___h63Gp']");
    private By buttonRequestRolloutAppLinks = By.xpath("//button[@class = 'ant-btn ant-btn-default ant-btn-block button___h63Gp']//span[normalize-space() = 'Request Rollout']");
    private By labelTestLink = By.xpath("//span[normalize-space()='Test Link']");
    private By labelProductLink = By.xpath("//span[normalize-space()='Production Link']");
    private By buttonEdit = By.xpath("//button[@class='ant-btn ant-btn-default ant-btn-block button___h63Gp']");
    private By messageUpdateAppLinkSuccess = By.xpath("//span[normalize-space()='Update successfully']");
    public void viewMiniApp(String menuName, String appName){
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + menuName + "']"));
        WebUI.clickElement(menuMiniApps);
        WebUI.verifyAssertTrueEqual(titleMiniAppList, "MINI APP LIST", "Title MINI APP LIST is NOT displayed");;
        WebUI.sleep(2);
        WebUI.setTextEnter(inputSearchMiniApp, appName);
        WebUI.sleep(2);
        WebUI.clickElement(actionView);
    }


    public void buildMiniAppReactNative(){
//        WebUI.verifyAssertTruIsDisplayed(titleConnectRepo, "Connect to Repo is NOT displayed");
//        WebUI.clickElement(serviceGitlab);
//        WebUI.verifyAssertTruIsDisplayed(titleRepoGitlap, "Gitlab popup is NOT displayed");
//        WebUI.clickElement(repositoryGitlab);
//        WebUI.sleep(100);
//        WebUI.verifyAssertTruIsDisplayed(titleSelectGitlap, "Select Gitlap popup is NOT displayed");
//        WebUI.clickElement(selectGitlap);
//        WebUI.clickElement(buttonConnectGitlap);
//        WebUI.verifyAssertTruIsDisplayed(messageConnectGitlapSuccess, "Connect Gitlab is failed");
        WebUI.sleep(2);
        WebUI.clickElement(actionBuild);
        WebUI.verifyAssertTrueIsDisplayed(titleBuildRequest, "Buid request page is NOT displayed");
        WebUI.clickElement(buttonBuildNow);
        WebUI.verifyAssertTrueIsDisplayed(titleBuildDetail, "Buid detail page is NOT displayed");
        WebUI.sleep(250);
        WebUI.verifyAssertTrueIsDisplayed(labelBuildCompleted, "Build is failed");
        WebUI.verifyAssertTrueIsDisplayed(buttonRequestRollout, "Request Rollout is NOT displayed");
    }

    public void buildMiniAppWebView(String testLink, String productionLink){
        WebUI.sleep(3);
        WebUI.verifyAssertTrueEqual(titleMiniAppLinks, "MINI APP LINKS", "Build Mini App WebView is NOT displayed");
        WebUI.clickElement(buttonEdit);
        WebUI.clearText(inputTestLink);
        WebUI.verifyAssertTrueIsDisplayed(labelTestLink, "Test Link text box is NOT displayed");
        WebUI.setText(inputTestLink, testLink);
        WebUI.verifyAssertTrueIsDisplayed(labelProductLink, "Product Link text box is NOT displayed");
        WebUI.clearText(inputProductLink);
        WebUI.setText(inputProductLink, productionLink);
        WebUI.clickElement(buttonSaveAppLink);
        WebUI.verifyAssertTrueIsDisplayed(messageUpdateAppLinkSuccess, "Update Mini App Link failed");
    }
}
