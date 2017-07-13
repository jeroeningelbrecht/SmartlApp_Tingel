package com.example.jingleski.smartlapp;

import android.content.Context;
import android.content.Intent;
import android.opengl.EGLConfig;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialize connection to Google
        ((MyApplication)this.getApplication()).initGoogleAndFirebaseConnection(this,this);

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart(){
        super.onStart();
        //only log in if firebase connection is not ok yet
        if( !((MyApplication)this.getApplication()).isFirebaseConnection() ) {
            Intent signInIntent = ((MyApplication) this.getApplication()).getSignInIntent();
            startActivityForResult(signInIntent, MyApplication.RC_SIGN_IN);
        }
        ((MyApplication)this.getApplication()).readData(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MyApplication.RC_SIGN_IN) {
            ((MyApplication)this.getApplication()).handleSignInResult(this, data);
        }
    }

    /** Called when the user taps the Laura button */
    public void sendMessageLaura(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
        Button startLaura = (Button) findViewById(R.id.startLaura);
        String message = startLaura.getContentDescription().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChild((MyApplication.Child.LAURA));
        startActivity(intent);

    }
    /** Called when the user taps the Riene button */
    public void sendMessageRiene(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
        Button startRiene = (Button) findViewById(R.id.startRiene);
        String message = startRiene.getContentDescription().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChild(MyApplication.Child.RIENE);
        startActivity(intent);
    }
    /** Called when the user taps the Marie button */
    public void sendMessageMarie(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
        Button startMarie = (Button) findViewById(R.id.startMarie);
        String message = startMarie.getContentDescription().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChild(MyApplication.Child.MARIE);
        startActivity(intent);
    }

    /** Called when the user taps the Schatkist button */
    public void sendMessageSchatkist(View view) {
        Intent intent = new Intent(this, StartSchatkistActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Admin button */
    public void sendMessageAdmin(View view) {
        Intent intent = new Intent(this, StartAdminActivity.class);
        startActivity(intent);
    }

}
