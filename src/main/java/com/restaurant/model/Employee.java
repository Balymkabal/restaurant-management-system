package com.restaurant.model;

public abstract class Employee extends User {

    public Employee(int id, String name, String username, String password, String role) {
        super(id, name, username, password, role);
    }

    public abstract void dashboard();
}
