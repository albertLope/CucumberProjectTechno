package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    public static WebDriver createInstance(String browserName) {
        WebDriver driver;

        if(browserName==null){
            browserName="chrome";
        }

        switch (browserName) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "D:\\Selenium dependency\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "D:\\Selenium dependency\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;

            default:
                driver = new FirefoxDriver();
                break;
        }
        // maximize browser's window on start
        driver.manage().window().maximize();
        return driver;
    }

    private static enum Browser {
        FIREFOX,
        CHROME,

    }
}
