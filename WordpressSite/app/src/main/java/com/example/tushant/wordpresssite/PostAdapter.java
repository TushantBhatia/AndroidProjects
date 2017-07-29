package com.example.tushant.wordpresssite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Tushant on 7/28/2017.
 */

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.Viewholder>  {


    @Override
    public PostAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list,parent,false));
    }

    @Override
    public void onBindViewHolder(PostAdapter.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView note;

        public Viewholder(View itemView) {
            super(itemView);
            note= (TextView) itemView.findViewById(R.id.);
        }

    }
}
