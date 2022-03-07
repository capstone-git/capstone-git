package ui.tests.cart;

import org.testng.annotations.*;
import ui.objects.Pages;
import ui.pages.extra.Home;
import ui.pages.login.Login;
import ui.pages.product.ProductDetails;
import ui.pages.cart.Cart;
import ui.pages.product.SearchProduct;

public class VerifyCart {

    @Test(groups = "VerifyCart", priority = 1)
    public void verifyProductQuantity() {
        Home.navigateHome();
        Home.verifyHomeTitle();
        // Testing with first product
        ProductDetails.clickFirstProductHome();
        ProductDetails.verifyProductDetailPage();
        // Setting item quantity to 4
        Cart.setItemQuantity("4");
        Cart.clickAddToCart();
        Cart.clickViewCart();
        // Verifying item quantity is 4
        Cart.verifyCartWithQuantity("4");
    }

    @Test(groups = "VerifyCart", priority = 2)
    public void searchProductsAndVerifyCartAfterLogin() {
        Home.navigateHome();
        ProductDetails.clickProductsButton();
        ProductDetails.verifyAllProductsTitle();
        SearchProduct.enterProductName("Blue top");
        SearchProduct.clickSearchButton();
        SearchProduct.verifySearchProductsPage();
        SearchProduct.verifySearchProducts(1);
        Cart.addingAllProducts();
        Cart.clickCartButton();
        Cart.verifyNumProducts(1);
        // Click 'Signup / Login' button and submit login details
        Login.loginValidCredentialsCart(Pages.user);
        Cart.clickCartButton();
        // Verify that those products are visible in cart after login as well
        Cart.verifyNumProducts(1);
    }

}
