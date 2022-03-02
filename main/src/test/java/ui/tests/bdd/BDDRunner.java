package ui.tests.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/steps", glue = "ui")

public class BDDRunner extends AbstractTestNGCucumberTests {

}
 