package ui.tests.checkout;

import org.testng.annotations.Test;

import static ui.pages.checkout.Checkout.*;
import static ui.pages.payment.Payment.verifyPaymentTitle;

public class CheckoutTest {

    @Test(groups = {"Checkout"}, priority = 1)
    public void test_verify_user_Delivery_Details() {
        verifyFirstLastName();
        verifyCompanyName();
        verifyCityZip();
        verifyCountry();
        verifyMobile();
    }

    @Test(groups = {"Checkout"}, priority = 2)
    public void test_verify_user_Billing_details() {
        verifyBillingFirstLastName();
        verifyBillingCompanyName();
        verifyBillingCityZip();
        verifyBillingCountry();
        verifyBillingMobile();
    }

    @Test(groups = {"Checkout"}, priority = 3)
    public void test_verify_user_Order_details() {
        verifyOrderList();
    }

    @Test(groups = {"Checkout"}, priority = 4)
    public void test_verify_navigation_Checkout_to_Payment() {
        clickPlaceOrder();
        verifyPaymentTitle();
    }

}
