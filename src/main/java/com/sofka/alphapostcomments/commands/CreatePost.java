package com.sofka.alphapostcomments.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.PostId;
import com.sofka.alphapostcomments.values.Title;

public class CreatePost extends Command {
    private PostId postId;

    private Title title;

    private Author author;

    public CreatePost(PostId postId, Title title, Author author) {
        this.postId = postId;
        this.title = title;
        this.author = author;
    }

    public CreatePost(){

    }

    public PostId getPostId() {
        return postId;
    }

    public Title getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}
