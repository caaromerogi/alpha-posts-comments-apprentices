package com.sofka.alphapostcomments.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.CommentId;
import com.sofka.alphapostcomments.values.Content;
import com.sofka.alphapostcomments.values.PostId;

public class AddComment extends Command {

    private String postId;

    private String commentId;
    private String author;

    private String content;

    public AddComment(String postId, String commentId, String author, String content){
        this.postId = postId;
        this.commentId = commentId;
        this.author = author;
        this.content = content;
    }

    public AddComment(){

    }

    public String getPostId() {
        return postId;
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
