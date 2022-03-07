package ui.objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static ui.objects.Utils.getRandomNumber;


public class Pages {

    public static UserForm user = new UserForm(getRandomNumber(1, 6));

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

    public static boolean verifyWebElements(By by, int expectedNum) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        try{
            List<WebElement> elements = driver.findElements(by);
            return expectedNum == elements.size();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void scrollToElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Find element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.tagName("body"));
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public static void clickElements(By byList, By byEle, By byContinue) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(byList));

        try{
            List<WebElement> elements = driver.findElements(byList);

            for(int i = 0; i < elements.size()-1; i++) {
                driver.findElement(byEle).click();
                driver.findElement((byContinue)).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e);
        }

    }

}
