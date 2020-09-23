Feature: Download file

  Scenario: Download assets page associated file

    Given I am as a user login to website
    And User navigate to assets page
    When User download the associated file
    Then User should be able download the file



