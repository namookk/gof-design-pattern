package com.gofdesignpattern.factorymethod.after;

import com.gofdesignpattern.factorymethod.Ship;

public class BlackShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
