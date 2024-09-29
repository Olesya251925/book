package org.example;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {
    // Метод для выполнения задачи, принимающий список посетителей
    public static void execute(List<Visitor> visitors) {
        // Создаем множество уникальных книг, извлекая их из списков любимых книг каждого посетителя
        Set<Book> uniqueBooks = visitors.stream()  // Преобразуем список посетителей в поток
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())  // Для каждого посетителя получаем поток его любимых книг
                .collect(Collectors.toSet());  // Собираем все книги в множество, что гарантирует уникальность

        // Выводим количество уникальных книг
        System.out.println("Всего уникальных книг: " + uniqueBooks.size());

        // Выводим название каждой уникальной книги
        uniqueBooks.forEach(book -> System.out.println(book.getName()));
    }
}