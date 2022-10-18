package MiniAppCenter.Pages;

import org.openqa.selenium.By;

public class DashboardPage extends CommonPage{

    public static By menu = By.xpath("//span[normalize-space()='Menu']");
    public static By registerMiniAppPlan = By.xpath("//span[normalize-space()='Register Mini App Plan']");

    public static By buttonAccount = By.xpath("//span[@class='ant-dropdown-trigger action___3ut1O account___1r_Ku']");

    public static By accountNganQC = By.xpath("//span[@class='userName___1zGMg anticon' and normalize-space() = 'Đặng Thị Thu Ngân - ITC - APP - Senior Tester']");

    public static By menuSystemManagement = By.xpath("//span[normalize-space()='System Management']");

    public static By menuMiniAppManagement = By.xpath("//span[normalize-space()='Mini App Management']");
    public static By menuBuild = By.xpath("//span[@class='ant-menu-title-content'][normalize-space()='Build']");
    public static By menuSettings = By.xpath("//span[normalize-space() = 'Settings']");


}
