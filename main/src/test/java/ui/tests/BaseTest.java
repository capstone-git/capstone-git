package ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ui.objects.Pages;
import ui.pages.extra.Home;


import java.time.Duration;

public class BaseTest {

    WebDriver driver = new ChromeDriver();
    Pages pages = new Pages(driver);

    @BeforeTest
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(Home.BASE_URL);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
