package ui.pages.extra;

import org.openqa.selenium.By;

import static ui.objects.Pages.*;


public class Home {

    public static final String SING_UP_LOGIN = "//a[@href='/login']";
    public static final String BASE_URL = "https://www.automationexercise.com/";

    public static void clickSignUpLogin(){
        click(By.xpath(SING_UP_LOGIN));
    }

    public static void navigateHome(){
        get(BASE_URL);
    }

}
