package com.hapifyme.ui.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.hapifyme.pages.HomePage;

public class PostSteps {

    @When("the user enters a postBody {string}")
    public void user_enters_post_body(String postBody) {
        homePage.enterPost(postBody);
    }

    @And("the user clicks on the post button")
    public void user_clicks_post_button() {
        homePage.clickPostButton();
    }

    @Then("the first post shows Just now")
    public void first_post_just_now() {
        homePage.verifyFirstPostJustNow();
    }

    @Then("the first post shows the correct body {string}")
    public void first_post_has_body(String body) {
        homePage.verifyFirstPostBody(body);
    }

    HomePage homePage = new HomePage();
}
