package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample3 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Job4j", Pattern.CASE_INSENSITIVE);

        String textOne = "Job4j";
        Matcher matcherOne = pattern.matcher(textOne);
        boolean isPresentOne = matcherOne.matches();
        System.out.println(isPresentOne);

        String textTwo = "joB4J";
        Matcher matcherTwo = pattern.matcher(textTwo);
        boolean isPresentTwo = matcherTwo.matches();
        System.out.println(isPresentTwo);
    }
}
