package org.dosomething.slothkit.auth;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.dosomething.slothkit.SKClient;
import org.json.JSONObject;

/**
 * Created by Jonathan Uy on 3/17/15.
 */

public class AuthService {

    private SKClient mClient;

    public static final String LOGIN_PATH = "login";
    public static final String LOGOUT_PATH = "logout";

    public AuthService(SKClient client) {
        mClient = client;
    }

    public boolean login(LoginData data) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                LOGIN_PATH,
                data.toJSONObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("AuthService", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("AuthService", error.getMessage());
                    }
                }
                );

        mClient.addToRequestQueue(request);

        return true;
    }

    public boolean logout() {
        return false;
    }


}
