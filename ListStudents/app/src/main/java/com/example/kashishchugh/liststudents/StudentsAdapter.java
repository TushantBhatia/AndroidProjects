package com.example.kashishchugh.liststudents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsAdapter extends BaseAdapter {

    ArrayList<Students> studentsArrayList;
    Context c;

    public StudentsAdapter(ArrayList<Students> studentsArrayList, Context c) {
        this.studentsArrayList = studentsArrayList;
        this.c = c;
    }

    @Override
    public int getCount() {
        return studentsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater l=LayoutInflater.from(c);
        View v;
        ViewHolder viewHolder;

        if (view==null){
            v=l.inflate(R.layout.single_list_layout,viewGroup,false);
            viewHolder =new ViewHolder();
            viewHolder.name=(TextView) v.findViewById(R.id.namelist);
            v.setTag(viewHolder);
        }
        else {
            v=view;
            viewHolder= (ViewHolder) v.getTag();
        }
        TextView name,age,course;
        Students s=studentsArrayList.get(i);
        viewHolder.name.setText(s.getName());
        return v;
    }

    static class ViewHolder{
        TextView name;
    }
}
