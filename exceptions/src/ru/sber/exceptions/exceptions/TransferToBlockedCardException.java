package ru.sber.exceptions.exceptions;

public class TransferToBlockedCardException extends BankOnlineException {
    public final String blockedCard;

    public TransferToBlockedCardException(String cardNumber) {
        super(cardNumber);

        this.blockedCard = cardNumber;
    }
}
