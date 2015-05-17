Feature: Login as an existing user
  In order to use the website
  As an existing user
  I want to login to the system

  Scenario Outline: Login as an existing user with incorrect details
    Given I am on login page
    And I enter "<username>" and "<password>"
    When I log in
    Then I should be on login page
    And I should see valid error message
  Examples:
    | username    | password |
    | abc@abc.com | 123      |

  Scenario Outline: Login as an existing user with correct details
    Given I am on login page
    And I enter "<username>" and "<password>"
    When I log in
    Then I should be logged in
    And I should be on my dashboard

  Examples:
    | username       | password |
    | test@wimdu.com | testing  |

  Scenario: Login with facebook
    Given I am on login page
    When I try to login with facebook
    Then I should be on facebook login page