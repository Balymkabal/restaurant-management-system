package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public void addUser(String name, String username, String password) {
        try {

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO users(name, username, password) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);

            ps.executeUpdate();

            System.out.println("✅ User added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean loginUser(String username, String password) {
        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            var rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("✅ Login successful!");
                return true;
            } else {
                System.out.println("❌ Invalid login!");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
