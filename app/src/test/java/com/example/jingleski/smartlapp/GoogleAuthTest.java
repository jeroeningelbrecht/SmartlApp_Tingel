package com.example.jingleski.smartlapp;

import android.util.Log;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by jingleski on 10.07.17.
 */

public class GoogleAuthTest implements GoogleApiClient.OnConnectionFailedListener{

    private GoogleApiClient googleApiClient;
    private FirebaseAuth firebaseAuth;

    @Before
    public void initialize(){
        //FirebaseAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d("Signing in", connectionResult.toString());
    }

    @Test
    public void test() throws Exception{
        Assert.assertTrue(true==true);
    }
}
