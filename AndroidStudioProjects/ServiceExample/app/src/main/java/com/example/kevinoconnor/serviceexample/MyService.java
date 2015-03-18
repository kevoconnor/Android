package com.example.kevinoconnor.serviceexample;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyService extends IntentService {

    private static final String TAG = "MyService";

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        NotificationCompat.Builder myBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.service)
                .setContentTitle("Service Started")
                .setContentText("PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());
        Intent resultIntent = new Intent (this, ServiceActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        stackBuilder.addParentStack(ServiceActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        myBuilder.setContentIntent(resultPendingIntent);
        NotificationManager myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotificationManager.notify(2, myBuilder.build());

        Log.d(TAG, "Second process ID: " + android.os.Process.myPid() + " Second thread ID: " + android.os.Process.myTid());
    }

}
