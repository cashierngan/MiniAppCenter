package MiniAppCenter.Pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import utils.WebUI;

import java.io.IOException;
import java.util.Map;

public class RegisterPage {
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

    private By buttonRegister = By.xpath("//a[contains(text(),'Register')]");
    public static By titleRegister = By.xpath("//div[@class = 'loginTitle___3rFhw']");
    private By selectRegisterWithEmail = By.xpath("//img[@src='/static/mail.b61f46d0.svg']");
    private By registerWithPhoneNumber = By.xpath("(//img[@src = '/static/phone.975b6128.svg']/ancestor::span)/preceding-sibling::span");
    private By registerWithEmail = By.xpath("(//img[@src = '/static/mail.b61f46d0.svg']/ancestor::span)/preceding-sibling::span");
    private By labelRegisterMoMo = By.xpath("//span[@data-inspector-line='256']");
    private By labelPhoneNumber = By.xpath("//label[@title='Phone Number']");
    private By inputPhoneNumber = By.xpath("//input[@id='login_phoneNumber']");
    private By labelEmail = By.xpath("//label[@title='Email']");
    private By inputEmail = By.xpath("//input[@id='login_email']");
    private By labelPassword = By.xpath("//label[@title='Password']");
    private By inputPassword = By.xpath("//input[@id='login_password']");
    private By requiredPhoneNumber = By.xpath("//div[contains(text(),'Phone number is required')]");
    private By requiredPassword = By.xpath("//div[contains(text(),'Password is required.')]");
    private By requiredEmail = By.xpath("//div[contains(text(),'Please enter your email.')]");
    private By labelConfirmPassword = By.xpath("//label[@title='Confirm Password']");
    private By inputConfirmPassword = By.xpath("//input[@id = 'login_confirmPassword']");
    private By requiredConfirmPassword = By.xpath("//div[contains(text(),'Confirm password is required.')]");
    private By labelName = By.xpath("//label[@title = 'Name']");
    private By inputName = By.xpath("//input[@id = 'login_name']");
    private By requiredName = By.xpath("//div[contains(text(),'Name is required')]");
    private By labelVerificationCode = By.xpath("//label[@title = 'Verification Code']");
    private By inputVerifyCode = By.xpath("//input[@placeholder='Please input your verification code']");
    private By buttonSendCode = By.xpath("//button[@class = 'ant-btn ant-btn-default otpButton___3id7n']");
    private By requiredVerificationCode = By.xpath("//div[contains(text(),'Verification code is required')]");
    private By buttonSubmitRegister = By.xpath("//button[normalize-space()='Register']");
    private By labelAreadyAccount = By.xpath("//div[@class = 'footerContent___1sSJp']//span[@class = 'dontHaveAcc___2pVpG']");
    private By navigateLogin = By.xpath("//span[@class='linkText___152pk']");
    private By eyePassword = By.xpath("//span//input[@id = 'login_password']/following-sibling::span");
    private By eyeConfirmPassword = By.xpath("//span//input[@id = 'login_confirmPassword']/following-sibling::span");
    private By validPhoneNumber = By.xpath("//div[@class = 'ant-form-item-explain-error']");
    private By messagePhoneNumberInValid = By.xpath("//span[normalize-space() = 'Số điện thoại sai định dạng.']");

    private By validConfirmPassword = By.xpath("//div[@class = 'ant-form-item-explain-error']");
    private By messageInvalidVerificationCode = By.xpath("//span[normalize-space() = 'Mã xác minh không đúng. Vui lòng thử lại.']");
    private By messageSentVerificaionCode = By.xpath("//span[normalize-space() = 'The verification code will be sent to your phone number within 1 minute']");
    private By messageValidPhoneNumberExist = By.xpath("//span[normalize-space() = 'Số điện thoại đã tồn tại']");
    private By validEmail = By.xpath("//div[@class = 'ant-form-item-explain-error']");
    private By messageRegisterSuccess = By.xpath("//span[@class='successText___1XbgM']");
    private By buttonlogin = By.xpath("//button[@class='ant-btn ant-btn-default button___h63Gp']");
    private By messagesentOTP = By.xpath("//div[@class='ant-message']//div");


    public void registerValidNullDataWithPhoneNumber(String URL) throws IOException {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonRegister);
        js.executeScript("arguments[0].scrollIntoView(true);", DriverManager.getDriver().findElement(buttonSubmitRegister));
        WebUI.clickElement(buttonSubmitRegister);
        WebUI.verifyAssertTrueContain(registerWithPhoneNumber, "class", "checked", "Phone Number is NOT checked");

