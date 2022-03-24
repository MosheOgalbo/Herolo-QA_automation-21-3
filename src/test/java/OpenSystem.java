import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class OpenSystem {

    private WebDriver driver = Driver.chromeDriverBrowser();
    @BeforeTest
    public void nweTest(){

    }
    @Test
    public void OpeningLandingPage(){
        ElementTest.setLogin(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,250)");
        js.executeScript("window.scrollTo(20, document.body.scrollHeight)");
    }

    @Test
    public void SendDetailsInPopup() throws InterruptedException {
        TestFunctions.NegativeExecutionOfDataTransmissionAllFields(driver,"  ","  ","  ");
        TestFunctions.NegativeExecutionOfDataTransmissionAllFields(driver,"moshe","sdfsdg","fdsfds");
        TestFunctions.NegativeExecutionOfDataTransmissionAllFields(driver,"moshe"," "," ");

        //TestFunctions.PartialExecutionOfSendingDataForContact(driver,"moshe","mos@gmail.com","0537169998");

    }
    @AfterTest
    public void closeLandingPage(){
        //driver.quit();
        driver.close();
    }

}
