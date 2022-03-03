package ui.tests.bdd.login;

import io.cucumber.java.en.Given;
import ui.objects.UserForm;


public class Users_initialisation {

    public static UserForm user;

    private static int INCREMENT = 0;

    @Given("User data initialised")
    public void userDataInitialised() {
        if (INCREMENT == 3) INCREMENT = 0;

        user = new UserForm(++INCREMENT);
    }
}
