package com.tushant.newlist;

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

import com.tushant.newlist.R;
import com.tushant.newlist.students;

import java.util.ArrayList;

/**
 * Created by sanchal on 6/16/2017.
 */
public class StudentsAdapter extends BaseAdapter {
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
            v = l.inflate(R.layout.list_single_student, parent, false);
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
        viewHolder.course.setTextSize(30);

        viewHolder.course.setText(s.getCourse());
        return v;
    }
    static class ViewHolder{
        TextView name,age,course;
    }
}

