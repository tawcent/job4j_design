package ru.job4j.io;

import javax.xml.catalog.Catalog;
import java.io.*;

public class ObjectStream {

    public static void main(String[] args) {
        Car car = new Car("Firm", "Model", 2000);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/serialized.dat"));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/serialized.dat"))) {
                out.writeObject(car);
                Car deserealized = (Car) in.readObject();
            System.out.println(deserealized.toString());
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
