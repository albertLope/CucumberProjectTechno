package stepDefinition;

import PageClasses.LeftNavigator;
import PageClasses.LoginPage;
import PageClasses.MS_Dialog;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepOfCountry {

    LoginPage parametersPage = new LoginPage();
    LeftNavigator leftNavigator = new LeftNavigator();
    MS_Dialog ms_dialog = new MS_Dialog();


    @Given("^Navigate in the left navigator first \"([^\"]*)\" second \"([^\"]*)\" third \"([^\"]*)\"$")
    public void navigate_in_the_left_navigator_first_second_third(String element1, String element2, String element3) {

        leftNavigator.findTheElementFromThePageAndClick(element1);
        leftNavigator.findTheElementFromThePageAndClick(element2);
        leftNavigator.findTheElementFromThePageAndClick(element3);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("^Navigate to Country$")
    public void navigate_to_City(){

        leftNavigator.findTheElementFromThePageAndClick("setupOne");
        leftNavigator.findTheElementFromThePageAndClick("Parameters");
        leftNavigator.findTheElementFromThePageAndClick("Country");
    }

    @Given("^Navigate to Fees$")
    public void navigate_to_Fees()  {
        leftNavigator.findTheElementFromThePageAndClick("setupOne");
        leftNavigator.findTheElementFromThePageAndClick("Parameters");
        leftNavigator.findTheElementFromThePageAndClick("Fees");
    }



    @And("^Create a Fees name as \"(.*?)\" code as \"(.*?)\" integratoin code as \"(.*?)\" priority as \"(.*?)\"$")
    public void create_a_Fees_name_as_code_as_integratoin_code_as_priority_as(String name, String Code, String integrateCode, String priority) {

        leftNavigator.findTheElementFromThePageAndClick("addButton");
        ms_dialog.findTheElementFromThePageAndSendKeys("nameInput", name);
        ms_dialog.findTheElementFromThePageAndSendKeys("codeInput", Code);
        ms_dialog.findTheElementFromThePageAndSendKeys("IntegrationCodeInput", integrateCode);
        ms_dialog.findTheElementFromThePageAndSendKeys("priorityInput", priority);
        ms_dialog.findTheElementFromThePageAndClick("saveButton");
    }

    @And("^Create a Country name as \"(.*?)\" code as \"(.*?)\"$")
    public void create_a_Country_name_as_code_as(String name, String code)  {

        leftNavigator.findTheElementFromThePageAndClick("addButton");
        ms_dialog.findTheElementFromThePageAndSendKeys("nameInput", name);
        ms_dialog.findTheElementFromThePageAndSendKeys("codeInput" , code);
        ms_dialog.findTheElementFromThePageAndClick("saveButton");

    }

    @And("^Edit a Country name \"(.*?)\" as \"(.*?)\" code \"(.*?)\" as \"(.*?)\"$")
    public void edit_a_Country_name_as_code_as(String name, String name2, String code1, String code2) {

        ms_dialog.handleTheMultipleList("edit" , name);
        ms_dialog.findTheElementFromThePageAndSendKeys("nameInput", name2);
        ms_dialog.findTheElementFromThePageAndSendKeys("codeInput" , code2);
        ms_dialog.findTheElementFromThePageAndClick("saveButton");

    }

    @And("^Delete an item name \"(.*?)\"$")
    public void delete_a_Country_name(String name) {
        ms_dialog.handleTheMultipleList("delete" , name);
        ms_dialog.findTheElementFromThePageAndClick("buttonYes");
    }

    @Then("^Success message is displayed$")
    public void success_message_is_displayed() {
        ms_dialog.visibilityOfElement("successMessage");
    }




}
