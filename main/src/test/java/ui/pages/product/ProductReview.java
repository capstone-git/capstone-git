package ui.pages.product;

import org.openqa.selenium.By;
import org.testng.Assert;
import static ui.objects.Pages.*;

public class ProductReview {

    // Declares all identifiers
    public static final String writeReview = "/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a";
    public static final String name = "Bob Ross";
    public static final String email = "bob@gmail.com";
    public static final String review = "Great product!";
    public static final String reviewAlert = "//*[@id=\"review-section\"]/div/div/span";

    //Verifying write your review is visible
    public static void verifyWriteReview() { isElementPresent(By.xpath(writeReview)); }

    // Entering information for review
    public static void enterName() { type(By.id("name"), name); }
    public static void enterEmail() { type(By.id("email"), email); }
    public static void enterReview() { type(By.id("review"), review); }

    // Submitting review
    public static void clickSubmit() { click(By.id("button-review")); }
    public static void verifyReview() { isElementPresent(By.xpath(reviewAlert)); }
}
