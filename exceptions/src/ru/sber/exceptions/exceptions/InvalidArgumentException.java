package ru.sber.exceptions.exceptions;

public class InvalidArgumentException extends BankOnlineException {
    public InvalidArgumentException(String argumentName, String reason) {
        super(argumentName + ": " + reason);
    }
}
