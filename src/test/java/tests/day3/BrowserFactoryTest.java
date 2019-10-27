package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BrowserFactoryTest {

    public static void main(String[] args) {
        //now we can get webdriver like this
        //getDriver() method will return webdriver object
        //and we can use reference variable to work with taht object
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com");
        //how we can print a source code of the page?
        System.out.println(driver.getPageSource());
        //to finish test execution
        driver.quit();
    }
}

