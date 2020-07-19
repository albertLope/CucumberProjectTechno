Feature: I am as a user able to create a Fees

  @SmokeTest
  Scenario: Create a Fees

    And Navigate in the left navigator first "setupOne" second "Parameters" third "Fees"
    And Create a Fees name as "Work hard" code as "123" integratoin code as "1234" priority as "12345"
    Then Success message is displayed

  @SmokeTest
  Scenario: Edit a Fees

    And Navigate in the left navigator first "setupOne" second "Parameters" third "Fees"
    And Edit a Country name "Work hard" as "Work not that hard" code "123" as "1234"
    Then Success message is displayed

  @SmokeTest
  Scenario: Delete a Fees

    And Navigate in the left navigator first "setupOne" second "Parameters" third "Fees"
    And Delete an item name "Work not that hard"
    Then Success message is displayed

