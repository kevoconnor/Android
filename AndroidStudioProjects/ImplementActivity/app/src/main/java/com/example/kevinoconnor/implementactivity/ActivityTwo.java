package com.example.kevinoconnor.implementactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityTwo extends Activity {

    private static final String TAG = "ActivityTwo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_two);
        Log.d(TAG, "ActivityTwo onCreate()");
    }

    public void startActivityOne(View v){
        Intent activity1 = new Intent(this, ActivityOne.class);
        startActivity(activity1);
        Log.d(TAG, "startActivityOne");
    }
}
