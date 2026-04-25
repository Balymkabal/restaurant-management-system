package com.restaurant.threads;

public class KitchenThread extends Thread {

    private int orderId;

    public KitchenThread(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        try {

            System.out.println("🍳 Kitchen started cooking order: " + orderId);

            Thread.sleep(3000); // имитация готовки

            System.out.println("✅ Order ready: " + orderId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}