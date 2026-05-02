package com.restaurant.model;

import java.util.List;
import java.io.Serializable;

public class Order implements Serializable {

    private int id;
    private User user;
    private List<OrderItem> items;
    private String status;

    public Order(int id, User user, List<OrderItem> items, String status) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.status = status;
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}