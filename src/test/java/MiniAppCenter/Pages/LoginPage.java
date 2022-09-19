package MiniAppCenter.Pages;
import Common.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.WebUI;
import java.io.IOException;
import java.util.Set;

public class LoginPage extends BaseTest {


//    private By buttonLogin = By.xpath("(//a[normalize-space() = 'Login'])[1]");
    public static By titleLogin = By.xpath("//span[@class = 'loginTitle___1HFUD']");
    private By labelLoginWithMoMo = By.xpath("//span[normalize-space()='Login with MoMo account for Business']");
    private By labelUsernamePhoneEmail = By.xpath("//label[@title = 'Username/Phone/Email']");
    private By inputUsernamePhoneEmail = By.xpath("//input[@id = 'login_email']");
    private By labelPassword = By.xpath("//label[@title = 'Password']");
    private By inputPassword = By.xpath("//input[@id = 'login_password']");
    private By eyePassword = By.xpath("//span[contains(@aria-label,'eye')]");
    private By buttonSubmitLogin = By.xpath("//button[@type='submit']");
    private By requiredUsernameEmailPhone = By.xpath("//div[contains(text(),'Username/email or phone number is required')]");
    private By requiredPassword = By.xpath("//div[contains(text(),'Password is required.')]");
    private By messageAccountIncorrect = By.xpath("//span[normalize-space() = 'User name/Email/Phone Number or Password is incorrect']");
    private By labelOrLoginBy = By.xpath("//span[@class='loginOption___1ycW2']");
    private By labelDontHaveAcc = By.xpath("//div[@class = 'loginOptionContainer___EwVV3']//span[@class=\"dontHaveAcc___3E-T6\"]");
    private By navigateRegister = By.xpath("//span[@class='linkText___3NgC3']");
    private By loginWithGoogle = By.xpath("//span[@class='ggTitle___1HwQ1']");

    private By inputEmail = By.xpath("//input[@id = 'identifierId']");
    private By buttonTiepTheo = By.xpath("//span[normalize-space() = 'Tiếp theo']");
    private By inputPasswordForEmail = By.xpath("//input[@aria-label = 'Nhập mật khẩu của bạn']");
    private By buttonTiepTheoForPassword = By.xpath("//span[normalize-space() = 'Tiếp theo']");
    private By validEmailInternal = By.xpath("//div[normalize-space() = 'Không tìm thấy Tài khoản Google của bạn']");



