import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentReports;



public class OpenSystem {

    private WebDriver driver = Driver.chromeDriverBrowser();


    // This code will run before executing any testcase
    @BeforeTest
    public void setup() {
        ExtentReports extent = new ExtentReports();
        

    }
    @AfterTest
    public void closeLandingPage(){
        //driver.quit();
        driver.close();
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
        String a,b,c,d;
        a= TestFunctions.NegativeExecutionOfDataTransmissionAllFields(driver,"  ","  ","  ");
        b= TestFunctions.NegativeExecutionOfDataTransmissionAllFields(driver,"moshe","sdfsdg","fdsfds");
        c= TestFunctions.NegativeExecutionOfDataTransmissionAllFields(driver,"moshe","   ","  ");
        d= TestFunctions.NegativeExecutionOfDataTransmissionAllFields(driver,"moshe","   "," ");
        System.out.println(a+"\n"+b+"\n" + c +"\n"+d);
       TestFunctions.PartialExecutionOfSendingDataForContact(driver,"moshe","mos@gmail.com","0537157775");

    }



}
