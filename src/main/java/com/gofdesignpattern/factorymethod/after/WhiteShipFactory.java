package com.gofdesignpattern.factorymethod.after;

import com.gofdesignpattern.factorymethod.Ship;

public class WhiteShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
