package helpers.flows;

import helpers.operations.onboarding.OnboardingHelper;
import helpers.operations.onboarding.payloads.AddUserInfoBody;
import helpers.operations.onboarding.payloads.UserEnableBody;
import helpers.operations.testingendpoints.TokenHelper;
import org.json.JSONObject;
import utils.TestUtils;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.TestUtils.getRandomInt;


public class OnboardingFlows {

    public void userRegister(String email) {
        OnboardingHelper.userRegister(email)
                .then()
                .statusCode(SC_OK);
    }

    public String getTokenByEmail(String email) {
        return TokenHelper.getTokenByEmail(email).then().extract().path("token");
    }

    public void userEnable(String email) {
        userRegister(email);
        final String token = TokenHelper.getTokenByEmail(email)
                .then()
                .statusCode(SC_OK)
                .extract()
                .path("token");
        final JSONObject body = UserEnableBody.bodyBuilder(token);
        OnboardingHelper.userEnable(body)
                .then()
                .statusCode(SC_OK);
    }

    public void  userInfoSubmitting(String email){
        userEnable(email);
        final JSONObject body = AddUserInfoBody.bodyBuilder(email);
        OnboardingHelper.userInfoSubmit(body)
                .then()
                .statusCode(SC_OK);

    }

}
