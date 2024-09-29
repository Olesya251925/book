package org.example;

import java.util.List;

public class Task1 {
    // Метод execute принимает список посетителей и выводит информацию о них
    public static void execute(List<Visitor> visitors) {
        // Выводим общее количество посетителей
        System.out.println("Всего посетителей: " + visitors.size());

        // Для каждого посетителя выводим его имя и фамилию
        visitors.forEach(visitor ->
                System.out.println(visitor.getName() + " " + visitor.getSurname())
        );
    }
}
