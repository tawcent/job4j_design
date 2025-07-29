package ru.job4j.serialization;

import java.util.Arrays;

public class Person {
    private final boolean sex;
    private final int age;
    private final String name;
    private final String[] statuses;

    public Person(boolean sex, int age, String name, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.statuses = statuses;
    }

        @Override
        public String toString() {
            return "Person{"
                    +
                    "sex=" + sex
                    +
                    ", age=" + age
                    +
                    ", name='" + name + '\''
                    +
                    ", statuses=" + Arrays.toString(statuses)
                    +
                    '}';
        }
    }

