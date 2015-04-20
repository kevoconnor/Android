package com.example.kevinoconnor.implementactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityOne extends Activity {

    private static final String TAG = "ActivityOne";
    public int count = 0;

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
        outState.putInt("count", count);
        count++;
        Log.d(TAG, "Count is " + count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
    }

    public void startActivityTwo(View v){
        Intent activity2 = new Intent(this, ActivityTwo.class);
        startActivity(activity2);
        Log.d(TAG, "startActivityTwo");
    }

}
