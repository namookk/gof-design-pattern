package com.gofdesignpattern.decorator.after;

public class TrimmingDecorator extends CommentDecorator{
    public TrimmingDecorator(CommentService target) {
        super(target);
    }

    @Override
    public void addComment(String comment){
        super.addComment(trim(comment));
    }
    private String trim(String comment) {
        return comment.replace("...", "");
    }
}
