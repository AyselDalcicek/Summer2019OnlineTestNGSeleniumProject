package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class TestCase2 {

    /*
    Step 1. Go to https://practicecybertekschool.herokuapp.com
    Step 2. Verify that number of listed examples is equals to 48.
    Hint: use findElemnts() and size() methods.
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.className("list-group-item"));
        System.out.println(list.size());
        Thread.sleep(2000);
        driver.quit();

        int expectedResult = 48;
        int actualResult = list.size();
        if(expectedResult==actualResult){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
    }
}
