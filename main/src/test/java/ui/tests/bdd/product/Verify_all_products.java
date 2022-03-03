package ui.tests.bdd.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ui.pages.product.ProductDetails;
import ui.pages.extra.Home;

public class Verify_all_products {
    @Given("Navigate to home page")
    public void navigate_to_home_page() {
        Home.navigateHome();
    }

    @When("Click on products button")
    public void click_on_products_button() {
        ProductDetails.clickProductsButton();
    }

    @Then("Verify ALL Products page")
    public void verify_all_products_page() {
        // Write code here that turns the phrase above into concrete actions
        ProductDetails.verifyAllProductsTitle();
    }
}
