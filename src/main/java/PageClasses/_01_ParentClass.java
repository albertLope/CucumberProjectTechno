package PageClasses;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class _01_ParentClass {

    private WebDriver driver;

    public _01_ParentClass(){
        driver= Driver.GetDriver();
    }

    public void sendKeysFunction(WebElement ElementToSendkeys , String value){

        System.out.println(ElementToSendkeys + "in the send key function");
        WebElement element = waitUntilVisible(ElementToSendkeys);

        element.clear();
        element.sendKeys(value);

    }

    public void clickFunction(WebElement ElementToClick){

        System.out.println(ElementToClick + "in the click function");
        WebElement element = waitUntilVisible(ElementToClick);
        element.click();

    }

    public WebElement waitUntilVisible(WebElement e1){

        WebDriverWait wait = new WebDriverWait(driver , 10);

        WebElement elementName= wait.until(ExpectedConditions.visibilityOf(e1));

        return elementName;
    }

    public void waitForMoreThen(List<WebElement> elementsToWait){
        WebDriverWait wait = new WebDriverWait(driver , 10);

        try{

        wait.until(ExpectedConditions.visibilityOfAllElements(elementsToWait));

        }catch (Exception e){
            System.out.println("Catch the exception");
        }
    }


    /*
        This method is taking two List of webelement(listOfName , ListofEditButton) and One string(Name)
            If the String(name) is in the listOfName then click on the edit button next to it
     */
    public void clickOnButtonAccordingToName(List<WebElement> listname , List<WebElement> Button , String expectedName){

        System.out.println(listname + "<<<<<<<<<<<<<<<<<---------------");

        for(int i = 0 ; i <listname.size() ; i++){

            if(listname.get(i).getText().equals(expectedName)){
                Button.get(i).click();
                break;
            }

        }

    }



}
