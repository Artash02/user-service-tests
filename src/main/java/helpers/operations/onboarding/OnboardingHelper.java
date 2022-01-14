package helpers.operations.onboarding;

import helpers.BaseAPIHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class OnboardingHelper extends BaseAPIHelper {

    final static RequestSpecification requestSpecification = setUpSpec("/user/");

    public static Response userRegister(String email) {
        return given()
                .spec(requestSpecification)
                .queryParam("email", email)
                .post("register");
    }

    public static Response userInfoSubmit(JSONObject payload) {
        return given()
                .spec(requestSpecification)
                .body(payload.toString())
                .post("info");
    }
}