package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task2Test {

    @Test
    public void testExecute() {
        // Создаем тестовые книги с уникальными и дублирующимися значениями
        Book book1 = new Book("Book One", "Author A", "1234567890", 2020);
        Book book2 = new Book("Book Two", "Author B", "0987654321", 2021);
        Book book3 = new Book("Book One", "Author A", "1234567890", 2020); // Дубликат

        // Создаем список книг для первого посетителя
        List<Book> visitor1Books = new ArrayList<>();
        visitor1Books.add(book1); // Добавляем первую книгу
        visitor1Books.add(book2); // Добавляем вторую книгу

        // Создаем список книг для второго посетителя, включающий дубликат
        List<Book> visitor2Books = new ArrayList<>();
        visitor2Books.add(book3); // Дубликат

        // Создаем двух посетителей с их списками книг
        Visitor visitor1 = new Visitor("John", "Doe", "123456789", true, visitor1Books);
        Visitor visitor2 = new Visitor("Jane", "Doe", "987654321", false, visitor2Books);

        // Объединяем обоих посетителей в один список
        List<Visitor> visitors = List.of(visitor1, visitor2);

        // Перенаправляем вывод в поток для захвата вывода метода execute
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Выполняем метод Task2.execute с переданным списком посетителей
        Task2.execute(visitors);

        // Получаем фактический вывод и обрезаем лишние пробелы
        String actualOutput = outContent.toString().trim();

        // Ожидаемый вывод, который мы хотим проверить
        String expectedOutput = "Всего уникальных книг: 2\n" +
                "Book One\n" +
                "Book Two";

        // Сортировка строк вывода для сравнения
        String[] actualLines = actualOutput.split("\n"); // Разделяем фактический вывод на строки
        Arrays.sort(actualLines); // Сортируем строки фактического вывода
        String[] expectedLines = expectedOutput.split("\n"); // Разделяем ожидаемый вывод на строки
        Arrays.sort(expectedLines); // Сортируем строки ожидаемого вывода

        // Сравниваем отсортированные массивы строк
        assertArrayEquals(expectedLines, actualLines);
    }
}
