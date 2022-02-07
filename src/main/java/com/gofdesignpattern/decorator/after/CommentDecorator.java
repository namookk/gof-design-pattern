package com.gofdesignpattern.decorator.after;

public class CommentDecorator implements CommentService{

    private CommentService target;

    public CommentDecorator(CommentService target) {
        this.target = target;
    }

    @Override
    public void addComment(String comment) {
        target.addComment(comment);
    }
}
