package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(true, 11, "Boris",
                new String[]{"purrs", "eatin"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        final String personJson =
                "{"
                        + "\"sex\":true,"
                        + "\"age\":11,"
                        + "\"name\":Boris,"
                        + "\"statuses\":"
                        + "[\"cat\",\"purrs\",\"eatin\"]"
                        + "}";

        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}