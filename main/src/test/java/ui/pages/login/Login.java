package ui.pages.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import ui.pages.extra.Home;

import static ui.objects.Pages.*;
import static ui.tests.bdd.login.Users_initialisation.user;

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

    public static void verifyUserName() {
        Assert.assertTrue(text(By.xpath(Home.USER_NAME)).contains(user.getUserName()));
    }

    public static void verifyErrorMessage() {
        Assert.assertTrue(text(By.xpath(ERROR_MSG)).contains("Your email or password is incorrect!"));
    }

    public static void verifyTitle() {
        Assert.assertTrue(title().contains(TITLE));
    }

}
