package ui.tests.login;

import org.testng.annotations.Test;
import ui.objects.Pages;

import static api.login.AccountApi.user;
import static ui.pages.extra.Home.clickSignUpLogin;
import static ui.pages.extra.Home.navigateHome;
import static ui.pages.login.Login.*;
import static ui.pages.login.Signup.registerWithValidCredentials;

public class Signup {

    @Test(groups = {"API to UI"}, priority = 1)
    public void test_Login_user_with_valid_credentials_after_api_user_registration() {
        navigateHome();
        clickSignUpLogin();
        typeLoginEmail(user.getEmail());
        typeLoginPassword(user.getPassword());
        clickOnLogin();
        verifyUserName(user.getUserName());
    }

    @Test(groups = {"Signup"})
    public void test_Register_user_with_valid_credentials() {
        registerWithValidCredentials(Pages.user);
    }

}
