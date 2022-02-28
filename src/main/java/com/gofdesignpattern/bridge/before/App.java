package com.gofdesignpattern.bridge.before;

public class App {
    public static void main(String[] args) {
        Champion kdaAkalliy = new KdaAkalliy();
        kdaAkalliy.move();
        kdaAkalliy.skillQ();
    }
}
