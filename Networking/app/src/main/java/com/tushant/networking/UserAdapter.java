package com.tushant.networking;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sanchal on 7/2/2017.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    ArrayList<User> userArrayList = new ArrayList<User>();
    Context c;
    public UserAdapter(ArrayList<User> userArrayList,Context context) {
        this.userArrayList = userArrayList;
        this.c = context;
         }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l= LayoutInflater.from(c);
        View v= l.inflate(R.layout.single_user_item,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User u=userArrayList.get(position);
        holder.id.setText("id: "+u.getId());
        holder.userID.setText("userID: "+u.getUseId());
        holder.title.setText("Title: "+u.getTitle());
        holder.body.setText("Body: "+u.getBody()+ "\n");

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView id,userID,title,body;
        public ViewHolder(View itemView) {
            super(itemView);
            id=  itemView.findViewById(R.id.id);
            userID =  itemView.findViewById(R.id.userID);
            title =  itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }


}
