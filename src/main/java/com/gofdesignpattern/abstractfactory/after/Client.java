package com.gofdesignpattern.abstractfactory.after;

public class Client {
    public static void main(String[] args) {
        ShipFactory shipFactory = new WhiteShipFactory(new WhiteSheepPartsFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
