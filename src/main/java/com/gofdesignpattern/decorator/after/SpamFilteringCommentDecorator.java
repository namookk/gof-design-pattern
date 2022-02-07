package com.gofdesignpattern.decorator.after;

public class SpamFilteringCommentDecorator extends CommentDecorator{

    public SpamFilteringCommentDecorator(CommentService target) {
        super(target);
    }

    @Override
    public void addComment(String comment){
        if(!isSpam(comment)) {
            super.addComment(comment);
        }
    }
    private boolean isSpam(String comment) {
        return comment.contains("http");
    }
}
