package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class VyTrackLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");  // launch chrome browser

        driver.get("https://qa2.vytrack.com/user/login");  // go to VyTrack Login Page

        WebElement username = driver.findElement(By.name("_username"));  //to find username box
        username.sendKeys("user171");  // entering the username

        WebElement password =driver.findElement(By.name("_password"));  //to find password box
        password.sendKeys("UserUser123");  // entering the  password

        WebElement clickLogin = driver.findElement(By.name("_submit"));  //to find login button
        clickLogin.click();  // clicking the login button

        //to test if the app login
        String expextedURL = "https://qa2.vytrack.com/";
        String actualURL = driver.getCurrentUrl();
        if(expextedURL.equals(actualURL)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.close();  //to close the tab

    }


}
