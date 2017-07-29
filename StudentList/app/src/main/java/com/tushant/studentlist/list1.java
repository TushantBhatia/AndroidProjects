package com.tushant.studentlist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sanchal on 6/21/2017.
 */

public class list1 extends Fragment {
    String[] students= new String[]{
            "Tushant",
            "Kunaal",
            "Varsha",
            "kriti",
            "Nishtha",
            "Edwin",
            "Allen",
            "John",
            "Marcus",
            "Sniper",
            "SharpShooter",
            "Vaseline.wtf",
            "Manan"
    };
    ArrayList<students> studentsArrayList = new ArrayList<>();
    String[] msg={"Being deeply loved by someone gives you strength, while loving someone deeply gives you courage",
            "how can someone be so cruel and so obsessed that he forgets someone oin just a milliseconds of time",
            "India Lost",
            "sometimes its better to be quiet then to pretend your fake happiness",
            "Love is the second important thing of one's life ,first is money :p",
            "Fill your stomachs",
            "go get yourself some food bitch,these fuck boys ain't going to fill your stomach",
            "lets live freely"};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.list1,container,false);
        setContentView(R.layout.list1);
        ListView l =((ListView)v.findViewById(R.id.listView));
        super.onCreate(savedInstanceState);

        studentsArrayList.add(new students("Arun Garg","13 Hours Ago",msg[2]));
        studentsArrayList.add(new students("Tushant Bhatia","20 Hours Ago",msg[1]));
        studentsArrayList.add(new students("Nishtha Pathak","1 Day Ago",msg[7]));
        studentsArrayList.add(new students("Kunaal Arora","21 Hours Ago",msg[0]));
        studentsArrayList.add(new students("Varsha Khandelwal","19 Hours Ago",msg[2]));
        studentsArrayList.add(new students("Kriti Gupta","18 Hours Ago",msg[3]));
        studentsArrayList.add(new students("Manan Kwatra","17 Hours Ago",msg[4]));
        studentsArrayList.add(new students("Rishabh Srivastava","20 Hours Ago",msg[5]));
        studentsArrayList.add(new students("Abhishek Garg","20 Hours Ago",msg[6]));


        //ArrayList studentsdetails= findViewById(R.id.stude)

        StudentsAdapter studentsAdapter=new StudentsAdapter(studentsArrayList,this);
        studentslist.setAdapter(studentsAdapter);

    }



    /**
     * Created by sanchal on 6/16/2017.
     */

    public static class StudentsAdapter extends BaseAdapter {
        ArrayList<students> studentsArrayList;
        Context c;

        public StudentsAdapter(ArrayList<students> arrayList, Context context) {
            this.studentsArrayList=arrayList;
            this.c=context;
        }

        @Override
            public int getCount() {
                return studentsArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater l= LayoutInflater.from(c);
                View v;
                ViewHolder viewHolder;
                if (convertView == null) {
                    v = l.inflate(R.layout.list1, parent, false);
                    viewHolder =new ViewHolder();
                    viewHolder.name = (TextView) v.findViewById(R.id.name);
                    viewHolder.age = (TextView) v.findViewById(R.id.age);
                    viewHolder.course = (TextView) v.findViewById(R.id.course);
                    v.setTag(viewHolder);

                }
                else{
                    v = convertView;
                    viewHolder = (ViewHolder) v.getTag();
                }
                TextView name,age,course;


                course = (TextView) v.findViewById(R.id.course);
                students s= studentsArrayList.get(position);
                viewHolder.name.setText(s.getName());
                viewHolder.age.setText(s.getAge());
                int size=s.getCourse().length();
                if(size>50)
                {
                    viewHolder.course.setTextSize(18);
                }
                else
                {
                    viewHolder.course.setTextSize(30);

                }
                viewHolder.course.setText(s.getCourse());
                return v;
            }
            static class ViewHolder{
                TextView name,age,course;
            }
    }
}
