package org.example;

import java.util.Objects;

public class Book {
    private final String name;
    private final String author;
    private final String isbn;
    private final int publishingYear; // Поле для года издания

    // Конструктор
    public Book(String name, String author, String isbn, int publishingYear) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.publishingYear = publishingYear; // Инициализация поля
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    // Переопределение метода equals для сравнения объектов Book
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true; // Проверка на ссылочную равенство
//        if (!(o instanceof Book book)) return false; // Проверка, что o является экземпляром Book
//        // Сравнение полей на равенство
//        return publishingYear == book.publishingYear && // Сравнение года издания
//                Objects.equals(name, book.name) && // Сравнение названия книги
//                Objects.equals(author, book.author) && // Сравнение автора книги
//                Objects.equals(isbn, book.isbn); // Сравнение ISBN
//    }
//
//    // Переопределение метода hashCode для генерации хэш-кода объекта Book
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, author, isbn, publishingYear); // Генерация хэш-кода на основе всех полей
//    }
}
