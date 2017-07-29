package com.tushant.textbuttontext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<students> studentsArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentsArrayList.add(new students("Arun","13","pandora"));
        studentsArrayList.add(new students("Tushant","20","pandora"));
        studentsArrayList.add(new students("kunaal","21","pandora"));
        studentsArrayList.add(new students("varsha","19","pandora"));
        studentsArrayList.add(new students("kriti","18","pandora"));
        studentsArrayList.add(new students("manan","17","pandora"));
        studentsArrayList.add(new students("rishabh","20","pandora"));
        studentsArrayList.add(new students("Abhishek","20","pandora"));
        studentsArrayList.add(new students("Arun","13","pandora"));
        studentsArrayList.add(new students("Tushant","20","pandora"));
        studentsArrayList.add(new students("kunaal","21","pandora"));
        studentsArrayList.add(new students("varsha","19","pandora"));
        studentsArrayList.add(new students("kriti","18","pandora"));
        studentsArrayList.add(new students("manan","17","pandora"));
        studentsArrayList.add(new students("rishabh","20","pandora"));
        studentsArrayList.add(new students("Abhishek","20","pandora"));
        ListView studentslist= (ListView) findViewById(R.id.listview);
        //ArrayList studentsdetails= findViewById(R.id.stude)

        StudentsAdapter studentsAdapter=new StudentsAdapter(studentsArrayList,this);
        studentslist.setAdapter(studentsAdapter);

    }
}
