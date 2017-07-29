package com.example.kashishchugh.notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kashish chugh on 26-Jun-17.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.Viewholder> {

    ArrayList<Notes> notesArrayList;

    public NotesAdapter(ArrayList<Notes> notesArrayList) {
        this.notesArrayList = notesArrayList;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list,parent,false));
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        final Notes notes=notesArrayList.get(position);
        holder.note.setText(notes.getNote());
        holder.isChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                notes.setChecked(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView note;
        CheckBox isChecked;


        public Viewholder(View itemView) {
            super(itemView);
            note= (TextView) itemView.findViewById(R.id.textview);
            isChecked= (CheckBox) itemView.findViewById(R.id.check);
        }

    }


}
