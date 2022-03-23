import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static java.lang.Thread.sleep;
import static java.lang.Thread.*;
import java.util.Collections;

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

    public static void NegativeExecutionOfDataTransmission(WebDriver driver, String name, String email, String phone) throws InterruptedException {
        waitDialogPanel(driver);
        actionsInWindowOfForInformation(driver,name,email,phone);
        try {
            List<WebElement> v = driver.findElement(By.id("modal-form")).findElements(By.tagName("span"));
            String[] message = new String[2];
            message[0] = v.get(0).getText();
            message[1] = v.get(1).getText();
            if (message[0].equals(TestString.EmailAddressText) && message[1].equals(TestString.PhoneNumberText)) {
                System.out.println("tro");
            } else {
                System.out.println("no");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
