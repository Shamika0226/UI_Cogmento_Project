package com.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:/Users/skiriwat/IdeaProjects/UICogmento/Feature",
        glue ={"com.Steps"},
        tags = "@TC5",
        plugin = {"pretty","junit:target/JUnitReports/report.xml","html:target/HtmlReports"},
        dryRun = false

)


public class TestRunner {



}
