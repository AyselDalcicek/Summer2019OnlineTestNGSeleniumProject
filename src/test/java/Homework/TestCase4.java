package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("firstname")).sendKeys("123");
        WebElement warningMessage = driver.findElement(By.xpath("//small[@style='display: block;']"));
        System.out.println(warningMessage.getText());

        String expectedResult = "first name can only consist of alphabetical letters";
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
