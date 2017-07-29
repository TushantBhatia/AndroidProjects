package com.tushant.twittersearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://api.github.com/search/users?q=";
    ArrayList<Statuses> statusArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final OkHttpClient okHttpClient = new OkHttpClient();
        final EditText editText = (EditText) findViewById(R.id.editTextName);
        Button button = (Button) findViewById(R.id.buttonSearch);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        final RecyclerViewAdapter recylerViewAdapter = new RecyclerViewAdapter(statusArrayList);
        recyclerView.setAdapter(recylerViewAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();


                final Request request = new Request.Builder()
                        .url("http://loklak.org/api/search.json?q=" + userName)
                        .build();


                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                        Log.e("TAG", "onFailure: " + call.request().url());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result = response.body().string();

                        Gson gson = new Gson();

                        final Tweet status = gson.fromJson(result, Tweet.class);

                        Log.e("TAG", "onResponse: " + status.getStatuses().size());

                        //Notify the adapter for data changes on the UI thread

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                statusArrayList.addAll(status.getStatuses());
                                recylerViewAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
            }
        });


    }
}
