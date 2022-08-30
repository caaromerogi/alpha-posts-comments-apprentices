package com.sofka.alphapostcomments.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.CommentId;
import com.sofka.alphapostcomments.values.Content;

public class CommentAdded extends DomainEvent {

    private CommentId commentId;

    private Author author;

    private Content content;

    public CommentAdded(CommentId commentId, Author author, Content content){
        super("com.sofka.alphapostcomments.CommentAdded");
        this.commentId = commentId;
        this.author = author;
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public Content getContent() {
        return content;
    }

    public CommentId getCommentId() {
        return commentId;
    }
}
