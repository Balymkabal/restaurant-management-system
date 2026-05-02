package com.restaurant.model;

public class Waiter extends Employee {

    public Waiter(int id, String name, String username, String password) {
        super(id, name, username, password, "WAITER");
    }

    public void takeOrder() {
        System.out.println("Waiter takes order");
    }

    @Override
    public void dashboard() {
        System.out.println("Waiter dashboard opened");
    }
}