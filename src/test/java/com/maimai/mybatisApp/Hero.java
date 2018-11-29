package com.maimai.mybatisApp;

/**
 * Created by maimai on 2018-05-24.
 */
public class Hero {
    private String name;

    public Hero() {
    }

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
}
