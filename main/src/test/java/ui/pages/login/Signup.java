package ui.pages.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import ui.pages.extra.Home;

import static ui.objects.Pages.*;
import static ui.tests.bdd.login.Users_initialisation.user;


public class Signup {

    public static String NAME = "//input[@data-qa=\"signup-name\"]";
    public static String FIRST_NAME = "//input[@id='first_name']";
    public static String LAST_NAME = "//input[@id='last_name']";
    public static String COMPANY = "//input[@id='company']";
    public static String USER_FORM = "//input[@id='name']";
    public static String EMAIL = "//input[@data-qa='signup-email']";
    public static String EMAIL_FORM = "//input[@id='email']";
    public static String SIGN_UP = "//button[@data-qa=\"signup-button\"]";
    public static String PASSWORD = "//input[@id='password']";
    public static String ACCOUNT_INFO = "(//h2[@class='title text-center'])[1]";
    public static String MR = "//input[@id='id_gender1']";
    public static String MRS = "//input[@id='id_gender2']";
    public static String SELECT_D = "//select[@id=\"days\"]";
    public static String SELECT_MM = "//select[@id=\"months\"]";
    public static String SELECT_YYYY = "//select[@id=\"years\"]";
    public static String ADDRESS1 = "//input[@id='address1']";
    public static String SELECT_CTRY = "//select[@id='country']";
    public static String STATE = "//input[@id='state']";
    public static String CITY = "//input[@id='city']";
    public static String ZIP = "//input[@id='zipcode']";
    public static String MOBILE = "//input[@id='mobile_number']";
    public static String CREATE_ACC = "//button[@data-qa='create-account']";
    public static String ACC_CREATED = "//h2[@data-qa='account-created']";
    public static String ERROR_MSG = "//p[@style='color: red;']";

    public static void typeUserName(String name) {
        type(By.xpath(NAME), name);
    }

    public static void typeEmailAddress(String email) {
        type(By.xpath(EMAIL), email);
    }

    public static void clickSignup() {
        click(By.xpath(SIGN_UP));
    }

    public static void typePassword(String password) {
        type(By.xpath(PASSWORD), password);
    }

    public static void verifyAccountVisibility() {
        isElementPresent(By.xpath(ACCOUNT_INFO));
    }

    public static void selectTitle(String title) {
        switch (title) {
            case "Mr.":
                click(By.xpath(MR));
            case "Mrs.":
                click(By.xpath(MRS));
        }
    }

    public static void typeReEnterUsername(String userName) {
        type(By.xpath(USER_FORM), userName);
    }

    public static void typeReEnterEmail(String email) {
        type(By.xpath(EMAIL_FORM), email);
    }

    public static void selectDoB(String dob) {

        String[] D_M_YYYY = dob.split("/");

        select(By.xpath(SELECT_D), D_M_YYYY[0]);
        select(By.xpath(SELECT_MM), D_M_YYYY[1]);
        select(By.xpath(SELECT_YYYY), D_M_YYYY[2]);
    }

    public static void typeFirstName(String name) {
        type(By.xpath(FIRST_NAME), name);
    }

    public static void typeLastName(String lastName) {
        type(By.xpath(LAST_NAME), lastName);
    }

    public static void typeCompany(String company) {
        type(By.xpath(COMPANY), company);
    }

    public static void typeAddress(String address) {
        type(By.xpath(ADDRESS1), address);
    }

    public static void selectCountry(String country) {
        select(By.xpath(SELECT_CTRY), country);
    }

    public static void selectState(String state) {
        type(By.xpath(STATE), state);
    }

    public static void typeCity(String city) {
        type(By.xpath(CITY), city);
    }

    public static void typeZip(String zip) {
        type(By.xpath(ZIP), zip);
    }

    public static void typeMobile(String mobile) {
        type(By.xpath(MOBILE), mobile);
    }

    public static void clickCreateAccount() {
        click(By.xpath(CREATE_ACC));
    }

    public static void verifyAccountCreated() {
        isElementPresent(By.xpath(ACC_CREATED));
    }

    public static void verifyErrorMessage() {
        Assert.assertTrue(text(By.xpath(ERROR_MSG)).contains("Email Address already exist!"));
    }
}
