package com.tushant.whatsapplayout;

/**
 * Created by sanchal on 6/25/2017.
 */

public class Chat {
    String name,messgae,time;

    public Chat(String name, String messgae, String time) {
        this.name = name;
        this.messgae = messgae;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
