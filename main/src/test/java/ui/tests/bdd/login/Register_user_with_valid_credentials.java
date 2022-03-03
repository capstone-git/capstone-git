package ui.tests.bdd.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.extra.Home;
import ui.pages.login.Signup;

import static ui.tests.bdd.login.Users_initialisation.user;

public class Register_user_with_valid_credentials {

    @And("User is on Home page")
    public void userIsOnHomePage() {
        Home.navigateHome();
    }

    @And("User click SignupLogin")
    public void clickSignup() {
        Home.clickSignUpLogin();
    }

    @And("User enter username")
    public void userEnterUsername() {
        Signup.typeUserName(user.getUserName());
    }

    @And("User enter email")
    public void userEnterEmail() {
        Signup.typeEmailAddress(user.getEmail());
    }

    @And("User click Signup")
    public void userClickSignup() {
        Signup.clickSignup();
    }

    @Given("User is on Account Information page")
    public void userIsOnAccountInformationPage() {
        Signup.verifyAccountVisibility();
    }

    @And("Select title")
    public void selectTitle() {
        Signup.selectTitle(user.getTitle());
    }

    @And("Enter password")
    public void enterPassword() {
        Signup.typePassword(user.getPassword());
    }

    @And("Select DoB")
    public void selectDoB() {
        Signup.selectDoB(user.getDob());
    }

    @And("Enter first name")
    public void enterFirstName() {
        Signup.typeFirstName(user.getFirstName());
    }

    @And("Enter last name")
    public void enterLastName() {
        Signup.typeLastName(user.getLastName());
    }

    @And("Enter company")
    public void enterCompany() {
        Signup.typeCompany(user.getCompany());
    }

    @And("Enter address")
    public void enterAddress() {
        Signup.typeAddress(user.getAddress());
    }

    @And("Select country")
    public void selectCountry() {
        Signup.selectCountry(user.getCountry());
    }

    @And("Select state")
    public void selectState() {
        Signup.selectState(user.getState());
    }

    @And("Enter city")
    public void enterCity() {
        Signup.typeCity(user.getCity());
    }

    @And("Enter zipcode")
    public void enterZipcode() {
        Signup.typeZip(user.getZip());
    }

    @And("Enter mobile")
    public void enterMobile() {
        Signup.typeMobile(user.getMobile());
    }

    @When("Click on Create Account button")
    public void clickOnCreateAccountButton() {
        Signup.clickCreateAccount();
    }

    @Then("User should be on Account page")
    public void iShouldBeOnAccountPage() {
        Signup.verifyAccountCreated();
    }
}
