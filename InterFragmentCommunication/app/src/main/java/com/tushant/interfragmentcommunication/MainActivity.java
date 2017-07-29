package com.tushant.interfragmentcommunication;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void addText(String Text) {

        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.FragB);
        FragmentB fragmentB1 = (FragmentB) fragmentB;
        fragmentB1.addText(Text);

    }
}
