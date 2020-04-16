package com.VyTrack.utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private static WebDriver driver;

    //    you cannot do like this, if constructor is private Driver obj = new Driver()
    private Driver() {

    }
    //if switch statement complains on string parameter
    //change java version to 7+, better at least 8
    //File--> Project Structure--> Set Project language level to at least 8 or above

    // marufjon's

    public static WebDriver get(){
        //if webdriver object was not created yet
        if(driver==null){
            //create webdriver object based on browser value from properties file
            String browser = ConfigurationReader.getProperty("browser");
            switch(browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                        // We added it for speed
//                        ChromeOptions chromeOptions = new ChromeOptions();  // //to configure chrome browser for tests
//                        chromeOptions.setHeadless(false);   //to run tests without interface, set to true
//                        driver = new ChromeDriver(chromeOptions);
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case"ie":
                    if(System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("You are operating Mac OS which doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case"safari":
                    if(System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("You are operating Windows OS which doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                default:
                    //if browser type is wrong throw exception
                    //no browser will be opened
                    throw new RuntimeException("Wrong browser type");
            }
        }
        //if webdriver object was created-you can use it
        return driver;
    }


    // Vasily's
//    public static WebDriver get() {
//        //if webdriver object was not created yet
//        if (driver == null) {
//            //create webdriver object based on browser value from properties file
//            String browser = ConfigurationReader.getProperty("browser");
//            switch (browser) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    //to configure chrome browser for tests
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    //to run tests without interface, set to true
//                    chromeOptions.setHeadless(false);
//                    driver = new ChromeDriver(chromeOptions);
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//                default:
//                    //if browser type is wrong, throw exception.
//                    //no browser will be opened
//                    throw new RuntimeException("Wrong browser type!");
//            }
//        }
//        //if webdriver object was created - you can use it
//        return driver;
//    }

    public static void close() {
        //if driver still exist
        if (driver != null) {
            //close all browsers
            driver.quit();
            //destroy driver object, ready for gc
            driver = null;
        }
    }
}