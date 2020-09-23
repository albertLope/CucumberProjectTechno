Feature: I am as a user able to create a Country

  @SmokeTest
  Scenario: Create a Country

    And Navigate in the left navigator first "setupOne" second "Parameters" third "Country"
    And Create a Country name as "Work hard" code as "123"
    Then Success message is displayed

  @SmokeTest
  Scenario: Edit a Country

    And Navigate in the left navigator first "setupOne" second "Parameters" third "Country"
    And Edit a Country name "Work hard" as "Work not that hard" code "123" as "1234"
    Then Success message is displayed

  @SmokeTest
  Scenario: Delete a Country

    And Navigate in the left navigator first "setupOne" second "Parameters" third "Country"
    And Delete an item name "Work not that hard"
    Then Success message is displayed

