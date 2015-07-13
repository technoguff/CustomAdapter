package com.technoguff.customadapterexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private ArrayList<AndroidVersion> mVersionList;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sample Data :: For this tutorial, let's just create sample data in the main activity. In real projects
        // we will either get the data for our list item from webservices or local storage.

        mVersionList = new ArrayList<AndroidVersion>();
        AndroidVersion version = new AndroidVersion();
        version = new AndroidVersion();
        version.setCodeName("Cupcake");
        version.setVersion("Android 1.5");
        version.setIcon(R.drawable.cupcake);
        mVersionList.add(version);

        version = new AndroidVersion();
        version.setCodeName("Donut");
        version.setVersion("Android 1.6");
        version.setIcon(R.drawable.donut);
        mVersionList.add(version);

        version = new AndroidVersion();
        version.setCodeName("Eclair");
        version.setVersion("Android 2.0");
        version.setIcon(R.drawable.eclair);
        mVersionList.add(version);

        version = new AndroidVersion();
        version.setCodeName("Froyo");
        version.setVersion("Android 2.2");
        version.setIcon(R.drawable.froyo);
        mVersionList.add(version);

        version = new AndroidVersion();
        version.setCodeName("Gingerbread");
        version.setVersion("Android 2.3");
        version.setIcon(R.drawable.gingerbread);
        mVersionList.add(version);


        mListView = (ListView)findViewById(R.id.listView);
        mListView.setAdapter(new CustomAdapter(this, R.layout.layout_item, mVersionList));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
