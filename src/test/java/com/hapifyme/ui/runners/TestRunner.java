package com.hapifyme.ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.hapifyme.ui.stepdefinitions"},

        tags = "@smoke or @regression",

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "rerun:target/failed_scenarios.txt"
        },
        monochrome = true
)

public class TestRunner { }
