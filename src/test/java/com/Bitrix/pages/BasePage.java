package com.Bitrix.pages;

import com.Bitrix.utils.BrowserUtils;
import com.Bitrix.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

//    public void NavigateToDrive(){
//        WebElement  driveElement = Driver.get().findElement(By.cssSelector("[title='Drive']"));
//        BrowserUtils.waitForVisibility(driveElement,5);
//        BrowserUtils.waitForClickablity(driveElement,5);
//        driveElement.click();
//    }
//
//
//    public void NavigateToCalender(){
//        WebElement calenderElement = Driver.get().findElement(By.cssSelector("[title='Calendar']"));
//        BrowserUtils.waitForVisibility(calenderElement,5);
//        BrowserUtils.waitForClickablity(calenderElement, 5);
//        calenderElement.click();
//    }

    public void menuNavigation(String menuItem) {
        WebElement menu = Driver.get().findElement(By.cssSelector("[title='" + menuItem + "']"));
        BrowserUtils.waitForVisibility(menu, 5);
        BrowserUtils.waitForClickablity(menu, 5);
        menu.click();

    }

    public String  getPageSubtitle() {
        WebElement subtitle = Driver.get().findElement(By.id("pagetitle"));
        BrowserUtils.waitForStaleElement(subtitle);
        String subTitleText = subtitle.getText();
        return subTitleText;
    }


    }



