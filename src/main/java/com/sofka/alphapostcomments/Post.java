package com.sofka.alphapostcomments;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.events.CommentAdded;
import com.sofka.alphapostcomments.events.PostCreated;
import com.sofka.alphapostcomments.values.*;

import java.util.List;
import java.util.Objects;

public class Post extends AggregateEvent<PostId> {
    protected Title title;

    protected Author author;

    protected List<Comment> comments;

    public Post(PostId entityId, Title title, Author author){
        super(entityId);
        appendChange(new PostCreated(title.value(), author.value())).apply();
    }

    private Post(PostId postId){
        super(postId);
        subscribe(new PostChange(this));
    }

    public static Post from(PostId postId, List<DomainEvent> events){
        var post= new Post(postId);
        events.forEach(post::applyEvent);
        return post;
    }

    public void addComment(CommentId commentId, Author author, Content content){
        Objects.requireNonNull(commentId);
        Objects.requireNonNull(author);
        Objects.requireNonNull(content);
        appendChange(new CommentAdded(commentId.value(), author.value(), content.value())).apply();
    }

    public Title title() {
        return title;
    }

    public Author author() {
        return author;
    }

    public List<Comment> comments() {
        return comments;
    }
}
