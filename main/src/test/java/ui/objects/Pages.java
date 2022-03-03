package ui.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Pages {

    private static WebDriver driver;

    public Pages(WebDriver driver){
        Pages.driver = driver;
    }

    public static void click(By by) {
        driver.findElement(by).click();
    }

    public static void get(String url) {
        driver.get(url);
    }

    public static void type(By by, String text) {
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
        }

        driver.findElement(by).sendKeys(text);
    }

    public static void clear(By by) {
        driver.findElement(by).clear();
    }

    private static void wait(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void select(By by, String text) {
        click(by);
        new Select(driver.findElement(by)).selectByValue(text);
    }

    public static String text(By by) {
        return driver.findElement(by).getText();
    }

    public static String title() {
        return driver.getTitle();
    }

    public static boolean isElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
