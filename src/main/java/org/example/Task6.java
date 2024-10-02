package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {
    public static void execute(List<Visitor> visitors) {
        double averageFavorites = visitors.stream()
                .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                .average()
                .orElse(0.0);

        Map<String, List<Visitor>> groupedMessages = visitors.stream()
                .filter(Visitor::isSubscribed)
                .collect(Collectors.groupingBy(visitor -> {
                    int favoriteCount = visitor.getFavoriteBooks().size();
                    if (favoriteCount > averageFavorites) {
                        return "you are a bookworm";
                    } else if (favoriteCount < averageFavorites) {
                        return "read more";
                    } else {
                        return "fine";
                    }
                }));

        List<SMS> smsList = groupedMessages.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(visitor -> new SMS(visitor.getPhone(), entry.getKey())))
                .collect(Collectors.toList());

        smsList.forEach(sms -> {
            System.out.println("SMS to " + sms.getPhoneNumber() + ": " + sms.getMessage());
        });
    }
}

