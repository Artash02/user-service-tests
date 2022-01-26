package e2e.onboarding;

import e2e.BaseTest;
import helpers.flows.OnboardingFlows;
import helpers.operations.onboarding.OnboardingHelper;
import helpers.operations.onboarding.payloads.AddUserInfoBody;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.EMAIL;
import static helpers.operations.onboarding.payloads.AddUserInfoBody.*;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matchers.*;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.Locale;

import static org.apache.http.HttpStatus.SC_OK;


public class UserInfoSubmit extends BaseTest {
    public String email;

    @Test(description = "User Register")
    public void beforeMethod() {
        email = TestUtils.getRandomInt() + "@estateguru.co";
        onboardingFlows.userEnable(email);
    }

    @Test(description = "Submit user info(happy path)")
    public void SubmitUserInfo() {
        final JSONObject body = AddUserInfoBody.bodyBuilder(email);
        OnboardingHelper.userInfoSubmit(body)
                .then()
                .log().all()
                .statusCode(SC_OK)
                .body(USERNAME, is(body.getString("username")))
                .body("email", Matchers.equalTo(email))
                .body(FIRST_NAME, is(body.getString("firstName")))
                .body(LAST_NAME, is(body.getString("lastName")))
                .body(COUNTRY, is(body.getString("country")))
                .body(CITIZENSHIP, is(body.getString("citizenship")))
                .body(FULL_ADDRESS, is(body.getString("fullAddress")))
                .body(CONTACT_COUNTRY, is(body.getString("contactCountry")))
                .body(CONTACT_ADDRESS, is(body.getString("contactAddress")));
    }
}

