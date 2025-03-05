package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> result = new ArrayList<>();
        try (BufferedReader log = new BufferedReader(new FileReader(file))) {
            log.lines()
                    .filter(line -> {
                        String[] parts = line.split(" ");
                        return parts.length > 1 && "404".equals(parts[parts.length - 2]);
                            })
                    .forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void saveTO(String out) {
        var data = filter();
        try (PrintWriter writer = new PrintWriter(new FileWriter(out))) {
            for (String line : data) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LogFilter("data/log.txt").saveTO("data/404.txt");
    }
}
