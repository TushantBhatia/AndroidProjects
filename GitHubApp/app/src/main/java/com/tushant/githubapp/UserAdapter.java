package com.tushant.githubapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sanchal on 7/5/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    ArrayList<User> userArrayList = new ArrayList<User>();
    Context c;
    public UserAdapter(ArrayList<User> userArrayList,Context context) {
        this.userArrayList = userArrayList;
        this.c = context;
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
        User u=userArrayList.get(position);
        holder.id.setText("id: "+u.getId());
        holder.name.setText("userID: "+u.getName());
        holder.url.setText("Body: "+u.getUrl());
        holder.profile.setText("Profile"+u.getProfile());

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,id,profile,url;
        public ViewHolder(View itemView) {
            super(itemView);
            name=  itemView.findViewById(R.id.name);
            id =  itemView.findViewById(R.id.id);
            url =  itemView.findViewById(R.id.url);
            profile = itemView.findViewById(R.id.profile);
        }
    }



}
