package ui.tests.bdd.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ui.pages.login.Login;

public class Login_user_with_invalid_credentials {

    @And("User enter invalid Email {string}")
    public void userEnterInvalidEmail(String arg0) {
        Login.typeLoginEmail(arg0);
    }

    @And("User enter invalid Password {string}")
    public void userEnterPassword(String arg0) {
        Login.typeLoginPassword(arg0);
    }

    @Then("I should see on Error message")
    public void iShouldSeeOnErrorMessage() {
        Login.verifyErrorMessage();
    }

}
