Feature: I am as a user able to create a Citizenship


  Scenario: Create a Citizenship

    And Navigate in the left navigator first "setupOne" second "Parameters" third "Citizenships"
    And Create a Fees name as "Work hard" code as "123" integratoin code as "1234" priority as "12345"
    Then Success message is displayed


  Scenario: Edit a Citizenship

    And Navigate in the left navigator first "setupOne" second "Parameters" third "Citizenships"
    And Edit a Country name "Work hard" as "Work not that hard" code "123" as "1234"
    Then Success message is displayed


  Scenario: Delete a Citizenship

    And Navigate in the left navigator first "setupOne" second "Parameters" third "Citizenships"
    And Delete an item name "Work not that hard"
    Then Success message is displayed



