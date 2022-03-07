package ui.tests.login;

import org.testng.annotations.Test;
import ui.objects.Pages;
import ui.pages.cart.Cart;

import static api.login.AccountApi.user;
import static ui.pages.login.Login.loginValidCredentials;
import static ui.pages.login.Login.verifyNavigationSingupLoginToCart;

public class LoginTest {

    @Test(groups = {"API to UI"}, priority = 1)
    public void test_Login_user_with_valid_credentials_after_api_user_registration() {
        loginValidCredentials(user);
    }

    @Test(groups = {"Login"}, priority = 1)
    public void test_Login_user_with_valid_credentials() {
        loginValidCredentials(Pages.user);
    }

    @Test(groups = {"Login"}, priority = 2)
    public void test_Rerun_Product_Listing_test() {
        verifyNavigationSingupLoginToCart();
    }

}
