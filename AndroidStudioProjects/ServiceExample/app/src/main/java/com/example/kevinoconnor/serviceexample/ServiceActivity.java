package com.example.kevinoconnor.serviceexample;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ServiceActivity extends Activity {

    private static final String TAG = "Test Service";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Log.d(TAG, "process ID: " + android.os.Process.myPid() + " thread ID: " + android.os.Process.myTid());
        Toast.makeText(getApplicationContext(), "Process ID: " + android.os.Process.myPid() + " Thread ID: " + android.os.Process.myPid(), Toast.LENGTH_LONG).show();

        Button button = (Button)findViewById(R.id.myButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startServ();
                Toast.makeText(getApplicationContext(), "Service has started", Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void startServ(){
        Intent myIntent = new Intent(this, MyService.class);
        startService(myIntent);
    }

}
