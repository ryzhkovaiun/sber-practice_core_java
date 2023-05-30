package ru.sber.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {

    void barger() {
        System.out.println("growl");
    }

    static void bat() {
        System.out.println("screech");
    }

    public static void main(String[] args) {
        List<Sounding> soundings = new ArrayList<>();

        soundings.add(new Alligator());
        soundings.add(new Alpaca());
        soundings.add(new Antelope());

        for (Sounding sounding : soundings) {
            sounding.sound();
        }

        soundings.add(new Sounding() { // bear
            @Override
            public void sound() {
                System.out.println("roar");
            }
        });

        soundings.add(() -> System.out.println("buzz")); // bee

        LambdaDemo demo = new LambdaDemo();
        soundings.add(demo::barger);
        soundings.add(LambdaDemo::bat);

        soundings.forEach(Sounding::sound);
    }

}
