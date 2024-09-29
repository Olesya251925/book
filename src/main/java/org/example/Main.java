package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "src/main/resources/books.json";

    public static void main(String[] args) {
        Gson gson = new Gson();
        Type visitorListType = new TypeToken<List<Visitor>>() {}.getType();

        try (FileReader reader = new FileReader(FILE_PATH)) {
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1 - Вывести список посетителей и их количество.");
                System.out.println("2 - Вывести список и количество книг в избранном без повторений.");
                System.out.println("3 - Отсортировать и вывести список книг по году издания.");
                System.out.println("4 - Проверить, есть ли книга автора 'Jane Austen' в избранном.");
                System.out.println("5 - Вывести максимальное количество книг в избранном.");
                System.out.println("6 - Сгруппировать посетителей по количеству избранных книг и отправить SMS.");
                System.out.print("Ваш выбор: ");
                System.out.println("\nВыберите задание (1-6) или 0 для выхода:");

                int taskNumber = scanner.nextInt();

                switch (taskNumber) {
                    case 1 -> {
                        System.out.println("\nЗадание 1: Список посетителей и их количество.");
                        Task1.execute(visitors);
                    }
                    case 2 -> {
                        System.out.println("\nЗадание 2: Список книг в избранном без повторений.");
                        Task2.execute(visitors);
                    }
                    case 3 -> {
                        System.out.println("\nЗадание 3: Отсортированный список книг по году издания.");
                        Task3.execute(visitors);
                    }
                    case 4 -> {
                        System.out.println("\nЗадание 4: Проверка на наличие книги автора 'Jane Austen' в избранном.");
                        Task4.execute(visitors);
                    }
                    case 5 -> {
                        System.out.println("\nЗадание 5: Максимальное количество книг в избранном.");
                        Task5.execute(visitors);
                    }
                    case 6 -> {
                        System.out.println("\nЗадание 6: SMS-сообщения для пользователей.");
                        Task6.execute(visitors);
                    }
                    case 0 -> {
                        System.out.println("Выход из программы.");
                        System.exit(0);
                    }
                    default -> System.out.println("Некорректный ввод. Попробуйте снова.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
