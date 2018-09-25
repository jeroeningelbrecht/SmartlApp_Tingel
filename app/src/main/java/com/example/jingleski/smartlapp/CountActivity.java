package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingleski.midtier.operations.OperationResponder;
import com.example.jingleski.midtier.operations.OperationResponse;

public class CountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        MyApplication application = (MyApplication)getApplication();
        String sign = application.getSign().toString();

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.sign);
        textView.setText(sign);


     //   ImageView imageView = (ImageView) findViewById(R.id.resultImg);
     //   imageView.setImageResource(prevResultOkIc ? R.drawable.good : R.drawable.sad);

        if (application.getOperationResponse() == null) {
            OperationResponse responseNew = OperationResponder.handleResponse(sign, application.getCurrentChild());
            application.setResponse(responseNew);
        //    application.setPrevResultOkIc(responseNew.isResultOkIc());
        }
        else {
            OperationResponse response = application.getOperationResponse();
            int sequenceNumber = response.getSequenceNumber();
            int a = response.getFactors()[0];
            int b = response.getFactors()[1];
            int result = application.getResult();

            OperationResponse responseNew =
                    OperationResponder.handleResponse(sign,sequenceNumber,a,b,result, application.getCurrentChild());

            if (responseNew.isResultOkIc()) {
                ImageView imageView = (ImageView) findViewById(R.id.resultImg);
                imageView.setImageResource(R.drawable.good);

                application.setResponse(responseNew);

            }
            else {
                ImageView imageView = (ImageView) findViewById(R.id.resultImg);
                imageView.setImageResource(R.drawable.sad);
            }
        }

        OperationResponse response = application.getOperationResponse();
        if (response.isFinishIc()){
            Intent intent2 = new Intent(this, ResultActivity.class);
            startActivity(intent2);
        }
        else {
            int a = response.getFactors()[0];
            int b = response.getFactors()[1];

            TextView number1 = (TextView) findViewById(R.id.number1);
            number1.setText(String.valueOf(a));

            TextView number2 = (TextView) findViewById(R.id.number2);
            number2.setText(String.valueOf(b));
        }
    }

    /** Called when the user taps the go button */
    public void sendMessageResult(View view) {
        MyApplication application = (MyApplication)getApplication();

        EditText resultChar = (EditText) findViewById(R.id.result);
        if( resultChar.getText().toString().trim().equals("")){

            /**
             *   You can Toast a message here that the Username is Empty
             **/

            resultChar.setError( "antwoord is verplicht!" );

        }else {
            application.setResult(Integer.valueOf(resultChar.getText().toString()));
            startActivity(getIntent());
        }

     //   String sign = application.getSign().toString();

     //   OperationResponse response = application.getOperationResponse();

     //   int sequenceNumber = response.getSequenceNumber();
     //   int[] numbers = response.getFactors();
     //   int a = numbers[0];
     //   int b = numbers[1];

      //  EditText resultChar = (EditText) findViewById(R.id.result);
      //  int result = Integer.valueOf(resultChar.getText().toString());

      //  response = OperationResponder.handleResponse(sign,sequenceNumber,a,b,result);
      //  application.setResponse(response);
      //  application.setPrevResultOkIc(response.isResultOkIc());

     //   ImageView imageView = (ImageView) findViewById(R.id.resultImg);
     //   imageView.setImageResource(response.isResultOkIc() ? R.drawable.good : R.drawable.sad);

     //   startActivity(getIntent());
    }
}

