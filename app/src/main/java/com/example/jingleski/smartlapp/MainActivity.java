package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jingleski.midtier.configuration.Configuration;


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
        } else {
            ((MyApplication)this.getApplication()).readData(this);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MyApplication application = (MyApplication)this.getApplication();
        if(requestCode==MyApplication.RC_SIGN_IN) {
            application.handleSignInResult(this, data);
        }
    }

    /** Called when the user taps the Laura button */
    public void sendMessageLaura(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
     //   Button startLaura = (Button) findViewById(R.id.startLaura);
     //   String message = startLaura.getContentDescription().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChild((Configuration.Child.LAURA));
        startActivity(intent);

    }
    /** Called when the user taps the Riene button */
    public void sendMessageRiene(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
     //   Button startRiene = (Button) findViewById(R.id.startRiene);
     //   String message = startRiene.getContentDescription().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChild(Configuration.Child.RIENE);
        startActivity(intent);
    }
    /** Called when the user taps the Marie button */
    public void sendMessageMarie(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
     //   Button startMarie = (Button) findViewById(R.id.startMarie);
    //    String message = startMarie.getContentDescription().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChild(Configuration.Child.MARIE);
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
