package com.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {
        try {

            if (connection == null) {

                Properties props = new Properties();

                InputStream input = DBConnection.class
                        .getClassLoader()
                        .getResourceAsStream("database.properties");

                props.load(input);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);

                System.out.println("✅ Database connected!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}