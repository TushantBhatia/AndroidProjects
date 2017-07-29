package com.example.tushant.firebase;

/**
 * Created by Tushant on 7/19/2017.
 */

public class Todo {
    private String id;
    private String task,status;

    public Todo(String id, String task, String status) {
        this.id = id;
        this.task = task;
        this.status = status;
    }

    public Todo() {
    }

    public String getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getStatus() {
        return status;
    }
}
