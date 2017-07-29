package com.tushant.time;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService2 extends IntentService {
    //public final String TAG = getClass().getSimpleName();
    public MyService2(String name) {
        super("MyServices2");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        time();
        NotificationCompat notification = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){

            PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(),
                    123,new Intent(getBaseContext(),MainActivity.class),
                    PendingIntent.FLAG_CANCEL_CURRENT);
            NotificationCompat.Action action= new NotificationCompat.Action.Builder(android.R.drawable.ic_menu_send,
                    "Send",
                    pendingIntent).build();

            notification = new Notification.Builder(getBaseContext())
                    .setContentTitle("TITLE")
                    .setContentText("Description")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pendingIntent)
                    .addAction(android.R.drawable.ic_menu_call,"Call",pendingIntent)
                    .addAction(action)
                    .build();


        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }

    public void time(){
        for(int i=0;i<10;i++){
            timer();
            Log.e("TAG"," Timer:"+ i);

        }}
    public void timer(){
        long currentTime=System.currentTimeMillis();
        while(System.currentTimeMillis()-currentTime<1000);

    }

}
