package tests.day14;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase {

    @Ignore
    @Test
    public void test1(){
        //read url value from the properties file
        String url = ConfigurationReader.getProperty("url");
        //Driver.get() --> will return webdriver object
        //and then we can call webdriver methods like get(), findElement()....
//        WebDriver driver = Driver.get(); --> so we do not need to create new reference variable. it works without this.
        Driver.get().get(url);
        //print page title
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
        Driver.close();
    }

    @Test
    public void test2(){  // if we extends DataBase Class we do not need to write previous code. Just this two lines will be enough.
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
    }
}