package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class VyTrackLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");  // launch chrome browser

        driver.get("https://qa2.vytrack.com/user/login");  // go to VyTrack Login Page

        WebElement username = driver.findElement(By.name("_username"));
        username.sendKeys("user171");  // entering the username

        WebElement password =driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");  // entering the  password

        WebElement clickLogin = driver.findElement(By.name("_submit"));  // clicking the login button
        clickLogin.click();

        Thread.sleep(4000);
        driver.close();

    }


}
