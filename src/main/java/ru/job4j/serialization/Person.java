package ru.job4j.serialization;

import jakarta.xml.bind.annotation.*;
import java.util.Arrays;

public class Person {

    private boolean sex;
    private int age;
    private String name;
    private String[] statuses;

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public Person(boolean sex, int age, String name, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", name='" + name + '\''
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}
