package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    public void testExecute() {
        // Создаем список посетителей с их любимыми книгами
        List<Visitor> visitors = Arrays.asList(
                new Visitor("John", "Doe", "1234567890", true,
                        Arrays.asList(
                                new Book("Book A", "Author A", "ISBN001", 2021),
                                new Book("Book B", "Author B", "ISBN002", 2022),
                                new Book("Book C", "Author C", "ISBN003", 2023))),
                new Visitor("Jane", "Smith", "0987654321", true,
                        Arrays.asList(
                                new Book("Book D", "Author D", "ISBN004", 2020))),
                new Visitor("Emily", "Jones", "5555555555", true,
                        Arrays.asList(
                                new Book("Book E", "Author E", "ISBN005", 2019),
                                new Book("Book F", "Author F", "ISBN006", 2018),
                                new Book("Book G", "Author G", "ISBN007", 2017),
                                new Book("Book H", "Author H", "ISBN008", 2016))),
                new Visitor("Alice", "Brown", "1111111111", false,
                        Arrays.asList()) // Не подписан, не должен получать SMS
        );

        // Перенаправление вывода в поток
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // Создаем поток для захвата вывода
        System.setOut(new PrintStream(outputStream)); // Перенаправляем стандартный вывод в наш поток

        // Вызов метода execute из класса Task6
        Task6.execute(visitors); // Вызываем метод, который отправляет SMS посетителям

        // Получение вывода
        String output = outputStream.toString(); // Получаем текст, который был выведен в поток

        // Проверка результата
        // Проверяем, что для каждого подписанного посетителя отправлены правильные SMS
        assertTrue(output.contains("SMS to 1234567890: you are a bookworm")); // Проверяем, что SMS для John корректно
        assertTrue(output.contains("SMS to 0987654321: read more")); // Проверяем, что SMS для Jane корректно
        assertTrue(output.contains("SMS to 5555555555: you are a bookworm")); // Проверяем, что SMS для Emily корректно
        assertTrue(!output.contains("SMS to 1111111111")); // Проверка, что не подписанный посетитель (Alice) не получил SMS
    }
}
