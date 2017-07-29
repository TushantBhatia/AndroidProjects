package com.tushant.newlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<students> studentsArrayList = new ArrayList<>();
    ArrayList<String> stringArrayList;
    String[] msg={"Being deeply loved by someone gives you strength, while loving someone deeply gives you courage",
    "how can someone be so cruel and so obsessed that he forgets someone oin just a milliseconds of time",
            "India Lost",
    "sometimes its better to be quiet then to pretend your fake happiness",
        "Love is the second important thing of one's life ,first is money :p",
            "Fill your stomachs",
        "go get yourself some food bitch,these fuck boys ain't going to fill your stomach",
    "lets live freely"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentsArrayList.add(new students("Arun Garg","13 Hours Ago",msg[2]));
        studentsArrayList.add(new students("Tushant Bhatia","20 Hours Ago",msg[1]));
        studentsArrayList.add(new students("Nishtha Pathak","1 Day Ago",msg[7]));
        studentsArrayList.add(new students("Kunaal Arora","21 Hours Ago",msg[0]));
        studentsArrayList.add(new students("Varsha Khandelwal","19 Hours Ago",msg[2]));
        studentsArrayList.add(new students("Kriti Gupta","18 Hours Ago",msg[3]));
        studentsArrayList.add(new students("Manan Kwatra","17 Hours Ago",msg[4]));
        studentsArrayList.add(new students("Rishabh Srivastava","20 Hours Ago",msg[5]));
        studentsArrayList.add(new students("Abhishek Garg","20 Hours Ago",msg[6]));
        stringArrayList.add("Arun");
        stringArrayList.add("Tushant");
        stringArrayList.add("Nishtha");
        stringArrayList.add("Kunaal");
        stringArrayList.add("Varsha");
        ListView studentslist= (ListView) findViewById(R.id.listview);
        //ArrayList studentsdetails= findViewById(R.id.stude)
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,
                stringArrayList);
       // StudentsAdapter studentsAdapter=new StudentsAdapter(studentsArrayList,this);
        studentslist.setAdapter(arrayAdapter);
        studentslist.setOnItemClickListener();
        FrameLayout frameLayout=(FrameLayout)findViewById(R.id.containerFragment);
        studentslist.setOnItemClickListener(new ;
    }
}

