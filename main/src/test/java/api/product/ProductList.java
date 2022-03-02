package api.product;

import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ProductList {
    @Test
    public void getProductList() {
        given().header("Accept", "application/json").contentType(ContentType.JSON).
        when().get("https://automationexercise.com/api/productsList").
        then().assertThat().statusCode(200);
    }

}