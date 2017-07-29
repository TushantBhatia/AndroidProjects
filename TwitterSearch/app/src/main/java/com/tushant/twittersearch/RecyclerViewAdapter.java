package com.tushant.twittersearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sanchal on 7/7/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {
    ArrayList<Statuses> status1;
    private Context context;

    public RecyclerViewAdapter(ArrayList<Statuses> status1) {
        this.status1 = status1;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_list,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Statuses status=status1.get(position);

        Gson gson=new Gson();
        Picasso.with(context)
                .load(status.getUser().getProfile_image_url_https())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(holder.profile_name_url_https);
        holder.screen_name.setText(status.getUser().getScreen_name());
        holder.user_id.setText(status.getUser().getUser_id());
        holder.text.setText(status.getText());
        holder.link.setText(status.getLink());

    }

    @Override
    public int getItemCount() {
        if (status1 != null)
            return status1.size();
        else
            return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView screen_name,user_id,text,link;
        ImageView profile_name_url_https;

        public MyHolder(View itemView) {
            super(itemView);
            screen_name = (TextView) itemView.findViewById(R.id.username);
            user_id= (TextView) itemView.findViewById(R.id.id);
            text= (TextView) itemView.findViewById(R.id.tweet);
            link= (TextView) itemView.findViewById(R.id.url);
            profile_name_url_https = (ImageView) itemView.findViewById(R.id.avatar);
        }
    }
}
