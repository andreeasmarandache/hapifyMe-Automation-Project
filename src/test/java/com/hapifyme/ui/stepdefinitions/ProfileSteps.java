package com.hapifyme.ui.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.hapifyme.pages.HomePage;
import com.hapifyme.pages.ProfilePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfileSteps {

    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();

    @When("the user clicks on the settings button")
    public void user_clicks_settings_button() {
        homePage.clickSettingsButton();
    }

    @And("the user updates the profile details:")
    public void user_updates_profile_details(DataTable dataTable) {
        profilePage.updateProfileDetails(dataTable.asMaps(String.class, String.class));
    }

    @And("the user clicks on the update details button")
    public void user_clicks_update_details_button() {
        profilePage.clickUpdateDetailsButton();
    }

    @Then("the user should see the message {string}")
    public void user_gets_message_for_updated_profile(String expectedMessage) {
        $("body").shouldHave(text(expectedMessage));
    }

}
