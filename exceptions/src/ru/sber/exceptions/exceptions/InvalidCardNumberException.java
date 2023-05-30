package ru.sber.exceptions.exceptions;

public class InvalidCardNumberException extends BankOnlineException {
    public final String cardNumber;
    public InvalidCardNumberException(String cardNumber, String reason) {
        super(cardNumber + ": " + reason);

        this.cardNumber = cardNumber;
    }
}
