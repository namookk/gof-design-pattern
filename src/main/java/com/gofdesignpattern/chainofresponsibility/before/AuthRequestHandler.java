package com.gofdesignpattern.chainofresponsibility.before;

public class AuthRequestHandler extends RequestHandler{
    public void handle(Request request) {
        System.out.println("인증 작업 처리");
        super.handle(request);
    }
}
