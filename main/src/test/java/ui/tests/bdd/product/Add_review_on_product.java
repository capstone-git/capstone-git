package ui.tests.bdd.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ui.pages.product.ProductReview;

public class Add_review_on_product {
    @Then("Verify Write Your Review is visible")
    public void verify_write_your_review_is_visible() {
        ProductReview.verifyWriteReview();
    }
    @When("Entered name")
    public void entered_name() {
        ProductReview.enterName();
    }
    @And("Entered email")
    public void entered_email() {
        ProductReview.enterEmail();
    }
    @And("Entered review")
    public void entered_review() {
        ProductReview.enterReview();
    }
    @Then("Click on Submit button")
    public void click_on_submit_button() {
        ProductReview.clickSubmit();
    }
    @And("Verify success message : Thank you for your review")
    public void verify_success_message_thank_you_for_your_review() {
        ProductReview.verifyReview();
    }

}
