package com.sofka.alphapostcomments.domain;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.alphapostcomments.events.CommentAdded;
import com.sofka.alphapostcomments.events.PostCreated;

import java.util.ArrayList;

public class PostChange extends EventChange {
    public PostChange(Post post) {
        apply((PostCreated event)-> {
            post.author = event.getAuthor();
            post.title = event.getTitle();
            post.comments = new ArrayList<>();
        });

        apply((CommentAdded event) -> {
            post.comments.add(new Comment(
                event.getCommentId(),
                event.getAuthor(),
                event.getContent()
            ));
        });
    }
}
