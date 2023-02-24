package ru.sber.base.oop1;

public class Author { private String name;

    private Gender gender;

    private String email = null;

    public Author(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Author(String name, Gender gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        if (email == null || "".equals(email)) {
            return String.format("%s, %s", name, gender);
        }

        return String.format("%s, %s (%s)", name, gender, email);
    }

}

