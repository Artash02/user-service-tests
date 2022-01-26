package helpers.operations.testingendpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static helpers.BaseAPIHelper.setUpSpec;
import static io.restassured.RestAssured.given;

public class TokenHelper {

    final static RequestSpecification requestSpecification = setUpSpec("/test/");

    public static Response getTokenByEmail(String email) {
        return given()
                .spec(requestSpecification)
                .queryParam("email", email)
                .get("guest/token");
    }
}
