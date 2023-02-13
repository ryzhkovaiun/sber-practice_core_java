package ru.sber.base.syntax;

public class Task2 {

    public static final int arraySize = 10;

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < opora)
                i++;

            while (array[j] > opora)
                j--;

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void main(String[] args) {
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = (int)(25 * Math.random());
            System.out.print(array[i] + " ");
        }

        System.out.println();

        quickSort(array, 0, arraySize - 1);

        for (int i = 0; i < arraySize; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
