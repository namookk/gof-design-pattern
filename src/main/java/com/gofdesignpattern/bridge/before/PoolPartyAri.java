package com.gofdesignpattern.bridge.before;

public class PoolPartyAri implements Champion{
    @Override
    public void move() {
        System.out.println("수영장파티 아칼리 move");
    }

    @Override
    public void skillQ() {
        System.out.println("수영장파티 아칼리 Q");
    }

    @Override
    public void skillW() {
        System.out.println("수영장파티 아칼리 W");
    }

    @Override
    public void skillE() {
        System.out.println("수영장파티 아칼리 E");
    }

    @Override
    public void skillR() {
        System.out.println("수영장파티 아칼리 R");
    }
}
