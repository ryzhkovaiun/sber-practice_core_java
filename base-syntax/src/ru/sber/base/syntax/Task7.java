package ru.sber.base.syntax;

public class Task7 {

    public static void main(String[] args) {
        int first = 0;
        int second = 1;

        for (int i = 0; i < 11; i++) {
            int n = first + second;
            first = second;
            second = n;

            System.out.print(n + " ");
        }
    }

}
