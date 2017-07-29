package com.tushant.pokemondekhoapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.tushant.pokemondekhoapp.R.id.search;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button,previous,next;
    TextView name,id,weight,height,base_experience;
    ImageView front_default;
    ImageButton launch;
    static int numprev=0;
    static int numnext=0;
    static int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OkHttpClient okHttpClient = new OkHttpClient();
        //editText= (EditText) findViewById(R.id.editText);
        //button = (Button) findViewById(R.id.button);

        name= (TextView) findViewById(R.id.name);
        id= (TextView) findViewById(R.id.rank);
        weight= (TextView) findViewById(R.id.weight);
        height= (TextView) findViewById(R.id.height);
        base_experience= (TextView) findViewById(R.id.base_experience);
        front_default = (ImageView) findViewById(R.id.image);
        launch = (ImageButton) findViewById(R.id.launch);

        final LinearLayout l = (LinearLayout) getLayoutInflater().inflate(R.layout.custom_dialog,null);
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Pokedex")
                .setView(l)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editText= l.findViewById(search);
                        //String s=editText.getText().toString();
                        String search=editText.getText().toString();
                        i=Integer.parseInt(search);
                        final Request request = new Request.Builder()
                                .url("https://pokeapi.co/api/v2/pokemon/" +i+"/")
                                .build();
                        okHttpClient.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                // Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                                // Log.e("TAG", "onFailure: " + call.request().url());

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String result = response.body().string();

                                Gson gson = new Gson();

                                final Pokemon poke =gson.fromJson(result, Pokemon.class);
                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        name.setText("NAME: "+poke.getName());
                                        id.setText("RANK: "+poke.getId());
                                        weight.setText("WEIGHT: "+poke.getWeight());
                                        height.setText("HEIGHT: "+poke.getHeight());
                                        base_experience.setText("XP: "+poke.getBase_experience());
                                        Picasso.with(MainActivity.this).load(poke.getSprites().front_default).into(front_default);
                                    }
                                });

                            }
                        });

                    }

                })
                .create();
        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                Log.e("Main", "onClick: "+i );


            }
        });


        previous= (Button) findViewById(R.id.previous);
        next= (Button) findViewById(R.id.next);


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //int number=i;
                //numprev++;
                //number=number-numprev;
                i++;
                final Request request = new Request.Builder()
                        .url("https://pokeapi.co/api/v2/pokemon/" +i+"/")
                        .build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        // Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                        // Log.e("TAG", "onFailure: " + call.request().url());

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result = response.body().string();

                        Gson gson = new Gson();

                        final Pokemon poke =gson.fromJson(result, Pokemon.class);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                name.setText("NAME: "+poke.getName());
                                id.setText("RANK: "+poke.getId());
                                weight.setText("WEIGHT: "+poke.getWeight());
                                height.setText("HEIGHT: "+poke.getHeight());
                                base_experience.setText("XP: "+poke.getBase_experience());
                                Picasso.with(MainActivity.this).load(poke.getSprites().front_default).into(front_default);
                            }
                        });

                    }
                });
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=Integer.parseInt(editText.getText().toString());
                numnext++;
                number=number+numnext;
                final Request request = new Request.Builder()
                        .url("https://pokeapi.co/api/v2/pokemon/" +number+"/")
                        .build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        // Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                        // Log.e("TAG", "onFailure: " + call.request().url());

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result = response.body().string();

                        Gson gson = new Gson();

                        final Pokemon poke = gson.fromJson(result, Pokemon.class);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                name.setText("NAME: " + poke.getName());
                                id.setText("RANK: " + poke.getId());
                                weight.setText("WEIGHT: " + poke.getWeight());
                                height.setText("HEIGHT: " + poke.getHeight());
                                base_experience.setText("XP: " + poke.getBase_experience());
                                Picasso.with(MainActivity.this).load(poke.getSprites().front_default).into(front_default);
                            }
                        });

                    }
                });
            }
        });

    }

}
