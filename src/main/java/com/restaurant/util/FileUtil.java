package com.restaurant.util;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void saveToFile(String filename, String data) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(data + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}