        // thiếu dấu . ở required
        WebUI.verifyAssertTrueEqual(labelPhoneNumber, "Phone Number","Incorrect label Phone Number");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPhoneNumber).getAttribute("placeholder").trim().equals("Please input your phone number"), "Incorrect placeholder for Phone Number field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredPhoneNumber).isDisplayed(), "Required Phone Number is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredPhoneNumber).getText().trim().equals("Phone number is required"), "Incorrect required Phone Number");

        Assert.assertTrue(DriverManager.getDriver().findElement(labelPassword).getText().trim().equals("Password"), "Incorrect label Password");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("placeholder").trim().equals("Please input your password"), "Incorrect placeholder for Password field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredPassword).isDisplayed(), "Required Password is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredPassword).getText().trim().equals("Password is required."), "Incorrect required Password");

        Assert.assertTrue(DriverManager.getDriver().findElement(labelConfirmPassword).getText().trim().equals("Confirm Password"), "Incorrect label Confirm Password");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputConfirmPassword).getAttribute("placeholder").trim().equals("Please confirm your password"), "Incorrect placeholder for Confirm Password field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredConfirmPassword).isDisplayed(), "Required Confirm Password is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredConfirmPassword).getText().trim().equals("Confirm password is required."), "Incorrect required Confirm Password");

        // thiếu dấu . cho required
        Assert.assertTrue(DriverManager.getDriver().findElement(labelName).getText().trim().equals("Name"), "Incorrect label Name");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputName).getAttribute("placeholder").trim().equals("Please input your name"), "Incorrect placeholder for Name field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredName).isDisplayed(), "Required Name is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredName).getText().trim().equals("Name is required"), "Incorrect required Name");

        Assert.assertTrue(DriverManager.getDriver().findElement(labelVerificationCode).getText().trim().equals("Verification Code"), "Incorrect label Verification Code");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputVerifyCode).getAttribute("placeholder").trim().equals("Please input your verification code"), "Incorrect placeholder for Verification Code field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredVerificationCode).isDisplayed(), "Required Verification Code is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredVerificationCode).getText().trim().equals("Verification code is required"), "Incorrect required Verification Code");

    }

    public void registerValidNullDataWithEmail(String URL) throws IOException {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonRegister);
        WebUI.clickElement(selectRegisterWithEmail);
        js.executeScript("arguments[0].scrollIntoView(true);", DriverManager.getDriver().findElement(buttonSubmitRegister));
        WebUI.clickElement(buttonSubmitRegister);
        Assert.assertTrue(DriverManager.getDriver().findElement(registerWithEmail).getAttribute("class").contains("checked"), "Email is NOT checked");

        // thiếu dấu . ở required
        Assert.assertTrue(DriverManager.getDriver().findElement(labelEmail).getText().trim().equals("Email"), "Incorrect label Email");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputEmail).getAttribute("placeholder").trim().equals("Please input your email"), "Incorrect placeholder for Email field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredEmail).isDisplayed(), "Required Email is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredEmail).getText().trim().equals("Please enter your email."), "Incorrect required Email");

        Assert.assertTrue(DriverManager.getDriver().findElement(labelPassword).getText().trim().equals("Password"), "Incorrect label Password");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("placeholder").trim().equals("Please input your password"), "Incorrect placeholder for Password field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredPassword).isDisplayed(), "Required Password is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredPassword).getText().trim().equals("Password is required."), "Incorrect required Password");

        Assert.assertTrue(DriverManager.getDriver().findElement(labelConfirmPassword).getText().trim().equals("Confirm Password"), "Incorrect label Confirm Password");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputConfirmPassword).getAttribute("placeholder").trim().equals("Please confirm your password"), "Incorrect placeholder for Confirm Password field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredConfirmPassword).isDisplayed(), "Required Confirm Password is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredConfirmPassword).getText().trim().equals("Confirm password is required."), "Incorrect required Confirm Password");

        // thiếu dấu . cho required
        Assert.assertTrue(DriverManager.getDriver().findElement(labelName).getText().trim().equals("Name"), "Incorrect label Name");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputName).getAttribute("placeholder").trim().equals("Please input your name"), "Incorrect placeholder for Name field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredName).isDisplayed(), "Required Name is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredName).getText().trim().equals("Name is required"), "Incorrect required Name");

        Assert.assertTrue(DriverManager.getDriver().findElement(labelVerificationCode).getText().trim().equals("Verification Code"), "Incorrect label Verification Code");
        Assert.assertTrue(DriverManager.getDriver().findElement(inputVerifyCode).getAttribute("placeholder").trim().equals("Please input your verification code"), "Incorrect placeholder for Verification Code field");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredVerificationCode).isDisplayed(), "Required Verification Code is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(requiredVerificationCode).getText().trim().equals("Verification code is required"), "Incorrect required Verification Code");

    }

    public void registerSuccessWithPhoneNumber(String URL, String phoneNumber01, String password, String confirmPw, String name, String code, String phoneNumber02, String phoneNumber03, String phoneNumberExist, String confirmPwInvalid, String phoneNumber, String codeInvalid) throws IOException {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonRegister);
        WebUI.setText(inputPhoneNumber, phoneNumber01);
        WebUI.setText(inputPassword, password);
        WebUI.setText(inputConfirmPassword, confirmPw);
        WebUI.setText(inputName, name);
        WebUI.clickElement(buttonSendCode);
        WebUI.setText(inputVerifyCode, code);
        WebUI.clickElement(buttonSubmitRegister);
        Assert.assertTrue(DriverManager.getDriver().findElement(validPhoneNumber).isDisplayed(), "Invalid format phone number is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(validPhoneNumber).getText().trim().equals("Please input valid phone number"));
        WebUI.clearText(inputPhoneNumber);
        WebUI.setText(inputPhoneNumber, phoneNumber02);
        WebUI.clickElement(buttonSubmitRegister);
        Assert.assertTrue(DriverManager.getDriver().findElement(validPhoneNumber).isDisplayed(), "Invalid format email is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(validPhoneNumber).getText().trim().equals("Please input valid phone number"));
        WebUI.clearText(inputPhoneNumber);
        WebUI.setText(inputPhoneNumber, phoneNumber03);
        WebUI.clickElement(buttonSubmitRegister);
        WebUI.waitForElementVisible(messagePhoneNumberInValid);
        Assert.assertTrue(DriverManager.getDriver().findElement(messagePhoneNumberInValid).isDisplayed(), "Message valid Phone Number is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(messagePhoneNumberInValid).getText().trim().equals("Số điện thoại sai định dạng."));
        WebUI.clearText(inputPhoneNumber);
        WebUI.setText(inputPhoneNumber, phoneNumberExist);

        WebUI.setText(inputConfirmPassword, confirmPwInvalid);
        WebUI.clickElement(buttonSubmitRegister);
        WebUI.waitForElementVisible(validConfirmPassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(validConfirmPassword).getText().trim().equals("Passwords do not match."));
        WebUI.clearText(inputConfirmPassword);
        WebUI.setText(inputConfirmPassword, confirmPw);

        WebUI.clickElement(buttonSendCode);
        WebUI.waitForElementVisible(messageValidPhoneNumberExist);
        Assert.assertTrue(DriverManager.getDriver().findElement(messageValidPhoneNumberExist).getText().trim().equals("Số điện thoại đã tồn tại"));

        WebUI.clearText(inputPhoneNumber);
        WebUI.setText(inputPhoneNumber, phoneNumber);
        WebUI.clickElement(buttonSendCode);
        WebUI.waitForElementVisible(messageSentVerificaionCode);
        Assert.assertTrue(DriverManager.getDriver().findElement(messageSentVerificaionCode).getText().trim().equals("The verification code will be sent to your phone number within 1 minute"));


        WebUI.clearText(inputVerifyCode);
        WebUI.setText(inputVerifyCode, codeInvalid);
        WebUI.clickElement(buttonSubmitRegister);
        WebUI.waitForElementVisible(messageInvalidVerificationCode);
        Assert.assertTrue(DriverManager.getDriver().findElement(messageInvalidVerificationCode).getText().trim().equals("Mã xác minh không đúng. Vui lòng thử lại."));

        WebUI.clearText(inputVerifyCode);
        WebUI.setText(inputVerifyCode, code);

        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("text"));
        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("password"));

        WebUI.clickElement(eyeConfirmPassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputConfirmPassword).getAttribute("type").equals("text"));
        WebUI.clickElement(eyeConfirmPassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputConfirmPassword).getAttribute("type").equals("password"));

        WebUI.clickElement(buttonSubmitRegister);
        WebUI.sleep(5);

    }

    public void registerSuccessWithEmail(Map<String, String> inputs) throws IOException {
        WebUI.openURL(inputs.get("URL"));
        WebUI.clickElement(buttonRegister);
        WebUI.clickElement(selectRegisterWithEmail);
        WebUI.setText(inputEmail, inputs.get("EMAIL_INVALID"));
        WebUI.setText(inputPassword, inputs.get("PASSWORD"));
        WebUI.setText(inputConfirmPassword, inputs.get("CONFIRM_PASSWORD"));
        WebUI.setText(inputName, inputs.get("NAME"));
        WebUI.clickElement(buttonSendCode);
        WebUI.setText(inputVerifyCode, inputs.get("CODE"));
        WebUI.clickElement(buttonSubmitRegister);
        Assert.assertTrue(DriverManager.getDriver().findElement(validEmail).isDisplayed(), "Invalid format email is NOT displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(validPhoneNumber).getText().trim().equals("Please enter a valid email."));
        WebUI.clearText(inputEmail);
        WebUI.setText(inputEmail, inputs.get("EMAIL_EXIST"));

        WebUI.setText(inputConfirmPassword, inputs.get("CONFIRM_PASSWORD_INVALID"));
        WebUI.clickElement(buttonSubmitRegister);
        Assert.assertTrue(DriverManager.getDriver().findElement(validConfirmPassword).getText().trim().equals("Passwords do not match."));
        WebUI.clearText(inputConfirmPassword);
        WebUI.setText(inputConfirmPassword, inputs.get("CONFIRM_PASSWORD"));
        WebUI.clickElement(buttonSendCode);

        // Chưa có element
        Assert.assertTrue(DriverManager.getDriver().findElement(messageValidPhoneNumberExist).getText().trim().equals("Số điện thoại đã tồn tại"));

        WebUI.clearText(inputEmail);
        WebUI.setText(inputEmail, inputs.get("EMAIL_VALID"));
        WebUI.clickElement(buttonSendCode);
        WebUI.waitForElementVisible(messageSentVerificaionCode);
        Assert.assertTrue(DriverManager.getDriver().findElement(messageSentVerificaionCode).getText().trim().equals("The verification code will be sent to your phone number within 1 minute"));

        WebUI.clearText(inputVerifyCode);
        WebUI.setText(inputVerifyCode, inputs.get("CODE_INVALID"));
        WebUI.clickElement(buttonSubmitRegister);
        WebUI.waitForElementVisible(messageInvalidVerificationCode);
        Assert.assertTrue(DriverManager.getDriver().findElement(messageInvalidVerificationCode).getText().trim().equals("Mã xác minh không đúng. Vui lòng thử lại."));

        WebUI.clearText(inputVerifyCode);
        WebUI.setText(inputVerifyCode, inputs.get("CODE"));

        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("text"));
        WebUI.clickElement(eyePassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputPassword).getAttribute("type").equals("password"));

        WebUI.clickElement(eyeConfirmPassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputConfirmPassword).getAttribute("type").equals("text"));
        WebUI.clickElement(eyeConfirmPassword);
        Assert.assertTrue(DriverManager.getDriver().findElement(inputConfirmPassword).getAttribute("type").equals("password"));

        WebUI.clickElement(buttonSubmitRegister);
        WebUI.sleep(5);


    }

    public void validationTextRegister(String URL) throws IOException {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonRegister);
        WebUI.sleep(3);
        Assert.assertTrue(DriverManager.getDriver().findElement(titleRegister).getText().trim().equals("Register"), "Fail title Register");
        Assert.assertTrue(DriverManager.getDriver().findElement(labelRegisterMoMo).getText().trim().equals("Register MoMo for Business account"), "Fail title Register");
        Assert.assertTrue(DriverManager.getDriver().findElement(labelAreadyAccount).getText().trim().equals("If you already have MoMo for Business account"));
        WebUI.clickElement(navigateLogin);
        WebUI.checkElementExist(LoginPage.titleLogin);

    }

    public void registerSuccessWithPhoneNumberNOTValid(String URL, String phoneNumber01, String password, String confirmPw, String name, String code, String phoneNumber02, String phoneNumber03, String phoneNumberExist, String confirmPwInvalid, String phoneNumber, String codeInvalid) throws IOException {
        WebUI.openURL(URL);
        WebUI.clickElement(buttonRegister);
        WebUI.setText(inputPhoneNumber, phoneNumber);
        WebUI.setText(inputPassword, password);
        WebUI.setText(inputConfirmPassword, confirmPw);
        WebUI.setText(inputName, name);
        WebUI.clickElement(buttonSendCode);
        WebUI.waitForElementVisible(messagesentOTP);
        WebUI.setText(inputVerifyCode, code);
        WebUI.clickElement(buttonSubmitRegister);
        WebUI.waitForElementVisible(messageRegisterSuccess);
        WebUI.verifyAssertTrueEqual(messageRegisterSuccess, "Register successfully", "Message Register successfully is NOT displayed");
        WebUI.clickElement(buttonlogin);
        WebUI.sleep(3);
    }

}
