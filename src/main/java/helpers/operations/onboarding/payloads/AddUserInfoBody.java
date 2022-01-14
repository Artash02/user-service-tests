package helpers.operations.onboarding.payloads;

import org.json.JSONObject;

public class AddUserInfoBody {


    public static final String USERNAME = "username";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String COUNTRY = "country";
    public static final String CITIZENSHIP = "citizenship";
    public static final String FULL_ADDRESS = "fullAddress";
    public static final String REFERRAL_CODE = "referralCode";
    public static final String CONTACT_COUNTRY = "contactCountry";
    public static final String CONTACT_ADDRESS = "contactAddress";

    public enum KeyCombinations {
        REQUIRED,
        ALL_FIELDS
    }

    public static JSONObject bodyBuilder() {
        final JSONObject body = new JSONObject();
        body.put(USERNAME, "hayk.harutyunyan+1@estateguru.co");
        body.put(FIRST_NAME, "first_name_test");
        body.put(LAST_NAME, "lastnmaefeef");
        body.put(COUNTRY, "Estonia");
        body.put(CITIZENSHIP, "Estonia");
        body.put(FULL_ADDRESS, "citizwef");
        body.put(CONTACT_COUNTRY, "Estonia");
        body.put(CONTACT_ADDRESS, "country");
        return body;
    }

    public static JSONObject bodyBuilder(KeyCombinations keyCombinations) {

        final JSONObject body = new JSONObject();
        switch (keyCombinations) {
            case REQUIRED:
                break;
            case ALL_FIELDS:
                break;
        }
        body.put(USERNAME, "hayk.harutyunyan+1@estateguru.co");
        body.put(FIRST_NAME, "first_name_test");
        body.put(LAST_NAME, "lastnmaefeef");
        body.put(COUNTRY, "Estonia");
        body.put(CITIZENSHIP, "Estonia");
        body.put(FULL_ADDRESS, "citizwef");
        body.put(CONTACT_COUNTRY, "Estonia");
        body.put(CONTACT_ADDRESS, "country");
        return body;
    }
}


