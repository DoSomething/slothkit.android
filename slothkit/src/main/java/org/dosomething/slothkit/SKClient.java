package org.dosomething.slothkit;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Jonathan Uy on 3/17/15.
 */

public class SKClient {

    private static SKClient mInstance;
    private static Context mContext;
    private RequestQueue mRequestQueue;

    private String mApplicationId;
    private String mApiKey;

    /**
     * Private constructor.
     *
     * @param context
     *   Must be instantiated with the Application context, not the Activity context.
     *   Ensure the RequestQueue will last the lifetime of the app and not recreated
     *   each time the Activity is recreated.
     */
    private SKClient(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized SKClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SKClient(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

    public void setApplicationId(String applicationId) {
        mApplicationId = applicationId;
    }

    public void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }

}
