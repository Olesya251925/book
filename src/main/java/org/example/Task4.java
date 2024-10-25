package org.example;

import java.util.List;

public class Task4 {
    // Метод execute принимает список посетителей и проверяет, есть ли у них книги Джейн Остин.
    public static boolean execute(List<Visitor> visitors) {
        // Проверяем наличие книг Джейн Остин у посетителей
        boolean hasAustenBooks = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream()) // Разворачиваем список книг для каждого посетителя
                .anyMatch(book -> book.getAuthor().equalsIgnoreCase("Jane Austen"));

        // Выводим соответствующее сообщение
        if (hasAustenBooks) {
            System.out.println("Есть посетители с книгами Jane Austen.");
        } else {
            System.out.println("Нет посетителей с книгами Jane Austen.");
        }

        return hasAustenBooks; // Возвращаем булевое значение
    }
}
