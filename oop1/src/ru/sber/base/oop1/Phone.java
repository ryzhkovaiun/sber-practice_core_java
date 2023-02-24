package ru.sber.base.oop1;
public class Phone {
    private String number = "";
    private String model = "";
    private int weight = 0;

    public Phone() {
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = number;

    }

    public Phone(String number, String model, int weight) {
        this.number = number;
        this.model = number;
        this.weight = weight;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит (" + name + ")");
    }

    public void sendMessage(String[] numbers) {
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return String.format("{ Номер: %s; Модель %s; Вес: %s }", number, model, weight);
    }

    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.receiveCall("Akiko");
        phone.sendMessage(new String[]{"900", "8 800 234-24-80", "09", "999", "0"});

        Phone sberPhone = new Phone("900", "Mi Mix 3s");
        Phone actualPhone = new Phone("8 888 234-24-80", "Mi Mix 3d", 999);

    }
}
