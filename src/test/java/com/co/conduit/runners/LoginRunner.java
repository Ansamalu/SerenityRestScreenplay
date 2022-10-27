package com.co.conduit.runners;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.core.snippets.SnippetType.*;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/login.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue= "com.co.conduit.stepsdefinitions",
        dryRun = false)
public class LoginRunner {

}
