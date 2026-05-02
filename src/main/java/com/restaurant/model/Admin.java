package com.restaurant.model;

public class Admin extends Employee {

    public Admin(int id, String name, String username, String password) {
        super(id, name, username, password, "ADMIN");
    }

    public void manageUsers() {
        System.out.println("Admin is managing users");
    }

    public void manageMenu() {
        System.out.println("Admin is managing menu");
    }

    @Override
    public void dashboard() {
        System.out.println("Admin dashboard opened");
    }
}