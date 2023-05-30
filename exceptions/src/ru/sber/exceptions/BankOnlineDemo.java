package ru.sber.exceptions;

import ru.sber.exceptions.exceptions.*;

public class BankOnlineDemo {
    public static void main(String[] args) throws BankOnlineException {
        BankOnline bank = new BankOnline();

        try {
            bank.send(null, 0.0);
        } catch (InvalidArgumentException ex) {
            System.out.println(ex.description);
        }

        try {
            bank.send("1234123412341234", null);
        } catch (InvalidArgumentException ex) {
            System.out.println(ex.description);
        }

        try {
            bank.send("1234123412341234", -1.0);
        } catch (OutOfLimitTransferException ex) {
            System.out.println(ex.description);
        }

        try {
            bank.send("1234123412341234", 10000000.0);
        } catch (OutOfLimitTransferException ex) {
            System.out.println(ex.description);
        }

        try {
            bank.send("1", 0.0);
        } catch (InvalidCardNumberException ex) {
            System.out.println(ex.description);
        }

        try {
            bank.send("ASDFASDFASDFASDF", 0.0);
        } catch (InvalidCardNumberException ex) {
            System.out.println(ex.description);
        }

        try {
            bank.send("1111111111111111", 0.0);
        } catch (TransferToBlockedCardException ex) {
            System.out.println(ex.description);
        }
    }
}
