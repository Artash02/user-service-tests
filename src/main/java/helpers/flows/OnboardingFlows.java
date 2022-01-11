package helpers.flows;

import helpers.operations.onboarding.OnboardingHelper;

import static utils.TestUtils.getRandomInt;
import static utils.TestUtils.*;

public class OnboardingFlows {

    public void userRegister() {
        OnboardingHelper.userRegister(getRandomInt() + "@estateguru.com");
    }
}
