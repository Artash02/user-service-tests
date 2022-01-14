package e2e.onboarding;

import helpers.operations.onboarding.OnboardingHelper;
import helpers.operations.onboarding.payloads.AddUserInfoBody;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static helpers.operations.onboarding.payloads.AddUserInfoBody.*;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class UserInfoSubmit {

    @Test(description = "Submit user info(happy path)")
    public void submitUserInfo() {
        final JSONObject body = new JSONObject();
        body.put(USERNAME, "hayk.harutyunyan+1@estateguru.co");
        body.put(FIRST_NAME, "first_name_test");
        body.put(LAST_NAME, "lastnmaefeef");
        body.put(COUNTRY, "Estonia");
        body.put(CITIZENSHIP, "Estonia");
        body.put(FULL_ADDRESS, "citizwef");
        body.put(CONTACT_COUNTRY, "Estonia");
        body.put(CONTACT_ADDRESS, "country");
        OnboardingHelper.userInfoSubmit(body)
                .then()
                .statusCode(SC_OK);
    }

    @Test(description ="Submit User info without Referral code" )
    public void submitUserInfoWithoutReferralCode() {
        final JSONObject body = new JSONObject();
        body.put(USERNAME, "hayk.harutyunyan+1@estateguru.co");
        body.put(FIRST_NAME, "first_name_test");
        body.put(LAST_NAME, "lastnmaefeef");
        body.put(COUNTRY, "Estonia");
        body.put(CITIZENSHIP, "Estonia");
        body.put(FULL_ADDRESS, "citizwef");
        body.put(CONTACT_COUNTRY, "Estonia");
        body.put(CONTACT_ADDRESS, "country");
        OnboardingHelper.userInfoSubmit(body)
                .then()
                .statusCode(SC_BAD_REQUEST);
    }
}
