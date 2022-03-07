package ui.pages.product;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import static ui.objects.Pages.*;
import ui.tests.BaseTest;

public class ViewProduct {

//    WebDriver driver;

//1. Parallel testing
//2. Priority param
//3. Dependency testing
    public static final String productTitle = "Automation Exercise";

    public static void verifyProductTitle() {
        Assert.assertTrue(productTitle.contains(title()));
    }
}