package com.sofka.alphapostcomments.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.PostId;
import com.sofka.alphapostcomments.values.Title;

public class PostCreated extends DomainEvent {
    private Title title;

    private Author author;

    public PostCreated(Title title, Author author){
        super("com.sofka.dddchallenge.Song.SongCreated");
        this.title = title;
        this.author = author;
    }

    public Title getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}

