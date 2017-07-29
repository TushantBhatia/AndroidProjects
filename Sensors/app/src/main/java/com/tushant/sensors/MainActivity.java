package com.tushant.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventCallback;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    String TAG="Activity";
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

       Sensor accel=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

//        List<Sensor> sensorList=sensorManager.getDefaultSensor(SensorManager.SENSOR_STATUS_NO_CONTACT)
//
//        for
//        Log.e(TAG, "onCreate: NAME: "+accel.getName());
//        Log.e(TAG, "onCreate: VERSION: "+accel.getVersion());
//        Log.e(TAG, "onCreate: RANGE: "+accel.getMaximumRange());
//        Log.e(TAG, "onCreate: TYPE: "+accel.getType());
//        Log.e(TAG, "onCreate: POWER: "+accel.getPower());
//        Log.e(TAG, "onCreate: VENDOR: "+accel.getVendor());
//
        final LinearLayout l= (LinearLayout) findViewById(R.id.back);
        sensorManager.registerListener(new SensorEventCallback() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.d(TAG, "onSensorChanged: accel in x: "+sensorEvent.values[0]);
                Log.d(TAG, "onSensorChanged: accel in y: "+sensorEvent.values[1]);
                int r= (int) ((Math.abs(sensorEvent.values[0])*255)/11);
                int g= (int) ((Math.abs(sensorEvent.values[1])*255)/11);
                int b= (int) ((Math.abs(sensorEvent.values[2])*255)/11);

                l.setBackgroundColor(Color.rgb(r,g,b));


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                super.onAccuracyChanged(sensor, accuracy);
            }
        },accel,1000000);


    }
}
