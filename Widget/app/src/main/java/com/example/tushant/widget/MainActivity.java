package com.example.tushant.widget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.mainActivity);
        Intent intent =getIntent();
        if (intent.getAction().equals("android.appwidget.action.APPWIDGET_UPDATE"))
        {
            textView.setText(""+intent.getIntExtra("VALUE",0));
        }

    }
}
