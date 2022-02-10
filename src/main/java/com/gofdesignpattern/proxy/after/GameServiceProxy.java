package com.gofdesignpattern.proxy.after;


public class GameServiceProxy extends GameService {

    @Override
    public void startGame() {
        long startTime = System.currentTimeMillis();
        super.startGame();
        long endTime = System.currentTimeMillis();
        System.out.println("time="+(endTime - startTime) +"ms");
    }
}
