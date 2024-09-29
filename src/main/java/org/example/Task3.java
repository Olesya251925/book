package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    // Метод execute принимает список посетителей и выводит их любимые книги в порядке года издания.
    public static void execute(List<Visitor> visitors) {
        // Используем поток для обработки списка посетителей
        List<Book> allBooks = visitors.stream()  // Преобразуем список посетителей в поток.
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())  // Объединяем все любимые книги всех посетителей в один поток.
                .sorted(Comparator.comparingInt(Book::getPublishingYear))  // Сортируем книги по году издания.
                .collect(Collectors.toList());  // Собираем отсортированные книги в список.

        // Для каждой книги в списке выводим ее название и год издания
        allBooks.forEach(book ->
                System.out.println(book.getName() + " (" + book.getPublishingYear() + ")")  // Форматируем вывод книги.
        );
    }
}