package ui.pages.product;

import org.openqa.selenium.By;
import org.testng.Assert;
import static ui.objects.Pages.*;


public class SearchProduct {

    // Declared all identifiers
    public static final String searchInputId = "search_product";
    public static final String searchButton = "submit_search";
    public static final String searchProductsPage = "/html/body/section[2]/div/div/div[2]/div/h2";
    public static final String verifyProducts = "//*[contains(@class,'col-sm-4')]";


    // Searching product
    public static void enterProductName(String productName) { type(By.id(searchInputId), productName); }
    public static void clickSearchButton() { click(By.id(searchButton)); }

    // Verify Search products
    public static void verifySearchProductsPage() { Assert.assertEquals(text(By.xpath(searchProductsPage)), "SEARCHED PRODUCTS");}
    public static void verifySearchProducts(int numberOfProducts) { verifyWebElements(By.xpath(verifyProducts), numberOfProducts); }

}
