package com.gofdesignpattern.factorymethod.before;

import com.gofdesignpattern.factorymethod.Ship;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteShip = ShipFactory.orderShip("WhiteShip", "email@email.com");
        System.out.println(whiteShip);

        Ship blackShip = ShipFactory.orderShip("blackShip", "email@email.com");
        System.out.println(blackShip);
    }

}
