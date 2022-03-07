package ui.tests.bdd.product;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@product", features = "src/test/resources/steps", glue = "ui")

public class ProductRunner extends AbstractTestNGCucumberTests {

}