    public void loginFailWithNullData( String URL) throws IOException {
        WebUI.openURL(URL);
        WebUI.clickElement(CommonPage.buttonLogin);
        Assert.assertTrue(DriverManager.getDriver().findElement(titleLogin).getText().trim().equals("Login"));
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.waitForElementVisible(requiredUsernameEmailPhone);
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredUsernameEmailPhone).isDisplayed());
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredUsernameEmailPhone).getText().trim().equals("Username/email or phone number is required"));
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredPassword).isDisplayed());
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredPassword).getText().trim().equals("Password is required."));

    }

    public void loginFailWithAccountFail(String URL, String username, String password) throws IOException {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonLogin);
        Assert.assertTrue(DriverManager.getDriver().findElement(titleLogin).getText().trim().equals("Login"));
        Assert.assertTrue(DriverManager.getDriver().findElement(labelUsernamePhoneEmail).getText().trim().equals("Username/Phone/Email"));
        WebUI.setText(inputUsernamePhoneEmail, username);
        Assert.assertTrue(DriverManager.getDriver().findElement(labelPassword).getText().trim().equals("Password"));
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("text"));
        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("password"));
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.waitForElementVisible(messageAccountIncorrect);
        Assert.assertTrue(DriverManager.getDriver().findElement(messageAccountIncorrect).isDisplayed());
        Assert.assertTrue(DriverManager.getDriver().findElement(messageAccountIncorrect).getText().trim().equals("User name/Email/Phone Number or Password is incorrect"));
    }

    public void loginSuccess(String URL, String username, String password) throws IOException {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonLogin);
        Assert.assertTrue(DriverManager.getDriver().findElement(titleLogin).getText().trim().equals("Login"));
        Assert.assertTrue(DriverManager.getDriver().findElement(labelUsernamePhoneEmail).getText().trim().equals("Username/Phone/Email"));
        WebUI.setText(inputUsernamePhoneEmail, username);
        Assert.assertTrue(DriverManager.getDriver().findElement(labelPassword).getText().trim().equals("Password"));
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("text"));
        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("password"));
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.waitForElementVisible(DashboardPage.menu);
        WebUI.checkElementExist(DashboardPage.menu);
        WebUI.checkElementExist(DashboardPage.registerMiniAppPlan);
        WebUI.sleep(2);
    }

    public void loginSuccessWithGoogle(String URL, String email, String password) {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonLogin);
        WebUI.clickElement(loginWithGoogle);
        String MainWindow = DriverManager.getDriver().getWindowHandle();
        WebUI.sleep(3);
        Set<String> windows = DriverManager.getDriver().getWindowHandles();
        for (String window : windows) {
            if (!MainWindow.equals(window)) {
                DriverManager.getDriver().switchTo().window(window);
                WebUI.sleep(3);
                WebUI.setText(inputEmail, email);
                WebUI.clickElement(buttonTiepTheo);
                WebUI.sleep(2);
                WebUI.setText(inputPasswordForEmail, password);
                WebUI.clickElement(buttonTiepTheoForPassword);
                WebUI.sleep(10);
            }
        }
        DriverManager.getDriver().switchTo().window(MainWindow);
        WebUI.sleep(5);
        Assert.assertTrue(WebUI.checkElementExist(DashboardPage.registerMiniAppPlan), "Login with google fail");
        WebUI.sleep(5);
    }

    public void loginWithGoogleAccountAdmin(String URL, String email, String password) {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonLogin);
        WebUI.clickElement(loginWithGoogle);
        String MainWindow = DriverManager.getDriver().getWindowHandle();
        WebUI.sleep(3);
        Set<String> windows = DriverManager.getDriver().getWindowHandles();
        for (String window : windows) {
            if (!MainWindow.equals(window)) {
                DriverManager.getDriver().switchTo().window(window);
                WebUI.waitForElementVisible(inputEmail);
                WebUI.setText(inputEmail, email);
                WebUI.clickElement(buttonTiepTheo);
                WebUI.waitForElementVisible(inputPasswordForEmail);
                WebUI.setText(inputPasswordForEmail, password);
                WebUI.clickElement(buttonTiepTheoForPassword);
                WebUI.sleep(10);
            }
        }
        DriverManager.getDriver().switchTo().window(MainWindow);
        WebUI.sleep(5);
        Assert.assertTrue(WebUI.checkElementExist(DashboardPage.registerMiniAppPlan), "Login with google fail");
        WebUI.waitForElementVisible(DashboardPage.accountNganQC);

    }

    public void loginFailWithGoogle(String URL, String email) {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonLogin);
        WebUI.clickElement(loginWithGoogle);
        String MainWindow = DriverManager.getDriver().getWindowHandle();
        WebUI.sleep(3);
        Set<String> windows = DriverManager.getDriver().getWindowHandles();
        for (String window : windows) {
            if (!MainWindow.equals(window)) {
                DriverManager.getDriver().switchTo().window(window);
                WebUI.waitForElementVisible(inputEmail);
                WebUI.setText(inputEmail, email);
                WebUI.clickElement(buttonTiepTheo);
                Assert.assertTrue(DriverManager.getDriver().findElement(validEmailInternal).getText().trim().equals("Không tìm thấy Tài khoản Google của bạn"));
                WebUI.sleep(3);
                DriverManager.getDriver().close();
            }
        }

    }



    public void validationText(String URL) throws IOException {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonLogin);
        Assert.assertTrue(DriverManager.getDriver().findElement(labelLoginWithMoMo).getText().trim().equals("Login with MoMo account for Business"));
        Assert.assertTrue(DriverManager.getDriver().findElement(labelOrLoginBy).getText().trim().equals("Or login by"));
        Assert.assertTrue(DriverManager.getDriver().findElement(labelDontHaveAcc).getText().trim().equals("Don't have a MoMo account for business ?"));
        WebUI.clickElement(navigateRegister);
        WebUI.waitForElementVisible(RegisterPage.titleRegister);
        WebUI.checkElementExist(RegisterPage.titleRegister);
    }

    public void loginSuccessFromRegister( String username, String password) throws IOException {

        Assert.assertTrue(DriverManager.getDriver().findElement(labelUsernamePhoneEmail).getText().trim().equals("Username/Phone/Email"));
        WebUI.setText(inputUsernamePhoneEmail, username);
        Assert.assertTrue(DriverManager.getDriver().findElement(labelPassword).getText().trim().equals("Password"));
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("text"));
        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("password"));
        WebUI.clickElement(buttonSubmitLogin);
        WebUI.checkElementExist(DashboardPage.registerMiniAppPlan);
        WebUI.sleep(6);
    }


}
