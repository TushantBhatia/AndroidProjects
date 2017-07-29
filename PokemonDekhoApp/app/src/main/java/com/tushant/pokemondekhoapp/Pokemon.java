package com.tushant.pokemondekhoapp;

/**
 * Created by sanchal on 7/5/2017.
 */

public class Pokemon {
    String name,id,base_experience,height,weight;

    Sprites sprites;

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public Pokemon(String name, String id, String height, String weight, Sprites sprites) {
        this.name = name;
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.sprites= sprites;

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

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
