package ui.pages.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import ui.objects.UserForm;
import ui.pages.extra.Home;

import static ui.objects.Pages.*;
import static ui.pages.extra.Home.clickSignUpLogin;

public class Login {

    public static String EMAIL = "//input[@name='email']";
    public static String PASSWORD = "//input[@name='password']";
    public static String LOGIN_BTN = "//button[@data-qa='login-button']";
    public static String ERROR_MSG = "//p[@style='color: red;']";
    public static String TITLE = "Automation Exercise - Signup / Login";

    public static void typeLoginEmail(String email) {
        type(By.xpath(EMAIL), email);
    }

    public static void typeLoginPassword(String password) {
        type(By.xpath(PASSWORD), password);
    }

    public static void clickOnLogin() {
        click(By.xpath(LOGIN_BTN));
    }

    public static void verifyUserName(String userName) {
        Assert.assertTrue(text(By.xpath(Home.USER_NAME)).contains(userName));
    }

    public static void verifyErrorMessage() {
        Assert.assertTrue(text(By.xpath(ERROR_MSG)).contains("Your email or password is incorrect!"));
    }

    public static void verifyTitle() {
        Assert.assertTrue(title().contains(TITLE));
    }

    public static void loginValidCredentialsCart(UserForm user) {
        Home.clickSignUpLogin();
        typeLoginEmail(user.getEmail());
        typeLoginPassword(user.getPassword());
        clickOnLogin();
	}
	
    public static void verifyNavigationSingupLoginToCart() {
        click(By.xpath(Home.CART));
    }

    public static void loginValidCredentials(UserForm user) {
        clickSignUpLogin();
        typeLoginEmail(user.getEmail());
        typeLoginPassword(user.getPassword());
        clickOnLogin();
        verifyUserName(user.getUserName());
    }

}
