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


public class BrandList {

    @BeforeSuite
    public static void setup() {
        // Base URL and URI for all REST API requests
        RestAssured.baseURI = "https://automationexercise.com/api/brandsList";
    }

    @Test()
    public void getBrandsList() {
        // Stores get response in res variable
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).
                when().get().
                then().statusCode(200).extract().response();

        //convert JSON to string
        JsonPath j = new JsonPath(res.asString());
        //length of JSON array
        int s = j.getInt("brands.size()");

        // Checks that there are the expectd amount of products
        Assert.assertEquals(s, 34);
    }

    @Test()
    public void putBrand() {
        // JSON body that will be passed to POST API
        Map<String, Object> data = new HashMap<>();
        data.put("id", "1");
        data.put("brand", "Ralph Lauren");

        // Gathers response of POST request
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(data)
                .when().put()
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        // Stores POST response into string and checks if correct response is returned
        String jsonString = res.asPrettyString();
        Assert.assertEquals(jsonString.contains("This request method is not supported."), true);
    }

}