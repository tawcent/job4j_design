package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class Multiple {

    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/Multiple.txt")) {
            output.write("1 * 1 = 1".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("1 * 2 = 2".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("1 * 3 = 3".getBytes());
            output.write(System.lineSeparator().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
