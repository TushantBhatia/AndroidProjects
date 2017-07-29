package com.tushant.rvcheckbox;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<Student> studentArrayList = new ArrayList<>();

        studentArrayList.add(new Student("Hari",false));
        studentArrayList.add(new Student("Kashyap",false));
        studentArrayList.add(new Student("Amar",false));
        studentArrayList.add(new Student("Akmal",false));
        studentArrayList.add(new Student("Virat",false));
        studentArrayList.add(new Student("Sachin",false));
        studentArrayList.add(new Student("Umar",false));
        studentArrayList.add(new Student("Akhbar",false));
        studentArrayList.add(new Student("Ram",false));
        studentArrayList.add(new Student("Rajeev",false));

        StudentAdapter studentAdapter = new StudentAdapter(studentArrayList,this);
        recyclerView.setAdapter(studentAdapter);

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int n=0;
                int un=0;

                for (int i=0;i<studentArrayList.size();i++)
                {
                    Student s = studentArrayList.get(i);
                    if(s.getEnable())
                    {
                        n++;

                    }
                    else
                    {
                        un++;

                    }
                }
                Toast.makeText(getBaseContext(),"No of Checked: " + n , Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(),"No of Unchecked: " + un  ,Toast.LENGTH_SHORT).show();

            }
        });


    }
}
