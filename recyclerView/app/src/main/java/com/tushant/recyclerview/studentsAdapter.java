package com.tushant.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by sanchal on 6/16/2017.
 */

public class studentsAdapter extends RecyclerView.Adapter<studentsAdapter.ViewHolder> {
    ArrayList<students> arrayList = new ArrayList<students>();
    Context c;

    public studentsAdapter(ArrayList<students> arrayList, Context c) {
        this.arrayList = arrayList;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l= LayoutInflater.from(c);
        View v= l.inflate(R.layout.single_list_item,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        students s=arrayList.get(position);
        holder.name.setText(s.getName());
        holder.age.setText(s.getAge());
        holder.course.setText(s.getCourse());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,age,course;
        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            age = (TextView) itemView.findViewById(R.id.age);
            course = (TextView) itemView.findViewById(R.id.course);
        }
    }
}
