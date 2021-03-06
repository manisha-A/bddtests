package com.wimdu.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Set;


/**
 * Created by manisha on 17/05/15.
 */
public class SignupPage extends PageObject {

    private static String SIGNUPTEXT = "SIGN UP FOR FREE";
    private static String MANDATORYFIELDERROR ="Please fill in";
    private static String REGISTRATION_URL="https://barcelona.staging.wimdu.com/users/register/sign_up";

    @FindBy(id="user_firstname")
    private WebElementFacade userFirstName;

    @FindBy(id="user_lastname")
    private WebElementFacade userLastName;

    @FindBy(id="user_email")
    private WebElementFacade userEmail;

    @FindBy(id="user_password")
    private WebElementFacade userPassword;

    @FindBy(className="btn--primary")
    private WebElementFacade register;

    @FindBy(className="btn--facebook")
    private WebElementFacade registerWithFacebook;

    @FindBy(className="panel__header")
    private WebElementFacade registrationPage;

    @FindBy(className="inputs__row-error")
    private WebElementFacade inputFieldError;

    @FindBy(className="fb_content")
    private WebElementFacade facebookLoginPage;

    public void go_to_registration(){
        getDriver().manage().window().maximize();
        getDriver().get(REGISTRATION_URL);
    }

    public void sign_up(){
        register.click();
    }

    public void assert_is_on_regiser_page(){
        assert registrationPage.getText().contains(SIGNUPTEXT);
    }

    public void assert_required_field_message(){
        assert inputFieldError.getText().contains(MANDATORYFIELDERROR);
    }

    public void connect_with_facebook(){
        assert registerWithFacebook.isDisplayed();
        assert registerWithFacebook.isEnabled();
        registerWithFacebook.click();

        // switch to facebook handle
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
    }

    public void is_on_facebook_login_page(){
        // validate facebook window
        assert facebookLoginPage.isDisplayed();
        assert facebookLoginPage.isEnabled();

        // close facebook window
        getDriver().close();
    }

    public void enter_sign_up_details(String firstName,String lastName, String email, String password){
        userFirstName.sendKeys(firstName);
        userLastName.sendKeys(lastName);
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
    }

    public void validate_error_message(String error){
        assert inputFieldError.isDisplayed();
        assert inputFieldError.getText().contains(error);
    }

    public void enter_sign_up_with_valid_details(String firstName,String lastName, String email, String password){
        String newemail = RandomStringUtils.randomAlphabetic(3).concat(email);
        userFirstName.sendKeys(firstName);
        userLastName.sendKeys(lastName);
        userEmail.sendKeys(newemail);
        userPassword.sendKeys(password);
    }
}
