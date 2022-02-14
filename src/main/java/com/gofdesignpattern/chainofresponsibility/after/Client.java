package com.gofdesignpattern.chainofresponsibility.after;

import com.gofdesignpattern.chainofresponsibility.before.Request;

public class Client {
    private RequestHandler requestHandler;

    public Client(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void doWork() {
        Request request = new Request("이번 놀이는 뽑기입니다.");
        requestHandler.handle(request);
    }

    public static void main(String[] args) {
        //체인 구성
        RequestHandler chain = new AuthRequestHandler(
                new LoggingRequestHandler(
                        new PrintRequestHandler(null)
                )
        );

        Client client = new Client(chain);
        client.doWork();
    }
}
