package com.restaurant.network;

import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void sendOrder(String order) {
        try {

            Socket socket = new Socket("localhost", 5000);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println(order);

            System.out.println("🧾 Order sent to kitchen: " + order);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}