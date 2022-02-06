package com.gofdesignpattern.factorymethod.after;

import com.gofdesignpattern.factorymethod.Ship;

public class BlackShip extends Ship {

    public BlackShip() {
        setName("blackship");
        setLogo("--- Black Ship ---");
        setColor("black");
    }
}
