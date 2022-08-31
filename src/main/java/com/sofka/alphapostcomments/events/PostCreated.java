package com.sofka.alphapostcomments.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.PostId;
import com.sofka.alphapostcomments.values.Title;

public class PostCreated extends DomainEvent {
    private String title;

    private String author;

    public PostCreated(String title, String author){
        super("com.sofka.dddchallenge.Song.SongCreated");
        this.title = title;
        this.author = author;
    }

    public  PostCreated(){
        super("com.sofka.dddchallenge.Song.SongCreated");
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

