package com.Bitrix.tests;

import com.Bitrix.utils.BrowserUtils;
import com.Bitrix.utils.ConfigurationReader;
import com.Bitrix.utils.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

//this class will be a test foundation for all test classes
//we will put here only before and after parts
//In this way before and after methods will be the same
//Every test class will extend testbase class
public abstract class TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeTest
    @Parameters({"test", "env_url"})
    public void beforeTest(@Optional String test, @Optional String env_url){
        String reportName = "report";  //location of report   //it's gonna be next to target folder, test-output folder
    if(test != null){
        reportName = test;
    }
    String filePath = System.getProperty("user_dir") + "/test-output/" +reportName + ".html";
    extentReports = new ExtentReports();
    extentHtmlReporter = new ExtentHtmlReporter(filePath);
    extentReports.attachReporter(extentHtmlReporter);
    extentHtmlReporter.config().setReportName("Bitrix Test Result");
    String env = ConfigurationReader.getProperty("url");
    if(env_url !=  null){
        env = env_url;
    }
    extentReports.setSystemInfo("Environment", env);
    extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
    extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @AfterTest
    public void afterTest(){
        extentReports.flush();   //  Writes test information from the started reporters to their output view
    }

//    @BeforeMethod
//    @Parameters("env_url")     //   <parameter name="env_url" value="https://qa3.vytrack.com/"></parameter>
//    public void setup(@Optional String env_url) {
//        String url = ConfigurationReader.getProperty("url");
//        if (env_url != null) {     //if name parameter was set, then use it  //if it's null that means it was not set
//                url = env_url;
//            }
//            Driver.get().get(url);
//        //  Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }


    @BeforeMethod
    public void setUp(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
        //Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    //ITestResult class describes the result of a test. (in TestNG)
    @AfterMethod
    public void teardown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try{
                //BrowserUtils.getScreenshot(result.getName()) - takes screenshot and returns location of that screenshot
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            }catch (IOException e){
                e.printStackTrace();
            }
        }else if (result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test case was skipped : " + result.getName());
        }
        Driver.close();
    }

}
