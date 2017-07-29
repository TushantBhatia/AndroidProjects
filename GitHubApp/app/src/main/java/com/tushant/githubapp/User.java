package com.tushant.githubapp;

/**
 * Created by sanchal on 7/5/2017.
 */

public class User {
    String name,id,url,profile;

    public User(String name, String id, String ur, String profile) {
        this.name = name;
        this.id = id;
        this.url = url;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
