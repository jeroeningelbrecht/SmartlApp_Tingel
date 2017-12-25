package com.example.jingleski.smartlapp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.jingleski.authentication.GoogleInteraction;
import com.example.jingleski.midtier.operations.OperationResponse;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by jingleski on 12.06.17.
 */

public class MyApplication extends Application {
    private String childName = "";
    private OperationResponse response;
    private String sign;
    private boolean prevResultOkIc;
    private int result;

    private GoogleApiClient googleApiClient = null;
    private FirebaseAuth firebaseAuth = null;

    public static final int RC_SIGN_IN = 9001;

    public enum Child {
        MARIE("Marie"),LAURA("Laura"),RIENE("Riene");

        private String name;
        private Child(String name) {
            this.name=name;
        }
        public String getName(){
            return this.name;
        }
    };

    private Map<Child, Integer> childrenPoints = new HashMap<>();


    private DatabaseReference marieDatebaseReference;
    private DatabaseReference lauraDatebaseReference;
    private DatabaseReference rieneDatebaseReference;

    private Child currentChild;

    public void setChild(Child child) {
        this.currentChild = child;
    }

    public Child getCurrentChild(){
        return this.currentChild;
    }

    public String getChildName() {
        return currentChild.getName();
    }

    public void setSign(String sign) {this.sign = sign; }

    public String getSign() { return sign; }
    
    public void setResponse (OperationResponse response){
        this.response = response;
    }
    
    public OperationResponse getOperationResponse() { return response; }

    public void setResult(int result) {this.result = result; }

    public int getResult() { return result; }

    /**
     * Get the points of one child
     * For instance: getChildPoints(Child.MARIE) gives you the points of Marie
     * @param child MyApplication.Child object e.g.: MyApplication.Child.MARIE
     * @return the points of that particular child
     */
    public int getChildPoints(Child child){
        return this.childrenPoints.get(child);
    }

    public boolean initGoogleAndFirebaseConnection(FragmentActivity activity, Context context){
        googleApiClient = GoogleInteraction.getGoogleApiClient(activity, context);
        firebaseAuth = FirebaseAuth.getInstance();
        return googleApiClient.isConnected();
    }

    public Intent getSignInIntent(){
        return Auth.GoogleSignInApi.getSignInIntent(this.googleApiClient);
    }

    public boolean isFirebaseConnection(){
        return null != firebaseAuth.getCurrentUser();
    }

    /**
     * 1. Sign in with Google
     * 2. If step 1. is successfull, authenticate with Firebase
     * @param context The Activity calling this method
     * @param data The result Intent
     */
    public void handleSignInResult(Context context, Intent data){
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        handleSignInResult(context, result);
    }

    private void handleSignInResult(Context context, GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            firebaseAuthWithGoogle(context, account);
        } else{
            Toast.makeText(context, "Google authentication failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void firebaseAuthWithGoogle(final Context context, GoogleSignInAccount account){
        final boolean result = false;
        AuthCredential googleCredential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        Task<AuthResult> task = firebaseAuth.signInWithCredential(googleCredential);

        task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    Toast.makeText(context, "Firebase authentication successful for user " + user.getDisplayName()+ ";" +user.getUid(), Toast.LENGTH_SHORT).show();
                    readData(context);
                } else {
                    Toast.makeText(context, "Firebase authentication failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setChildPoints(Child child, int points){
        this.childrenPoints.put(child, points);
    }

    private ValueEventListener getChildValueEventListener(final Context context, final Child child) {
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int points = dataSnapshot.getValue(Integer.class);
                setChildPoints(child, points);
              //  Toast.makeText(context, child.getName() +"s points: " + points, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("DB exception for " + child.getName(), databaseError.toException());
                Toast.makeText(context, "Failed to load points for " + child.getName(), Toast.LENGTH_SHORT).show();
            }
        };

        return listener;
    }

    /**
     * only create new valuelisteners if the current one is null
     * @param context
     */
    public void readData(final Context context){
        if(null == marieDatebaseReference) {
            marieDatebaseReference = FirebaseDatabase.getInstance().getReference().child("points").child(firebaseAuth.getCurrentUser().getUid()).child(Child.MARIE.getName());
            marieDatebaseReference.addValueEventListener(getChildValueEventListener(context, Child.MARIE));
        }

        if(null == lauraDatebaseReference) {
            lauraDatebaseReference = FirebaseDatabase.getInstance().getReference().child("points").child(firebaseAuth.getCurrentUser().getUid()).child(Child.LAURA.getName());
            lauraDatebaseReference.addValueEventListener(getChildValueEventListener(context, Child.LAURA));
        }

        if(null == rieneDatebaseReference) {
            rieneDatebaseReference = FirebaseDatabase.getInstance().getReference().child("points").child(firebaseAuth.getCurrentUser().getUid()).child(Child.RIENE.getName());
            rieneDatebaseReference.addValueEventListener(getChildValueEventListener(context, Child.RIENE));
        }
    }

    public void updateChildPoints(Child child, int addPointsNumber) {
        int currentPoints = this.childrenPoints.get(child);

        int newTotalPoints = addPointsNumber+currentPoints;
        switch (child){
            case MARIE: marieDatebaseReference.setValue(newTotalPoints); break;
            case LAURA: lauraDatebaseReference.setValue(newTotalPoints);break;
            case RIENE: rieneDatebaseReference.setValue(newTotalPoints);break;
            default: ;
        }
    }


}
