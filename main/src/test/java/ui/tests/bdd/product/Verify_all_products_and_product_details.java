package ui.tests.bdd.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import ui.pages.product.ProductDetails;

public class Verify_all_products_and_product_details {
    @When("Click on View Product of first product")
    public void click_on_view_product_of_first_product() {
        ProductDetails.clickFirstProductButton();
    }
    @And("Verify user is landed to product detail page")
    public void verify_user_is_landed_to_product_detail_page() {
        ProductDetails.verifyProductDetailPage();
    }
    @And("Verify product name is visible")
    public void verify_product_name_is_visible() {
        ProductDetails.productNameIsVisible();
    }
    @And("Verify category is visible")
    public void verify_category_is_visible() {
        ProductDetails.productCategoryIsVisible();
    }
    @And("Verify price is visible")
    public void verify_price_is_visible() {
        ProductDetails.productPriceIsVisible();
    }
    @And("Verify product availability is visible")
    public void verify_product_availability_is_visible() {
        ProductDetails.productAvailabilityIsVisible();
    }
    @And("Verify condition is visible")
    public void verify_condition_is_visible() {
        ProductDetails.productConditionIsVisible();
    }
    @And("Verify brand is visible")
    public void verify_brand_is_visible() {
        ProductDetails.productBrandIsVisible();
    }

}
