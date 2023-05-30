package ru.sber.reflection;

import lombok.NonNull;
import ru.sber.annotations.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Reflection {
    public WeekBase create(int day, String description, int counter, double time) throws Exception {
        Class<? extends WeekBase> metadata = null;

        if (WeekClass.class.getAnnotation(Week.class).day() == day) {
            metadata = WeekClass.class;
        }

        if (Objects.isNull(metadata) && WeekClassNoAnnotation.class.getAnnotation(Week.class).day() == day) {
            metadata = WeekClassNoAnnotation.class;
        }

        Objects.requireNonNull(metadata);

        WeekBase instance = metadata.getConstructor().newInstance();
        Field containerField = WeekBase.class.getDeclaredField("container");
        containerField.setAccessible(true);

        DataContainer dataContainer = new DataContainer();
        dataContainer.setDescription(description);
        dataContainer.setCounter(counter);
        dataContainer.setTime(time);
        containerField.set(instance, dataContainer);

        return instance;
    }
    public void change(@NonNull WeekBase instance) throws Exception {
        Field containerField = WeekBase.class.getDeclaredField("container");
        containerField.setAccessible(true);

        Method setter = instance.getClass().getMethod("setData", String.class);
        Alarm[] alarms = setter.getAnnotationsByType(Alarm.class);

        // Сортировка по приоритетность, от менее приоритетных к более
        Arrays.sort(alarms, Comparator.comparingInt(Alarm::priority));

        for (Alarm alarm : alarms) {
            setter.invoke(instance, alarm.description());

            DataContainer container = (DataContainer) containerField.get(instance);
        }
    }
    public DataContainer extract(@NonNull WeekBase instance) throws Exception {
        Field containerField = WeekBase.class.getDeclaredField("container");

        containerField.setAccessible(true);
        return (DataContainer) containerField.get(instance);
    }
}
