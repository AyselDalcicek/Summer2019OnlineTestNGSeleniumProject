package com.Bitrix.tests.SmokeTest;

import com.Bitrix.pages.LoginPage;
import com.Bitrix.tests.TestBase;
import com.Bitrix.utils.BrowserUtils;
import com.Bitrix.utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyLogin extends TestBase {

    @Test(description = "Verify Login Test through page title")
    public void LoginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        String expectedTitle = "Portal";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle, "Login verification failed");

    }

}
