package ru.job4j.serialization;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                +
                "zipCode="
                + zipCode
                +
                ", phone='"
                + phone + '\''
                +
                '}';
    }

    public static void main(String[] args) {
        final Contact contact = new Contact(123456, "+7 (777) 111-11-11");
        final File file = new File("C:/projects/job4j_design/data/contact.txt");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(contact);
            System.out.println("Object serialized in file: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
             Contact contactFromFile = (Contact) ois.readObject();
            System.out.println("Object deserialization");
            System.out.println(contactFromFile);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
