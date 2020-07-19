package PageClasses;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends _01_ParentClass {

    private WebDriver driver ;

//    https://www.softwaretestinghelp.com/page-object-model-pom-with-pagefactory/#:~:text=The%20initElements%20is%20a%20static,java.lang.Class%20pageObjectClass)
    public LoginPage(){

        driver = Driver.GetDriver();
        PageFactory.initElements( driver , this );

    }

    @FindBy(xpath="//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath="//button[@aria-label='LOGIN']")
    private WebElement login;

    @FindBy(linkText="Got it!")
    private WebElement GotItButton;


    WebElement myElement;

    public void findTheElementFromThePageAndSendKeys(String elementName ,String value){

        switch (elementName){

            case "username":
                myElement = username;

                break;
            case "password":
                myElement = password;
                break;

        }

        sendKeysFunction(myElement , value );
    }

    public void findTheElementFromThePageAndClick(String elementName){

        switch (elementName){

            case "login":
                myElement = login;
                break;
            case "GotItButton":
                myElement = GotItButton;
                break;


        }

        clickFunction(myElement);
    }



}
