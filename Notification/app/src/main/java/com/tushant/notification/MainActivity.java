package com.tushant.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notification notification = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(),
                    123, new Intent(getBaseContext(), MainActivity.class),
                    PendingIntent.FLAG_CANCEL_CURRENT);
            NotificationCompat.Action action = new NotificationCompat.Action.Builder(android.R.drawable.ic_menu_send,
                    "Send",
                    pendingIntent).build();

            notification = new NotificationCompat.Builder(getBaseContext())
                    .setContentTitle("TITLE")
                    .setContentText("Description")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pendingIntent)
                    .addAction(android.R.drawable.ic_menu_call, "Call", pendingIntent)
                    .addAction(action)
                    .build();
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}
