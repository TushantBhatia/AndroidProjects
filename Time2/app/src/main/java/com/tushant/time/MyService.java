package com.tushant.time;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {

    public final String TAG= getClass().getSimpleName();
    @Override
    public void onCreate() {
        Log.e("TAG","onCreate : ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG","onStartCommand : ");
        //time();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //time();
            }
        });
        t.start();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
