package pageObjects;

import commonUtils.CommonUtils;
import org.openqa.selenium.By;

public class LambdaLoginPage {

    final CommonUtils _utils;
    public LambdaLoginPage(CommonUtils utils){
        _utils = utils;
    }

    By loginWithGoogleButton = By.xpath("//span[contains(text(),'Log in with Google')]");
    By loginWithGithubButton = By.xpath("//span[contains(text(),'Log in with Github')]");
    By emailTextField = By.xpath("//input[@name='email']");
    By passwordField = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@id='login-button']");


    public void enterEmail(String email) throws Exception {
        this._utils.doSendkeys(this.emailTextField, email);
    }

    public void enterPassword(String password) throws Exception {
        this._utils.doSendkeys(this.passwordField, password);
    }

    public void clickLoginButton() throws Exception {
        this._utils.doClick(loginButton);
    }
}
