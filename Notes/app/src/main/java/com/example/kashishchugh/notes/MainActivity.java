package com.example.kashishchugh.notes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ArrayList<Notes> notesArrayList;
    NotesAdapter notesAdapter;
    RecyclerView recyclerView;
    Gson gson = new Gson();

    @Override
    protected void onPause() {
        super.onPause();
        String jsonString = gson.toJson(notesArrayList);
        editor.putString("KEY", jsonString).apply();
    }

    @Override
    protected void onStart() {
        super.onStart();
        String empty_list = gson.toJson(new ArrayList<Notes>());

        ArrayList<Notes> mSelectedList = gson.fromJson(sharedPreferences.getString("KEY", empty_list),
                new TypeToken<ArrayList<Notes>>() {
                }.getType());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=getPreferences(MODE_PRIVATE);
        editor=sharedPreferences.edit();

        recyclerView= (RecyclerView) findViewById(R.id.recycler);
        notesArrayList=new ArrayList<>();

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        notesAdapter=new NotesAdapter(notesArrayList);
        recyclerView.setAdapter(notesAdapter);

        final EditText editText= (EditText) findViewById(R.id.edittext);
        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String s = editText.getText().toString();
                    if (!(s.isEmpty())){
                    notesArrayList.add(new Notes(s, false));
                    editText.setText("");}
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                catch (Exception e){}
            }
        });

        Button del= (Button) findViewById(R.id.delete);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int i=0;i<notesArrayList.size();i++
//                int i = questionList.getCount() - 1; i >= 0; i--
                for (int i = (notesArrayList.size()-1); i >= 0; i--){
                    if (notesArrayList.get(i).isChecked()){
                        notesArrayList.remove(notesArrayList.get(i));
                        //notesArrayList.get(i).setChecked(false);
                        notesAdapter.notifyItemRemoved(i);
                        notesAdapter.notifyItemRangeChanged(i,notesArrayList.size());
                    }
                }

                notesAdapter.notifyDataSetChanged();

//                for (int i=0;i<notesArrayList.size();i++){
//                    if (notesArrayList.get(i).isChecked())
//                    notesArrayList.get(i).setChecked(false);
//                }

                //notifyItemRemoved(position);
                //notifyItemRangeChanged(position, mDataSet.size());

            }
        });

    }
}
