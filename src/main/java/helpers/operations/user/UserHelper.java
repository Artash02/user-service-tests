package helpers.operations.user;

import helpers.BaseAPIHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UserHelper extends BaseAPIHelper {

    final static RequestSpecification requestSpecification = setUpSpec("/accounts/");

    public static Response changePassword(String email) {
        return given()
                .spec(requestSpecification)
                .queryParam("email", email)
                .get("current/change-password");
    }

}
