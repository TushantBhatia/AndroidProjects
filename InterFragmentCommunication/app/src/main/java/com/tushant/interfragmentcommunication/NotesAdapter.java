package com.tushant.interfragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sanchal on 6/28/2017.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {
    ArrayList<Notes> noteArrayList = new ArrayList<>();
    public NotesAdapter(ArrayList<Notes> chatArrayList) {
        this.noteArrayList = chatArrayList;

    }

    @Override
    public NotesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_notes,parent,false);
        return new NotesHolder(v);

    }

    @Override
    public void onBindViewHolder(NotesHolder holder, int position) {
        Notes c = noteArrayList.get(position);
        holder.note.setText(c.getNote());


    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public class NotesHolder extends RecyclerView.ViewHolder {
        TextView note;
        public NotesHolder(View itemView) {
            super(itemView);
            note = (TextView) itemView.findViewById(R.id.note);

        }
    }
}
