package helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class BaseAPIHelper {

    public static final String BASE_URI = "https://user.staging.estateguru.co/api";

    public static RequestSpecification setUpSpec(String basePath) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(basePath)
                .setContentType(JSON)
                .build();
    }
}
