package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDAO {

    // создать заказ
    public int createOrder(int userId, double totalPrice) {
        try {

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO orders(user_id, total_price) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, userId);
            ps.setDouble(2, totalPrice);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int orderId = rs.getInt(1);
                System.out.println("🧾 Order created with ID: " + orderId);
                return orderId;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    // показать заказы
    public void getAllOrders() {
        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM orders";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("📦 ORDERS:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getInt("user_id") + " | " +
                                rs.getDouble("total_price") + " | " +
                                rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}