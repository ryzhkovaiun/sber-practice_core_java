package ru.sber.base.syntax;

public class Task4 {

    public static final int arraySize = 10;

    public static void main(String[] args) {
        double[] array = new double[arraySize];
        double max = 0;
        double average = 0;

        for (int i = 0; i < arraySize; i++) {
            array[i] = Math.random();
            average += array[i];

            if (array[i] > max)
                max = array[i];
        }

        average /= arraySize;

        System.out.println("Максимальное: " + max);
        System.out.println("Среднее: " + average);
    }

}
