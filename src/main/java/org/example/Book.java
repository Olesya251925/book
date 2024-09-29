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

    public String getIsbn() {
        return isbn;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    // Переопределение equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Проверка на ссылочную равенство
        if (!(o instanceof Book)) return false; // Проверка типа
        Book book = (Book) o; // Приведение типа
        return publishingYear == book.publishingYear && // Сравнение полей
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

    // Переопределение hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, author, isbn, publishingYear); // Генерация хэш-кода
    }
}
