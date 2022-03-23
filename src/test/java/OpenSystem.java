import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import static java.lang.Thread.sleep;

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
        //js.executeScript("window.scrollTo(20, document.body.scrollHeight)");
       // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test
    public void SendDetailsInPopup(){
        //TestFunctions.PartialExecutionOfSendingDataForContact(driver,"moshe","mos@gmail.com","0537169998");
        TestFunctions.NegativeExecutionOfDataTransmission(driver,"moshe","sdfsdg","fdsfds");

    }
    @AfterTest
    public void closeLandingPage(){
        //driver.quit();
//        driver.close();
    }

}
