package ui.tests.bdd.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ui.pages.product.ProductCategories;

public class View_product_categories {
    @And("Verify that categories are visible on left side bar")
    public void verify_that_categories_are_visible_on_left_side_bar() {
        ProductCategories.verifyCategorySideBar();
    }
    @When("Click on Women category")
    public void click_on_women_category() {
        ProductCategories.clickWomenCategory();
    }
    @And("Click on category link under Women category, ex: Dress")
    public void click_on_category_link_under_women_category_ex_dress() {
        ProductCategories.clickDressLink();
    }
    @Then("Verify that category page is displayed and confirm text WOMEN-DRESS PRODUCTS")
    public void verify_that_category_page_is_displayed_and_confirm_text_women_tops_products() {
        ProductCategories.verifyWomenCategoryPage();
    }
    @When("Click on any sub-category ex: link of Men jean category")
    public void click_on_any_sub_category_link_of_men_category() {
        ProductCategories.clickMenSubCategory();
    }
    @Then("Verify that user is navigated to that category page ex: Men jean category page")
    public void verify_that_user_is_navigated_to_that_category_page() {
        ProductCategories.verifyMenCategoryPage();
    }
}
