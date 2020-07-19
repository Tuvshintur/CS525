package com.example;

public class Notebook extends Item {
    
    public Notebook(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("Notebook name: " + this.name);
    }
}
