package com.restaurant.util;

import java.io.*;

public class SerializationUtil {

    public static void saveObject(Object obj, String filename) {
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(filename));

            out.writeObject(obj);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject(String filename) {
        try {
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(filename));

            return in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}