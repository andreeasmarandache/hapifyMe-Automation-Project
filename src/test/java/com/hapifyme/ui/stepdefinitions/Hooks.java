package com.hapifyme.ui.stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks {

    @Before
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://test.hapifyme.com";
        Configuration.timeout = 10000;
        Configuration.reportsFolder = "target/screenshots";

        System.out.println("--- Start Scenario ---");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_") + ".png";

            byte[] screenshotBytes = ((org.openqa.selenium.TakesScreenshot) getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshotBytes, "image/png", screenshotName);

            System.out.println("!!! Scenario Failed. Screenshot attached: " + screenshotName);
        }

        if (getWebDriver() != null) {
            getWebDriver().quit();
        }

        System.out.println("--- Stop Scenario ---");
    }
}
