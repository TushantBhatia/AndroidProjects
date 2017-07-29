package com.example.tushant.camera;

import android.hardware.Camera;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Camera c;
    TextView textView;
    Button button;
    String TAG="Main Activity";
    FrameLayout constraintLayout;
    CameraView cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void getCameraparams()
         {
        List<Camera.Size> pictureSizes=c.getParameters().getSupportedPictureSizes();

        for(Camera.Size s : pictureSizes){
            Log.d(TAG,"Picture width: "+s.width+ "  height: "+s.height);
        }
        List<Camera.Size> videoSizes=c.getParameters().getSupportedVideoSizes();
        for(Camera.Size s : videoSizes){
            Log.d(TAG,"Video width: "+s.width+ "  height: "+s.height);
        }
        List<Camera.Size> previewSizes=c.getParameters().getSupportedPreviewSizes();
        for(Camera.Size s : previewSizes){
            Log.d(TAG,"Preview width: "+s.width+ "  height: "+s.height);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        c=Camera.open();

        int currentOrientation = getWindowManager().getDefaultDisplay().getRotation();

        switch(currentOrientation)
        {
            case Surface.ROTATION_0:
                c.setDisplayOrientation(90);
                break;
            case Surface.ROTATION_90:
                c.setDisplayOrientation(0);
                break;
            case Surface.ROTATION_180:
                c.setDisplayOrientation(270);
                break;
            case Surface.ROTATION_270:
                c.setDisplayOrientation(180);
        }
        //c.setDisplayOrientation(90);
        constraintLayout = (FrameLayout) findViewById(R.id.container);

        cameraView = new CameraView(this,c);
        constraintLayout.addView(cameraView);

    }

    @Override
    protected void onStop() {
        super.onStop();
        c.release();
    }

    public void click(View view) {

        textView= (TextView) findViewById(R.id.msg);
        textView.setText("Shot On Coolpad \n By Tushant");
        button = (Button) findViewById(R.id.button);
        button.setVisibility(View.GONE);
        c.takePicture(null, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] bytes, Camera camera) {
                //raw
            }
        }, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] bytes, Camera camera) {
                //jpeg
            }
        });

    }
}
