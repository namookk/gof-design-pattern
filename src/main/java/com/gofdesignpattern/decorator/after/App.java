package com.gofdesignpattern.decorator.after;

public class App {

    private static boolean enabledSpamFilter = false;

    private static boolean enableTrimming = false;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        if(enabledSpamFilter){
            commentService = new SpamFilteringCommentDecorator(commentService);
        }
        if(enableTrimming){
            commentService = new TrimmingDecorator(commentService);
        }

        Client client = new Client(commentService);
        client.writeComment("오징어 게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://www.naver.com");
    }
}
