package ru.sber.annotations;

import lombok.NonNull;

@Week(day = 2)
public class WeekClass extends WeekBase {
    @Override
    @Alarm(hour = 7, priority = -1, description = "bla-bla-bla")
    @Alarm(hour = 5)
    @Alarm(hour = 9, priority = 1, description = "yay")
    public void setData(@NonNull String description) {
        this.container.setDescription(description);
    }
}