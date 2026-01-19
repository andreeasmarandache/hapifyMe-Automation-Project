package com.hapifyme.ui.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.hapifyme.pages.LoginPage;
import com.hapifyme.utils.TestData;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static org.junit.Assert.assertTrue;


public class RegisterSteps {

    LoginPage loginPage = new LoginPage();


    @And("the user clicks on the register link")
    public void user_clicks_on_register_link(){
        loginPage.navigateToRegister();
    }

    @When("the user enters first name {string}")
    public void user_enters_first_name_to_reg(String value){
        if (value.equalsIgnoreCase("random name")) {
            loginPage.enterFirstName(TestData.randomNames());
        } else {
            loginPage.enterFirstName(value);
        }
    }

    @And("the user enters last name {string}")
    public void user_enters_last_name_to_reg(String value){
        if (value.equalsIgnoreCase("random name")) {
            loginPage.enterLastName(TestData.randomNames());
        } else {
            loginPage.enterLastName(value);
        }
    }


    @And("the user enters email {string}")
    public void user_enters_email_to_reg(String value) {
        if (value.equalsIgnoreCase("random email")) {
            loginPage.enterEmailForReg(TestData.randomEmail());
        } else {
            loginPage.enterEmailForReg(value);
        }
    }

    @And("the user enters password {string}")
    public void user_enters_password_to_reg(String value) {
        if (value.equalsIgnoreCase("random password")) {
            loginPage.enterPasswordForReg(TestData.randomPassword());
        } else {
            loginPage.enterPasswordForReg(value);
        }
    }

    @And("the user presses the register button")
    public void user_clicks_register() {
        loginPage.clickRegisterButton();
    }

    @Then("the user should see a success message {string}")
    public void use_should_see_success_message(String expectedMessage) {
        loginPage.verifySuccessMessage(expectedMessage);
    }

    @Then("the required field should show the browser validation message {string}")
    public void required_field_shows_validation(String ignored){
        String actualMessage = executeJavaScript(
                "return arguments[0].validationMessage;",
                loginPage.getFirstInvalidField()
        );

        assertTrue("Expected browser validation message, but got none!",
                actualMessage != null && !actualMessage.isEmpty());
    }
}
