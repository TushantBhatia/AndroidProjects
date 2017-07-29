package com.tushant.buttonlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button b1, b2, b3;
    private ListView l1, l2, l3;
    String[] Students = new String[]{
            "Tushant",
            "Kunaal",
            "Varsha",
            "kriti",
            "Nishtha",
            "Edwin",
            "Allen",
            "John",
            "Marcus",
            "Sniper",
            "SharpShooter",
            "Vaseline.wtf",
            "Manan"
    };
    String[] games = new String[]{
            "CS",
            "GTA",
            "Farcry",
            "Mario",
            "Spider",
            "IcyTower",
            "RoadRash",
            "Taken",
            "COC",
            "GTA-CITY",
            "CandyCrush",
            "POOL",
            "Subway"
    };
    String[] andr = new String[]{
            "Alpha",
            "Beta",
            "Cupcake",
            "Donut",
            "Eclair",
            "FroYo",
            "GingerBread",
            "HoneyComb",
            "IceCreamSandwich",
            "JellyBean",
            "Kitkat",
            "Lolipop",
            "MarshMallow",
            "Noughat",
            "Oreo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        /*
        l1= (ListView) findViewById(R.id.listView);
        l2= (ListView) findViewById(R.id.listView2);
        l3= (ListView) findViewById(R.id.listView3);
        */

    }

    @Override
    public void onClick(View v) {
        ListView lis = (ListView) findViewById(R.id.listView);
        if (v.getId() == R.id.button) {
           
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, Students);
            lis.setAdapter(arrayAdapter);

        } else if (v.getId() == R.id.button2) {
            ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, games);
            lis.setAdapter(arrayAdapter3);

        } else if (v.getId() == R.id.button3) {
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, andr);
            lis.setAdapter(arrayAdapter2);

        }

    }
}
