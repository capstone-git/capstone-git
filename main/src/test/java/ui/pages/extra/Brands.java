package ui.pages.extra;

import org.openqa.selenium.By;
import org.testng.Assert;

import static ui.objects.Pages.*;

public class Brands {

    public static final String brandsList = "/html/body/section[2]/div/div/div[1]/div/div[2]/div/ul";
    public static final String POLOBrandLink = "/html/body/section[2]/div/div/div[1]/div/div[2]/div/ul/li[1]/a";
    public static final String BrandPage = "/html/body/section/div/div[2]/div[2]/div/h2"; //title
    public static final String brandProducts = "//*[contains(@class,'col-sm-4')]"; //products displayed
    public static final String HMBrandLink = "/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[2]/a";

    // Select brand links
    public static void clickPOLOBrandLink() { click(By.xpath(POLOBrandLink)); }
    public static void clickHMBrandLink() { click(By.xpath(HMBrandLink)); }

    // Verify Brands
    public static void verifyBrandsList() { isElementPresent(By.xpath(brandsList)); }
    public static void verifyPOLOBrandPage() {
        Assert.assertEquals(text(By.xpath(BrandPage)), "BRAND - POLO PRODUCTS");
    }
    public static void verifyHMBrandPage() {
        Assert.assertEquals(text(By.xpath(BrandPage)), "BRAND - H&M PRODUCTS");
    }

    // Verify Brand Products
    public static void verifyBrandProducts (int numOfProducts) {
        verifyWebElements(By.xpath(brandProducts), numOfProducts);
    }

}
