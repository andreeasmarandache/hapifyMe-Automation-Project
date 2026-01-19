package com.hapifyme.ui.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.hapifyme.pages.HomePage;

public class SearchSteps {
    private String searchedProfile;

    HomePage homePage = new HomePage();

    @When("the user searches for a profile named {string}")
    public void the_user_searches_for_a_profile_named(String profileName) {
        searchedProfile = profileName;
        homePage.enterSearch(profileName);
    }

    @And("the user clicks on the search button")
    public void the_user_clicks_on_the_search_button() {
        homePage.clickSearchButton();
    }

    @Then("the user profile is displayed")
    public void the_user_profile_is_displayed() {
        homePage.verifySearchResult(searchedProfile);
    }
}
