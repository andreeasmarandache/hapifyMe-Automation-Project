package com.hapifyme.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.hapifyme.utils.UiHelpers.waitForElementWithText;

public class HomePage {

    private By postArea = By.cssSelector(".posts_area");
    private By postInput = By.name("post_text");
    private By postButton = By.id("post_button");
    private By posts = By.cssSelector(".status_post");
    private By postBodyContent = By.cssSelector(".post_body_content");
    private By timestamp = By.cssSelector(".posted_by");
    private By settingsButton = By.xpath("//a[@href='settings.php']");
    private By searchInput = By.id("search_text_input");
    private By searchButton = By.cssSelector(".button_holder");
    private By searchResult = By.cssSelector(".search_result");

    public void verifyHomepage() {
        $(postArea).shouldBe(visible);
    }

    public void enterPost(String postBody) {
        $(postInput).setValue(postBody);
    }

    public void clickPostButton() {
        $(postButton).click();
    }

    public void verifyFirstPostJustNow() {
        waitForElementWithText($$(posts).first().$(timestamp), "Just now", 15);
    }

    public void verifyFirstPostBody(String expectedBody) {
        waitForElementWithText($$(posts).first().$(postBodyContent), expectedBody, 15);
    }

    public void clickSettingsButton() {
        $(settingsButton).click();
    }

    public void enterSearch(String searchBody) {
        $(searchInput).setValue(searchBody);
    }

    public void clickSearchButton() {
        $(searchButton).click();
    }

    public void verifySearchResult(String expectedBody) {
        $(searchResult).shouldHave(text(expectedBody));
    }

}
