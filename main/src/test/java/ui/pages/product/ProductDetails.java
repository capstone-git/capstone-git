package ui.pages.product;

import org.openqa.selenium.By;
import org.testng.Assert;
import static ui.objects.Pages.*;

public class ProductDetails {

    // Declared all identifiers
    public static final String productsButton = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a";
    public static final String productTitle = "Automation Exercise - All Products";
    public static final String firstProductInProductPage = "body > section > div > div.row > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.choose > ul > li > a";
    public static final String firstProductInHomePage = "body > section:nth-child(4) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a";
    public static final String productDetailsTitle = "Automation Exercise - Product Details";
    public static final String productName = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2";
    public static final String productCategory = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]";
    public static final String productPrice = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span";
    public static final String productAvailability = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]";
    public static final String productCondition = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]";
    public static final String productBrand = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]";
    public static final String homeTitle = "Automation Exercise";

    public static void verifyHomeTitle() { Assert.assertTrue(homeTitle.contains(title())); }

    // Verify all products page
    public static void clickProductsButton() { click(By.xpath(productsButton));}
    public static void verifyAllProductsTitle() {
        Assert.assertTrue(productTitle.contains(title()));
    }

    // Verify product page details
    public static void clickFirstProductButton() { click(By.cssSelector(firstProductInProductPage));}
    public static void clickFirstProductHome() { click(By.cssSelector(firstProductInHomePage)); }
    public static void verifyProductDetailPage() { Assert.assertTrue(productDetailsTitle.contains(title()));}
    public static void productNameIsVisible() { isElementPresent(By.xpath(productName)); }
    public static void productCategoryIsVisible() { isElementPresent(By.xpath(productCategory)); }
    public static void productPriceIsVisible() { isElementPresent(By.xpath(productPrice)); }
    public static void productAvailabilityIsVisible() { isElementPresent(By.xpath(productAvailability)); }
    public static void productConditionIsVisible() { isElementPresent(By.xpath(productCondition)); }
    public static void productBrandIsVisible() { isElementPresent(By.xpath(productBrand)); }
}