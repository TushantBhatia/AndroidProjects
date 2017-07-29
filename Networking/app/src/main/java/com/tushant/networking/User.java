package com.tushant.networking;

/**
 * Created by sanchal on 7/2/2017.
 */

public class User {
    String id,useId,title,body;

    public User(String name, String useId, String title, String body) {
        this.id = id;
        this.useId = useId;
        this.title = title;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.id = name;
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
