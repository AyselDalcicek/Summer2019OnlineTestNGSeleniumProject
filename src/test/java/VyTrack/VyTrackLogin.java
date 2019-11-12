package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class VyTrackLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");  // launch chrome browser

        driver.get("https://qa2.vytrack.com/user/login");  // go to VyTrack Login Page

        driver.findElement(By.name("_username")).sendKeys("user171");;
                                //to find username box       // entering the username

        driver.findElement(By.name("_password")).sendKeys("UserUser123");
                                 //to find password box       // entering the  password

        driver.findElement(By.name("_submit")).click();
                        //to find login button // clicking the login button

    /*    WebElement logginButton = driver.findElement(By.id("_submit"));
        logginButton.click(); ---> we can also use this way */

        //to test if the app login
        String expectedURL = "https://qa2.vytrack.com/";
        String actualURL = driver.getCurrentUrl();
        if(expectedURL.equals(actualURL)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit();  //to close the tab

    }


}
