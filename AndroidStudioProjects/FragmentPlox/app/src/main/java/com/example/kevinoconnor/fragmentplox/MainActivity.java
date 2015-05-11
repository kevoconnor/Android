package com.example.kevinoconnor.fragmentplox;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private String[] items;
    private DrawerLayout drawerLayout;
    private ListView listView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = getResources().getStringArray(R.array.items);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        listView = (ListView) findViewById(android.R.id.list);

        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, items));
        listView.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }else{
            getFragmentManager().popBackStack();
        }

    }

    private void changeFrag(int position){

        Fragment frag;

        if (position == 0){
            frag = new Frag1();
        }else{
            frag = new Frag2();
        }

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().addToBackStack("").replace(R.id.container, frag).commit();

        listView.setItemChecked(position, true);
        drawerLayout.closeDrawer(listView);

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            changeFrag(position);
        }
    }
}
