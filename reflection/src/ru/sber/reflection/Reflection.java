package ru.sber.reflection;

import lombok.NonNull;
import ru.sber.annotations.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Reflection {
    List<Class<? extends WeekBase>> classes = List.of(WeekClass.class, WeekClassNoAnnotation.class);
    public WeekBase create(int day) throws Exception {
        Class<? extends WeekBase> metadata = null;

        for (var clazz : classes) {
            if (clazz.getAnnotation(Week.class).day() == day) {
                metadata = clazz;
                break;
            }
        }

        Objects.requireNonNull(metadata);

        WeekBase instance = metadata.getConstructor().newInstance();
        change(instance, day);

        return instance;
    }
    private void change(@NonNull WeekBase instance, int day) throws Exception {
        Method setter = instance.getClass().getMethod("setData", String.class);
        List<Alarm> alarms = Arrays
                .stream(setter.getAnnotationsByType(Alarm.class))
                .filter(alarm -> alarm.hour() == day)
                .toList();

        for (Alarm alarm : alarms) {
            setter.invoke(instance, alarm.description());

            DataContainer container = extract(instance);
        }
    }
    public DataContainer extract(@NonNull WeekBase instance) throws Exception {
        Field containerField = WeekBase.class.getDeclaredField("container");

        containerField.setAccessible(true);
        return (DataContainer) containerField.get(instance);
    }
}
