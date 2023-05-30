package ru.sber.exceptions.exceptions;

public class BankOnlineException extends Exception {
    public final String description;
    public BankOnlineException() {
        this.description = "";
    }
    public BankOnlineException(String description) {
        this.description = description;
    }
}
