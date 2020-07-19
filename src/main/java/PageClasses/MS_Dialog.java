package PageClasses;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MS_Dialog extends _01_ParentClass {


    private WebDriver driver ;

    //    https://www.softwaretestinghelp.com/page-object-model-pom-with-pagefactory/#:~:text=The%20initElements%20is%20a%20static,java.lang.Class%20pageObjectClass)
    public MS_Dialog(){

        driver = Driver.GetDriver();
        PageFactory.initElements( driver , this );

    }

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']/input")
    private WebElement nameInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='code']/input")
    private WebElement codeInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']/input")
    private WebElement IntegrationCodeInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='priority']/input")
    private WebElement priorityInput;

    @FindBy(xpath="//ms-save-button/button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'success')]")
    private WebElement successMessage;

    @FindAll({
         @FindBy(xpath = "//ms-edit-button//button")
    })
    private List<WebElement> allEditButtons;

    @FindAll({
        @FindBy(xpath = "//ms-delete-button//button")
    })
    private List<WebElement> allDeleteButtons;

    @FindAll({
    @FindBy(xpath = "//table//td[2]")
    })
    private List<WebElement> allNames;

    @FindBy(xpath = "//tr[1]//td[1]")
    private WebElement numberOne;

    @FindBy(xpath = "//span[text()=' Yes ']")
    private WebElement buttonYes;



    WebElement myElement;

    public void findTheElementFromThePageAndSendKeys(String elementName ,String value){

        switch (elementName){

            case "nameInput":
                myElement = nameInput;
                break;
            case "codeInput":
                myElement = codeInput;
                break;
            case "IntegrationCodeInput":
                myElement = IntegrationCodeInput;
                break;
            case "priorityInput":
                myElement = priorityInput;
                break;
        }
        sendKeysFunction(myElement , value );
    }

    public void findTheElementFromThePageAndClick(String elementName){

        switch (elementName){

            case "saveButton":
                myElement = saveButton;
                break;
            case "buttonYes":
                myElement = buttonYes;
                break;

        }
        clickFunction(myElement);
    }

    public void visibilityOfElement(String elementName){

        switch (elementName){

            case "successMessage":
                myElement = successMessage;
                break;
        }

        waitUntilVisible(myElement);

        System.out.println(successMessage.getText());
        successMessage.isDisplayed();
    }



    public void handleTheMultipleList(String editOrDelete , String name){

        List<WebElement> l1 = new ArrayList<>();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (editOrDelete) {
            case "edit":
                l1=allEditButtons;
                break;
            case "delete":
                l1=allDeleteButtons;
                break;

        }

        clickOnButtonAccordingToName(allNames , l1 , name);

    }

    /*

        Make a cross browser testing

        Add a report

        Log4J

     */
}
