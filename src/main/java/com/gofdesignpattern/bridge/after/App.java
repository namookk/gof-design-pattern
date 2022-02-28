package com.gofdesignpattern.bridge.after;

import com.gofdesignpattern.bridge.before.Champion;

public class App {
    public static void main(String[] args) {
        Champion kdaAri = new Ari(new Kda());
        kdaAri.skillQ();
        kdaAri.skillW();

        Champion poolPartyAri = new Ari(new PoolParty());
        poolPartyAri.skillQ();
        poolPartyAri.skillW();
    }
}
