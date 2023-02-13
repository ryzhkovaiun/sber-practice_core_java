package ru.sber.base.syntax;

public class Task1 {

    public static final int arraySize = 10;

    public static void main(String[] args) {
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = (int)(25 * Math.random());
            System.out.print(array[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arraySize; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
