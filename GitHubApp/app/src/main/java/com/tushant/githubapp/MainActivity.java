package com.tushant.githubapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    ArrayList<User> userArrayList=new ArrayList<>();
    String result;
    public String search;
    final UserAdapter userAdapter = new UserAdapter(userArrayList,this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search = editText.getText().toString();
                //Log.e("MainActivity", "onClick: "+search );
                final MyAsyncTask myAsyncTask = new MyAsyncTask();
                String a =("https://api.github.com/search/users?q="+search);
                myAsyncTask.execute(a);

            }
        });
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Log.e("MainActivity", "onCreate: Adapter Set" );
        recyclerView.setAdapter(userAdapter);

    }
    class MyAsyncTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please Wait!!");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.hide();
            try{
                JSONObject object=new JSONObject(s);
                JSONArray jsonArray = new JSONArray("items");
                int b=object.getInt("total_count");
                for(int i=0;i<b;i++){
                    JSONObject currentObject = jsonArray.getJSONObject(i);
                    String name = currentObject.getString("login");
                    String id=currentObject.getString("avatar_url");
                    String url=currentObject.getString("url");
                    String profile=currentObject.getString("events_url");
                    Log.e("Main ACtivity", "onPostExecute: "+name );
                    userArrayList.add(new User("Name: "+name,"Avatar_url"+id,"URL: "+url,"Profile"+profile));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        protected String doInBackground(String... strings) {
            String url1 = strings[0];

            try {
                URL url = new URL(url1);
                //Create a URL Connection
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                //Set the request method (POST or GET)
                httpURLConnection.setRequestMethod("GET");
                //Set Read timeout
                httpURLConnection.setReadTimeout(3000);
                //Set Connection timeout
                httpURLConnection.setConnectTimeout(5000);
                //Connect
                httpURLConnection.connect();

                //Throw an exception if the response was not 200
                if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new IOException("HTTP error code" + httpURLConnection.getResponseCode());
                }

                //Read the data as InputStread from response
                InputStream inputStream = httpURLConnection.getInputStream();

                //Convert the byteArray into characterStream and stores to the disk
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                //Create a BufferedReader from the InputStream which stores the result to a memory, resulting in faster I/O
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                //Create a StringBuilder to store the result
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                //Read the input and stroe it to StringBuilder line by line
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                //Save the result to a string
                result = stringBuilder.toString();
                Log.e("MainActivity", "doInBackground: "+result );
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
