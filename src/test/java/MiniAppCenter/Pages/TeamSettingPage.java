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
    public static By inFormMemberIsAdded = By.xpath("//div[contains(text(),'Member is already added.')]");
    public static By inFormDataIsInvalid = By.xpath("//div[contains(text(),'Please input valid email or phone number')]");
    public static By notiInformDeleteSuccess = By.xpath("//span[contains(text(),'Removed member successfully')]");
    public void addNewMenberIntoMiniAppPageSuccessfull(String emailAddedMenber){
        WebUI.clickElement(inviteMenberButton);
        WebUI.setText(inputEmailfield,emailAddedMenber);
        WebUI.clickElement(buttonInviteOnPopup);
        WebUI.verifyAssertTrueIsDisplayed(notiInformAddSuccess, "invite member's failed");
    }

    public void addNewMenberIntoMiniAppWithNullData(){
        WebUI.clickElement(inviteMenberButton);
        WebUI.clickElement(buttonInviteOnPopup);
        WebUI.verifyAssertTrueIsDisplayed(dataIsRequired, "inform error is failed");
    }

    public void addNewMenberIntoMiniAppWithIncorrectData(String emailMember, By NotiInform){
        WebUI.clickElement(inviteMenberButton);
        WebUI.setText(inputEmailfield,emailMember);
        WebUI.clickElement(buttonInviteOnPopup);
        WebUI.verifyAssertTrueIsDisplayed(NotiInform, "invite user successfull");
    }

    public void checkMemberWasAddIntoMiniAppPage(){
        WebUI.verifyAssertTrueIsDisplayed(DashboardPage.namFolder, "Can't found MiniApp folder");
    }

    public void deleteExitedUser(String email){
        By buttonDelete = By.xpath("//tr[@data-row-key='" + email +"']/descendant::span[@aria-label='delete']");
        WebUI.clickElement(buttonDelete);
        WebUI.verifyAssertTrueIsDisplayed(notiInformDeleteSuccess, "Delete Member's failed");
    }
}
