package com.VyTrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.VyTrack.utils.BrowserUtils;

public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    public void clickToCreateCalendarEvent() {
        BrowserUtils.waitForVisibility(createCalendarEvent, 5);
        BrowserUtils.waitForClickablity(createCalendarEvent, 5);
        createCalendarEvent.click();
    }


}