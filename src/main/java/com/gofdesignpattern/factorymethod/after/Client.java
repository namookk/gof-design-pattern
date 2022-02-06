package com.gofdesignpattern.factorymethod.after;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.print(new WhiteShipFactory(), "Whiteship", "email@email.com");
        client.print(new BlackShipFactory(), "Whiteship", "email@email.com");
    }

    private void print(ShipFactory shipFactory, String name, String email) {
         System.out.println(shipFactory.orderShip(name, email));
    }
}
