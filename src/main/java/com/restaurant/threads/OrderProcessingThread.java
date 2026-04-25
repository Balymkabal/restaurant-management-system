package com.restaurant.threads;

public class OrderProcessingThread extends Thread {

    private int orderId;

    public OrderProcessingThread(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        try {

            System.out.println("🧾 Order received: " + orderId);

            Thread.sleep(1000);

            System.out.println("📦 Sending order to kitchen...");

            KitchenThread kitchen = new KitchenThread(orderId);
            kitchen.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}