package com.example.kevinoconnor.notificationlayout;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    public static String emailTo, emailFrom, emailSubject, emailMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notifyMe(View v){

        Intent resultIntent = new Intent (this, Colors.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder myBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.email)
                .setContentIntent(pendingIntent)
                .setContentTitle("Email alert")
                .setContentText("You received an email!");

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(2, myBuilder.build());

        emailTo = ((EditText) findViewById(R.id.editText)).getText().toString();
        emailFrom = ((EditText) findViewById(R.id.editText2)).getText().toString();
        emailSubject = ((EditText) findViewById(R.id.editText3)).getText().toString();
        emailMessage = ((EditText) findViewById(R.id.editText4)).getText().toString();
    }

    public static String getEmailTo(){
        return emailTo;
    }

    public static String getEmailFrom(){
        return emailFrom;
    }

    public static String getEmailSubject(){
        return emailSubject;
    }

    public static String getEmailMessage(){
        return emailMessage;
    }

}
