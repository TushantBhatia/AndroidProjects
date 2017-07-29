package com.example.tushant.jokerapp;

/**
 * Created by Tushant on 7/23/2017.
 */

public class Joke {
   Value value;

    public Joke(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
