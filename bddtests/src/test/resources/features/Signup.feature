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



