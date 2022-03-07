package ui.pages.product;

import org.openqa.selenium.By;
import org.testng.Assert;

import static ui.objects.Pages.*;
import static ui.pages.cart.Cart.verifyCartTitle;
import static ui.pages.extra.Home.clickProducts;
import static ui.pages.extra.Home.navigateHome;

public class ProductListing {

   public static final String PRODUCTS_HOVER_LIST = "//div[@class='features_items']//ancestor::div[@class='col-sm-4']//a[@class='btn btn-default add-to-cart']";
   public static final String PRODUCTS_CLICK_LIST = "//div[@class='features_items']//ancestor::div[@class='col-sm-4']//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']";
   public static final String VIEW_CART = "//p[@class='text-center']//ancestor::a[@href='/view_cart']";
   public static final String CONTINUE_SHOPPING = "//button[@class='btn btn-success close-modal btn-block']";
   public static final String PRODUCT_ADDED_DIALOG = "//div[@class='modal-content']";

    public static void verifyProductsTitle() {
        Assert.assertTrue(title().contains("All Products"));
    }

    public static void addProductToCart() {
        hover(listElement(By.xpath(PRODUCTS_HOVER_LIST), 1));
        click(listElement(By.xpath(PRODUCTS_CLICK_LIST), 1));
    }

    public static void verifyProductAddedDialogVisible() {
        Assert.assertTrue(isElementPresent(By.xpath(PRODUCT_ADDED_DIALOG)));
    }

    public static void verifyProductAddedDialogGone() {
        Assert.assertFalse(isElementPresent(By.xpath(PRODUCT_ADDED_DIALOG)));
    }

    public static void clickContinueShopping() {
        click(By.xpath(CONTINUE_SHOPPING));
    }

    public static void clickViewCart() {
        click(By.xpath(VIEW_CART));
    }

    public static void verifyUserNavigateToProducts() {
        navigateHome();
        clickProducts();
        verifyProductsTitle();
    }

    public static void verifyContinueDialog() {
        clickContinueShopping();
        verifyProductAddedDialogGone();
    }

    public static void verifyViewCartDialog() {
        addProductToCart();
        clickViewCart();
        verifyCartTitle();
    }

}
