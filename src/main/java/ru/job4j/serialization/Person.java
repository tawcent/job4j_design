package ru.job4j.serialization;

import jakarta.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;

    private String name;

    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] statuses;

    public Person() {
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
