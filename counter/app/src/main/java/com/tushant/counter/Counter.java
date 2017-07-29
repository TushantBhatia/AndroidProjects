package com.tushant.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Counter extends AppCompatActivity {
    private Integer counter=0;
    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
            textview= (TextView) findViewById(R.id.textView);

    }

    public void increment(View view) {
        counter=counter+1;
        textview.setText(""+counter);
        Log.e("COUNTER", "increment: "+counter);


    }
}
