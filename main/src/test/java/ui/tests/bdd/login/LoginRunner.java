package ui.tests.bdd.login;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@login", features = "src/test/resources/steps", monochrome = true, glue = "ui")

public class LoginRunner extends AbstractTestNGCucumberTests {

}
 