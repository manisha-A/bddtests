package com.wimdu.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.yecht.Data;

/**
 * Created by manisha on 17/05/15.
 */
public class LoginPage extends PageObject {
    private static String ERRORMESSAGE = "Invalid email or password.";
    private static String LOGINTEXT = "LOG IN";
    private static String LOGGEDINTEXT = "Signed in successfully.";
    private static String SERVER_URL ="https://qa:testing@barcelona.staging.wimdu.com";
    private static String LOGIN_URL = "https://barcelona.staging.wimdu.com/users/login";

    @FindBy(id="user_email")
    private WebElementFacade userEmail;

    @FindBy(id="user_password")
    private WebElementFacade userPassword;

    @FindBy(className="btn--primary")
    private WebElementFacade logIn;

    @FindBy(className="panel__header")
    private WebElementFacade registrationPage;

    @FindBy(className="inputs__row-error")
    private WebElementFacade errorMessage;

    @FindBy(id="navbar-sign-in-link")
    private WebElementFacade navigationBarLogin;

    @FindBy(className="dashboard")
    private WebElementFacade userDashboard;

    @FindBy(css = ".flash-message")
    private WebElementFacade flashMessage;

    public void go_to_login(){
//        waitForRenderedElementsToBePresent(By.id("navbar"));
//        navigationBarLogin.click();
        getDriver().get(LOGIN_URL);
    }

    public void enter_user(String user,String password){
        userEmail.clear();
        userEmail.sendKeys(user);
        userPassword.clear();
        userPassword.sendKeys(password);
    }

    public void login_user(){
        logIn.click();
    }

    public void is_on_login_page(){
        assert registrationPage.containsText(LOGINTEXT);
    }

    public void validate_error(){
        assert errorMessage.containsText(ERRORMESSAGE);
    }

    public void server_login(){
        getDriver().get(SERVER_URL);
        getDriver().manage().window().maximize();
    }

    public void is_on_dashboard(){
        assert userDashboard.isDisplayed();
        assert userDashboard.isEnabled();
    }

    public void is_logged_in(){
        assert flashMessage.containsText(LOGGEDINTEXT);
    }
}
