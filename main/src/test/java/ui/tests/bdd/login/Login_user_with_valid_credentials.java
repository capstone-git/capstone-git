package ui.tests.bdd.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.login.Login;

import static ui.tests.bdd.login.Users_initialisation.user;


public class Login_user_with_valid_credentials {

    @And("User enter valid email")
    public void userEnterValidEmail() {
        Login.typeLoginEmail(user.getEmail());
    }

    @And("User enter valid password")
    public void userEnterValidPassword() {
        Login.typeLoginPassword(user.getPassword());
    }

    @When("User click Login")
    public void userClickLogin() {
        Login.clickOnLogin();
    }

    @Then("User should see valid user name")
    public void iShouldSeeValidUserName() {
        Login.verifyUserName(user.getUserName());
    }

}
