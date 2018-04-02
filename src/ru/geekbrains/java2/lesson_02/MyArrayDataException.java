package ru.geekbrains.java2.lesson_02;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int size1, int size2) {
        super("Невозможно преобразовать в число строку в ячейке [" + size1 + "][" + size2 + "].");
    }
}
