package Utilities;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Driver {

//    public static WebDriver driver;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver GetDriver(){

        if(driver.get()==null) {

            System.setProperty("webdriver.chrome.driver", "D:\\Selenium dependency\\drivers\\chromedriver.exe");

            setWebDriver(DriverFactory.createInstance(null));

        }

        return driver.get();

    }

    public static void setWebDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.driver.set(driver);
    }

    public static void quitDriver(){

        if( driver.get()!=null) {
            driver.get().quit();
            WebDriver driver1 = driver.get();
            driver1=null;
            driver.set(driver1);

        }

    }


}
