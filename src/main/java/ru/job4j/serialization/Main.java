package ru.job4j.serialization;

import jakarta.xml.bind.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person(true, 11, "Boris", new String[]{"purrs", "eatin"});

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("name", person.getName());
        jsonObject.put("statuses", new JSONArray(Arrays.asList(person.getStatuses())));

        System.out.println("Ручное создание JSONObject: ");
        System.out.println(jsonObject.toString(2));

        JSONObject autoJson = new JSONObject(person);
        System.out.println("Автоматическое создание из POJO: ");
        System.out.println(autoJson.toString(2));
    }
}
