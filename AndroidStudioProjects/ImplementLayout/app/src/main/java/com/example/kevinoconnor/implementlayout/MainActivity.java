package com.example.kevinoconnor.implementlayout;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    EditText distance, minutes, seconds, date;
    TextView average, distanceVal, timeVal;
    Spinner units;

    private static final String TAG = "Add Run App";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distance = (EditText) findViewById(R.id.distanceInput);
        minutes = (EditText) findViewById(R.id.minutes);
        seconds = (EditText) findViewById(R.id.seconds);
        date = (EditText) findViewById(R.id.date);
        average = (TextView) findViewById(R.id.averageText);
        distanceVal = (TextView) findViewById(R.id.distanceVal);
        timeVal = (TextView) findViewById(R.id.timeVal);
        units = (Spinner) findViewById(R.id.units);
    }

    public void display(View v){
        Integer total = Integer.parseInt(distance.getText().toString());
        Integer minuteVal = Integer.parseInt(minutes.getText().toString());
        Integer secondVal = Integer.parseInt(seconds.getText().toString());
        String otherUnits = units.getSelectedItem().toString();
        float totalUnits = ((((minuteVal * 60) + secondVal) * total) / 3600);
        if (otherUnits.equals("Mi")) {
            distanceVal.setText(total.toString() + " miles");
        }else{
            distanceVal.setText(total.toString() + " kilometers");
        }
        String finalTime = minuteVal.toString() + "m " + secondVal.toString() + "s";
        timeVal.setText(finalTime);

        if (otherUnits.equals("Mi")){
            average.setText(totalUnits + "mph");
        }else{
            average.setText(totalUnits + "kph");
        }
    }
}
