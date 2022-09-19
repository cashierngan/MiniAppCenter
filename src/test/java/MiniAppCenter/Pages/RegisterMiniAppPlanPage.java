package MiniAppCenter.Pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.WebUI;

public class RegisterMiniAppPlanPage {

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

    private By buttonAddMiniApp = By.xpath("//button[normalize-space()='Add Mini App']");


    public void registerMiniAppPlanSuccess(String organization, String contactName, String title, String email, String phoneNumber, String menuMiniApp){
        WebUI.waitForElementVisible(DashboardPage.registerMiniAppPlan);
        WebUI.clickElement(DashboardPage.registerMiniAppPlan);
        WebUI.waitForElementVisible(titleSetupInformation);
        WebUI.verifyAssertTruIsDisplayed(titleSetupInformation, "Form Register MiniApp Plan is NOT displayed");
        WebUI.verifyAssertTruIsDisplayed(labelStep1,  "Step 1/2: Organization Information is NOT displayed");
        WebUI.verifyAssertTruIsDisplayed(labelType, "Field Type is not displayed");
        WebUI.clickElement(inputType);
        WebUI.waitForElementVisible(selecTypeBusiness);
        WebUI.clickElement(selecTypeBusiness);
        WebUI.verifyAssertTruIsDisplayed(labelOrganization, "Field Organization Name is NOT displayed");
        WebUI.setText(inputOrganizationName, organization);
        WebUI.verifyAssertTruIsDisplayed(labelBusinessField, "Business Field is NOT displayed");
        WebUI.clickElement(inputBusinessField);
        WebUI.clickElement(selectShopping);
        WebUI.clickElement(buttonContinueStep2);
        WebUI.waitForElementVisible(labelStep2);
        WebUI.verifyAssertTruIsDisplayed(labelStep2, "Contact information form is NOT dislayed");
        WebUI.verifyAssertTruIsDisplayed(labelContactName, "Field Contact Name is NOT displayed");
        WebUI.setText(inputContactName, contactName);
        WebUI.verifyAssertTruIsDisplayed(labelTitle, "Field Title is NOT displayed");
        WebUI.setText(inputTitle, title);
        WebUI.verifyAssertTruIsDisplayed(labelEmailAddress, "Field Email Address is NOT displayed");
        WebUI.setText(inputEmailAddress, email);
        WebUI.verifyAssertTruIsDisplayed(labelPhoneNumber, "Field Phone number is NOT displayed");
        WebUI.setText(inputPhoneNumber, phoneNumber);
        WebUI.clickElement(buttonRegister);
        WebUI.sleep(6);
        WebUI.checkElementExist(By.xpath("//span[normalize-space()='" + menuMiniApp + "']"));
    }

    public void viewMiniAppList(String menuName){
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + menuName + "']"));
        WebUI.clickElement(menuMiniApps);
        WebUI.verifyAssertTrueEqual(titleMiniAppList, "MINI APP LIST", "Title MINI APP LIST is NOT displayed");
        WebUI.verifyAssertTruIsDisplayed(buttonAddMiniApp, "Add Mini App button is NOT displayed");
    }
}
