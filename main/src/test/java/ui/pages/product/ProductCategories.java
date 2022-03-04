package ui.pages.product;

import org.openqa.selenium.By;
import org.testng.Assert;
import static ui.objects.Pages.*;

public class ProductCategories {

    // Declares all identifiers
    public static final String categorySideBar = "//*[@id=\"accordian\"]";
    public static final String womenCategory = "//*[@id=\"accordian\"]/div[1]/div[1]/h4/a";
    public static final String dressLink = "//*[@id=\"Women\"]/div/ul/li[1]/a";
    public static final String womenCategoryPage = "/html/body/section/div/div[2]/div[2]/div/h2";
    public static final String menCategory = "//*[@id=\"accordian\"]/div[2]/div[1]/h4/a";
    public static final String jeansLink = "//*[@id=\"Men\"]/div/ul/li[2]/a";
    public static final String menCategoryPage = "/html/body/section/div/div[2]/div[2]/div/h2";


    // Verify category sidebar is present
    public static void verifyCategorySideBar() { isElementPresent(By.xpath(categorySideBar)); }

    // Verify women -> dress category page opens
    public static void clickWomenCategory() { click(By.xpath(womenCategory)); }
    public static void clickDressLink() { click(By.xpath(dressLink));}
    public static void verifyWomenCategoryPage() {
        Assert.assertEquals(text(By.xpath(womenCategoryPage)), "WOMEN - DRESS PRODUCTS");
    }

    // Verify sub-category flows to men category page
    public static void clickMenSubCategory() {
        click(By.xpath(menCategory));
        click(By.xpath(jeansLink));
    }
    public static void verifyMenCategoryPage() {
        Assert.assertEquals(text(By.xpath(menCategoryPage)), "MEN - JEANS PRODUCTS");
    }


}
