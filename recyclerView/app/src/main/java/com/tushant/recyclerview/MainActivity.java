package com.tushant.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<students> studentsArrayList = new ArrayList<>();
        setContentView(R.layout.activity_main);
        studentsArrayList.add(new students("Arun","13","pandora"));
        studentsArrayList.add(new students("Tushant","20","pandora"));
        studentsArrayList.add(new students("kunaal","21","pandora"));
        studentsArrayList.add(new students("varsha","19","pandora"));
        studentsArrayList.add(new students("kriti","18","pandora"));
        studentsArrayList.add(new students("manan","17","pandora"));
        studentsArrayList.add(new students("rishabh","20","pandora"));
        studentsArrayList.add(new students("Abhishek","20","pandora"));
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        studentsAdapter StudentsAdapter= new studentsAdapter(studentsArrayList,this);
        recyclerView.setAdapter(StudentsAdapter);

    }
}
