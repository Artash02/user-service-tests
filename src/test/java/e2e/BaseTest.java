package e2e;

import helpers.flows.OnboardingFlows;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public OnboardingFlows onboardingFlows;

    @BeforeClass
    public void beforeClass() {
        onboardingFlows = new OnboardingFlows();
    }

}
