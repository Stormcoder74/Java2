// https://github.com/Stormcoder74/Java2.git
package ru.geekbrains.java2.lesson_02;

public class Homework {
    public static final int SIZE = 4;

    public static void main(String[] args) {
        try {
            int testResult = testException(new String[][]{
                    {"6", "2", "12", "5"},
                    {"3", "9", "4", "21"},
                    {"4", "s", "7", "8"},
                    {"1", "0", "3", "9"}});
            System.out.println("testResult = " + testResult);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
            //e.printStackTrace();
        }

        try {
            int testResult = testException(new String[][]{
                    {"6", "2", "12", "5"},
                    {"3", "9", "4"},
                    {"4", "5", "7", "8"},
                    {"1", "0"}});
            System.out.println("testResult = " + testResult);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
            //e.printStackTrace();
        }

        try {
            int testResult = testException(new String[][]{
                    {"6", "2", "12", "5"},
                    {"3", "9", "4", "21"},
                    {"4", "5", "7", "8"},
                    {"1", "0", "3", "9"}});
            System.out.println("testResult = " + testResult);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    public static int testException(String[][] arr) throws MyArraySizeException {
        int result = 0;
        if (arr.length != SIZE) throw new MyArraySizeException(SIZE, SIZE);
        else for (int i = 0; i < SIZE; i++) {
            if (arr[i].length != SIZE) throw new MyArraySizeException(SIZE, SIZE);
            for (int j = 0; j < SIZE; j++) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return result;
    }


}
