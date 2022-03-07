package ui.tests.cart;

import org.testng.annotations.*;
import ui.pages.extra.Brands;
import ui.pages.extra.Home;
import ui.pages.product.ProductDetails;
import ui.pages.cart.Cart;


public class UpdateCart {

    @Test(groups = "UpdateCart", priority = 1)
    public void addToCart() {
        Home.navigateHome();
        Home.verifyHomeTitle();
        ProductDetails.clickProductsButton();
        // Adding BlueTop to cart
        Cart.clickAddProduct1();
        Cart.clickContinueShopping();
        // Adding Men Tshirt to cart
        Cart.clickAddProduct2();
        Cart.clickViewCart();
        // Verifying there are two products
        Cart.verifyNumProducts(2);
        Cart.verifyProducts();
    }

    @Test(groups = "UpdateCart", priority = 2)
    public void removeFromCart() {
        Home.navigateHome();
        Home.verifyHomeTitle();
        // Adding Blue Top product to cart
        Cart.clickAddProduct1();
        Cart.clickContinueShopping();
        Cart.clickCartButton();
        Cart.verifyCartPage();
        Cart.removeProduct();
        Cart.verifyProductRemoval();
    }

    @Test(groups = "UpdateCart", priority = 3)
    public void addToCartFromRecommended() {
        Home.navigateHome();
        Home.verifyHomeTitle();
        Cart.scrollToRecommendations();
        Cart.verifyRecommendations();
        // Adding Blue Top product to cart
        Cart.clickAddProduct1();
        Cart.clickViewCart();
        Cart.verifyCartPage();
        // Verifying there is only blue top in cart
        Cart.verifyNumProducts(1);
    }

    @Test(groups = "UpdateCart", priority = 4)
    public void viewAndCartBrandProducts() {
        Home.navigateHome();
        Home.verifyHomeTitle();
        ProductDetails.clickProductsButton();
        // Verify that Brands list are visible on left sidebar
        Brands.verifyBrandsList();
        // Click Polo Brand
        Brands.clickPOLOBrandLink();
        // Verify that user is navigated to POLO brand page and brand products are displayed
        Brands.verifyPOLOBrandPage();
        Brands.verifyBrandProducts(6);
        // On left sidebar, click on H&M brand link
        Brands.clickHMBrandLink();
        // Verify that user is navigated to H&M brand page and brand products are displayed
        Brands.verifyHMBrandPage();
        Brands.verifyBrandProducts(5);
        // Add product from brands page
        ProductDetails.clickFirstProductButton();
        Cart.clickAddToCart();
        // Verify product is in cart
        Cart.clickViewCart();
        Cart.verifyCartPage();
        Cart.verifyNumProducts(1);
    }

}
