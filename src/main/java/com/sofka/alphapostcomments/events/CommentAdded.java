package com.sofka.alphapostcomments.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.CommentId;
import com.sofka.alphapostcomments.values.Content;

public class CommentAdded extends DomainEvent {

    private String commentId;

    private String author;

    private String content;

    public CommentAdded(String commentId, String author, String content){
        super("com.sofka.alphapostcomments.CommentAdded");
        this.commentId = commentId;
        this.author = author;
        this.content = content;
    }

    public CommentAdded(){
        super("com.sofka.alphapostcomments.CommentAdded");
    }

    public String getCommentId() {
        return commentId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
