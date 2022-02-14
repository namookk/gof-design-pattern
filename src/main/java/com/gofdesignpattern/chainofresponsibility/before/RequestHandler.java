package com.gofdesignpattern.chainofresponsibility.before;

public class RequestHandler {
    public void handle(Request request) {
        System.out.println(request.getBody());
    }
}
