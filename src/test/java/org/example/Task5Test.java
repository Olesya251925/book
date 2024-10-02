package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void testExecuteWithMultipleVisitors() {
        // Создаем несколько книг
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "111-222", 1813);
        Book book2 = new Book("1984", "George Orwell", "333-444", 1949);
        Book book3 = new Book("Dune", "Frank Herbert", "555-666", 1965);

        // Создаем посетителей с разным количеством любимых книг
        Visitor visitor1 = new Visitor("Alice", "Smith", "123-456-7890", true, Arrays.asList(book1, book2));
        Visitor visitor2 = new Visitor("Bob", "Johnson", "987-654-3210", false, Arrays.asList(book1, book2, book3));
        Visitor visitor3 = new Visitor("Charlie", "Brown", "555-123-4567", true, Collections.singletonList(book1));

        // Собираем список посетителей
        List<Visitor> visitors = Arrays.asList(visitor1, visitor2, visitor3);

        // Ожидаемый результат
        String expectedOutput = "Максимальное количество любимых книг: 3\n";

        // Перехватываем вывод в консоль
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Вызываем метод
        Task5.execute(visitors);

        // Проверяем, что результат совпадает с ожидаемым
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testExecuteWithSingleVisitor() {
        // Создаем книгу
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "111-222", 1813);

        // Создаем одного посетителя с одной книгой
        Visitor visitor = new Visitor("Alice", "Smith", "123-456-7890", true, Collections.singletonList(book1));

        // Собираем список посетителей
        List<Visitor> visitors = Collections.singletonList(visitor);

        // Ожидаемый результат
        String expectedOutput = "Максимальное количество любимых книг: 1\n";

        // Перехватываем вывод в консоль
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Вызываем метод
        Task5.execute(visitors);

        // Проверяем, что результат совпадает с ожидаемым
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testExecuteWithNoVisitors() {
        // Создаем пустой список посетителей
        List<Visitor> visitors = Collections.emptyList();

        // Ожидаемый результат
        String expectedOutput = "Максимальное количество любимых книг: 0\n";

        // Перехватываем вывод в консоль
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Вызываем метод
        Task5.execute(visitors);

        // Проверяем, что результат совпадает с ожидаемым
        assertEquals(expectedOutput, outContent.toString());
    }
}
