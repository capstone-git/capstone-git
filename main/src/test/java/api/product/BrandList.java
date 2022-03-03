package api.product;

import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.*;

import static io.restassured.RestAssured.*;


public class BrandList {

    @Test(groups = "product_api")
    public void getBrandsList() {
        // Stores get response in res variable
        System.out.println("Response for getting the list of brands :");
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).
                when().get("/brandsList").
                then().
                    statusCode(200)
                    .log().body()
                    .extract().response();

        // Stores POST response into string and checks if correct response is returned
        String jsonString = res.asPrettyString();
        Assert.assertTrue(jsonString.contains("200"));
    }

    @Test(groups = "product_api")
    public void putBrand() {
        // JSON body that will be passed to PUT API
        System.out.println("Response for updating a brand :");
        Map<String, Object> data = new HashMap<>();
        data.put("id", "1");
        data.put("brand", "Ralph Lauren");

        // Gathers response of PUT request
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(data)
                .when().put("/brandsList")
                .then()
                    .statusCode(200)
                    .log().body()
                    .extract().response();

        // Stores PUT response into string and checks if correct response is returned
        String jsonString = res.asPrettyString();
        Assert.assertTrue(jsonString.contains("This request method is not supported."));
    }

}