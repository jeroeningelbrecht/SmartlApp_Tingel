package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(StartChildActivity.SIGN);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.sign);
        textView.setText(message);
    }
}
