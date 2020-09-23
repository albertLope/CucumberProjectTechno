package Utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

//    public static WebDriver driver;

    private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>();

    public static String browsername;

    public static WebDriver GetDriver(){

        if(driverInstance.get()==null) {

            setWebDriver(ChooseDriver(browsername));

        }

        return driverInstance.get();

    }

    public static void setWebDriver(WebDriver driver) {

        Driver.driverInstance.set(driver);
    }

    public static void quitDriver(){

        if( driverInstance.get()!=null) {
            driverInstance.get().quit();
            WebDriver driver1 = driverInstance.get();
            driver1=null;
            driverInstance.set(driver1);
        }

    }

    private static WebDriver ChooseDriver(String browserName){

        WebDriver driver;

        System.out.println(browserName + "<---------------- browser name ");

        if(browserName==null){
            browserName="chrome";
        }

        switch (browserName) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        return driver;
    }

}
