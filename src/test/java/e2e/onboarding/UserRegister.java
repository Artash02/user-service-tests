package e2e.onboarding;

import e2e.BaseTest;

import helpers.operations.onboarding.OnboardingHelper;
import org.testng.annotations.Test;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.hamcrest.Matchers.is;
import static utils.TestUtils.getRandomInt;

import static org.apache.http.HttpStatus.SC_OK;

public class UserRegister extends BaseTest {

    @Test
    public void userRegister() {
        OnboardingHelper.userRegister(getRandomInt() + "@estateguru.com")
                .then()
                .statusCode(SC_OK)
                .body("status", is(200
                ));
    }

    @Test
    public void userRegisterWithoutEmail() {
        OnboardingHelper.userRegister("")
                .then()
                .statusCode(SC_BAD_REQUEST)
                .body("status", is(400
                ));
    }
}
