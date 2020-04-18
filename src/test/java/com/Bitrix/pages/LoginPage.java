package com.Bitrix.pages;

import com.Bitrix.utils.ConfigurationReader;
import com.Bitrix.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(name ="USER_LOGIN")
    private WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(className = "login-btn")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    public void login(){
        userName.clear();
        password.clear();

        userName.sendKeys(ConfigurationReader.getProperty("user_name"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }
}
