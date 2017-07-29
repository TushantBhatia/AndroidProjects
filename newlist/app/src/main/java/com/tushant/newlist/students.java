package com.tushant.newlist;

/**
 * Created by sanchal on 6/16/2017.
 */

public class students {
    String name;
    String age;
    String course;

    public students(String name, String age, String course) {
        this.name=name;
        this.age=age;
        this.course=course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }


    public void setCourse(String course) {
        this.course = course;
}
}
