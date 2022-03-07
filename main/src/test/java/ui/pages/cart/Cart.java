package ui.pages.cart;

import org.openqa.selenium.By;
import org.testng.Assert;
import ui.pages.extra.Home;

import static ui.objects.Pages.*;

public class Cart {

    private static final String CART = "//li[@class='active']";
    private static final String PRODUCTS_LIST = "//*[@id='cart_info_table']/tbody";
    private static final String CHECKOUT = "//a[@class='btn btn-default check_out']";
    private static final String CHECKOUT_MSG = "//div[@class='modal-body']/p[@class='text-center'][1]";
    private static final String REGISTER_LOGIN = "(//a[@href='/login'])[1]";
    private static final String CONTINUE_ON_CART = "//button[@class='btn btn-success close-checkout-modal btn-block']";

    public static void verifyCartTitle() {
        Assert.assertTrue(text(By.xpath(CART)).contains("Shopping Cart"));
    }

    public static void verifyProductsInCartVisibility() {
        Assert.assertTrue(list(By.xpath(PRODUCTS_LIST)).size() >= 1);
    }

    public static void clickProceedToCheckout() {
        click(By.xpath(CHECKOUT));
    }

    public static void verifyCheckoutDialogVisibility() {
        Assert.assertTrue(isElementPresent(By.xpath(CHECKOUT_MSG)));
    }

    public static void verifyCheckoutDialogGone() {
        Assert.assertFalse(isElementPresent(By.xpath(CHECKOUT_MSG)));
    }

    public static void clickRegisterOrLogin() {
        click(By.xpath(REGISTER_LOGIN));
    }

    public static void clickContinueOnCart() {
        click(By.xpath(CONTINUE_ON_CART));
    }

    public static void clickCart() {
        click(By.xpath(Home.CART));
    }

}
