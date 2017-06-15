package com.example.jingleski.smartlapp;

import android.app.Application;

/**
 * Created by jingleski on 12.06.17.
 */

public class MyApplication extends Application {
    private String childName = "";

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }
}
