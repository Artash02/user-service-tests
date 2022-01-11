package helpers.operations.user;

import helpers.BaseAPIHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UserHelper extends BaseAPIHelper {

    final static RequestSpecification requestSpecification = setUpSpec("/accounts/");

    public static Response changePassword(Object token, JSONObject body) {
        return given()
                .spec(requestSpecification)
                .body(body.toString())
                .header("Authorization", "Bearer " + token)
                .put("current/change-password");
    }

}
