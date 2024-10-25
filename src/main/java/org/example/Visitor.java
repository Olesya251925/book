package org.example;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
public class Visitor {
    private  final String name;
    private final String surname;
    private final String phone;
    private final boolean subscribed;
    private final List<Book> favoriteBooks;
}

