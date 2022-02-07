package com.gofdesignpattern.composite.before;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Bag {
    List<Item> items;

    Bag() {
        items = new ArrayList<>();
    }

    public void add(Item item){
        items.add(item);
    }
}
