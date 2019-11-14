package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase7 {
    /*
    Step 1. Go to https://practicecybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “testers@email” into email input box.
    Step 4. Verify that warning message is displayed: “email address is not a valid
    Email format is not correct”
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("email")).sendKeys("testers@email");
        WebElement warningMessage1 = driver.findElement(By.xpath("//small[@data-bv-validator='emailAddress']"));
        System.out.println(warningMessage1.getText());
        WebElement warningMessage2 = driver.findElement(By.xpath("//small[.='Email format is not correct']"));
        System.out.println(warningMessage2.getText());

        String expectedResult1 = "email address is not a valid";
        String expectedResult2 = "Email format is not correct";
        String actualResult1 = warningMessage1.getText();
        String actualResult2 = warningMessage2.getText();
        if(actualResult1.equals(expectedResult1) && actualResult2.equals(expectedResult2)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
