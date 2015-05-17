package com.wimdu.cucumber;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.wimdu.steps.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Before
    public void beforeEveryScenario(){
        endUser.server_login();
    }

    @Before
    public void afterEveryScenario(){
        endUser.getDriver().close();
    }

    //Login steps

    @Given("^I am on login page$")
    public void i_am_on_login_page() {
        endUser.navigate_to_login();
    }

    @Given("^I enter \"(.*?)\" and \"(.*?)\"$")
    public void i_enter_and(String username, String password) {
        endUser.enter_user_details(username, password);
    }

    @Given("^I log in$")
    public void i_log_in() {
        endUser.login();
    }

    @Then("^I should be on login page$")
    public void i_should_be_on_login_page() {
        endUser.assert_is_on_login_page();
    }

    @Then("^I should see valid error message$")
    public void i_should_see_valid_error_message() {
        endUser.assert_error_message();
    }

    @Then("^I should be on my dashboard$")
    public void i_should_see_dashboard() {
        endUser.assert_is_on_dashboard();
    }

    @And("^I should be logged in$")
    public void should_be_logged_in(){
        endUser.assert_logged_in();
    }

    //Registration steps

    @Given("^I am on registration page$")
    public void i_am_on_registration_page() {
        endUser.navigate_to_signup();
    }

    @Given("^I register$")
    public void i_register() {
        endUser.sign_up();
    }

    @Then("^I should be on registration page$")
    public void i_should_be_on_registration_page() {
        endUser.assert_is_on_signup_page();
    }

    @Then("^I should see mandatory field error message$")
    public void i_should_see_mandatory_field_error_message() {
        endUser.assert_required_field_error_message();
    }

    @When("^I try to sign up with facebook$")
    public void i_try_to_sign_up_with_facebook() {
        endUser.connect_with_facebook();
    }

    @Then("^I should be on facebook login page$")
    public void i_should_be_on_facebook_login_page() {
        endUser.validate_facebook_login_page();
    }

    @Given("^I enter \"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"$")
    public void i_enter(String firstname, String lastname, String email, String password) {
        endUser.enter_sign_up_details(firstname,lastname,email,password);
    }

    @Then("^I should see valid error \"(.*?)\"$")
    public void i_should_see_valid_error(String errormessage) {
        endUser.validate_error(errormessage);
    }
}
