package ui.pages.checkout;

import org.openqa.selenium.By;
import org.testng.Assert;

import static ui.objects.Pages.*;

public class Checkout {

    private static final String CART = "//li[@class='active']";
    private static final String FN_LN = "(//li[@class='address_firstname address_lastname'])[1]";
    private static final String COMPANY = "(//li[@class='address_address1 address_address2'])[1]";
    private static final String CITY_ZIP = "(//li[@class='address_city address_state_name address_postcode'])[1]";
    private static final String COUNTRY = "(//li[@class='address_country_name'])[1]";
    private static final String MOBILE = "(//li[@class='address_phone'])[1]";
    private static final String BL_FN_LN = "(//li[@class='address_firstname address_lastname'])[2]";
    private static final String BL_COMPANY = "(//ul[@class='address alternate_item box']//ancestor::li[@class='address_address1 address_address2'])[1]";
    private static final String BL_CITY_ZIP = "(//li[@class='address_city address_state_name address_postcode'])[2]";
    private static final String BL_COUNTRY = "(//li[@class='address_country_name'])[2]";
    private static final String BL_MOBILE = "(//li[@class='address_phone'])[2]";
    private static final String ORDER_LIST = "//div[@id='cart_info']//ancestor::tbody/tr";
    private static final String PLACE_ORDER = "//a[@href='/payment']";

    public static void verifyCheckoutTitle() {
        Assert.assertTrue(text(By.xpath(CART)).contains("Checkout"));
    }

    public static void verifyFirstLastName() {
        Assert.assertTrue(text(By.xpath(FN_LN)).contains(user.getFirstName() + " " + user.getLastName()));
    }

    public static void verifyCompanyName() {
        Assert.assertTrue(text(By.xpath(COMPANY)).contains(user.getCompany()));
    }

    public static void verifyCityZip() {
        Assert.assertTrue(text(By.xpath(CITY_ZIP)).contains(user.getCity() + " " + user.getState() + " "  + user.getZip()));
    }

    public static void verifyCountry() {
        Assert.assertTrue(text(By.xpath(COUNTRY)).contains(user.getCountry()));
    }

    public static void verifyMobile() {
        Assert.assertTrue(text(By.xpath(MOBILE)).contains(user.getMobile()));
    }

    public static void verifyBillingFirstLastName() {
        Assert.assertTrue(text(By.xpath(BL_FN_LN)).contains(user.getFirstName() + " " + user.getLastName()));
    }

    public static void verifyBillingCompanyName() {
        Assert.assertTrue(text(By.xpath(BL_COMPANY)).contains(user.getCompany()));
    }

    public static void verifyBillingCityZip() {
        Assert.assertTrue(text(By.xpath(BL_CITY_ZIP)).contains(user.getCity() + " " + user.getState() + " "  + user.getZip()));
    }

    public static void verifyBillingCountry() {
        Assert.assertTrue(text(By.xpath(BL_COUNTRY)).contains(user.getCountry()));
    }

    public static void verifyBillingMobile() {
        Assert.assertTrue(text(By.xpath(BL_MOBILE)).contains(user.getMobile()));
    }

    public static void verifyOrderList() {
        Assert.assertTrue(list(By.xpath(ORDER_LIST)).size() > 1);
    }

    public static void clickPlaceOrder() {
       click(By.xpath(PLACE_ORDER));
    }

}
