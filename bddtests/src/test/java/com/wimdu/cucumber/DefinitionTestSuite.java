package com.wimdu.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(format = "pretty",features="src/test/resources/features/Login.feature",tags = "~@wip")
public class DefinitionTestSuite {}
