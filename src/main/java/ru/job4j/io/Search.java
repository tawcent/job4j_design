package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validate(args);
        Path start = Paths.get(args[0]);
        String extension = args[1];

        Predicate<Path> condition = path -> path.toFile().getName().endsWith(extension);
        List<Path> result = search(start, condition);

        result.forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void validate(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Root folder and file extension must be provided. Usage: ROOT_FOLDER FILE_EXTENSION");
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }

        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }

        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("File extension must start with a dot. Example: .txt");
        }
    }
}
