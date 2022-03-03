package api.product;

import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class SearchProduct {

    @Test(groups = "product_api")
    public void postSearchProductWithParams() {
        // Gathers response of POST request using parameters with x-www-form-urlencoded content type
        System.out.println("Response for adding a search-product to the search-product list using parameters :");
        Response resp = given().relaxedHTTPSValidation().
                headers("Content-Type", "application/x-www-form-urlencoded")
                .formParam("search_product", "top")
            .when().post("/searchProduct")
            .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        // Stores POST response into string and checks if correct response is returned
        String jsonString = resp.asPrettyString();
        Assert.assertTrue(jsonString.contains("200"));
    }

    @Test(groups = "product_api")
    public void postSearchProductWithoutParams() {
        // Gathers response of POST request
        System.out.println("Response for adding a search-product to the search-product list without using parameters :");
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON)
                .when().post("/searchProduct")
                .then()
                    .statusCode(200)
                    .log().body()
                    .extract().response();

        // Stores POST response into string and checks if correct response is returned
        String jsonString = res.asPrettyString();
        Assert.assertTrue(jsonString.contains("Bad request, search_product parameter is missing in POST request."));
    }

}