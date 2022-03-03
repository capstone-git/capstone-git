package api.product;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class SearchProduct {

    @BeforeSuite
    public static void setup() {
        // Base URL and URI for all REST API requests
        RestAssured.baseURI = "https://automationexercise.com/api/searchProduct";
    }

    @Test()
    public void postSearchProductWithoutParams() {
        // Gathers response of POST request
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON)
                .when().post()
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        // Stores POST response into string and checks if correct response is returned
        String jsonString = res.asPrettyString();
        Assert.assertEquals(jsonString.contains("Bad request, search_product parameter is missing in POST request."), true);
    }

}