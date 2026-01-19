package com.hapifyme.utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import java.time.Duration;

public class UiHelpers {

    public static void waitForElementWithText(SelenideElement element, String expectedText, long seconds) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(seconds))
                .shouldHave(Condition.text(expectedText), Duration.ofSeconds(seconds));
    }
}

