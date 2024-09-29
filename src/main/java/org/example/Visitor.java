package org.example;

import java.util.List;

public class Visitor {
    private final String name; // final указывает, что значение переменной не может быть изменено после ее инициализации.
    private final String surname;
    private final String phone;
    private final boolean subscribed;
    private final List<Book> favoriteBooks;

    // Конструктор
    public Visitor(String name, String surname, String phone, boolean subscribed, List<Book> favoriteBooks) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.subscribed = subscribed;
        this.favoriteBooks = favoriteBooks;
    }

    // Геттер для name
    public String getName() {
        return name;
    }

    // Геттер для surname
    public String getSurname() {
        return surname;
    }

    // Другие геттеры и сеттеры, если нужно
    public String getPhone() {
        return phone;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public List<Book> getFavoriteBooks() {
        return favoriteBooks;
    }
}
