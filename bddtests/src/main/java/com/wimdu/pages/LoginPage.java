package com.wimdu.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.UserAndPassword;
import org.yecht.Data;

/**
 * Created by manisha on 17/05/15.
 */
public class LoginPage extends PageObject {
    private static String ERRORMESSAGE = "Invalid email or password.";
    private static String LOGINTEXT = "LOG IN";
    private static String LOGGEDINTEXT = "Signed in successfully.";

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
        getDriver().manage().window().maximize();
        waitForRenderedElementsToBePresent(By.id("navbar"));
        navigationBarLogin.click();
//        getDriver().get("https://barcelona.staging.wimdu.com/users/login");
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
        WebElement invalidInput = getDriver().findElement(By.cssSelector("input:invalid"));
        System.out.println("***********");
        System.out.println(invalidInput.getText().toString());
        System.out.println("***********");
        assert errorMessage.containsText(ERRORMESSAGE);
    }

    public void server_login(){
        getDriver().get("https://qa:testing@barcelona.staging.wimdu.com");
    }

    public void is_on_dashboard(){
        assert userDashboard.isDisplayed();
        assert userDashboard.isEnabled();
    }

    public void is_logged_in(){
        assert flashMessage.containsText(LOGGEDINTEXT);
    }
}
