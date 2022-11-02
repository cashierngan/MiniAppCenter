package MiniAppCenter.Pages;

import driver.DriverManager;
import helpers.Helpers;
import org.openqa.selenium.By;
import utils.WebUI;

public class AppInfoPage {
    private By menuAppInfo = By.xpath("//span[normalize-space()='App Info']");
    private By titleAppInfo = By.xpath("//div[@class='title___49HqJ']");
    private By inputAppName = By.xpath("//input[@id='appName']");
    private By inputShortDescription = By.xpath("//input[@id='shortDesc']");
    private By inputCSPhoneNumber = By.xpath("//input[@id='phone']");
    private By uploadIcon = By.xpath("//span[@role='button']");
    private By inputIcon = By.xpath("//input[@accept = 'image/*']");
    private By buttonSaveChange = By.xpath("//button[@class='ant-btn ant-btn-primary button___h63Gp']");
    private By messageSaveAppInfoSuccess = By.xpath("//span[normalize-space()='Updated Mini App info successfully']");

    public void configAppInfo( String appName, String shortDescription, String phoneCS){
        WebUI.sleep(5);
        WebUI.clickElement(DashboardPage.menuSettings);
        WebUI.clickElement(menuAppInfo);
        WebUI.verifyAssertTrueIsDisplayed(titleAppInfo, "App info page is NOT displayed");
        WebUI.verifyAssertTrueContain(inputAppName,"value", appName, "Mini App Name is NOT corrected");
        WebUI.setText(inputShortDescription, shortDescription);
        WebUI.setText(inputCSPhoneNumber, phoneCS);
        WebUI.clickElement(uploadIcon);
//        DriverManager.getDriver().findElement(inputIcon).sendKeys(System.getProperty("user.dir") + "/src/main/resources/koi.jpeg");
        DriverManager.getDriver().findElement(inputIcon).sendKeys(Helpers.getCurrentDir2() +"datatest/logoTheKoi.jpeg");
        WebUI.clickElement(buttonSaveChange);
        WebUI.verifyAssertTrueIsDisplayed(messageSaveAppInfoSuccess, "Save App Info is NOT successfully");
    }
}
