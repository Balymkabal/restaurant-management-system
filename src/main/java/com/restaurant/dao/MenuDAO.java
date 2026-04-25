package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MenuDAO {

    // добавить блюдо
    public void addMenuItem(String name, double price) {
        try {

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO menu(name, price) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);

            ps.executeUpdate();

            System.out.println("🍽 Menu item added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // показать меню
    public void getAllMenu() {
        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM menu";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("📋 MENU:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
