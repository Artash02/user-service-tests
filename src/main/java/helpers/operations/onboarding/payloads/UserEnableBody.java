package helpers.operations.onboarding.payloads;

import org.json.JSONObject;

public class UserEnableBody {

    public static final String TOKEN = "token";
    public static final String PASSWORD = "password";


    public static JSONObject bodyBuilder(String token) {
        final JSONObject body = new JSONObject();
        body.put(TOKEN, token);
        body.put(PASSWORD, "Aes12856ed!");
        return body;
    }
}
