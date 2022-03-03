package ui.tests.bdd.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ui.pages.login.Signup;

import static ui.tests.bdd.login.Users_initialisation.user;

public class Register_user_with_existing_email {

    @And("User enter exist username")
    public void userEnterExistUserName() {
        Signup.typeUserName(user.getUserName());
    }

    @And("User enter exist email")
    public void userEnterExistEmail() {
        Signup.typeEmailAddress(user.getEmail());
    }

    @Then("User should see Error message")
    public void userShouldSeeErrorMessage() {
        Signup.verifyErrorMessage();
    }
}
