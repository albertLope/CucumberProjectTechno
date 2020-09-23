package stepDefinition;

import PageClasses.LoginPage;
import Utilities.Driver;

import Utilities.ReadProperties;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseDriver {

    LoginPage loginPage = new LoginPage();

    private static WebDriver driver;

//    @Before
//    public void beforeMethod(Scenario scenario){
//
//       System.out.println("Before method");
//
//        driver = Driver.GetDriver();
//
//        driver.get("https://test.basqar.techno.study/");
//
//        System.out.println(driver + "<-----------   driver");
//
//        loginPage.findTheElementFromThePageAndSendKeys("username" , ReadProperties.getData("username"));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        loginPage.findTheElementFromThePageAndSendKeys("password" , ReadProperties.getData("password"));
//        loginPage.findTheElementFromThePageAndClick("login");
//        loginPage.findTheElementFromThePageAndClick("GotItButton");
//
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='cdk-overlay-container']/div"))));
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @After
//    public void closeDriver(Scenario scenario){
//
//
//        Driver.quitDriver();
//    }



    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots"
        // under src folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
                + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

}
