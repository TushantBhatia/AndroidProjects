package com.tushant.rvcheckbox;

/**
 * Created by sanchal on 6/19/2017.
 */

public class Student {
    String name;
    Boolean enable;

    public Student(String name, Boolean enable) {
        this.name = name;
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
