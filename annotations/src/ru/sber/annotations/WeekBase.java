package ru.sber.annotations;

@Week(day = 1)
public abstract class WeekBase {
    protected DataContainer container;

    public abstract void setData(String description);
}
