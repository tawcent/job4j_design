package ru.job4j.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "Закончить";
    private static final String STOP = "Стоп";
    private static final String CONTINUE = "Продолжить";

    private final String path;
    private final String botAnswers;
    private final List<String> log = new ArrayList<>();
    private static final Logger LOG = LoggerFactory.getLogger(ConsoleChat.class.getName());

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
    List<String> phrases = readPhrases();
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        boolean respond = true;

        System.out.println("Чат запущен. Введите сообщение: ");

        while (!OUT.equalsIgnoreCase(userInput)) {
            userInput = scanner.nextLine();
            log.add("Пользователь: " + userInput);

            if (STOP.equalsIgnoreCase(userInput)) {
                respond = false;
            } else if (CONTINUE.equalsIgnoreCase(userInput)) {
                respond = true;
            } else if (respond) {
                String botResponse = phrases.get(new Random().nextInt(phrases.size()));
                System.out.println(botResponse);
                log.add("Бот: " + botResponse);
            }
        }
        saveLog(log);
        System.out.println("Чат завершен. Лог сохранен в файл: " + path);
    }

    private void saveLog(List<String> log) {
        try {
            Files.write(Paths.get(path), log);
        } catch (IOException e) {
            LOG.error("Ошибка при сохранении лога в файл {}", path, e);
        }
    }

    public List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try {
            phrases = Files.readAllLines((java.nio.file.Paths.get(botAnswers)));
        } catch (IOException e) {
            LOG.error("Ошибка при чтении файла {} ", botAnswers, e);
        }
        return phrases;
    }

    public static void main(String[] args) {
        String logFile = "data/chat.log.txt";
        String botPhrasesFile = "data/bot_phrases.txt";

        ConsoleChat chat = new ConsoleChat(logFile, botPhrasesFile);
        chat.run();
    }
}
