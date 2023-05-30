package ru.sber.exceptions;

import ru.sber.exceptions.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BankOnline {
    List<String> blockedCards = new ArrayList<>();
    Pattern validCardPattern = Pattern.compile("^[0-9]*$");
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

        if (money < 0 || money > 50_000) {
            throw new OutOfLimitTransferException(cardNumber, money, 50000.0);
        }

        if (cardNumber.length() != 16) {
            throw new InvalidCardNumberException(cardNumber, "Длина карты не равна 16");
        }

        if (!validCardPattern.matcher(cardNumber).matches()) {
            throw new InvalidCardNumberException(cardNumber, "В номере карты есть символы, отличные от цифр");
        }

        if (this.blockedCards.contains(cardNumber)) {
            throw new TransferToBlockedCardException(cardNumber);
        }
    }
}
