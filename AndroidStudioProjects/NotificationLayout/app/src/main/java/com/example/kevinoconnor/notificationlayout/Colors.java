package com.example.kevinoconnor.notificationlayout;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Colors extends ActionBarActivity {

    TextView emailTo, emailFrom, emailSubject, emailMessage;
    String to, from, subject, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        to = MainActivity.getEmailTo();
        from = MainActivity.getEmailFrom();
        subject = MainActivity.getEmailSubject();
        message = MainActivity.getEmailMessage();

        emailTo = (TextView) findViewById(R.id.emailTo);
        emailFrom = (TextView) findViewById(R.id.emailFrom);
        emailSubject = (TextView) findViewById(R.id.emailSubject);
        emailMessage = (TextView) findViewById(R.id.emailMessage);

        emailTo.setText(to);
        emailFrom.setText(from);
        emailSubject.setText(subject);
        emailMessage.setText(message);
    }

}
