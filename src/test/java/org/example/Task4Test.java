package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void testExecuteWithJaneAustenBook() {
        // Создаем книги, включая книгу Джейн Остин
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "111-222", 1813);
        Book book2 = new Book("1984", "George Orwell", "333-444", 1949);

        // Создаем посетителя с книгами, одна из которых от Джейн Остин
        Visitor visitor = new Visitor("Alice", "Smith", "123-456-7890", true, Arrays.asList(book1, book2));

        // Собираем список посетителей
        List<Visitor> visitors = Arrays.asList(visitor);

        // Ожидаемый результат
        String expectedOutput = "Есть ли книга Jane Austen в избранном? Да\n";

        // Перехватываем вывод в консоль
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Вызываем метод
        Task4.execute(visitors);

        // Проверяем, что результат совпадает с ожидаемым
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testExecuteWithoutJaneAustenBook() {
        // Создаем книги, но ни одна из них не принадлежит Джейн Остин
        Book book1 = new Book("Dune", "Frank Herbert", "555-666", 1965);
        Book book2 = new Book("1984", "George Orwell", "333-444", 1949);

        // Создаем посетителя с книгами, но без книг от Джейн Остин
        Visitor visitor = new Visitor("Bob", "Johnson", "987-654-3210", false, Arrays.asList(book1, book2));

        // Собираем список посетителей
        List<Visitor> visitors = Arrays.asList(visitor);

        // Ожидаемый результат
        String expectedOutput = "Есть ли книга Jane Austen в избранном? Нет\n";

        // Перехватываем вывод в консоль
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Вызываем метод
        Task4.execute(visitors);

        // Проверяем, что результат совпадает с ожидаемым
        assertEquals(expectedOutput, outContent.toString());
    }
}
