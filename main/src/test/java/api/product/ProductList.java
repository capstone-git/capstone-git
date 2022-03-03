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


public class ProductList {

    @BeforeSuite
    public static void setup() {
        // Base URL and URI for all REST API requests
        RestAssured.baseURI = "https://automationexercise.com/api/productsList";
    }

    @Test()
    public void getProductList() {
        // Stores get response in res variable
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).
        when().get().
        then().statusCode(200).extract().response();

        //convert JSON to string
        JsonPath j = new JsonPath(res.asString());
        //length of JSON array
        int s = j.getInt("products.size()");

        // Checks that there are the expectd amount of products
        Assert.assertEquals(s, 34);
    }

    @Test()
    public void postProduct() {
        // JSON body that will be passed to POST API
        Map<String, Object> data = new HashMap<>();
        data.put("id", "44");
        data.put("name", "Red Top");
        data.put("price", "Rs. 500");
        data.put("brand", "Polo");
        data.put("category", Arrays.asList(new HashMap<String, Object>() {{
                                             put("usertype", Arrays.asList(new HashMap<String, Object>() {{
                                                 put("usertype", "Men");
                                             }}));
                                             put("category", "Tshirts");
                                         }}
        ));

        // Gathers response of POST request
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(data)
                .when().post()
                .then()
                    .statusCode(200)
                    .log().body()
                    .extract().response();

        // Stores POST response into string and checks if correct response is returned
        String jsonString = res.asPrettyString();
        Assert.assertEquals(jsonString.contains("This request method is not supported."), true);
    }

}