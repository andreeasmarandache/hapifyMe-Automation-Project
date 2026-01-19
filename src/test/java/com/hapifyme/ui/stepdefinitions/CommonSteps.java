package com.hapifyme.ui.stepdefinitions;

import io.cucumber.java.en.Given;
import com.hapifyme.pages.LoginPage;

public class CommonSteps {

    LoginPage loginPage = new LoginPage();

    @Given("the user is logged into the application")
    public void perform_background_login() {
        System.out.println("--- Background: Automatic Login is running ---");

        loginPage.openPage();

        loginPage.login("andreea.cristina86@yahoo.com", "QAtest4#");

        System.out.println("--- Background: Login complete. Post test begins. ---");
    }
}
