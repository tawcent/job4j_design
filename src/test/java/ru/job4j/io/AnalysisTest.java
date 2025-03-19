package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {

    @TempDir
    Path tempDir;

    @Test
    void whenServerDown_thenCorrectPeriodWritten() throws IOException {
        Path sourceFile = tempDir.resolve("server.log");
        Path targetFile = tempDir.resolve("target.csv");

        List<String> logLines = List.of(
                "200 10:56",
                "500 10:57",
                "400 10:58",
                "300 11:00",
                "200 11:01",
                "500 11:02",
                "200 11:05"
        );
        Files.write(sourceFile, logLines);

        Analysis analysis = new Analysis();
        analysis.unavailable(sourceFile.toString(), targetFile.toString());

        List<String> resultLines = Files.readAllLines(targetFile);
        List<String> expectedLines = List.of(
                "10:57;11:00",
                "11:02;11:05"
        );
        assertEquals(expectedLines, resultLines);
    }
}