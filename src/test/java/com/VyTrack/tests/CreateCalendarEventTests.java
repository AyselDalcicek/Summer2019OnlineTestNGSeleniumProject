package com.VyTrack.tests;
import com.VyTrack.pages.CalendarEventsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.VyTrack.pages.CreateCalendarEventPage;
import com.VyTrack.pages.LoginPage;

public class CreateCalendarEventTests extends TestBase {


    @Test(description = "Verify owners name is equals to Stephan Haley (it works on qa1 storemenager85)")
    public void test1(){
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();

        //login as Stephan Haley (storemanager85)
        loginPage.login("storemanager85", "UserUser123");

        //go to calendar events page
        loginPage.navigateTo("Activities", "Calendar Events");

        //click on create calendar event button
        calendarEventsPage.waitUntilLoaderMaskDisappear();
        calendarEventsPage.clickToCreateCalendarEvent();

        calendarEventsPage.waitUntilLoaderMaskDisappear();
        String expectedOwner = "Pearl Wuckert";
        String actualOwner = createCalendarEventPage.owner.getText().trim();

        Assert.assertEquals(actualOwner, expectedOwner);


    }
}