package ru.job4j.io;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target, Path rootDir) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                String relativePath = rootDir.relativize(source).toString();
                zip.putNextEntry(new ZipEntry(relativePath));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
                zip.closeEntry();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to pack files", e);
        }
    }

    private static void validateArgs(ArgsName args) {
        Path directory = Paths.get(args.get("d"));
        String exclude = args.get("e");
        String output = args.get("o");

        if (!Files.exists(directory) || !Files.isDirectory(directory)) {
            throw new IllegalArgumentException("Invalid directory: " + directory);
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException("Exclude extension must start with dot: " + exclude);
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException("Output file must end with .zip: " + output);
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName arguments = ArgsName.of(args);
        validateArgs(arguments);

        Path sourceDir = Paths.get(arguments.get("d"));
        String exclude = arguments.get("e");
        File output = new File(arguments.get("o"));

        Predicate<Path> filter = path -> !path.toFile().getName().endsWith(exclude);
        List<Path> filesToZip = Search.search(sourceDir, filter);

        new Zip().packFiles(filesToZip, output, sourceDir);
    }
}
