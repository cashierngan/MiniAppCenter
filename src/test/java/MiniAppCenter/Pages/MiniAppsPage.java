package MiniAppCenter.Pages;

import org.openqa.selenium.By;
import utils.WebUI;

public class MiniAppsPage extends CommonPage {
    public static By buttonAddMiniApp = By.xpath("//button[normalize-space()='Add Mini App']");
    private By titleMiniAppInformationForm = By.xpath("//div[@class='ant-modal-title']");
    private By labelNameTextbox = By.xpath("//span[normalize-space()='Name *']");
    private By inputName = By.xpath("//input[@id='app_appName']");
    private By labelTypeSelectbox = By.xpath("//span[normalize-space()='Type *']");
    private By selectType = By.xpath("//input[@id='app_type']");
    private By selectTypeReactNative = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='ReactNative']");
    private By selectTypeWebView = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='WebView']");
    private By labelBusinessField = By.xpath("//span[normalize-space()='Business Field *']");
    private By selectBusiness = By.xpath("//input[@id='app_businessField']");
    private By selectBusinessGoCopany = By.xpath("//div[contains(text(),'Go Company')]");
    private By labelServiceScenario = By.xpath("//span[normalize-space()='Service Scenario *']");
    private By selectServiceScenario = By.xpath("//input[@id='app_scenario']");
    private By selectServiceScenarioPayment = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Payment']");
    private By selectServiceScenarioNONPayment = By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Non-Payment']");
    private By labelWebsiteOrApp = By.xpath("//span[normalize-space()='Website /App']");
    private By inputWebsiteOrApp = By.xpath("//input[@id='app_storeName']");
    private By labelDescription = By.xpath("//span[normalize-space()='Description']");
    private By inputDescription = By.xpath("//textarea[@id='app_description']");
    private By checkboxOperationRule = By.xpath("//span[@class='ant-checkbox']");
    private By buttonAddNew = By.xpath("//span[normalize-space()='Add New']");
    private By messageAddMiniAppSuccess = By.xpath("//h4[normalize-space()='Mini App is added successfully!']");
    private By buttonCloseMessageSuccess = By.xpath("//div[@class='ant-result-extra']//div//button[@type='button']");
    private By inputSearchMiniApp = By.xpath("//input[@placeholder='Search Mini App']");
    private By miniappStatus = By.xpath("//span[@class='ant-tag ant-tag-orange tag___3F0E0']");
    private By provider = By.xpath("//td[normalize-space()='Ngăn Ngăn Shop']");
    private By businessField = By.xpath("//td[normalize-space()='Ngăn Ngăn Shop']");
    private By serviceScenario = By.xpath("//td[normalize-space()='Non-Payment']");
    private By titleMiniAppList = By.xpath("//div[@class='title___49HqJ']");
    private By buttonViewMiniApp = By.xpath("//span[normalize-space()='View']");

    public void addMiniAppReactNativeSuccess(String nameMiniApp, String type, String serviceScenario, String description, String status, String provider){
        WebUI.sleep(6);
        WebUI.verifyAssertTrueIsDisplayed(buttonAddMiniApp, "User is denied permission to Add Mini App");
        WebUI.waitForElementVisible(buttonAddMiniApp);
        WebUI.sleep(2);
        WebUI.clickElement(buttonAddMiniApp);
        WebUI.verifyAssertTrueIsDisplayed(titleMiniAppInformationForm, "Mini App Information form is NOT displayed");
        WebUI.verifyAssertTrueIsDisplayed(labelNameTextbox, "Name text box is NOT displayed");
        WebUI.setText(inputName, nameMiniApp);
        WebUI.verifyAssertTrueIsDisplayed(labelTypeSelectbox, "Type list box is NOT displayed");
        WebUI.clickElement(selectType);
        WebUI.clickElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + type + "']"));
        WebUI.verifyAssertTrueIsDisplayed(labelBusinessField, "Business Field list box is NOT displayed");
        WebUI.clickElement(selectBusiness);
        WebUI.clickElement(selectBusinessGoCopany);
        WebUI.verifyAssertTrueIsDisplayed(labelServiceScenario, "Service Scenario is NOT displayed");
        WebUI.clickElement(selectServiceScenario);
        WebUI.clickElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + serviceScenario + "']"));
        WebUI.verifyAssertTrueIsDisplayed(labelDescription, "Description text area is NOT displayed");
        WebUI.setText(inputDescription, description);
        WebUI.clickElement(checkboxOperationRule);
        WebUI.sleep(2);
        WebUI.clickElement(buttonAddNew);
        WebUI.verifyAssertTrueIsDisplayed(messageAddMiniAppSuccess, "Add new Mini App failed");
        WebUI.clickElement(buttonCloseMessageSuccess);
        WebUI.sleep(2);
        WebUI.clearText(inputSearchMiniApp);
        WebUI.setText(inputSearchMiniApp, nameMiniApp);
        WebUI.keydownEnter();
        WebUI.waitForElementVisible(By.xpath("//td[normalize-space()='" + nameMiniApp + "']"));
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//td[normalize-space()='" + nameMiniApp + "']"), "Mini App is NOT exist");
        WebUI.verifyAssertTrueEqual(miniappStatus, status, "Status Mini App is failed");
        WebUI.verifyAssertTrueEqual(By.xpath("//td[normalize-space()='" + provider + "']"),provider, "Provider Name is failed");
        WebUI.verifyAssertTrueEqual(By.xpath("//td[normalize-space()='Go Company']"),"Go Company", "Business field is failed");
        WebUI.verifyAssertTrueEqual(By.xpath("//td[normalize-space()='" + serviceScenario + "']"),serviceScenario, "Service Scenario is failed");
    }

    public void addMiniAppWebViewSuccess(String nameMiniApp, String type, String serviceScenario, String linkWeb, String description, String status){
        WebUI.verifyAssertTrueIsDisplayed(buttonAddMiniApp, "User is denied permission to Add Mini App");
        WebUI.waitForElementVisible(buttonAddMiniApp);
        WebUI.clickElement(buttonAddMiniApp);
        WebUI.verifyAssertTrueIsDisplayed(titleMiniAppInformationForm, "Mini App Information form is NOT displayed");
        WebUI.verifyAssertTrueIsDisplayed(labelNameTextbox, "Name text box is NOT displayed");
        WebUI.setText(inputName, nameMiniApp);
        WebUI.verifyAssertTrueIsDisplayed(labelTypeSelectbox, "Type list box is NOT displayed");
        WebUI.clickElement(selectType);
        WebUI.clickElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + type + "']"));
        WebUI.verifyAssertTrueIsDisplayed(labelBusinessField, "Business Field list box is NOT displayed");
        WebUI.clickElement(selectBusiness);
        WebUI.clickElement(selectBusinessGoCopany);
        WebUI.verifyAssertTrueIsDisplayed(labelServiceScenario, "Service Scenario is NOT displayed");
        WebUI.clickElement(selectServiceScenario);
        WebUI.clickElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + serviceScenario + "']"));
        WebUI.verifyAssertTrueIsDisplayed(labelWebsiteOrApp, "Website/ App field is NOT displayed");
        WebUI.setText(inputWebsiteOrApp, linkWeb);
        WebUI.verifyAssertTrueIsDisplayed(labelDescription, "Description text area is NOT displayed");
        WebUI.setText(inputDescription, description);
        WebUI.clickElement(checkboxOperationRule);
        WebUI.clickElement(buttonAddNew);
        WebUI.verifyAssertTrueIsDisplayed(messageAddMiniAppSuccess, "Add new Mini App failed");
        WebUI.clickElement(buttonCloseMessageSuccess);
        WebUI.sleep(2);
        WebUI.setText(inputSearchMiniApp, nameMiniApp);
        WebUI.keydownEnter();
        WebUI.waitForElementVisible(By.xpath("//td[normalize-space()='" + nameMiniApp + "']"));
        WebUI.verifyAssertTrueIsDisplayed(By.xpath("//td[normalize-space()='" + nameMiniApp + "']"), "Mini App is NOT exist");
        WebUI.verifyAssertTrueEqual(miniappStatus, status, "Status Mini App is failed");
//        WebUI.verifyAssertTrueEqual(By.xpath("//td[normalize-space()='" + provider + "']"),provider, "Provider Name is failed");
        WebUI.verifyAssertTrueEqual(By.xpath("//td[normalize-space()='Go Company']"),"Go Company", "Business field is failed");
        WebUI.verifyAssertTrueEqual(By.xpath("//td[normalize-space()='" + serviceScenario + "']"),serviceScenario, "Service Scenario is failed");

    }

    public void searchAndViewMiniApp(String nameMiniApp, String provider){
        getRegisterMiniAppPlanPage().viewMiniAppList(provider);
        WebUI.clickElement(DashboardPage.menu);
//        WebUI.verifyAssertTrueEqual(titleMiniAppList, "MINI APP LIST", "Mini App List page is NOT displayed");
        WebUI.sleep(2);
        WebUI.setTextEnter(inputSearchMiniApp, nameMiniApp);
        WebUI.sleep(2);
        WebUI.clickElement(buttonViewMiniApp);
    }
}
