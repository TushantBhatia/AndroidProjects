package com.example.tushant.mediaplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        final VideoView vv= (VideoView) findViewById(R.id.videoView);
        //Uri uri= Uri.parse("android.resource://com.example.tushant.mediaplayer/"+R.raw.video);
        //vv.setVideoURI(uri);

        vv.setVideoPath("https://raw.githubusercontent.com/the-dagger/sample-media/master/video.mp4");
        MediaController mediaController=new MediaController(this);
      //  mediaController.setPrevNextListeners(new View.OnClickListener() {
      ///      @Override
            //public void onClick(View v) {
               // vv.getCurrentPosition();
//            }, new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//            }}
    //    }});
        vv.setMediaController(mediaController);
        vv.start();
    }
}
