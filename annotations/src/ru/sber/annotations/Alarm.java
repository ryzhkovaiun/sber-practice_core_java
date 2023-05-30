package ru.sber.annotations;

import java.lang.annotation.*;

@Repeatable(Alarms.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Alarm {
    int hour() default 0;
    int priority() default 0;
    String description() default "";
}