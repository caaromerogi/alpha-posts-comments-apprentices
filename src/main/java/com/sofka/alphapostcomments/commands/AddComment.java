package com.sofka.alphapostcomments.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.CommentId;
import com.sofka.alphapostcomments.values.Content;
import com.sofka.alphapostcomments.values.PostId;

public class AddComment extends Command {

    private PostId postId;

    private CommentId commentId;
    private Author author;

    private Content content;

    public AddComment(PostId postId, CommentId commentId, Author author, Content content){
        this.postId = postId;
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
}
