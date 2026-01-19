package com.hapifyme.ui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static com.codeborne.selenide.Selenide.open;
import com.hapifyme.pages.HomePage;
import com.hapifyme.pages.LoginPage;


public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("the user opens the login page {string}")
    public void user_opens_login_page(String url) {
        open(url);
    }

    @When("the user enters email {string} to login")
    public void user_enters_email_to_login(String email) {
        loginPage.enterEmailForLogin(email);
    }

    @And("the user enters password {string} to login")
    public void user_enters_password_to_login(String password) {
        loginPage.enterPasswordForLogin(password);
    }

    @And("the user presses the login button")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the homepage")
    public void user_should_be_redirected_to_homepage() {
        homePage.verifyHomepage();
    }

    @Then("the user should see an error message {string}")
    public void user_should_see_an_error_message(String expectedError) {
        loginPage.verifyErrorMessage(expectedError);
    }

}
