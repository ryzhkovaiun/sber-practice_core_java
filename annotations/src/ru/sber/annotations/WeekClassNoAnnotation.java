package ru.sber.annotations;

import lombok.NonNull;

public class WeekClassNoAnnotation extends WeekBase {
    @Override
    @Alarm(hour = 1, priority = -1, description = "bla-bla-bla")
    @Alarm(hour = 2)
    @Alarm(hour = 3, priority = 1, description = "yay")
    public void setData(@NonNull String description) {
        this.container.setDescription(description);
    }
}