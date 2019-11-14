package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://practice-cybertekschool.herokuapp.com\"");
        Thread.sleep(2000);
//        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
//        driver.findElement(By.name("full_name")).sendKeys("Aysel Dalcicek");
//        Thread.sleep(2000);
//        driver.findElement(By.name("email")).sendKeys("ayseldalcicek07@gmail.com");
//        Thread.sleep(2000);
//        driver.findElement(By.name("wooden_spoon")).click();
//        Thread.sleep(2000);
//        WebElement message = driver.findElement(By.tagName("h3"));
//        System.out.println(message.getText());
//        String expectedResult ="Thank you for signing up. Click the button below to return to the home page.";
//        if(message.getText().equals(expectedResult)){
//            System.out.println("Pass");
//        }else{
//            System.out.println("Fail");
//        }

        driver.quit();


    }

}
