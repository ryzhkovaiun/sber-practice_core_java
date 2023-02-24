package ru.sber.base.oop1;

public class Book {private String name;

    private Author author;

    private int year;

    public Book(String name, Author author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return String.format("Книга под названием \"%s\", выпущенная %s в %d году.\n", name, author, year);
    }
    public static void main(String[] args){
    Author lewis = new Author("Барри Берд", Gender.MALE);
    Book alice = new Book("Java для чайников", lewis, 2019);

        System.out.println(lewis);
        System.out.println(alice);

    Author robertMartin = new Author("Чак Поланик", Gender.MALE, null);
        robertMartin.setEmail("Chuck.Polanick@gmail.ru");

    Book cleanCode = new Book("Бойцовский клуб", robertMartin, 1996);
        cleanCode.setYear(2019);

        System.out.println(robertMartin);
        System.out.println(cleanCode);
}

}

