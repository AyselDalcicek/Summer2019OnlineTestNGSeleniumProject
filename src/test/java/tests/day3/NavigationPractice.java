package tests.day3;


import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {

                public static void main(String[] args) {
                        //create a webdriver object to work with a browser
                        WebDriver driver = BrowserFactory.getDriver("chrome");
                        //to maximize browser wimdow
                        driver.manage().window().maximize();
                        driver.get("http://google.com");
                        //wait for 3seconds
                        //this is our custom method
                        //since method is static we use class name to cal the method
                        //as a parameter we provide number of seconds(time in seconds)
                        BrowserUtils.wait(3);
                        //to print page title
                        System.out.println(driver.getTitle());
                        driver.navigate().to("http://amazon.com");
                        //navigate back to google(previous URL)
                        driver.navigate().back();
                        //move forward the amazon again
                        driver.navigate().forward();
                        //to refresh/reload a webpage/website
                        driver.navigate().refresh();
                        driver.getTitle(); // <title>google/<title>
                        //shutdown browser
                        driver.quit();
                        //if tab only one close() will shutdown browser
                        //and we can not use driver any more
                        //so we have to recreate an object of Webdriver
                        //what  will happen if you call the driver after quit() method
                        driver.get("http://google.com");
                }
        }

