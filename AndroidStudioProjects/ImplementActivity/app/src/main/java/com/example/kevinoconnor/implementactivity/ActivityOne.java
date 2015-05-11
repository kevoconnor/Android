package com.example.kevinoconnor.implementactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityOne extends Activity {

    private static final String TAG = "ActivityOne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_one);
        Log.d(TAG, "ActivityOne onCreate()");
    }

    @Override
    protected void onPause() {
        super.onResume();
        Log.d(TAG, "ActivityOne onPause()");
    }

    @Override
    protected void onRestart() {
        super.onResume();
        Log.d(TAG, "ActivityOne onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ActivityOne onResume()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState called");
    }

    public void startActivityTwo(View v){
        Intent activity2 = new Intent(this, ActivityTwo.class);
        startActivity(activity2);
        Log.d(TAG, "startActivityTwo");
    }

}
