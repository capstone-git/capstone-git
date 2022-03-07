package ui.pages.payment;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;

import static ui.objects.Pages.*;
import static ui.objects.Utils.isFileExist;

public class Payment {

    public static File invoicePath = new File("src/test/resources/xlsx");
    public static final String PAYMENT = "//li[@class='active']";
    public static final String NAME_ON_CARD = "//input[@name='name_on_card']";
    public static final String CARD_NUM = "//input[@name='card_number']";
    public static final String CVC = "//input[@name='cvc']";
    public static final String EX_MONTH = "//input[@name='expiry_month']";
    public static final String EX_YEAR = "//input[@name='expiry_year']";
    public static final String PAY_CONFIRM_ORDER = "//button[@id='submit']";
    public static final String ORDER_CONFIRMED = "//p[@style='font-size: 20px; font-family: garamond;']";
    public static final String INVOICE = "//a[@class='btn btn-default check_out']";
    public static final String CONTINUE = "//a[@data-qa='continue-button']";

    public static void verifyPaymentTitle() {
        Assert.assertTrue(text(By.xpath(PAYMENT)).contains("Payment"));
    }

    public static void typeNameOnCart() {
        type(By.xpath(NAME_ON_CARD), user.getFirstName() + " " + user.getLastName());
    }

    public static void typeCardNumber() {
        type(By.xpath(CARD_NUM), user.getCardNumber());
    }

    public static void typeCVC() {
        type(By.xpath(CVC), user.getCvc());
    }

    public static void typeExpirationMM() {
        type(By.xpath(EX_MONTH), user.getExpiration().split("/")[0]);
    }

    public static void typeExpirationYYYY() {
        type(By.xpath(EX_YEAR), user.getExpiration().split("/")[1]);
    }

    public static void clickPayAndConfirmOrder() {
        click(By.xpath(PAY_CONFIRM_ORDER));
    }

    public static void verifyOrderPlacedMessage() {
        Assert.assertTrue(text(By.xpath(ORDER_CONFIRMED)).contains("Congratulations! Your order has been confirmed!"));
    }

    public static void clickContinue() {
        click(By.xpath(CONTINUE));
    }

    public static void clickDownloadInvoice() {
        click(By.xpath(INVOICE));
    }

    public static void verifyDownloadedInvoice() {
        Assert.assertTrue(isFileExist());
    }

}
