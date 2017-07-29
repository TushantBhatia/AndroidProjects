package com.tushant.twittersearch;

import java.util.ArrayList;

/**
 * Created by sanchal on 7/7/2017.
 */

public class Tweet {
    ArrayList<Statuses> statuses;

    public Tweet(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }
}
