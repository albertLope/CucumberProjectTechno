package PageClasses;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNavigator extends _01_ParentClass {

    private WebDriver driver ;

    //    https://www.softwaretestinghelp.com/page-object-model-pom-with-pagefactory/#:~:text=The%20initElements%20is%20a%20static,java.lang.Class%20pageObjectClass)
    public LeftNavigator(){

        driver = Driver.GetDriver();
        PageFactory.initElements( driver , this );

    }

    @FindBy(xpath="//span[text()='Setup']")
    private WebElement setupOne;

    @FindBy(xpath="//span[text()='Parameters']")
    private WebElement Parameters;

    @FindBy(xpath=" //span[text()='Countries']")
    private WebElement Country;

    @FindBy(xpath="//span[text()='Fees']")
    private WebElement Fees;

    @FindBy(xpath="//span[text()='Citizenships']")
    private WebElement Citizenships;

    @FindBy(xpath=" //span[text()='Schedulers Management']")
    private WebElement Schedulers_Management;


    @FindBy(xpath="//ms-add-button//button")
    private WebElement addButton;

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']/input")
    private WebElement NameInThePopUp;

    WebElement myElement;

    public void findTheElementFromThePageAndClick(String elementName){

        switch (elementName){

            case "setupOne":
                myElement = setupOne;
                break;
            case "Parameters":
                myElement = Parameters;
                break;
            case "Country":
                myElement = Country;
                break;
            case "addButton":
                myElement = addButton;
                break;
            case "Fees":
                myElement = Fees;
                break;
            case "Citizenships":
                myElement = Citizenships;
                break;
            case "Schedulers_Management":
                myElement = Schedulers_Management;
                break;
            default:
                break;
        }

        clickFunction(myElement);
    }
}
