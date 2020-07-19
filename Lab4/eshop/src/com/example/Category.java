package com.example;

import java.util.ArrayList;
import java.util.List;

public class Category extends Item {
    private List<Item> list;

    public Category(String name) {
        super(name);
        this.list = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.list.add(item);
    }

    @Override
    public void print() {
        System.out.println("Catalog : ");
        for (Item item : this.list) {
            item.print();
        }
    }
}
