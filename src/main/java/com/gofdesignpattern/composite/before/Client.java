package com.gofdesignpattern.composite.before;

public class Client {
    public static void main(String[] args) {
        Item doranBlade = new Item("도란검", 450);
        Item healPotion = new Item("체력 물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healPotion);

        Client client = new Client();
        client.printPrice(doranBlade);
        client.printPrice(bag);
    }

    private void printPrice(Bag bag) {
        System.out.println(bag.getItems().stream()
                        .mapToInt(Item::getPrice)
                        .sum());
    }

    private void printPrice(Item item) {
        System.out.println(item.getPrice());
    }
}
