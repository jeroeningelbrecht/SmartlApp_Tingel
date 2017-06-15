package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartChildActivity extends AppCompatActivity {
    public static final String SIGN = "com.example.jingleski.smartlapp.SIGN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_child);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        MyApplication application = (MyApplication)this.getApplication();
        String message = application.getChildName();

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.act_start_child_textView);
        textView.setText(message);

    }

    /** Called when the user taps the addition button */
    public void sendMessageAddition(View view) {
        Intent intent = new Intent(this, CountActivity.class);
        Button addition = (Button) findViewById(R.id.addition);
        String message = addition.getText().toString();
        intent.putExtra(SIGN, message);
        startActivity(intent);
    }

    /** Called when the user taps the subtraction button */
    public void sendMessageSubtraction(View view) {
        Intent intent = new Intent(this, CountActivity.class);
        Button subtraction = (Button) findViewById(R.id.subtraction);
        String message = subtraction.getText().toString();
        intent.putExtra(SIGN,message);
        startActivity(intent);
    }

    /** Called when the user taps the split button */
    public void sendMessageSplit(View view) {
        Intent intent = new Intent(this, SplitActivity.class);
        startActivity(intent);
    }

}
