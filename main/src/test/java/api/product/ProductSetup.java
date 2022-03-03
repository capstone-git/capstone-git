package api.product;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class ProductSetup {

    @BeforeSuite(groups = "product_api")
    public void setup() {
        // Base URL/URI for all REST API requests
        RestAssured.baseURI = "https://automationexercise.com/api";
    }
}
