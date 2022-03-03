package ui.tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    @Before
    @BeforeTest(groups = {"BaseTest"})
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(Home.BASE_URL);
    }

    @After
    @AfterTest(groups = {"BaseTest"})
    public void tearDown() {
        driver.quit();
    }
}
