Feature: SignUp
  In order to use the website
  As a new user
  I want to sign up

  Scenario: Sign up as a new user without providing mandatory fields
    Given I am on registration page
    And I register
    Then I should be on registration page
    And I should see mandatory field error message

  Scenario: Sign up as a new user with facebook
    Given I am on registration page
    When I try to sign up with facebook
    Then I should be on facebook login page

  Scenario Outline: Sign up as a new user without providing mandatory fields
    Given I am on registration page
    And I enter "<firstname>","<lastname>","<email>","<password>"
    And I register
    Then I should be on registration page
    And I should see valid error "<message>"

  Examples:
    | firstname | lastname | email         | password | message                               |
    | test      | test     | test          | test12   | Please enter a valid email address    |
    | test      | test     | test@.com     | test12   | Please enter a valid email address    |
    | test      | test     | test.com      | test12   | Please enter a valid email address    |
    | test      | test     | test@test.com | test2    | too short (no less than 6 characters) |



