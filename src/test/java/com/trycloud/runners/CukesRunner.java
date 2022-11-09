package com.trycloud.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
        "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.text"},
        features = "src/test/resources/features",
        glue = "com/trycloud/step_definitions",
        dryRun = false,
        tags ="@US10"

)
public class CukesRunner {


    



}
