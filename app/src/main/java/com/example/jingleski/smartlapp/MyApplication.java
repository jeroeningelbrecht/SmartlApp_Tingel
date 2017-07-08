package com.example.jingleski.smartlapp;

import android.app.Application;

import com.example.jingleski.midtier.operations.OperationResponse;

/**
 * Created by jingleski on 12.06.17.
 */

public class MyApplication extends Application {
    private String childName = "";
    private OperationResponse response;
    private String sign;
    private boolean prevResultOkIc;
    private int result;

    public static final int RC_SIGN_IN = 9001;

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }

    public void setSign(String sign) {this.sign = sign; }

    public String getSign() { return sign; }
    
    public void setResponse (OperationResponse response){
        this.response = response;
    }
    
    public OperationResponse getOperationResponse() { return response; }

    public void setResult(int result) {this.result = result; }

    public int getResult() { return result; }
}
