package com.nhs.project;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"com.nhs.project.stepdefinitions"},
        plugin = {"pretty", "html:target/Destination", "json:target/Destination/cucumber.json" },
        tags = {"@EndToEndJourney"}
)

public class TestRunner extends AbstractTestNGCucumberTests
{
}

