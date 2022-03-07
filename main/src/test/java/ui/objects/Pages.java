package ui.objects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import static ui.objects.Utils.getRandomNumber;
import static ui.pages.extra.Home.navigateHome;
import static ui.pages.payment.Payment.invoicePath;


public class Pages {

    public static UserForm user = new UserForm(getRandomNumber(1, 6));

    private static WebDriver driver;

    public Pages(WebDriver driver) {
        Pages.driver = driver;
    }

    public Pages(String browser) {
        init(browser, new ChromeOptions());
    }

    public Pages(String browser, ChromeOptions options) {
        init(browser, options);
    }

    private void init(String browser, ChromeOptions options) {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver(options);
                break;
        }
        manage();
        navigateHome();
    }

    public static ChromeOptions chromeInvoiceOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", new HashMap<String, Object>() {{
            put("download.default_directory", invoicePath.getAbsolutePath());
        }});

        return options;
    }

    private static void manage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void click(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public static void get(String url) {
        driver.get(url);
    }

    public static void type(By by, String text) {
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
    }

    public static void clear(By by) {
        driver.findElement(by).clear();
    }

    public static void waitFile(File file) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(IOException.class);

        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return file.isFile();
            }
        });
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

    public static void quit() {
        driver.quit();
    }

    public static void hover(By by) {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(by);
        builder.moveToElement(element).pause(200).build().perform();
    }

    public static By listElement(By xpath, int index) {
        return new By.ByXPath(xpath.toString().substring(10) + "[" + index + "]");
    }

    public static List<WebElement> list(By by) {
        return driver.findElements(by);
    }

    public static boolean isElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verifyWebElements(By by, int expectedNum) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        try {
            List<WebElement> elements = driver.findElements(by);
            return expectedNum == elements.size() ? true : false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
