package ru.sber.exceptions.exceptions;

public class OutOfLimitTransferException extends BankOnlineException {
    public final String cardNumber;
    public final Double requestedTransfer;
    public final Double remainingTransfer;
    public OutOfLimitTransferException(String cardNumber, Double requested, Double remaining) {
        super(cardNumber + ": " + requested + " > " + remaining);

        this.cardNumber = cardNumber;
        this.requestedTransfer = requested;
        this.remainingTransfer = remaining;
    }
}
