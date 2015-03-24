package org.dosomething.slothkit.auth;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by juy on 3/24/15.
 */
public class LoginData {

    private String mEmail;
    private String mMobile;
    private String mUsername;
    private String mPassword;

    public void setEmail(String email) {
        mEmail = email;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    private boolean hasEmail() {
        return mEmail != null && !mEmail.isEmpty();
    }

    private boolean hasMobile() {
        return mMobile != null && !mMobile.isEmpty();
    }

    private boolean hasUsername() {
        return mUsername != null && !mUsername.isEmpty();
    }

    private boolean hasPassword() {
        return mPassword != null && !mPassword.isEmpty();
    }

    public boolean isValid() {
        if ((hasEmail() || hasMobile() || hasUsername()) && hasPassword()) {
            return true;
        }
        else {
            return false;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        try {
            if (hasEmail()) {
                json.put("email", mEmail);
            }
            if (hasMobile()) {
                json.put("mobile", mMobile);
            }
            if (hasUsername()) {
                json.put("username", mUsername);
            }

            json.put("password", mPassword);

            return json;
        }
        catch (JSONException jsonException) {
            return null;
        }
    }
}
