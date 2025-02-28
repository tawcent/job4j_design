package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream even = new FileInputStream("data/even.txt")) {
            Scanner scanner = new Scanner(even);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                 int number = scanner.nextInt();
                    if (number % 2 == 0) {
                        System.out.println(number + " - chetnoe");
                    } else {
                        System.out.println(number + " - ne chetnoe");
                    }
                } else {
                    scanner.next();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
