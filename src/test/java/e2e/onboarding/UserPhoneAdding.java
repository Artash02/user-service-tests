package e2e.onboarding;

import e2e.BaseTest;
import helpers.operations.onboarding.OnboardingHelper;
import helpers.operations.onboarding.payloads.AddUserPhoneNumberBody;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestUtils;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.hasItem;

public class UserPhoneAdding extends BaseTest {

    public String email;

    @BeforeMethod
    public void beforeMethod(){
        email = TestUtils.getRandomInt() + "@estateguru.co";
        onboardingFlows.userInfoSubmitting(email);
    }

    @Test(description = "Positive case, where phone number is being added")
    public void addUserPhoneNumber() {
        final JSONObject body = AddUserPhoneNumberBody.validBody(email);
//        OnboardingHelper.userPhoneAdding(body)
//                .then()
//                .log().all()
//                .statusCode(SC_OK);
//

      final String code =  OnboardingHelper.userPhoneAdding(body).then().extract().path("code");
    }

    @Test(description = "Negative case, where there are no mandatory fields")
    public void addingPhoneWithNoMandatoryFields(){
        final JSONObject body = AddUserPhoneNumberBody.bodyWithoutMandatoryFields();
        OnboardingHelper.userPhoneAdding(body)
                .then()
                .log().all()
                .statusCode(SC_BAD_REQUEST)
                .body("errors.code", hasItem("phone.number.format.invalid"))
                .body("errors.field", hasItem("phone"));
    }

    @Test(description = "Negative case, where there are letters instead of numbers")
    public void addingPhoneWithLetters() {
        final JSONObject body = AddUserPhoneNumberBody.phoneNumberWithLetters();
        OnboardingHelper.userPhoneAdding(body)
                .then()
                .log().all()
                .statusCode(SC_BAD_REQUEST)
                .body("errors.code", hasItem("phone.number.format.invalid"))
                .body("errors.field", hasItem("phone"));
    }

    @Test(description = "Negative case, where there is no phoneNumber in payload")
    public void bodyWithoutPhoneNumber() {
        final JSONObject body = AddUserPhoneNumberBody.bodyWithoutPhoneNumber(email);
        OnboardingHelper.userPhoneAdding(body)
                .then()
                .log().all()
                .statusCode(SC_BAD_REQUEST)
                .body("errors.code", hasItem("not.null"))
                .body("errors.field", hasItem("phone"));
    }

    @Test(description = "Negative case, where there is no username in payload")
    public void bodyWithoutUsername() {
        final JSONObject body = AddUserPhoneNumberBody.bodyWithoutUsername();
        OnboardingHelper.userPhoneAdding(body)
                .then()
                .log().all()
                .statusCode(SC_BAD_REQUEST)
                .body("errors.code", hasItem("not.blank"))
                .body("errors.field", hasItem("username"));
    }

    @Test(description = "Negative case, where phone number has no country code")
    public void phoneNumberWithoutCountryCode() {
        final JSONObject body = AddUserPhoneNumberBody.phoneNumberWithoutCountryCode(email);
        OnboardingHelper.userPhoneAdding(body)
                .then()
                .log().all()
                .statusCode(SC_BAD_REQUEST)
                .body("errors.code", hasItem("phone.number.format.invalid"))
                .body("errors.field", hasItem("phone"));
    }
}
