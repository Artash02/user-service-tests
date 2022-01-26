package helpers.operations.onboarding.payloads;

import org.json.JSONObject;

public class AddUserPhoneNumberBody {

    public static final String USERNAME = "username";
    public static final String PHONE_NUMBER = "phone";
    public static final boolean ENABLE_TWO_FACTOR_AUTH = false;

    public static JSONObject validBody(String email) {
        final JSONObject body = new JSONObject();
        body.put(USERNAME, email);
        body.put(PHONE_NUMBER, "+37455652554");
        return body;
    }

    public static JSONObject bodyWithoutMandatoryFields() {
        final JSONObject body = new JSONObject();
        body.put(USERNAME, "");
        body.put(PHONE_NUMBER, "");
        return body;
    }

    public static JSONObject phoneNumberWithLetters() {
        final JSONObject body = new JSONObject();
        body.put(USERNAME, "hayk.harutyunyan+111@estateguru.co");
        body.put(PHONE_NUMBER, "Invalid_phone_number");
        return body;
    }

    public static JSONObject bodyWithoutUsername() {
        final JSONObject body = new JSONObject();
        body.put(PHONE_NUMBER, "091666061");
        return body;
    }

    public static JSONObject bodyWithoutPhoneNumber(String email) {
        final JSONObject body = new JSONObject();
        body.put(USERNAME, email);
        return body;
    }

    public static JSONObject phoneNumberWithoutCountryCode(String email) {
        final JSONObject body = new JSONObject();
        body.put(USERNAME, email);
        body.put(PHONE_NUMBER, "55549313");
        return body;
    }
}
