package ru.job4j.io;

import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        FileProperty property = new FileProperty(attrs.size(), file.getFileName().toString());
        files.computeIfAbsent(property, k -> new ArrayList<>()).add(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    public void showDuplicates() {
        for (Map.Entry<FileProperty, List<Path>> entry : files.entrySet()) {
            List<Path> list = entry.getValue();
            if (list.size() > 1) {
                FileProperty prop = entry.getKey();
                System.out.println(prop.getName() + " - " + prop.getSize() + "bytes");
                for (Path path : list) {
                    System.out.println(" " + path);
                }
                System.out.println();
            }
        }
    }
}
