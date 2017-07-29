package com.example.kashishchugh.liststudents;

/**
 * Created by kashish chugh on 21-Jun-17.
 */

public class Students {
    String name;
    String age;
    String course;

    public Students(String name, String age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }
}
