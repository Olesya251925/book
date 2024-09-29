package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {
    public static void execute(List<Visitor> visitors) {
        double averageFavorites = visitors.stream()  // Преобразуем список посетителей в поток.
                .mapToInt(visitor -> visitor.getFavoriteBooks().size())  // Получаем количество любимых книг для каждого посетителя.
                .average()  // Вычисляем среднее значение среди полученных количеств.
                .orElse(0.0);  // Если список пуст, возвращаем 0.0 как значение по умолчанию.

        Map<String, List<Visitor>> groupedMessages = visitors.stream()
                .filter(Visitor::isSubscribed)
                .collect(Collectors.groupingBy(visitor -> {
                    int favoriteCount = visitor.getFavoriteBooks().size();
                    if (favoriteCount > averageFavorites) {
                        return "you are a bookworm";  // Если больше среднего, возвращаем сообщение "вы книжный червь".
                    } else if (favoriteCount < averageFavorites) {
                        return "read more";  // Если меньше среднего, возвращаем сообщение "читайте больше".
                    } else {
                        return "fine";  // Если равно среднему, возвращаем сообщение "в порядке".
                    }
                }));

        groupedMessages.forEach((message, visitorsList) -> {
            visitorsList.forEach(visitor -> {
                System.out.println("SMS to " + visitor.getPhone() + ": " + message);
            });
        });
    }
}
