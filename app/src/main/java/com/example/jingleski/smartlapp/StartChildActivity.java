package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_child);

        MyApplication application = (MyApplication)this.getApplication();
        String message = application.getChildName();

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.act_start_child_textView);
        textView.setText(message);

        //initialise response for each child
        application.setResponse(null);

    }

    /** Called when the user taps the addition button */
    public void sendMessageAddition(View view) {
        Intent intent = new Intent(this, CountActivity.class);
        Button addition = (Button) findViewById(R.id.addition);
        String sign = addition.getContentDescription().toString();

        MyApplication application = (MyApplication)this.getApplication();
        application.setSign(sign);
        startActivity(intent);
    }

    /** Called when the user taps the subtraction button */
    public void sendMessageSubtraction(View view) {
        Intent intent = new Intent(this, CountActivity.class);
        Button subtraction = (Button) findViewById(R.id.subtraction);
        String sign = subtraction.getContentDescription().toString();
        MyApplication application = (MyApplication)this.getApplication();
        application.setSign(sign);
        startActivity(intent);
    }

    /** Called when the user taps the split button */
    public void sendMessageSplit(View view) {
        Intent intent = new Intent(this, SplitActivity.class);
        startActivity(intent);
    }

}
