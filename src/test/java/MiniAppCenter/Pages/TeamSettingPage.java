package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;


public class TeamSettingPage {

    public static By inviteMenberButton = By.xpath("//span[contains(text(),'Invite Member')]");
    public static By inputEmailfield = By.xpath("//input[@id='email']");
    public static By buttonInviteOnPopup = By.xpath("//button[@class='ant-btn ant-btn-primary button___h63Gp']/span[text()='Invite']");
    public static By notiInformAddSuccess = By.xpath("//span[contains(text(),'Added member successfully')]");

    public static By dataIsRequired = By.xpath("//div[contains(text(),'Email or phone number is required')]");

    public static By informUserNotFound = By.xpath("//span[contains(text(),'User information not found')]");

    public static By notiInformDeleteSuccess = By.xpath("//span[contains(text(),'Removed member successfully')]");
    public void addNewMenberIntoMiniAppPageSuccessfull(String emailAddedMenber){
        WebUI.waitForElementVisible(inviteMenberButton);
        WebUI.clickElement(inviteMenberButton);
        WebUI.waitForElementVisible(inputEmailfield);
        WebUI.setText(inputEmailfield,emailAddedMenber);
        WebUI.clickElement(buttonInviteOnPopup);
        WebUI.waitForElementVisible(notiInformAddSuccess);
        WebUI.verifyAssertTruIsDisplayed(notiInformAddSuccess, "invite member's failed");
        WebUI.waitForElementinVisible(notiInformAddSuccess);
    }

    public void addNewMenberIntoMiniAppWithNullData(){
        WebUI.waitForElementVisible(inviteMenberButton);
        WebUI.clickElement(inviteMenberButton);
        WebUI.waitForElementVisible(inputEmailfield);
        WebUI.clickElement(buttonInviteOnPopup);
        WebUI.waitForElementinVisible(dataIsRequired);
        WebUI.verifyAssertTruIsDisplayed(dataIsRequired, "inform error is failed");
    }

    public void addNewMenberIntoMiniAppWithUserNotCreated(String emailMenber){
        WebUI.waitForElementVisible(inviteMenberButton);
        WebUI.clickElement(inviteMenberButton);
        WebUI.waitForElementVisible(inputEmailfield);
        WebUI.setText(inputEmailfield,emailMenber);
        WebUI.clickElement(buttonInviteOnPopup);
        WebUI.waitForElementVisible(informUserNotFound);
        WebUI.verifyAssertTruIsDisplayed(informUserNotFound, "invite not created user successfull");
    }

    public void checkMemberWasAddIntoMiniAppPage(){
        WebUI.waitForElementVisible(DashboardPage.menu);
        WebUI.verifyAssertTruIsDisplayed(DashboardPage.namFolder, "Can't found MiniApp folder");
    }

    public void deleteExitedUser(String email){
        By buttonDelete = By.xpath("//tr[@data-row-key='" + email +"']/descendant::span[@aria-label='delete']");
        WebUI.waitForElementinVisible(buttonDelete);
        WebUI.clickElement(buttonDelete);

    }
}
