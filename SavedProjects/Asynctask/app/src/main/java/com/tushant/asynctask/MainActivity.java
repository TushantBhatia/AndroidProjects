package com.tushant.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    TextView textView;
    Button button;
    MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute("https://jsonplaceholder.typicode.com/posts");

            }
        });
    }

//    public Void parseJson(String s){
//        try {
//            JSONArray jsonArray = new JSONArray(s);
//            for (int i=0;i<jsonArray.length(); i++){
//                JSONObject currentObject = jsonArray.getJSONObject(i);
////                String userID = currentObject.getString("userId");
////                String id= currentObject.getString("id");
////                String title = currentObject.getString("title");
////                String body = currentObject.getString("body");
////                parseJson(s).add(new User(userID,id,title,body));
//                Log.e("Main Activity","User id: "+s);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//            Log.e("Main Activity","catch: json is invalid");
//        }
//        return parseJson(s);
//    }

    class MyAsyncTask extends AsyncTask<String,Integer,String>{
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please Wait");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Integer receivedProgress = values[0];
            progressDialog.setMessage(receivedProgress + "  Seconds have passed");
        }


        @Override
        protected String doInBackground(String... params) {
            String result = "";
            String url1=params[0];
            try {
                URL url=new URL(url1);
              //  URL url = new URL("");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(3000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();

                if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new IOException("HTTP error code" + httpURLConnection.getResponseCode());
                }
                InputStream inputStream = httpURLConnection.getInputStream();

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder stringBuilder = new StringBuilder();

                String line;


                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                result = stringBuilder.toString();

                Log.e("Result","Result: "+result);
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(String string) {
            super.onPostExecute(string);
            progressDialog.hide();
            try {
                JSONArray jsonArray = new JSONArray(string);
                for (int i=0;i<jsonArray.length(); i++){
                    JSONObject currentObject = jsonArray.getJSONObject(i);
                    String userID = currentObject.getString("userId");
                    Log.e("Activity","onCreate: "+userID);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("Main Activity","onCreate: json is invalid");
            }
            //textView.setText(string);
            //progressDialog.hide();
        }


    }
}
