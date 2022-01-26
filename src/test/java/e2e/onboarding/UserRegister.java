//package e2e.onboarding;
//
//import e2e.BaseTest;
//
//import helpers.operations.onboarding.OnboardingHelper;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
//import static org.hamcrest.Matchers.is;
//import static utils.TestUtils.getRandomInt;
//
//import static org.apache.http.HttpStatus.SC_OK;
//
//public class UserRegister extends BaseTest {
//
//    @Test(priority = 0)
//    public void userRegister() {
//        OnboardingHelper.userRegister(getRandomInt() + "@estateguru.com")
//                .then()
//                .statusCode(SC_OK)
//                .body("status", is(200
//                ));
//    }
//
//    @Test(alwaysRun = true)
//    public void userRegisterWithoutEmail() {
//        OnboardingHelper.userRegister("")
//                .then()
//                .statusCode(SC_BAD_REQUEST)
//                .body("status", is(400
//                ));
//    } {}
//
//    @Test(dataProvider = )
//    public void userRegistration() {
//    }
//
//    @Test(description = "User registration(with already used email)")
//    public void userRegistrationWithAlreadyUsedEmail() {}
//
//    @AfterMethod(enabled = false) {
//        deleteUser()
//    }
////    @Test(description = "User registration(with no email)")
////    @Test(description = "User registration(with incorrect email format)")
////    @Test(description = "User registration(with no parameters)")
//
//
//
//}
