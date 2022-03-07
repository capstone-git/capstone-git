package ui.pages.cart;

import org.openqa.selenium.By;
import org.testng.Assert;

import static ui.objects.Pages.*;

public class Cart {

    // Declares all identifiers
    public static final String addProduct1 = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a";
    public static final String addProduct2 = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a";
    public static final String continueShoppingButton = "//*[@id=\"cartModal\"]/div/div/div[3]/button";
    public static final String viewCartButton = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a";
    public static final String productsTable = "//*[@id=\"cart_info_table\"]/tbody";
    public static final String product1Price = "//*[@id=\"product-1\"]/td[3]";
    public static final String product1Quantity = "//*[@id=\"product-1\"]/td[4]" ;
    public static final String product1TotalPrice = "//*[@id=\"product-1\"]/td[5]";
    public static final String product2Price = "//*[@id=\"product-2\"]/td[3]";
    public static final String product2Quantity = "//*[@id=\"product-2\"]/td[4]" ;
    public static final String product2TotalPrice = "//*[@id=\"product-2\"]/td[5]";
    public static final String cartButton = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a";
    public static final String addToCartButton = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button";
    public static final String cartPage = "//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]";
    public static final String removeButton = "//*[@id=\"product-1\"]/td[6]/a";
    public static final String recommendations = "/html/body/section[2]/div/div/div[2]/div[2]";
    public static final String recommendationTitle = "/html/body/section[2]/div/div/div[2]/div[2]/h2";
    public static final String cartQuantity = "//*[@id=\"product-1\"]/td[4]/button";
    public static final String quantityID = "quantity";
    public static final String allProducts = "//*[contains(@class,'col-sm-4')]";
    public static final String product = "add-to-cart";

    // Adding products to cart
    public static void clickAddProduct1() { click(By.xpath(addProduct1)); }
    public static void clickAddProduct2() { click(By.xpath(addProduct2)); }
    public static void clickContinueShopping() { click(By.xpath(continueShoppingButton)); }
    public static void clickViewCart() { click(By.xpath(viewCartButton)); }
    public static void clickAddToCart() { click(By.xpath(addToCartButton)); }

    // Verify products in cart
    public static void clickCartButton() { click(By.xpath(cartButton)); }
    public static void verifyNumProducts(int numOfProducts) { verifyWebElements(By.xpath(productsTable), numOfProducts); }
    public static void verifyProducts() {
        isElementPresent(By.xpath(product1Price));
        isElementPresent(By.xpath(product1Quantity));
        isElementPresent(By.xpath(product1TotalPrice));
        isElementPresent(By.xpath(product2Price));
        isElementPresent(By.xpath(product2Quantity));
        isElementPresent(By.xpath(product2TotalPrice));
    }
    public static void verifyCartPage() { Assert.assertEquals(text(By.xpath(cartPage)), "Shopping Cart"); }

    // Verifying product removal from cart
    public static void removeProduct() { click(By.xpath(removeButton)); }
    public static void verifyProductRemoval() { verifyWebElements(By.xpath(productsTable), 0); }

    // Recommended Items
    public static void scrollToRecommendations() { scrollToElement(By.xpath(recommendations)); }
    public static void verifyRecommendations() { Assert.assertEquals(text(By.xpath(recommendationTitle)), "RECOMMENDED ITEMS"); }

    // Item quantity
    public static void setItemQuantity(String quantity) {
        clear(By.id(quantityID));
        type(By.id(quantityID), quantity);
    }
    public static void verifyCartWithQuantity(String quantity) { Assert.assertEquals(text(By.xpath(cartQuantity)), quantity); }

    // Adding all products after search to cart
    public static void addingAllProducts() {
        clickElements(By.xpath(allProducts), By.className(product), By.xpath(continueShoppingButton));
    }
}
