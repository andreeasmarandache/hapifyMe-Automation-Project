package com.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private By logEmailInput = By.name("log_email");
    private By logPasswordInput = By.name("log_password");
    private By loginButton = By.name("login_button");
    private By errorMessage = By.cssSelector("body");
    private By registerLink = By.id("signup");
    private By fNameInput = By.name("reg_fname");
    private By lNameInput = By.name("reg_lname");
    private By regEmailInput = By.name("reg_email");
    private By regConfirmEmailInput = By.name("reg_email2");
    private By regPasswordInput = By.name("reg_password");
    private By regConfirmPasswordInput = By.name("reg_password2");
    private By registerButton = By.name("register_button");
    private By successMessage = By.className("success-message");


    public void openPage() {
        open("/login_register.php");
    }

    public void login(String email, String password) {
        enterEmailForLogin(email);
        enterPasswordForLogin(password);
        clickLogin();
    }

    public void enterEmailForLogin(String email) {
        $(logEmailInput).setValue(email);
    }

    public void enterPasswordForLogin(String password) {
        $(logPasswordInput).setValue(password);
    }

    public void clickLogin() {
        $(loginButton).click();
    }

    public void verifyErrorMessage (String expectedError) {
        $(errorMessage).shouldHave(text(expectedError));
    }

    public void navigateToRegister() {
        $(registerLink).click();
    }

    public void enterFirstName(String fName) {
        $(fNameInput).setValue(fName);
    }

    public void enterLastName(String lName) {
        $(lNameInput).setValue(lName);
    }

    public void enterEmailForReg(String email) {
        $(regEmailInput).setValue(email);
        $(regConfirmEmailInput).setValue(email);
    }

    public void enterPasswordForReg(String password) {
        $(regPasswordInput).setValue(password);
        $(regConfirmPasswordInput).setValue(password);
    }

    public void clickRegisterButton() {
        $(registerButton).click();
    }

    public void verifySuccessMessage (String expectedMessage) {
        $(successMessage).shouldHave(text(expectedMessage));
    }

    public SelenideElement getFirstInvalidField() {
        return $("input:invalid");
    }



}
