package ui.pages.extra;

import org.openqa.selenium.By;
import org.testng.Assert;

import static ui.objects.Pages.*;


public class Home {

    public static final String SING_UP_LOGIN = "//a[@href='/login']";
    public static final String BASE_URL = "https://www.automationexercise.com/";
    public static final String USER_NAME = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a/b";
    public static final String LOGOUT = "//a[@href='/logout']";

    public static void clickSignUpLogin(){
        click(By.xpath(SING_UP_LOGIN));
    }

    public static void navigateHome(){
        get(BASE_URL);
    }

    public static void clickLogout(){
        click(By.xpath(LOGOUT));
    }

    public static void verifyHomeTitle() {
        Assert.assertTrue(title().contains("Automation Exercise"));
    }

}
