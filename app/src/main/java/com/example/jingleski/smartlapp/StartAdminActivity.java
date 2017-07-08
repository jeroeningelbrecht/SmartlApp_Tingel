package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StartAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_admin);
    }

    public void sendMessageAdmin(View view) {
        Intent intent = new Intent(this, AdminActivity.class);
        EditText paswoord = (EditText) findViewById(R.id.paswoord);
        if (paswoord.getText().toString().equals("manneke")){
            startActivity(intent);
        }
        else {
            paswoord.setError("paswoord foutief!");
        }
    }
}
