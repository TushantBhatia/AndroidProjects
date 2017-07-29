package com.tushant.whatsapplayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sanchal on 6/25/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {
    ArrayList<Chat> chatArrayList = new ArrayList<>();
    public ChatAdapter(ArrayList<Chat> chatArrayList) {
        this.chatArrayList = chatArrayList;

    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_chat,parent,false);
        return new ChatHolder(v);
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {
        Chat c = chatArrayList.get(position);
        holder.name.setText(c.getName());
        holder.message.setText(c.getMessgae());
        holder.time.setText(c.getTime());

    }

    @Override
    public int getItemCount() {
        return chatArrayList.size();
    }

    class ChatHolder extends RecyclerView.ViewHolder{
        TextView name,message,time;

        public ChatHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            message =(TextView) itemView.findViewById(R.id.message);
            time = (TextView) itemView.findViewById(R.id.time);
        }
    }
}
