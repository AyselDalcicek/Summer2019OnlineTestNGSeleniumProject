package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase8 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("phone")).sendKeys("t5711234354");
        WebElement warningMessage = driver.findElement(By.cssSelector("small[style='display: block;']")); // ????????
        System.out.println(warningMessage.getText());

        String expectedResult = "Phone format is not correct";
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

