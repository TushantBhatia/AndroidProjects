package com.tushant.files;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String TAG="Main Activity";
    EditText etFileName,etFileContent;
    TextView tvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFileName = (EditText) findViewById(R.id.etFileName);

        etFileContent = (EditText) findViewById(R.id.etFileContent);

        tvContent = (TextView) findViewById(R.id.tvContent);


        File filesDir=getFilesDir();

        File cacheDir = getCacheDir();

        File externalFilesDir= getExternalFilesDir(null);

        File externalMusicDirectory = getExternalFilesDir(Environment.DIRECTORY_MUSIC);

        File externalCacheDir = getExternalCacheDir();

        File externalStorageDir = Environment.getExternalStorageDirectory();



        try {
            Log.d(TAG, "onCreate: filesdir: "+filesDir.getCanonicalPath());
            Log.d(TAG, "onCreate: cachedir: "+cacheDir.getCanonicalPath());
            Log.d(TAG, "onCreate: externalfilesdir: "+externalFilesDir.getCanonicalPath());
            Log.d(TAG, "onCreate: externalmusicdir: "+externalMusicDirectory.getCanonicalPath());
            Log.d(TAG, "onCreate: externalcache: "+externalCacheDir.getCanonicalPath());
            Log.d(TAG, "onCreate: externalstoragedir: "+externalStorageDir.getCanonicalPath());

        } catch (IOException e) {
            e.printStackTrace();
        }}



        public void writeToInternal(View view) {


            int permissionResult= ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if(permissionResult== PackageManager.PERMISSION_GRANTED) {
                String fileName = etFileName.getText().toString();
                String fileContent = etFileContent.getText().toString();


                File f = new File(Environment.getExternalStorageDirectory(), fileName);
                try {
                    FileOutputStream fos = new FileOutputStream(f, true);
                    fos.write(fileContent.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},12);
            }
        }

        public void readFromInternal(View view) {
            String fileName = etFileName.getText().toString();
            StringBuilder stringBuilder = new StringBuilder();

            File f = new File(Environment.getExternalStorageDirectory(), fileName);
            try {
                FileInputStream fis =new FileInputStream(f);
                int currChar;
                while((currChar=fis.read())!=-1)
                {
                    stringBuilder.append((char)currChar);

                }
                tvContent.setText(stringBuilder);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==12){
            if(permissions[0].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                String fileName = etFileName.getText().toString();
                String fileContent = etFileContent.getText().toString();


                File f = new File(Environment.getExternalStorageDirectory(), fileName);
                try {
                    FileOutputStream fos = new FileOutputStream(f, true);
                    fos.write(fileContent.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
