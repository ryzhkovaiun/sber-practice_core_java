package ru.sber.reflection;

import ru.sber.annotations.DataContainer;
import ru.sber.annotations.WeekBase;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Reflection reflection = new Reflection();
        WeekBase base = reflection.create(1);

        DataContainer container = reflection.extract(base);
        System.out.println(container.getCounter());
        System.out.println(container.getDescription());
    }
}
