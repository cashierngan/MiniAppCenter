package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class RegisterMiniAppPage extends CommonPage{

    private By titleSetupInformation = By.xpath("//span[@class='title___b7qY_']");
    private By labelStep1 = By.xpath("//span[@class='title___b7qY_']");
    private By labelType = By.xpath("//span[normalize-space()='Type *']");
    private By inputType  = By.xpath("//span[@title='Business']");
    private By selecTypeBusiness = By.xpath("//div[@class='ant-select-item-option-content']");
    private By labelOrganization = By.xpath("//span[normalize-space()='Organization Name *']");
    private By inputOrganizationName = By.xpath("//input[@id='step1_organizationName']");
    private By labelBusinessField = By.xpath("//span[normalize-space()='Business Field *']");
    private By inputBusinessField = By.xpath("//span[@title='Food and Beverage']");
    private By selectShopping = By.xpath("//div[contains(text(),'Shopping')]");
    private By labelTaxNumber = By.xpath("//span[normalize-space()='Tax Number']");
    private By inputTaxNumber = By.xpath("//input[@id='step1_taxCode']");
    private By buttonContinueStep2 = By.xpath("//button[@type='button']");
    private By labelStep2 = By.xpath("//span[@class='stepText___1NsDK']");
    private By labelContactName = By.xpath("//span[@class='stepText___1NsDK']");
    private By inputContactName = By.xpath("//input[@id='step2_name']");
    private By labelTitle = By.xpath("//span[normalize-space()='Title']");
    private By inputTitle = By.xpath("//input[@id='step2_position']");
    private By labelEmailAddress = By.xpath("//span[normalize-space()='Email Address *']");
    private By inputEmailAddress = By.xpath("//input[@id='step2_email']");
    private By labelPhoneNumber = By.xpath("//span[normalize-space()='Phone Number *']");
    private By inputPhoneNumber = By.xpath("//input[@id='step2_phone']");
    private By buttonRegister = By.xpath("//button[@class='ant-btn ant-btn-default registerButton___11Knh']");

    private By menuMiniApps = By.xpath("//span[@class='ant-menu-title-content'][normalize-space()='Mini Apps']");
    private By titleMiniAppList = By.xpath("//div[@class='title___49HqJ']");
    private By actionView = By.xpath("//span[@class='viewAction___2dWqD']");
    private By messageRegisterSuccess =By.xpath("//div[@class='ant-notification-notice-description']");

    public void viewMiniAppList(String menuName){
//        WebUI.waitForElementInvisible(messageRegisterSuccess);
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + menuName + "']"));
        WebUI.clickElement(menuMiniApps);
        WebUI.verifyAssertTrueEqual(titleMiniAppList, "MINI APP LIST", "Title MINI APP LIST is NOT displayed");
    }

    public void registerMiniAppPlanSuccessReactNative(String organization, String contactName, String title, String email, String phoneNumber, String menuMiniApp){
        WebUI.waitForElementVisible(DashboardPage.registerMiniAppPlan);
        WebUI.clickElement(DashboardPage.registerMiniAppPlan);
        WebUI.waitForElementVisible(titleSetupInformation);
        WebUI.verifyAssertTrueIsDisplayed(titleSetupInformation, "Form Register MiniApp Plan is NOT displayed");
        WebUI.verifyAssertTrueIsDisplayed(labelStep1,  "Step 1/2: Organization Information is NOT displayed");
        WebUI.verifyAssertTrueIsDisplayed(labelType, "Field Type is not displayed");
        WebUI.clickElement(inputType);
        WebUI.waitForElementVisible(selecTypeBusiness);
        WebUI.clickElement(selecTypeBusiness);
        WebUI.verifyAssertTrueIsDisplayed(labelOrganization, "Field Organization Name is NOT displayed");
        WebUI.setText(inputOrganizationName, organization);
        WebUI.verifyAssertTrueIsDisplayed(labelBusinessField, "Business Field is NOT displayed");
        WebUI.clickElement(inputBusinessField);
        WebUI.clickElement(selectShopping);
        WebUI.clickElement(buttonContinueStep2);
        WebUI.waitForElementVisible(labelStep2);
        WebUI.verifyAssertTrueIsDisplayed(labelStep2, "Contact information form is NOT dislayed");
        WebUI.verifyAssertTrueIsDisplayed(labelContactName, "Field Contact Name is NOT displayed");
        WebUI.setText(inputContactName, contactName);
        WebUI.verifyAssertTrueIsDisplayed(labelTitle, "Field Title is NOT displayed");
        WebUI.setText(inputTitle, title);
        WebUI.verifyAssertTrueIsDisplayed(labelEmailAddress, "Field Email Address is NOT displayed");
        WebUI.setText(inputEmailAddress, email);
        WebUI.verifyAssertTrueIsDisplayed(labelPhoneNumber, "Field Phone number is NOT displayed");
        WebUI.setText(inputPhoneNumber, phoneNumber);
        WebUI.clickElement(buttonRegister);
        WebUI.sleep(6);
        WebUI.checkElementExist(By.xpath("//span[normalize-space()='" + menuMiniApp + "']"));
    }

    public void registerMiniAppPlanSuccessWebView(String organization, String contactName, String title, String email, String phoneNumber, String menuMiniApp){
        WebUI.waitForElementVisible(DashboardPage.registerMiniAppPlan);
        WebUI.clickElement(DashboardPage.registerMiniAppPlan);
        WebUI.waitForElementVisible(titleSetupInformation);
        WebUI.verifyAssertTrueIsDisplayed(titleSetupInformation, "Form Register MiniApp Plan is NOT displayed");
        WebUI.verifyAssertTrueIsDisplayed(labelStep1,  "Step 1/2: Organization Information is NOT displayed");
        WebUI.verifyAssertTrueIsDisplayed(labelType, "Field Type is not displayed");
        WebUI.clickElement(inputType);
        WebUI.waitForElementVisible(selecTypeBusiness);
        WebUI.clickElement(selecTypeBusiness);
        WebUI.verifyAssertTrueIsDisplayed(labelOrganization, "Field Organization Name is NOT displayed");
        WebUI.setText(inputOrganizationName, organization);
        WebUI.verifyAssertTrueIsDisplayed(labelBusinessField, "Business Field is NOT displayed");
        WebUI.clickElement(inputBusinessField);
        WebUI.clickElement(selectShopping);
        WebUI.clickElement(buttonContinueStep2);
        WebUI.waitForElementVisible(labelStep2);
        WebUI.verifyAssertTrueIsDisplayed(labelStep2, "Contact information form is NOT dislayed");
        WebUI.verifyAssertTrueIsDisplayed(labelContactName, "Field Contact Name is NOT displayed");
        WebUI.setText(inputContactName, contactName);
        WebUI.verifyAssertTrueIsDisplayed(labelTitle, "Field Title is NOT displayed");
        WebUI.setText(inputTitle, title);
        WebUI.verifyAssertTrueIsDisplayed(labelEmailAddress, "Field Email Address is NOT displayed");
        WebUI.setText(inputEmailAddress, email);
        WebUI.verifyAssertTrueIsDisplayed(labelPhoneNumber, "Field Phone number is NOT displayed");
        WebUI.setText(inputPhoneNumber, phoneNumber);
        WebUI.clickElement(buttonRegister);
        WebUI.sleep(6);
        WebUI.checkElementExist(By.xpath("//span[normalize-space()='" + menuMiniApp + "']"));
    }


}
