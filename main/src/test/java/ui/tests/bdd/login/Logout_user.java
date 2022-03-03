package ui.tests.bdd.login;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.extra.Home;
import ui.pages.login.Login;

public class Logout_user {

    @When("User click Logout")
    public void userClickLogout() {
        Home.clickLogout();
    }

    @Then("User should be on Login page")
    public void userShouldBeOnLoginPage() {
        Login.verifyTitle();
    }
}
