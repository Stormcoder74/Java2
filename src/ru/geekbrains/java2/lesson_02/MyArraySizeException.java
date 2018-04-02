package ru.geekbrains.java2.lesson_02;

public class MyArraySizeException extends Exception {
    MyArraySizeException(int size1, int size2) {
        super("Размерность массива отличается от [" + size1 + "][" + size2 + "].");
    }
}
