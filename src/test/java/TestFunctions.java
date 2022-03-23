import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

public class TestFunctions {
    public static void waitDialogPanel(WebDriver driver){
        Driver.waitDrivervisibilityOfElement(driver,ElementTest.DialogPanel());
        driver.findElement(ElementTest.DialogPanel()).click();
    }
    public static void waitingWindowSuccessExecution(WebDriver driver){
        Driver.waitInvisibilityOfElementLocated(driver,ElementTest.DialogPanel());
    }
    public static void actionsInWindowOfForInformation(WebDriver driver,String name,String email,String phone) {
        ElementTest.dataSendingFields(driver).get(0).click();
        ElementTest.dataSendingFields(driver).get(0).sendKeys(name);
        ElementTest.dataSendingFields(driver).get(1).sendKeys(email);
        ElementTest.dataSendingFields(driver).get(2).sendKeys(phone);
        ElementTest.buttonToReceivingCall(driver).click();
    }
    /** Positive test of sending data and then back to main page  **/
    public static void PartialExecutionOfSendingDataForContact(WebDriver driver,String name,String email,String phone){
        waitDialogPanel(driver);
        actionsInWindowOfForInformation(driver,name,email,phone);
        waitingWindowSuccessExecution(driver);
        Driver.waitDrivervisibilityOfElement(driver,ElementTest.jugglingSuccess());
        System.out.println(ElementTest.SuccessMessage(driver));
        driver.navigate().back();
    }
    public static void NegativeExecutionOfDataTransmission(WebDriver driver,String name,String email,String phone) {
        waitDialogPanel(driver);
        actionsInWindowOfForInformation(driver,name,email,phone);
        String c= ElementTest.dataSendingFields(driver).get(1).getText();
        System.out.println(c);

    }
}
