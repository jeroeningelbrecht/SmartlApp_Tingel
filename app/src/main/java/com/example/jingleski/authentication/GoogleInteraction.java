package com.example.jingleski.authentication;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by jingleski on 13.07.17.
 */

public class GoogleInteraction implements GoogleApiClient.OnConnectionFailedListener{

    public static GoogleApiClient googleApiClient;

    private static void init(FragmentActivity activity, Context context){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("717814102404-gmp3mnhi8omv6iqnmtm9bsg612lh2eia.apps.googleusercontent.com")
                .build();

        googleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(activity,new GoogleInteraction())
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    public static GoogleApiClient getGoogleApiClient(FragmentActivity activity, Context context){
        if(null == googleApiClient) {
            init(activity, context);
        }
        return googleApiClient;
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d("Signing in", connectionResult.toString());
    }


}
