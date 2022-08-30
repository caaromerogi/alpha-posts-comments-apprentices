package com.sofka.alphapostcomments.domain;

import co.com.sofka.domain.generic.Entity;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.CommentId;
import com.sofka.alphapostcomments.values.Content;

public class Comment extends Entity<CommentId> {

    private Author author;

    private Content content;

    public Comment(CommentId commentId,Author author, Content content) {
        super(commentId);
        this.author = author;
        this.content = content;
    }

    public Author author() {
        return author;
    }

    public Content content() {
        return content;
    }
}
