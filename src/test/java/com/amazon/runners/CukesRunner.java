package com.amazon.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com/amazon/step_defs",
    plugin = {"json:target/cucumber.json",
            "html:target/default-html-reports"},
    tags = "@regression",
    dryRun = false
)

public class CukesRunner {
}
