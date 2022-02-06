package com.gofdesignpattern.factorymethod.after;

import com.gofdesignpattern.factorymethod.Ship;

public class WhiteShip extends Ship {
    public WhiteShip() {
        setName("whiteship");
        setLogo("--- White Ship ---");
        setColor("white");
    }
}
