package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class RolloutRequestPage {
    private By menuBuildList = By.xpath("//span[contains(text(),'Build List')]");
    private By rolloutRequestAndroid = By.xpath("(//span[contains(text(),'Rollout Request')])[1]");
    private By rolloutRequestIOS = By.xpath("(//span[contains(text(),'Rollout Request')])[2]");
    private By titleRolloutRequest = By.xpath("//div[normalize-space()='Rollout Request']");
    private By labelAndroid = By.xpath("//div[normalize-space()='Android']");
    private By inputRolloutDescription = By.xpath("//textarea[@placeholder='Please input your description']");
    private By buttonCreateRollout = By.xpath("//button[@class='ant-btn ant-btn-primary button___h63Gp']");
    private By labelIOS = By.xpath("//div[normalize-space()='iOS']");
    private By messageRolloutRequestSuccess = By.xpath("//span[normalize-space()='Your rollout request has been created!']");
    private By titleBuildList = By.xpath("//div[@class='title___49HqJ']");
    private By menuRolloutRequestList = By.xpath("//span[normalize-space()='Rollout Request List']");
    private By titleRolloutRequestList = By.xpath("//div[@class='title___49HqJ']");
    private By searchRequestRollout = By.xpath("//input[@placeholder='Search Request']");
    private By actionViewRolloutRequestIOS = By.xpath("(//span[contains(text(),'View')])[1]");
    private By actionViewRolloutRequestAndroid = By.xpath("(//span[contains(text(),'View')])[2]");
    private By getTitleRolloutRequest = By.xpath("//div[normalize-space()='Rollout Request']");
    private By tabAssign = By.xpath("//div[@id='rc-tabs-1-tab-Assign']");
    private By inputAddMember = By.xpath("//div[@class='ant-select-selection-overflow']");
    private By selectAccAssign = By.xpath("//div[@class='content___1OrUe']//div[contains(text(),'0909872304')]");
    private By buttonCloseAssigntab = By.xpath("//span[normalize-space()='Close']");
    private By tabInformation = By.xpath("//div[@id='rc-tabs-2-tab-Information']");
    private By buttonStartReview = By.xpath("//span[normalize-space()='Start Review']");
    private By messageStartReviewSuccess = By.xpath("//div[@class='ant-notification-notice-message']");
    private By messageAssignSuccess = By.xpath("//span[normalize-space()='Assigned member successfully.']");
    private By inputNoteApprove = By.xpath("//textarea[@placeholder='Why this request is rejected or approved?']");
    private By buttonApprove = By.xpath("//button[@class='ant-btn ant-btn-default approvalBtn___PXmfo']");
    private By checkboxAppName = By.xpath("(//span[@class = 'ant-checkbox'])[1]");
    private By titleAssignRolloutRequest = By.xpath("//div[@id='rcDialogTitle0']");
    private By buttonConfirmAssign = By.xpath("//span[normalize-space()='Confirm']");
    private By buttonAssign = By.xpath("//span[normalize-space() = 'Assign']/parent::button");
    private By messageApproveSuccess = By.xpath("//span[normalize-space()='Approved rollout request successfully.']");
    private By outside = By.xpath("//div[@class='ant-table ant-table-small ant-table-ping-right ant-table-scroll-horizontal']//th[@class='ant-table-cell'][normalize-space()='App ID']");

    public void rolloutRequest(String description){
//        WebUI.clickElement(DashboardPage.menuBuild);
        WebUI.clickElement(menuBuildList);
        WebUI.verifyAssertTrueIsDisplayed(titleBuildList, "Build List page is NOT displayed");
        WebUI.clickElement(rolloutRequestAndroid);
//        WebUI.verifyAssertTrueIsDisplayed(titleRolloutRequest, "Create rollout request is NOT displayed");
//        WebUI.verifyAssertTrueIsDisplayed(labelAndroid, "Android label is NOT displayed");
//        WebUI.clearText(inputRolloutDescription);
        WebUI.setText(inputRolloutDescription, description);
        WebUI.clickElement(buttonCreateRollout);
        WebUI.verifyAssertTrueIsDisplayed(messageRolloutRequestSuccess, "Rollout request is Failed");

        WebUI.sleep(4);
        WebUI.clickElement(rolloutRequestIOS);
//        WebUI.verifyAssertTrueIsDisplayed(titleRolloutRequest, "Create rollout request is NOT displayed");
//        WebUI.verifyAssertTrueIsDisplayed(labelIOS, "IOS label is NOT displayed");
        WebUI.setText(inputRolloutDescription, description);
        WebUI.clickElement(buttonCreateRollout);
        WebUI.verifyAssertTrueIsDisplayed(messageRolloutRequestSuccess, "Rollout request is Failed");
    }

    public void approveRolloutRequest(String appName, String asignacc, String noteApproveAndroid, String noteApproveIOS){
        WebUI.clickElement(DashboardPage.menuMiniAppManagement);
        WebUI.clickElement(menuRolloutRequestList);
        WebUI.sleep(7);
        WebUI.verifyAssertTrueIsDisplayed(titleRolloutRequestList, "Rollout Request List is NOT displayed");
        WebUI.sleep(2);
        WebUI.setTextEnter(searchRequestRollout, appName);
        WebUI.sleep(2);
        WebUI.clickElement(checkboxAppName);
        WebUI.clickElement(buttonAssign);
        WebUI.sleep(2);
        WebUI.verifyAssertTrueIsDisplayed(titleAssignRolloutRequest, "Assign Rollout Request page is NOT displayed");
        WebUI.clickElement(inputAddMember);
        WebUI.clickElement(selectAccAssign);
        WebUI.clickElement(inputAddMember);
        WebUI.clickElement(buttonConfirmAssign);
//        WebUI.verifyAssertTrueIsDisplayed(messageAssignSuccess, "Assign is failed");
        WebUI.sleep(7);
        WebUI.clickElement(actionViewRolloutRequestAndroid);
//        WebUI.verifyAssertTrueEqual(titleRolloutRequest, "Rollout Request page is NOT displayed", "Rollout Request page is NOT displayed");
        WebUI.clickElement(buttonStartReview);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueIsDisplayed(messageStartReviewSuccess, "Reviewing Mini App Android is failed");
        WebUI.clickElement(actionViewRolloutRequestIOS);
        WebUI.sleep(2);
//        WebUI.verifyAssertTrueEqual(titleRolloutRequest, "Rollout Request page is NOT displayed", "Rollout Request page is NOT displayed");
        WebUI.clickElement(buttonStartReview);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueIsDisplayed(messageStartReviewSuccess, "Reviewing Mini App IOS is failed");
        WebUI.clickElement(actionViewRolloutRequestAndroid);
        WebUI.setText(inputNoteApprove, noteApproveAndroid);
        WebUI.clickElement(buttonApprove);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueIsDisplayed(messageApproveSuccess, "Approve Mini App is failed");
        WebUI.clickElement(actionViewRolloutRequestIOS);
        WebUI.setText(inputNoteApprove, noteApproveIOS);
        WebUI.clickElement(buttonApprove);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueIsDisplayed(messageApproveSuccess, "Approve Mini App is failed");
    }
}
