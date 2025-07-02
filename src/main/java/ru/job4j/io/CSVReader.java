package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String[] filters = argsName.get("filter").split(",");

        for (String f : filters) {
            System.out.println("Фильтр: " + f);
        }

        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine();
                String[] columns = header.split(delimiter);
                List<Integer> filterIndexes = new ArrayList<>();

                for (String filter : filters) {
                    for (int i = 0; i < columns.length; i++) {
                        if (columns[i].equals(filter)) {
                            filterIndexes.add(i);
                            System.out.println("Фильтр " + filter + "=> индекс: " + i);
                            break;
                        }
                    }
                }
                List<String> result = new ArrayList<>();
                result.add(joinSelectedColumns(columns, filterIndexes, delimiter));

                while (scanner.hasNextLine()) {
                    String[] row = scanner.nextLine().split(delimiter);
                    result.add(joinSelectedColumns(row, filterIndexes, delimiter));
                }

                if ("stdout".equals(out)) {
                    result.forEach(System.out::println);
                } else {
                    try (PrintStream ps = new PrintStream(new FileOutputStream(out))) {
                        result.forEach(ps::println);
                    }
                }
            }
        }
    }

    private static String joinSelectedColumns(String[] row, List<Integer> indexes, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        for (Integer index : indexes) {
            if (index < row.length) {
                joiner.add(row[index]);
            }
        }
        return joiner.toString();
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided. Example : -path=data/file.csv -delimiter=;-out=stdout -filter=name,age");
        }

        ArgsName argsName = ArgsName.of(args);

        if (!argsName.get("out").equals("stdout") && !argsName.get("out").endsWith(".txt")) {
            throw new IllegalArgumentException("out must be 'stdout' or a path to a file");
        }

        handle(argsName);
    }
}