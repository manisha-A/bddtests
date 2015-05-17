package com.wimdu.steps;

import com.wimdu.pages.DictionaryPage;
import com.wimdu.pages.LoginPage;
import com.wimdu.pages.SignupPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.jruby.ext.stringio.RubyStringIO$INVOKER$i$0$1$read_nonblock;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class EndUserSteps extends ScenarioSteps {

    LoginPage loginpage;
    SignupPage signuppage;

    @Step
    public void navigate_to_login(){
        loginpage.go_to_login();
    }

    @Step
    public void enter_user_details(String user,String password) {
        loginpage.enter_user(user, password);
    }

    @Step
    public void login(){
        loginpage.login_user();
    }

    @Step
    public void assert_is_on_login_page(){
        loginpage.is_on_login_page();
    }

    @Step
    public void assert_error_message(){
        loginpage.validate_error();
    }

    @Step
    public void server_login(){
        loginpage.server_login();
    }

    @Step
    public void navigate_to_signup(){
        signuppage.go_to_registration();
    }

    @Step
    public void sign_up(){signuppage.sign_up();}

    @Step
    public void assert_is_on_signup_page(){
        signuppage.assert_is_on_regiser_page();
    }

    @Step
    public void assert_required_field_error_message(){
        signuppage.assert_required_field_message();
    }

    @Step
    public void connect_with_facebook(){
        signuppage.connect_with_facebook();
    }

    @Step
    public void validate_facebook_login_page(){
        signuppage.is_on_facebook_login_page();
    }

    @Step
    public void assert_is_on_dashboard(){
        loginpage.is_on_dashboard();
    }

    @Step
    public void assert_logged_in(){
        loginpage.is_logged_in();
    }

    @Step
    public void enter_sign_up_details(String firstName,String lastName, String email, String password){
        signuppage.enter_sign_up_details(firstName, lastName, email, password);
    }

    @Step
    public void validate_error(String error){
        signuppage.validate_error_message(error);
    }
}