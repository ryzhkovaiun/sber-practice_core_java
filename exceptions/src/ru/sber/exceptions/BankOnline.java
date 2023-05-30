package ru.sber.exceptions;

import ru.sber.exceptions.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class BankOnline {
    List<String> blockedCards = new ArrayList<>();
    public BankOnline() {
        // я не знаю как сделать это через файл
        blockedCards.add("1111111111111111");
        blockedCards.add("2222222222222222");
        blockedCards.add("3333333333333333");
    }
    public void send(String cardNumber, Double money) throws BankOnlineException {
        if (cardNumber == null) {
            throw new InvalidArgumentException("cardNumber", "Передан null");
        }

        if (money == null) {
            throw new InvalidArgumentException("money", "Передан null");
        }

        if (money < 0) {
            throw new OutOfLimitTransferException(cardNumber, money, 50000.0);
        }

        if (money > 50_000) {
            throw new OutOfLimitTransferException(cardNumber, money, 50000.0);
        }

        if (cardNumber.length() != 16) {
            throw new InvalidCardNumberException(cardNumber, "Длина карты не равна 16");
        }

        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                throw new InvalidCardNumberException(cardNumber, "В номере карты есть символы, отличные от цифр");
            }
        }

        if (this.blockedCards.contains(cardNumber)) {
            throw new TransferToBlockedCardException(cardNumber);
        }
    }
}
