package com.gofdesignpattern.proxy.after;

public class Client {
    public static void main(String[] args) {
        GameService proxy = new GameServiceProxy();
        proxy.startGame();
    }
}
