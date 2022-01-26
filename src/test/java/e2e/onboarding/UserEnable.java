package e2e.onboarding;

import e2e.BaseTest;
import helpers.flows.OnboardingFlows;
import helpers.operations.onboarding.OnboardingHelper;
import helpers.operations.onboarding.payloads.UserEnableBody;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.util.ArrayList;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.EMAIL;
import static helpers.operations.onboarding.payloads.UserEnableBody.PASSWORD;
import static helpers.operations.onboarding.payloads.UserEnableBody.TOKEN;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;


public class UserEnable extends BaseTest {

    public String email;

    @BeforeMethod
    public void beforeMethod() {
        email = TestUtils.getRandomInt() + "@estateguru.co";
    }

    @Test(description = "User Enable")
    public void userEnable() {
        final String token = onboardingFlows.getTokenByEmail(email);
        final JSONObject body = UserEnableBody.bodyBuilder(token);
        OnboardingHelper.userEnable(body)
                .then()
                .log()
                .all()
                .statusCode(SC_OK);
    }

    @Test(description = "User enable with already used token")
    public void userEnableWithAlreadyUsedToken() {
        onboardingFlows.userRegister(email);
        final String token = onboardingFlows.getTokenByEmail(email);
        final JSONObject body = new JSONObject();
        body.put(TOKEN, token);
        body.put(PASSWORD, "Aes12856ed!");
        OnboardingHelper.userEnable(body);

        final String newEmail = TestUtils.getRandomInt() + "@estateguru.co";
        onboardingFlows.userRegister(newEmail);
        final JSONObject newBody = new JSONObject();
        newBody.put(TOKEN, token);
        newBody.put(PASSWORD, "Aes12856ed!");
        OnboardingHelper.userEnable(newBody)
                .then()
                .log().all()
                .statusCode(SC_BAD_REQUEST)
                .body("status",is(400))
                .body("token", is(token));
    }

    @Test(description = "User enable with providing wrong token")
    public void userEnableWithProvidingToken() {
        final String email = TestUtils.getRandomInt() + "@estateguru.co";
        onboardingFlows.userRegister(email);
        final JSONObject body = UserEnableBody.bodyBuilder("eyJhbGciOiAiUlMyNTYiLCAidHlwIjogImp3dCIsICJraWQiOiAiNWViNmMzYjQzYzVkNjk0YSJ9.eyJlbWFpbCI6IjE0NTAzOTU0NzFAZXN0YXRlZ3VydS5jbyIsImF1ZCI6ImlkLXNlcnZlciwgdXNlciIsImlzcyI6ImlkLXNlcnZlciIsImlhdCI6MTY0MzE5NzAwNSwiZXhwIjoxNjQzMjA3ODA1LCJqdGkiOiI2OWEzY2QxYS04NDNmLTRjOTYtOGFiZS0xY2YxZTFjZWFjZTEiLCJzdWIiOiJjMTVhMzUyMy1iYzg0LTRiYTYtODVkZi0xZmRkZDk3OTZkM2MiLCJmbm0iOm51bGwsInNubSI6bnVsbCwiZGZfYWNjIjoiIn0.MEUCICvt5SDIrotf0Ymdshyfz6X8qGxMsLzDO0-EDUlN0jP45AiEAw1S2Gqwf1jOqHPvNy4eO7IcoodkHAsu5D2vxCCQq-jQ");
        OnboardingHelper.userEnable(body)
                .then()
                .statusCode(SC_BAD_REQUEST);

    }
}
