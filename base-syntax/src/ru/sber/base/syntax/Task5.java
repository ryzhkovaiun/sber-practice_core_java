package ru.sber.base.syntax;

public class Task5 {

    public static boolean isprime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++)
            if (isprime(i))
                System.out.println(i);
    }

}
