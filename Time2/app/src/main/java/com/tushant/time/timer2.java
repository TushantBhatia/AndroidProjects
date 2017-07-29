package com.tushant.time;

/**
 * Created by sanchal on 6/29/2017.
 */

public class timer2 {
    int duration;

    public timer2(int duration) {
        this.duration = duration;
    }

    public void setOnTickListener(OnTickListener l) {
        listener l;
    }

    public void start() {
        for (int i = 0; i < duration; i++) {
            long currTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - currTime < 1000) ;
            listener.onTick(i);
        }
    }
}
//
//    public void setOnTickListener( new OnTickListener{
//
//        @Override
//                public void onTick(int secondsPassed){
//
//        }
//    });
//    t.start();

