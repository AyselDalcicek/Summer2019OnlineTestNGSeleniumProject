package com.Bitrix.tests;

import com.Bitrix.pages.LoginPage;
import com.Bitrix.utils.BrowserUtils;
import com.Bitrix.utils.Driver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

   @Test(description = "Verify login")
   public void test1(){
       LoginPage loginPage = new LoginPage();
       loginPage.login();

       System.out.println(Driver.get().getTitle());

//       loginPage.NavigateToDrive();
//       BrowserUtils.wait(2);
//
//       loginPage.NavigateToCalender();
//       BrowserUtils.wait(2);

       loginPage.menuNavigation("Drive");
       System.out.println(loginPage.getPageSubtitle());
       BrowserUtils.wait(2);

       loginPage.menuNavigation("Calendar");
       System.out.println(loginPage.getPageSubtitle());
       BrowserUtils.wait(2);

       loginPage.menuNavigation("Mail");
       System.out.println(loginPage.getPageSubtitle());
       BrowserUtils.wait(2);
   }

}
