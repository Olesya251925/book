package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void testExecuteSortsBooksByPublishingYear() {
        // Создаем книги с разными годами издания
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", "123-456", 1937);
        Book book2 = new Book("1984", "George Orwell", "234-567", 1949);
        Book book3 = new Book("Dune", "Frank Herbert", "345-678", 1965);

        // Создаем посетителей с любимыми книгами
        Visitor visitor1 = new Visitor("John", "Doe", "111-222-3333", true, Arrays.asList(book1, book2));
        Visitor visitor2 = new Visitor("Jane", "Doe", "444-555-6666", false, Arrays.asList(book3));

        // Собираем список всех посетителей
        List<Visitor> visitors = Arrays.asList(visitor1, visitor2);

        // Ожидаемый результат: список книг отсортирован по году издания
        String expectedOutput = "The Hobbit (1937)\n1984 (1949)\nDune (1965)\n";

        // Перехватываем вывод в консоль
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Вызываем метод
        Task3.execute(visitors);

        // Проверяем, что результат совпадает с ожидаемым
        assertEquals(expectedOutput, outContent.toString());
    }
}
