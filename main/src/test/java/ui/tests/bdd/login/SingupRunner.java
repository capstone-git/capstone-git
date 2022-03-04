package ui.tests.bdd.login;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@singup", features = "src/test/resources/steps", glue = "ui")

public class SingupRunner extends AbstractTestNGCucumberTests {

}
