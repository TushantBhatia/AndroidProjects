package com.example.kashishchugh.liststudents;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kashishchugh.liststudents.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Students> studentsArrayList=new ArrayList<>();
        studentsArrayList.add(new Students("Sachin","18","Pandora"));
        studentsArrayList.add(new Students("Yuvraj","20","Pandora"));
        studentsArrayList.add(new Students("Virat","19","Pandora"));
        studentsArrayList.add(new Students("Dhoni","21","Pandora"));
        studentsArrayList.add(new Students("Rohit","13","Pandora"));
        studentsArrayList.add(new Students("Shikhar","13","Pandora"));
        studentsArrayList.add(new Students("Ajinkya","13","Pandora"));
        studentsArrayList.add(new Students("Hardik","13","Pandora"));
        studentsArrayList.add(new Students("Kedar","13","Pandora"));
        studentsArrayList.add(new Students("Ravindra","13","Pandora"));
        studentsArrayList.add(new Students("Ravi","13","Pandora"));
        studentsArrayList.add(new Students("Bhuvaneshwar","13","Pandora"));
        studentsArrayList.add(new Students("Japrit","13","Pandora"));
        studentsArrayList.add(new Students("Rahul","13","Pandora"));
        studentsArrayList.add(new Students("Laxman","13","Pandora"));
        studentsArrayList.add(new Students("Saurav","13","Pandora"));
        studentsArrayList.add(new Students("Virender","13","Pandora"));
        studentsArrayList.add(new Students("Anil","13","Pandora"));
        studentsArrayList.add(new Students("Harbhajan","13","Pandora"));
        studentsArrayList.add(new Students("Zaheer","13","Pandora"));
        studentsArrayList.add(new Students("Ashish ","13","Pandora"));
        ListView listView= (ListView) findViewById(R.id.recycler);
        final StudentsAdapter studentsAdapter=new StudentsAdapter(studentsArrayList,this);
        listView.setAdapter(studentsAdapter);

        final FragmentA fragmentA=new FragmentA();
        final FragmentManager fragmentManager=getFragmentManager();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.container,FragmentA.newInstance(studentsArrayList.get(i).getName(),studentsArrayList.get(i).getAge(),studentsArrayList.get(i).getCourse()));
                transaction.commit();
            }
        });

    }
}
