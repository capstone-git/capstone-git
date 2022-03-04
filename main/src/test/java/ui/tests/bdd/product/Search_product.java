package ui.tests.bdd.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ui.pages.product.SearchProduct;

public class Search_product {
    @When("Entered product name in search input")
    public void entered_product_name_in_search_input() {
        SearchProduct.enterProductName();
    }
    @And("Click search button")
    public void click_search_button() {
        SearchProduct.clickSearchButton();
    }
    @Then("Verify SEARCH PRODUCTS is visible")
    public void verify_search_products_is_visible() {
        SearchProduct.verifySearchProductsPage();
    }
    @And("Verify all products related to search are visible")
    public void verify_all_products_related_to_search_are_visible() {
        SearchProduct.verifySearchProducts();
    }
}
