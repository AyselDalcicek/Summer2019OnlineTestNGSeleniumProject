package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase5 {

    /*
    Step 1. Go to https://practicecybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “123” into last name input box.
    Step 4. Verify that warning message is displayed:
    “The last name can only consist of alphabetical letters and dash”
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("lastname")).sendKeys("123");
        WebElement warningMessage = driver.findElement(By.xpath("//small[@style='display: block;']"));
        System.out.println(warningMessage.getText());

        String expectedResult = "The last name can only consist of alphabetical letters and dash";
        String actualResult = warningMessage.getText();
        if(actualResult.equals(expectedResult)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        Thread.sleep(2000);
        driver.quit();

    }
}