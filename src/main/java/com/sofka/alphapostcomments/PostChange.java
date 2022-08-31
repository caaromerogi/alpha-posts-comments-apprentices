package com.sofka.alphapostcomments;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.alphapostcomments.events.CommentAdded;
import com.sofka.alphapostcomments.events.PostCreated;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.CommentId;
import com.sofka.alphapostcomments.values.Content;
import com.sofka.alphapostcomments.values.Title;

import java.util.ArrayList;

public class PostChange extends EventChange {
    public PostChange(Post post) {
        apply((PostCreated event)-> {
            post.author = new Author(event.getAuthor());
            post.title = new Title(event.getTitle());
            post.comments = new ArrayList<>();
        });

        apply((CommentAdded event) -> {
            post.comments.add(new Comment(
                new CommentId(),
                new Author(event.getAuthor()),
                new Content(event.getContent())
            ));
        });
    }
}
