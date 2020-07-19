package com.example;

public class Main {

    public static void main(String[] args) {
        Category library = new Category("Library Category");

        Book book1 = new Book("Python 3", "124549848");
        Book book2 = new Book("Javascript fundamental", "124354657687");
        Notebook notebook1 = new Notebook("Python 3 note");
        Notebook notebook2 = new Notebook("Javascript fundamental note");

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(notebook1);
        library.addItem(notebook2);

        library.print();
    }
}
