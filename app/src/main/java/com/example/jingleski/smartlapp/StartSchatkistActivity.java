package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StartSchatkistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_schatkist);

        MyApplication application = (MyApplication)getApplication();
        int puntenRiene = application.getChildPoints(MyApplication.Child.RIENE);
        int puntenLaura = application.getChildPoints(MyApplication.Child.LAURA);
        int puntenMarie = application.getChildPoints(MyApplication.Child.MARIE);

        int resultRiene = puntenRiene;
        TextView rienePunten = (TextView) findViewById(R.id.rienePunten);
        rienePunten.setText(String.valueOf(resultRiene));

        int resultLaura = puntenLaura;
        TextView lauraPunten = (TextView) findViewById(R.id.lauraPunten);
        lauraPunten.setText(String.valueOf(resultLaura));

        int resultMarie = puntenMarie;
        TextView mariePunten = (TextView) findViewById(R.id.mariePunten);
        mariePunten.setText(String.valueOf(resultMarie));

        int resultTotaal = resultRiene + resultLaura + resultMarie;
        TextView totaalPunten = (TextView) findViewById(R.id.totaalPunten);
        totaalPunten.setText(String.valueOf(resultTotaal));

        ProgressBar speeltuin = (ProgressBar) findViewById(R.id.speeltuinProgress);
        speeltuin.setProgress(resultTotaal);

        ProgressBar film = (ProgressBar) findViewById(R.id.filmProgress);
        film.setProgress(resultTotaal);

        ProgressBar zee = (ProgressBar) findViewById(R.id.zeeProgress);
        zee.setProgress(resultTotaal);

    }
    /** Called when the user taps the Laura button */
    public void sendMessageLaura(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
        //   Button startLaura = (Button) findViewById(R.id.startLaura);
        //   String message = startLaura.getContentDescription().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChild((MyApplication.Child.LAURA));
        startActivity(intent);

    }
    /** Called when the user taps the Riene button */
    public void sendMessageRiene(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
        //   Button startRiene = (Button) findViewById(R.id.startRiene);
        //   String message = startRiene.getContentDescription().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChild(MyApplication.Child.RIENE);
        startActivity(intent);
    }
    /** Called when the user taps the Marie button */
    public void sendMessageMarie(View view) {
        Intent intent = new Intent(this, StartChildActivity.class);
        //   Button startMarie = (Button) findViewById(R.id.startMarie);
        //    String message = startMarie.getContentDescription().toString();
        MyApplication application = (MyApplication) this.getApplication();
        application.setChild(MyApplication.Child.MARIE);
        startActivity(intent);
    }
}
