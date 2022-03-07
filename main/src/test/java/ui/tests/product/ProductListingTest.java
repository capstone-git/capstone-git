package ui.tests.product;

import org.testng.annotations.Test;
import ui.pages.product.ViewProduct;

import static ui.pages.product.ProductListing.*;

public class ProductListingTest {

    @Test(description = "This method verifies that homepage loads", priority = 1)
    public void homePageLoads() {
        ViewProduct.verifyProductTitle();
    }

    @Test(groups = {"Products"}, priority = 1)
    public void test_verify_user_navigate_Home_to_Products_page() {
        verifyUserNavigateToProducts();
    }

    @Test(groups = {"Products"}, priority = 2)
    public void test_verify_user_Add_to_Cart_product() {
        addProductToCart();
    }

    @Test(groups = {"Products"}, priority = 3)
    public void test_verify_Continue_shopping_for_product_added_dialog() {
        verifyContinueDialog();
    }

    @Test(groups = {"Products"}, priority = 4)
    public void test_verify_View_Cart_for_product_added_dialog() {
        verifyViewCartDialog();
    }

}
