package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;


public class TeamSettingPage {
    public static By inviteMemberButton = By.xpath("//span[contains(text(),'Invite Member')]");
    public static By inputEmailfield = By.xpath("//input[@id='email']");
    public static By buttonInviteOnPopup = By.xpath("//button[@class='ant-btn ant-btn-primary button___h63Gp']/span[text()='Invite']");
    public static By notiInformAddSuccess = By.xpath("//span[contains(text(),'Added member successfully')]");
    public static By dataIsRequired = By.xpath("//div[contains(text(),'Email or phone number is required')]");
    public static By inFormMemberIsAdded = By.xpath("//div[contains(text(),'Member is already added')]");
    public static By inFormDataIsInvalid = By.xpath("//div[contains(text(),'Please input valid email or phone number')]");
    public static By informUserNotFound = By.xpath("//span[contains(text(),'User information not found')]");
    public static By notiInformDeleteSuccess = By.xpath("//span[contains(text(),'Removed member successfully')]");
    public static By notiUpdateRoleSuccess = By.xpath("//span[contains(text(),'Updated successfully')]");

    public void addNewMemberIntoMiniAppPageSuccessful(String emailAddedMember){
        WebUI.clickElement(inviteMemberButton);
        WebUI.setText(inputEmailfield,emailAddedMember);
        WebUI.clickElement(buttonInviteOnPopup);
        WebUI.verifyAssertTrueIsDisplayed(notiInformAddSuccess, "invite member's failed");
        WebUI.waitForElementinVisible(notiInformAddSuccess);
    }

    public void addNewMemberIntoMiniAppWithNullData(){
        WebUI.clickElement(inviteMemberButton);
        WebUI.clickElement(buttonInviteOnPopup);
        WebUI.verifyAssertTrueIsDisplayed(dataIsRequired, "inform error is failed");
    }

    public void addNewMemberIntoMiniAppWithIncorrectData(String emailMember){
        WebUI.clickElement(inviteMemberButton);
        WebUI.setText(inputEmailfield,emailMember);
        WebUI.clickElement(buttonInviteOnPopup);
        WebUI.verifyAssertTrueIsDisplayed(informUserNotFound, "invite user successfull");
    }

    public void checkMemberWasAddIntoMiniAppPage(String folder){
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//span[contains(text(),'" + folder + "')]"), "Can't found MiniApp folder");
    }

    public void deleteExitedUser(String email){
        By buttonDelete = By.xpath("//tr[@data-row-key='" + email +"']/descendant::span[@aria-label='delete']");
        WebUI.clickElement(buttonDelete);
        WebUI.verifyAssertTrueIsDisplayed(notiInformDeleteSuccess, "Delete Member's failed");
    }

    public void editRoleForMemberInMiniAppSuccessful(String email, String role){
        By buttonEdited = By.xpath("//tr[@data-row-key='"+ email +"']/descendant::span[@aria-label='edit']");
        By roleDropdownBox = By.xpath("//tr[@data-row-key='"+ email +"']/descendant::span[@class='ant-select-selection-item']");
        WebUI.clickElement(buttonEdited);
        WebUI.clickElement(roleDropdownBox);
        WebUI.clickElement(By.xpath("//div[contains(text(),'"+ role +"')]"));
        WebUI.clickElement(By.xpath("//tr[@data-row-key='"+ email +"']/descendant::span[@aria-label='save']"));
        WebUI.verifyAssertTrueIsDisplayed(notiUpdateRoleSuccess,"Role isn't updated");
    }

    public void editRoleForMemberInMiniAppWithoutSaving(String email, String role){
        By buttonEdited = By.xpath("//tr[@data-row-key='"+ email +"']/descendant::span[@aria-label='edit']");
        By roleDropdownBox = By.xpath("//tr[@data-row-key='"+ email +"']/descendant::span[@class='ant-select-selection-item']");
        WebUI.clickElement(buttonEdited);
        WebUI.clickElement(roleDropdownBox);
        WebUI.clickElement(By.xpath("//div[contains(text(),'"+ role +"')]"));
        WebUI.refesh();
    }

    public void checkCurrentRoleOfUser(String email, String role){
        By currentRole = By.xpath("//tr[@data-row-key='"+ email +"']/td[2]");
        WebUI.verifyAssertTrueEqual(currentRole,role,"role is updated");
    }

    public void clickEditButtonOnOtherMemberWhenEditingMemberIsNotSaved(String email1, String email2, String role){
        By buttonEditedEmail1 = By.xpath("//tr[@data-row-key='"+ email1 +"']/descendant::span[@aria-label='edit']");
        By roleDropdownBoxEmail1 = By.xpath("//tr[@data-row-key='"+ email1 +"']/descendant::span[@class='ant-select-selection-item']");
        By buttonEditedEmail2 = By.xpath("//tr[@data-row-key='"+ email2 +"']/descendant::span[@aria-label='edit']");
        WebUI.clickElement(buttonEditedEmail1);
        WebUI.clickElement(roleDropdownBoxEmail1);
        WebUI.clickElement(By.xpath("//div[contains(text(),'"+ role +"')]"));
        WebUI.clickElement(buttonEditedEmail2);
        WebUI.verifyAssertTrueIsDisplayed(notiUpdateRoleSuccess,"Role isn't updated");
        checkCurrentRoleOfUser(email1,role);
    }
}
