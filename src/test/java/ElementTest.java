import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementTest {

    public static void setLogin (WebDriver driver){
        driver.navigate().to("http://automation.herolo.co.il");
    }
    public static By DialogPanel(){
        return By.id("modal-form");
    }

    public static WebElement buttonToReceivingCall(WebDriver driver){
        return driver.findElement(ElementTest.DialogPanel()).findElement(By.tagName("button"));
    }
    public static List<WebElement> dataSendingFields(WebDriver driver){
        return driver.findElement(ElementTest.DialogPanel()).findElements(By.tagName("input"));
    }
    /** The happy girl's logo **/
    public static By jugglingSuccess(){
        return By.id("juggling");
    }
    public static String SuccessMessage(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/div/main/div[1]/div[2]")).getText();
    }
}
