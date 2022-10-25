package com.fgarzon.appgent.models;

import java.io.Serializable;

public class Profile implements Serializable {

    private int id;
    private String name;

    public Profile() {}

    public Profile(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
