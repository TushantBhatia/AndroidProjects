package com.tushant.frags;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileDescriptor;
import java.io.PrintWriter;

import static com.tushant.frags.R.id.container;

public class MainActivity extends AppCompatActivity {
int r,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        Button blue = (Button) findViewById(R.id.blue);
        Button green = (Button) findViewById(R.id.green);

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container,Frags1.newInstance(r++));
                transaction.commit();
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.container,Frags2.newInstance(b++));
                transaction.commit();
            }
        });

    }
}
