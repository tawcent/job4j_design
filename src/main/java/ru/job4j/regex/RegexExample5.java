package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample5 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Job4j");
        String text = "Job4j и Job4j и Job4j";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение");
        }
    }
}
