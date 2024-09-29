package org.example;

import java.util.List;


public class Task4 {
    // Метод execute принимает список посетителей и проверяет, есть ли у них книги Джейн Остин.
    public static void execute(List<Visitor> visitors) {
        // Используем поток для обработки списка посетителей
        boolean hasAustenBook = visitors.stream()  // Преобразуем список посетителей в поток.
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())  // Объединяем все любимые книги всех посетителей в один поток.
                .anyMatch(book -> book.getAuthor().equalsIgnoreCase("Jane Austen"));  // Проверяем, есть ли хотя бы одна книга от Джейн Остин.

        // Выводим результат проверки на экран
        System.out.println("Есть ли книга Jane Austen в избранном? " + (hasAustenBook ? "Да" : "Нет"));  // Форматируем вывод результата.
    }
}

