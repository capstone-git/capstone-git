package ui.tests.cart;

import org.testng.annotations.Test;
import ui.objects.Pages;

import static ui.pages.cart.Cart.*;
import static ui.pages.login.Login.loginValidCredentials;
import static ui.pages.login.Signup.registerWithValidCredentials;


public class CartTest {

    @Test(groups = {"Cart"}, priority = 1)
    public void test_verify_Products_in_cart() {
        verifyProductsInCartVisibility();
    }

    @Test(groups = {"Cart"}, priority = 2)
    public void test_verify_Checkout_Dialog_for_unregister_user() {
        clickProceedToCheckout();
        verifyCheckoutDialogVisibility();
    }

    @Test(groups = {"Cart"}, priority = 3)
    public void test_verify_user_Continue_On_Cart() {
        clickContinueOnCart();
        verifyCheckoutDialogGone();
    }

    @Test(groups = {"Cart"}, priority = 4)
    public void test_verify_checkout_dialog_navigation_To_Register_Or_Login() {
        clickRegisterOrLogin();
    }

    @Test(groups = {"CartSignup"}, dependsOnMethods = "test_verify_checkout_dialog_navigation_To_Register_Or_Login")
    public void test_verify_user_Register_In_Checkout() {
        registerWithValidCredentials(Pages.user);
    }

    @Test(groups = {"CartLogin"}, dependsOnMethods = "test_verify_checkout_dialog_navigation_To_Register_Or_Login")
    public void test_verify_user_Login_In_Checkout() {
        loginValidCredentials(Pages.user);
    }

    @Test(groups = {"Cart"}, priority = 5)
    public void test_verify_checkout_dialog_navigation_Account_To_Cart() {
        clickCart();
    }

    @Test(groups = {"Cart"}, priority = 6)
    public void test_verify_checkout_dialog_navigation_Cart_To_Checkout() {
        clickProceedToCheckout();
    }

}
