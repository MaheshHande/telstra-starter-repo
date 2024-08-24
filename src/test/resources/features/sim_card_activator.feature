
Feature: SIM Card Activation

  Scenario: Successful SIM card activation
    Given I have a valid ICCID "1255789453849037777"
    When I submit the activation request
    Then the activation should be successful
    And I should be able to query the activation status and find the record

  Scenario: Failed SIM card activation
    Given I have an invalid ICCID "8944500102198304826"
    When I submit the activation request
    Then the activation should fail
    And I should not find any activation record in the database
