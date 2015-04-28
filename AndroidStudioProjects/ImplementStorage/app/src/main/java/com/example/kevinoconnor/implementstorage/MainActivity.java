package com.example.kevinoconnor.implementstorage;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private static final String TAG = "ListActivity";
    private ArrayList<String> list_values;
    private ArrayAdapter<String> list_adapter;
    private static final String FILENAME = "storage3";
    private RelativeLayout rel;
    private int count = 0;
    private String value;
    private int value2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        value = preferences.getString("value", "none");

        rel = (RelativeLayout) findViewById(R.id.rel);
        value2 = Integer.valueOf(value);
        if (value2 % 2 == 0){
            rel.setBackgroundColor(Color.GRAY);
        }

        list_values = new ArrayList<String>();
        list_adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                list_values
        );
        setListAdapter(list_adapter);
    }

    public void increment(View v){
        count++;
        value = Integer.toString(count);
        list_values.add(0, value);
        list_adapter.notifyDataSetChanged();
        rel = (RelativeLayout) findViewById(R.id.rel);

        SharedPreferences preferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        if (count % 2 == 0){
            rel.setBackgroundColor(Color.GRAY);
        }else{
            rel.setBackgroundColor(Color.BLACK);
        }

        editor.putString("value", value);
        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (!list_values.isEmpty()){

            try {
                FileOutputStream outfile = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                ObjectOutputStream os = new ObjectOutputStream(outfile);
                os.writeObject(list_values);
                os.close();
                outfile.close();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "Could not open file for saving");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (list_values.isEmpty()){
            try {
                FileInputStream infile = openFileInput(FILENAME);
                ObjectInputStream is = new ObjectInputStream(infile);
                ArrayList<String> list_from_storage = (ArrayList<String>) is.readObject();
                is.close();
                infile.close();
                list_values.addAll(list_from_storage);
                list_adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "Could not open file for reading");
            }
        }
    }

}
