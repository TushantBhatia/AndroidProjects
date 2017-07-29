package com.codingblocks.ultrabatterysaver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SaverActivity extends AppCompatActivity {

    ImageView chargingImage;
    TextView chargingText;
    LinearLayout linearLayout;
    private TextView batteryTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_saver);
        chargingImage = (ImageView) findViewById(R.id.chargingIcon);
        chargingText = (TextView) findViewById(R.id.chargingStatus);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        batteryTxt = (TextView) this.findViewById(R.id.batteryTxt);
        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        Intent i = getIntent();
        if (i.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            linearLayout.setBackgroundColor(Color.RED);
            chargingImage.setImageResource(R.drawable.discharge);
            chargingText.setText("DISCHARGING");
            chargingText.setTextColor(Color.RED);
            chargingText.setBackgroundColor(Color.BLACK);
        }else if (i.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            linearLayout.setBackgroundColor(Color.GREEN);
            chargingImage.setImageResource(R.drawable.charge);
            chargingText.setText("CHARGING");
            chargingText.setTextColor(Color.GREEN);
            chargingText.setBackgroundColor(Color.BLACK);

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            batteryTxt.setText("Battery Level : "+String.valueOf(level) + "%");
            batteryTxt.setBackgroundColor(Color.GRAY);
        }};
}