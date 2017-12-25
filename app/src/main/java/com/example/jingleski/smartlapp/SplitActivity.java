package com.example.jingleski.smartlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingleski.midtier.operations.OperationResponse;
import com.example.jingleski.midtier.operations.SplitResponder;


public class SplitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);

        MyApplication application = (MyApplication) getApplication();
        String sign = application.getSign().toString();

        if (application.getOperationResponse() == null) {
            OperationResponse responseNew = SplitResponder.handleResponse(sign);
            application.setResponse(responseNew);
        } else {
            OperationResponse response = application.getOperationResponse();
            int sequenceNumber = response.getSequenceNumber();
            int splitResult = response.getFactors()[0];
            int factor1 = response.getFactors()[1];
            int factor2 = application.getResult();

            //TODO: the code is 99% as in CountActivity; the only difference is that in CountActivity we pass
            //the parameters in another order: handleResponse(sign, sequenceNumber, response.getFactors()[0], response.getFactors()[1], result)
            //here: handleResponse(sign, sequenceNumber, response.getFactors()[1], result, response.getFactors()[0] ) because
            //response.getFactors()[0] is the result of the operation
            OperationResponse responseNew =
                    SplitResponder.handleResponse(sign, sequenceNumber, factor1, factor2, splitResult);

            if (responseNew.isResultOkIc()) {
                ImageView imageView = (ImageView) findViewById(R.id.resultImg);
                imageView.setImageResource(R.drawable.good);

                application.setResponse(responseNew);

            } else {
                ImageView imageView = (ImageView) findViewById(R.id.resultImg);
                imageView.setImageResource(R.drawable.sad);
            }
        }

        OperationResponse response = application.getOperationResponse();
            if (response.isFinishIc()){
                Intent intent2 = new Intent(this, ResultActivity.class);
                startActivity(intent2);
        }else {
            int a = response.getFactors()[0];
            int b = response.getFactors()[1];

            TextView number1 = (TextView) findViewById(R.id.splitnumber1);
            number1.setText(String.valueOf(a));

            TextView number2 = (TextView) findViewById(R.id.splitnumber2);
            number2.setText(String.valueOf(b));
        }//end else

    }
        /** Called when the user taps the go button */
    public void sendMessageResult(View view) {
        MyApplication application = (MyApplication)getApplication();

        EditText resultChar = (EditText) findViewById(R.id.splitresult);
        if( resultChar.getText().toString().trim().equals("")){
            resultChar.setError( "antwoord is verplicht!" );
        }else {
            application.setResult(Integer.valueOf(resultChar.getText().toString()));
            startActivity(getIntent());
        }

    }
}
