package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Перенаправляем System.out на наш ByteArrayOutputStream для тестирования вывода
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testExecute() {
        // Создаем тестовые данные
        List<Book> emptyBookList = new ArrayList<>();
        List<Visitor> visitors = List.of(
                new Visitor("John", "Doe", "123-456-7890", true, emptyBookList),
                new Visitor("Jane", "Smith", "987-654-3210", false, emptyBookList)
        );

        // Ожидаемый результат
        String expectedOutput = "Всего посетителей: 2\nJohn Doe\nJane Smith\n";

        // Выполняем тестируемый метод
        Task1.execute(visitors);

        // Проверяем результат
        assertEquals(expectedOutput, outContent.toString());
    }

    @BeforeEach
    public void tearDown() {
        // Возвращаем System.out в исходное состояние
        System.setOut(originalOut);
    }
}
