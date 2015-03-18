package org.dosomething.slothkit;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Jonathan Uy on 3/17/15.
 */

public class DSAPIClient {

    private static DSAPIClient mInstance;
    private static Context mContext;
    private RequestQueue mRequestQueue;

    /**
     * Private constructor.
     *
     * @param context
     *   Must be instantiated with the Application context, not the Activity context.
     *   Ensure the RequestQueue will last the lifetime of the app and not recreated
     *   each time the Activity is recreated.
     */
    private DSAPIClient(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    };

    public static synchronized DSAPIClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DSAPIClient(context);
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
}
