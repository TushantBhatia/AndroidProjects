package com.tushant.interfragmentcommunication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sanchal on 6/28/2017.
 */

public class FragmentB extends Fragment {
    TextView textView;
    String text;
    ArrayList<Notes> notesArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.single_item_notes,container);
        textView = (TextView) v.findViewById(R.id.note);

        if (savedInstanceState != null && savedInstanceState.containsKey("KEY"))
        {
            String s= savedInstanceState.getString("KEY");
            textView.setText(s);
       }
//        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.notesRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        NotesAdapter notesAdapter = new NotesAdapter(notesArrayList);
//        recyclerView.setAdapter(notesAdapter);
        return v;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY",text);
    }

    public void addText(String Text){
        this.text = Text;
        notesArrayList.add(new Notes(this.text));
        textView.setText(Text);
 }
}

