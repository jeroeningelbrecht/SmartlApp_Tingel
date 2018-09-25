package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jingleski.midtier.configuration.Configuration;

public class ResultActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    @Override
    protected void onStart(){
        super.onStart();
        MyApplication application = (MyApplication)this.getApplication();
        Configuration.Child currentChild = ((MyApplication) this.getApplication()).getCurrentChild();
        application.updateChildPoints(currentChild, 1);
    }

    /** Called when the user taps the ok button */
    public void sendMessageCount(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
