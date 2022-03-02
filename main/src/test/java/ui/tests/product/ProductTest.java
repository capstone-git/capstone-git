package ui.tests.product;

import org.testng.annotations.Test;
import ui.pages.product.ViewProduct;
import ui.tests.BaseTest;

public class ProductTest extends BaseTest {

    @Test(description = "This method verifies that homepage loads", priority = 1)
    public void homePageLoads() {
        ViewProduct.verifyProductTitle();
    }
}
