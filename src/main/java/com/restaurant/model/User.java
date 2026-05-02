package com.restaurant.model;
import java.io.Serializable;

public class User implements Serializable {

    protected int id;
    protected String name;
    protected String username;
    protected String password;
    protected String role;

    public User(int id, String name, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}