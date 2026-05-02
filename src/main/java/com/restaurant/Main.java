package com.restaurant;

import com.restaurant.dao.DBConnection;
import com.restaurant.dao.UserDAO;
import com.restaurant.dao.MenuDAO;
import com.restaurant.dao.OrderDAO;
import com.restaurant.threads.OrderProcessingThread;
import com.restaurant.network.Client;
import java.util.Random;
import com.restaurant.model.Admin;
import com.restaurant.model.Waiter;
import com.restaurant.model.User;
import com.restaurant.util.SerializationUtil;

public class Main {
    public static void main(String[] args) {

        // 1. Подключение к базе
        DBConnection.getConnection();

        // 2. Логин
        UserDAO userDAO = new UserDAO();
        boolean isLogin = userDAO.loginUser("admin", "1234");

        if (isLogin) {

            // 3. Показ меню
            MenuDAO menuDAO = new MenuDAO();
            menuDAO.getAllMenu();

            // 4. Создание заказа
            OrderDAO orderDAO = new OrderDAO();
            int orderId = orderDAO.createOrder(2, 5000);

            // 5. Поток (обработка)
            OrderProcessingThread thread = new OrderProcessingThread(orderId);
            thread.start();

            // 6. Отправка на кухню (socket)
            String[] menuItems = {
                    "Pizza",
                    "Tea",
                    "Burger",
                    "Cheese Shawarma",
                    "12 Wings Basket",
                    "Rice",
                    "Caesar Salad",
                    "8 Nuggets",
                    "Cola",
                    "Fanta",
                    "Juice",
                    "Fuze Tea",
                    "Ketchup",
                    "Naan",
                    "French Fries",
                    "Philadelphia Roll",
                    "Tempura Roll"
            };

            Random random = new Random();

            for (int i = 0; i < 3; i++) {

                String randomItem = menuItems[random.nextInt(menuItems.length)];

                System.out.println("Client order: " + randomItem);

                Client.sendOrder(randomItem);
            }

        } else {
            System.out.println("❌ Login failed");
        }

        Admin admin = new Admin(1, "Beka", "admin", "1234");
        Waiter waiter = new Waiter(2, "Ali", "waiter", "1111");

        admin.dashboard();
        waiter.dashboard();

        User user = new User(1, "Beka", "admin", "1234", "ADMIN");
        SerializationUtil.saveObject(user, "user.dat");
        User loadedUser = (User) SerializationUtil.readObject("user.dat");
        System.out.println("Loaded user: " + loadedUser.getUsername());
    }
}