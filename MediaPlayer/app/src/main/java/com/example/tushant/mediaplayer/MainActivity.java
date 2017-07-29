package com.example.tushant.mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri uri= Uri.parse("https://raw.githubusercontent.com/the-dagger/sample-media/master/audio.mp3");
        // Uri uri= Uri.parse("android.resource://com.example.tushant.mediaplayer/"+R.raw.audi);
        mp=new MediaPlayer();
        //mp=MediaPlayer.create(this, Uri.parse("https://raw.githubusercontent.com/the-dagger/sample-media/master/audio.mp3"));
       // mp = MediaPlayer.create(this,R.raw.audi);
        //mp = MediaPlayer.create(this,uri);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mp.setDataSource(this,uri);
            mp.prepareAsync();

            final ProgressBar pb=(ProgressBar) findViewById(R.id.progressBar);
            pb.setVisibility(View.VISIBLE);
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    pb.setVisibility(View.GONE);
                    mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
      //  mp.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.release();
    }
}
