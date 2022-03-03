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

    @Test(groups = "product_api")
    public void getProductList() {
        // Stores get response in res variable
        System.out.println("Response for getting the list of products :");
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).
        when().get("/productsList").
        then().
                statusCode(200)
                .log().body()
                .extract().response();

        // Stores POST response into string and checks if correct response is returned
        String jsonString = res.asPrettyString();
        Assert.assertTrue(jsonString.contains("200"));
    }

    @Test(groups = "product_api")
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
        System.out.println("Response for adding a product to the prodcut list :");
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(data)
                .when().post("/productsList")
                .then()
                    .statusCode(200)
                    .log().body()
                    .extract().response();

        // Stores POST response into string and checks if correct response is returned
        String jsonString = res.asPrettyString();
        Assert.assertTrue(jsonString.contains("This request method is not supported."));
    }

}