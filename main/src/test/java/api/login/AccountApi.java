package api.login;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.objects.UserForm;

import static ui.objects.Utils.*;

public class AccountApi {

    public static UserForm user;

    @BeforeClass(groups = {"BaseTest"})
    public void setUp() {
        RestAssured.baseURI = "https://automationexercise.com/api";
    }

    @Test(groups = {"API to UI"}, priority = 1)
    public void test_POST_to_register_User_Account() {
        user = new UserForm(getRandomNumber(1,6));
        user.setEmail(getRandomEmail());

        Response response = RestAssured
                .given().relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("name", user.getUserName())
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getDob().split("/")[0])
                .formParam("birth_month", user.getDob().split("/")[1])
                .formParam("birth_year", user.getDob().split("/")[2])
                .formParam("firstname", user.getFirstName())
                .formParam("lastname", user.getLastName())
                .formParam("company", user.getCompany())
                .formParam("address1", user.getAddress())
                .formParam("address2", user.getAddress())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZip())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", user.getMobile())
                .when()
                .post("/createAccount")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        Assert.assertTrue(response.asString().contains("User created!"));
    }

    @Test(groups = {"API"}, priority = 2)
    public void test_POST_To_Verify_Login_with_valid_details() {

        Response response = RestAssured
                .given().relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .when()
                .post("/verifyLogin")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        Assert.assertTrue(response.asString().contains("User exists!"));
    }

    @Test(groups = {"API"}, priority = 2)
    public void test_POST_To_Verify_Login_with_invalid_details() {

        Response response = RestAssured
                .given().relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("email", user.getEmail())
                .formParam("password", getRandomString(5))
                .when()
                .post("/verifyLogin")
                .then()
                .log().body()
                .extract().response();

        Assert.assertTrue(response.asString().contains("User not found!"));
    }

    @Test(groups = {"API"}, priority = 2)
    public void test_PUT_To_Update_User_Account() {

        Response response = RestAssured
                .given().relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("name", user.getUserName())
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getDob().split("/")[0])
                .formParam("birth_month", user.getDob().split("/")[1])
                .formParam("birth_year", user.getDob().split("/")[2])
                .formParam("firstname", user.getFirstName())
                .formParam("lastname", user.getLastName())
                .formParam("company", user.getCompany())
                .formParam("address1", user.getAddress())
                .formParam("address2", user.getAddress())
                .formParam("country", user.getCountry())
                .formParam("zipcode", user.getZip())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("mobile_number", user.getMobile())
                .when()
                .put("/updateAccount")
                .then()
                .log().body()
                .extract().response();

        Assert.assertTrue(response.asString().contains("User updated!"));
    }

    @Test(groups = {"API"}, priority = 2)
    public void test_GET_user_account_detail_by_email() {

        Response response = RestAssured
                .given().relaxedHTTPSValidation()
                .queryParam("email", user.getEmail())
                .when()
                .get("/getUserDetailByEmail")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        Assert.assertTrue(response.statusCode() == 200);
    }

    @Test(groups = {"API"}, priority = 3)
    public void test_DELETE_To_Verify_Login() {

        Response response = RestAssured
                .given().relaxedHTTPSValidation()
                .when()
                .delete("/verifyLogin")
                .then()
                .log().body()
                .extract().response();

        Assert.assertTrue(response.asString().contains("This request method is not supported."));
    }

    @Test(groups = {"API"}, priority = 3)
    public void test_DELETE_To_Delete_User_Account() {

        search:{
            for (int i = 0; i < 6; i++) {
                UserForm user = new UserForm(i);

                Response response = RestAssured
                        .given().relaxedHTTPSValidation()
                        .contentType("application/x-www-form-urlencoded; charset=utf-8")
                        .formParam("email", user.getEmail())
                        .formParam("password", user.getPassword())
                        .when()
                        .delete("/deleteAccount")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().response();

                if (response.asString().contains("Account deleted!")) {
                    Assert.assertTrue(response.asString().contains("Account deleted!"));
                    break search;
                }
            }
        }
    }

}
