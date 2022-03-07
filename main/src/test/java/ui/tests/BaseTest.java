package ui.tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ui.objects.Pages;

import static ui.objects.Pages.chromeInvoiceOptions;
import static ui.objects.Pages.quit;

public class BaseTest {

    Pages pages;

    @BeforeSuite(groups = {"BaseSuit"})
    public void setUpSuit() {
        pages = new Pages("chrome", chromeInvoiceOptions());
    }

    @Before
    @BeforeTest(groups = {"BaseTest"})
    public void setUp() {
        pages = new Pages("chrome");
    }

    @After
    @AfterTest(groups = {"BaseTest"})
    public void tearDown() {
        quit();
    }

    @AfterSuite(groups = {"BaseSuit"})
    public void tearDownSuit() {
        quit();
    }

}
