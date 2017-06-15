package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Laura button */
    public void sendMessageLaura(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
        Button startLaura = (Button) findViewById(R.id.startLaura);
        String message = startLaura.getText().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChildName(message);
        startActivity(intent);

    }
    /** Called when the user taps the Riene button */
    public void sendMessageRiene(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
        Button startRiene = (Button) findViewById(R.id.startRiene);
        String message = startRiene.getText().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChildName(message);
        startActivity(intent);
    }
    /** Called when the user taps the Marie button */
    public void sendMessageMarie(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
        Button startMarie = (Button) findViewById(R.id.startMarie);
        String message = startMarie.getText().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChildName(message);
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
