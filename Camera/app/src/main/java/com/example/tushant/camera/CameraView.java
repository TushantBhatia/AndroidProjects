package com.example.tushant.camera;

import android.content.Context;
import android.hardware.Camera;
import android.telecom.Call;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by Tushant on 7/21/2017.
 */

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
    Camera c;
    public CameraView(Context context,Camera camera) {
        super(context);
        this.c=camera;

        SurfaceHolder h = getHolder();
        h.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            c.setPreviewDisplay(surfaceHolder);
            c.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
       c.stopPreview();
        try {
            c.setPreviewDisplay(surfaceHolder);
            c.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
//   c.release();
    }
}
