package com.example.kevinoconnor.implementstorage;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
    private static final String FILENAME = "storage5";
    private RelativeLayout rel;
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        color = preferences.getString("color", "none");

        Log.d("Get String", color);

        rel = (RelativeLayout) findViewById(R.id.rel);
        if (color.equals("red")){
            rel.setBackgroundColor(Color.RED);
        }else if (color.equals("yellow")){
            rel.setBackgroundColor(Color.YELLOW);
        }else if (color.equals("green")){
            rel.setBackgroundColor(Color.GREEN);
        }else if (color.equals("blue")){
            rel.setBackgroundColor(Color.BLUE);
        }else{
            rel.setBackgroundColor(Color.BLACK);
        }

        list_values = new ArrayList<String>();
        list_adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                list_values
        );
        setListAdapter(list_adapter);
    }

    public void change(View v){
        EditText evalue = (EditText) findViewById(R.id.inputText);
        color = evalue.getText().toString();

        Log.d("Button Click", color);

        list_values.add(0, color);
        list_adapter.notifyDataSetChanged();
        rel = (RelativeLayout) findViewById(R.id.rel);

        SharedPreferences preferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        if (color.equals("red")){
            rel.setBackgroundColor(Color.RED);
        }else if (color.equals("yellow")){
            rel.setBackgroundColor(Color.YELLOW);
        }else if (color.equals("green")){
            rel.setBackgroundColor(Color.GREEN);
        }else if (color.equals("blue")){
            rel.setBackgroundColor(Color.BLUE);
        }else{
            rel.setBackgroundColor(Color.BLACK);
        }

        Log.d("Put String", color);
        //color2 = color;
        editor.putString("color", color);
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

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        Log.d("Saved", Integer.toString(count));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
        Log.d("Restored", Integer.toString(count));
    }*/

}
