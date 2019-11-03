package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Multiple Buttons")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();
        WebElement buttonMessage = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println(buttonMessage.getText());
        Thread.sleep(2000);


        String expectedResult = "Clicked on button one!";
        String actualResult = buttonMessage.getText();
        if(actualResult.equals(expectedResult)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        Thread.sleep(2000);
        driver.quit();

    }
}
