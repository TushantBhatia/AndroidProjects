package com.tushant.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListView extends AppCompatActivity {

    String[] students= new String[]{
            "Tushant",
            "Raman",
            "Krampus",
            "Ram",
            "Folan",
            "Edwin",
            "Allen",
            "John",
            "Marcus",
            "Sniper",
            "SharpShooter",
            "Vaseline.wtf",
            "Untraceable"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        android.widget.ListView lis = (android.widget.ListView) findViewById(R.id.listView2);
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,
                android.R.layout.sing,android.R.id.text1,students);
        lis.setAdapter(arrayAdapter);
    }
}
