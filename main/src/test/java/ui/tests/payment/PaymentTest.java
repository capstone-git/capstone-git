package ui.tests.payment;

import org.testng.annotations.Test;

import static ui.pages.extra.Home.verifyHomeTitle;
import static ui.pages.payment.Payment.*;

public class PaymentTest {

    @Test(groups = {"Payment"}, priority = 1)
    public void test_verify_user_Pay_And_Confirm_Order_with_valid_data() {
        typeNameOnCart();
        typeCardNumber();
        typeCVC();
        typeExpirationMM();
        typeExpirationYYYY();
        clickPayAndConfirmOrder();
        verifyOrderPlacedMessage();
    }

    @Test(groups = {"Payment"}, priority = 2)
    public void test_verify_invoice_is_downloadable() {
        clickDownloadInvoice();
        verifyDownloadedInvoice();
    }

    @Test(groups = {"Payment"}, priority = 3)
    public void test_verify_user_navigate_Payment_to_Home() {
        clickContinue();
        verifyHomeTitle();
    }

}
