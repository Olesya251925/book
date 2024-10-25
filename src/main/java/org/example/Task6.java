package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {

    public static void execute(List<Visitor> visitors) {
        // 1. Вычисляем среднее количество любимых книг у всех посетителей
        double averageFavorites = visitors.stream()
                .mapToInt(visitor -> visitor.getFavoriteBooks().size()) // Извлекаем количество любимых книг для каждого посетителя
                .average() // Вычисляем среднее значение
                .orElse(0.0); // Если нет посетителей, возвращаем 0.0

        // 2. Создаём список SMS на основе количества любимых книг и среднего значения
        List<SMS> smsList = visitors.stream()
                .filter(Visitor::isSubscribed) // Оставляем только подписанных посетителей
                .map(visitor -> {
                    int favoriteCount = visitor.getFavoriteBooks().size(); // Получаем количество любимых книг
                    String message;

                    // Определяем сообщение на основе количества любимых книг
                    if (favoriteCount > averageFavorites) {
                        message = "you are a bookworm";
                    } else if (favoriteCount < averageFavorites) {
                        message = "read more";
                    } else {
                        message = "fine";
                    }

                    // Создаём SMS
                    return new SMS(visitor.getPhone(), message);
                })
                .toList(); // Собираем в список

        // 3. Выводим каждое SMS на экран
        smsList.forEach(System.out::println);
    }
}
