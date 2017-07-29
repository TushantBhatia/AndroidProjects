package com.tushant.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        textView = (TextView) findViewById(R.id.textview);

        Button b= new Button(this);
        b.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        b.setText("Intent");
        linearLayout.addView(b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<3;i++){
                            long currTime=System.currentTimeMillis();
                            while(System.currentTimeMillis() - currTime <1000);
                        }
                        textView.setText("10 Seconds have passed");
                    }
                });
//                Intent intent = new Intent();
//                intent.setAction("my_custom_action");
//                intent.putExtra("key","Notice me Senpai");
//
//                sendBroadcast(intent);

            }
        });
        IntentFilter intentFilter = new IntentFilter();
   //     intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
     //   intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        MyNewReciever myNewReciever = new MyNewReciever();
        registerReceiver(myNewReciever,intentFilter);

    }

    class MyNewReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
            textView = (TextView) findViewById(R.id.textview);
            if (intent.getAction()==Intent.ACTION_POWER_CONNECTED){
                linearLayout.setBackgroundColor(Color.GREEN);
                textView.setText("CHARGING");
               // startActivity(intent);
            }
            else if (intent.getAction() == Intent.ACTION_POWER_DISCONNECTED){
                linearLayout.setBackgroundColor(Color.RED);
                textView.setText("CHARGER DISCONNECTED");

              //  intent.setAction(intent.ACTION_POWER_USAGE_SUMMARY);
             //   startActivity(intent);
            }
        }
    }
}
