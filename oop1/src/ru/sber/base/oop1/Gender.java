package ru.sber.base.oop1;

public enum Gender {
    FEMALE("Женщина"),
    MALE("Мужчина");

    private final String genderAsString;

    Gender(String genderAsString) {
        this.genderAsString = genderAsString;
    }

    public String toString() {
        return genderAsString;
    }
}
