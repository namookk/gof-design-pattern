package com.gofdesignpattern.chainofresponsibility.after;

import com.gofdesignpattern.chainofresponsibility.before.Request;

public abstract class RequestHandler {
    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Request request) {
        if (nextHandler != null){
            nextHandler.handle(request);
        }
    }
}
