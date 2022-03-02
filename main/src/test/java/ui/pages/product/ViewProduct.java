package ui.pages.product;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ViewProduct {

    WebDriver driver;

    @BeforeClass
    public void testSetup()
    {
        System.setProperty("webdriver.chrome.driver", "../main/src/utils/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openBrowser()
    {
        driver.get("https://automationexercise.com/");
        System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
    }

    @Test(description="This method verifies that homepage loads", priority = 1)
    public void homePageLoads()
    {
        String homeTitle = driver.getTitle().toString();
        Assert.assertEquals(homeTitle,"Automation Exercise");
    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }

}