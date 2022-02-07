package com.gofdesignpattern.composite.after;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Bag implements Component {
    List<Component> components;

    Bag() {
        components = new ArrayList<>();
    }

    public void add(Component component){
        components.add(component);
    }

    @Override
    public int getPrice() {
        return this.components.stream()
                .mapToInt(Component::getPrice)
                .sum();
    }
}
