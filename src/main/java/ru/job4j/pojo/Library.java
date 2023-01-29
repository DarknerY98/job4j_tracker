package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {

        Book bookOne = new Book("Оne", 1000);
        Book bookTwo = new Book("Two", 34);
        Book bookThree = new Book("Three", 567);
        Book bookFour = new Book("Clean code", 12);
        Book[] books = new Book[4];
        books[0] = bookOne;
        books[1] = bookTwo;
        books[2] = bookThree;
        books[3] = bookFour;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount() + " - " + index);
        }
        Book bookNew = books[0];
        books[0] = books[3];
        books[3] = bookNew;
        System.out.println("Replace books[3] and  books[0]");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount() + " - " + index);
        }
        System.out.println("Book \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
                Book bk = books[index];
            if (bk.getName() == "Clean code") {
                System.out.println(bk.getName() + " - " + bk.getCount() + " - " + index);
            }
        }

    }

}
