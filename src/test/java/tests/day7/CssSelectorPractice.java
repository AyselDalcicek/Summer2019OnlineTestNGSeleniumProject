package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.sql.SQLOutput;
import java.util.List;

public class CssSelectorPractice {

    public static void main(String[] args) {
        //Please use google chrome
        //Which locator to use?
        //#1 id
        //#2 css
        //#3 xpath
        //## whatever
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/multiple_buttons");
        //let's find all buttons, and click on them one by one
        // why I put . instead of space? because it's 2 class names .btn.btn-primary
        //in this case, we will find all buttons that have: class="btn btn-primary"
        // or like this [class='btn btn-primary'], no need for .
        //. means class name
        //# means id
        //all buttons
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        //loop through list of buttons
        for(WebElement button: buttons){
            //and click on every button one by one
            button.click();
            BrowserUtils.wait(1);
            //get the message after click
            WebElement message = driver.findElement(By.cssSelector("#result"));  // <p id="result"
            //print a text of that message
            System.out.println(message.getText());
        }
        // find element with a tag name h3, that has a parent element, with class name container
        WebElement header = driver.findElement(By.cssSelector(".container > h3"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.cssSelector("[class='container'] > p"));  // "p" we can find by using "p"
        System.out.println(p.getText());
        driver.quit();
    }
}
 // [class='btn btn-primary'][name='button2']  we can write like this for button 2