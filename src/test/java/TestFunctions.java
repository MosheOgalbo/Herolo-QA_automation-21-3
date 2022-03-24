import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static java.lang.Thread.sleep;

public class TestFunctions {
    public static void waitDialogPanel(WebDriver driver){
        Driver.waitDrivervisibilityOfElement(driver,ElementTest.DialogPanel());
        driver.findElement(ElementTest.DialogPanel()).click();
    }
    public static void waitingWindowSuccessExecution(WebDriver driver){
        Driver.waitInvisibilityOfElementLocated(driver,ElementTest.DialogPanel());
    }
    public static void ClearFieldsOnPopup(WebDriver driver){
        ElementTest.dataSendingFields(driver).get(0).click();
        ElementTest.dataSendingFields(driver).get(0).clear();
        ElementTest.dataSendingFields(driver).get(1).clear();
        ElementTest.dataSendingFields(driver).get(2).clear();
    }
    public static void actionsInWindowOfForInformation(WebDriver driver,String name,String email,String phone) {
        ClearFieldsOnPopup(driver);
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
    /** The function types in all the fields in the pop-up window and returns whether there is a valid message **/
    public static String NegativeExecutionOfDataTransmissionAllFields(WebDriver driver,String name,String email,String phone) {
        waitDialogPanel(driver);
        actionsInWindowOfForInformation(driver, name, email, phone);
        if (checkForErrorMessage(driver)){
            if (ReceiveTextMessages(driver)[0].equals(TestString.PhoneNumberText)&&
                    ReceiveTextMessages(driver)[1].equals(TestString.EmailAddressText)) {
                return TestString.TextMatchSucceeded ;
            }
            else {
             return TestString.NoTextMatchSucceeded;
            }
        }
        else {
            return TestString.NoMessage;
        }
    }
    public static boolean checkForErrorMessage(WebDriver driver){
        try {
            if (ElementTest.errorMessages(driver).get(0).isDisplayed()){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static String[] ReceiveTextMessages(WebDriver driver){
        String MessageText[] = new String[3];
        MessageText[0] = ElementTest.errorMessages(driver).get(0).getText();
        MessageText[1] = ElementTest.errorMessages(driver).get(1).getText();
        MessageText[2] = ElementTest.errorMessages(driver).get(2).getText();
        return MessageText;
    }
    public static void NegativeExecutionOfDataTransmissionNotAllFields(WebDriver driver,
                                                                       String name,String email,String phone){
        waitDialogPanel(driver);
        actionsInWindowOfForInformation(driver, name, email, phone);
    }





}
