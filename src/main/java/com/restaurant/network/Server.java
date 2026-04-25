package com.restaurant.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {

            ServerSocket server = new ServerSocket(5000);
            System.out.println("🍳 Kitchen Server started...");

            while (true) {
                Socket socket = server.accept();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                String order = reader.readLine();

                System.out.println("📦 Received order: " + order);

                System.out.println("🍳 Cooking " + order + "...");
                Thread.sleep(3000);

                System.out.println("✅ Ready: " + order);

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}