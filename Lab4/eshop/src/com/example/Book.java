package com.example;

public class Book extends Item {
    String isbn;

    public Book(String name, String isbn) {
        super(name);
        this.isbn = isbn;
    }

    @Override
    public void print() {
        System.out.println("Book name: " + this.name + "\n" + "ISBN: " + this.isbn);
    }
}
